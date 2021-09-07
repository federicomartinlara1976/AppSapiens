package com.mdval.bussiness.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.InformeValidacion;
import com.mdval.bussiness.service.ExcelGeneratorService;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LiteralesSingleton;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

/**
 * @author hcarreno
 */
@Service(Constants.EXCEL_GENERATOR_SERVICE)
@Log4j
public class ExcelGeneratorServiceImpl extends ServiceSupport implements ExcelGeneratorService {

	@Override
	@SneakyThrows
	public void generarExcelGlosarioCampoModelo(List<CampoGlosario> camposGlosario, String path, String codigoGlosario,
			String nombreGlosario) {

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String dateFormatReporte = configuration.getConfig("dateFormatReporte");
		String nombreReporteGlosario = configuration.getConfig("nombreReporteGlosario");
		String hoja = configuration.getConfig("nombreHojaGlosario");

//        List<CampoGlosario> lista = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            CampoGlosario campoGlosario = CampoGlosario.builder()
//                    .tipoDato("tipoDato"+i) // Tipo
//                    .nombreColumna("nombre"+i) //Campo
//                    .numeroLongitud(BigDecimal.valueOf(i)) //Longitud
//                    .numeroDecimal(BigDecimal.valueOf(i)) //Decimales
//                    .mcaExcepcion("mcaEx"+i) //Excepcion
//                    .txtComentario("comentario"+i) //Comentario
//                    .txtExcepcion("comentarioExcepcion"+i) //Comentario Excepcion
//                    .codigoUsuario("usuario"+i) //COD_USR
//                    .fechaActualizacion(new Date()) // FEC_ACTU
//                    .build();
//            lista.add(campoGlosario);
//        }

		// FileInputStream inputStream = new FileInputStream(new
		// File(Constants.CAMPO_GLOSARIO_TEMPLATE_LOCATION));
		InputStream inputStream = getClass().getResourceAsStream(Constants.CAMPO_GLOSARIO_TEMPLATE_LOCATION);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(hoja);

		int rownum = 4; // row to start writting
		for (CampoGlosario campoGlosario : camposGlosario) {
			Row row = sheet.createRow(rownum++);
			createRowCampoGlosario(campoGlosario, row);
		}

		setupCabecera(sheet);

		DateFormat formatter = new SimpleDateFormat(dateFormatReporte);
		String fecha = formatter.format(new Date(System.currentTimeMillis()));

		String format = "%s_%s_%s_%s.xlsx"; 
		String fileName = String.format(format, fecha, nombreReporteGlosario, codigoGlosario, nombreGlosario);
		LogWrapper.debug(log, "Archivo: %s", fileName);
		FileOutputStream outputStream = new FileOutputStream(new File(path + "/" + fileName));
		workbook.write(outputStream);
		workbook.close();

	}

	@SneakyThrows
	private void setupCabecera(Sheet sheet) {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();

		Row titleRow = sheet.getRow(1);
		Cell titleCell = titleRow.getCell(1);
		titleCell.setCellValue(literales.getLiteral("glosarioCampos.titulo"));

		Row headerRow = sheet.getRow(3);
		Cell nombreCell = headerRow.getCell(0);
		nombreCell.setCellValue(literales.getLiteral("glosarioCampos.nombre"));
		Cell tipoDatoCell = headerRow.getCell(1);
		tipoDatoCell.setCellValue(literales.getLiteral("glosarioCampos.tipoDato"));
		Cell longitudCell = headerRow.getCell(2);
		longitudCell.setCellValue(literales.getLiteral("glosarioCampos.longitud"));
		Cell decimalCell = headerRow.getCell(3);
		decimalCell.setCellValue(literales.getLiteral("glosarioCampos.decimal"));
		Cell errorCell = headerRow.getCell(4);
		errorCell.setCellValue(literales.getLiteral("glosarioCampos.ce"));
	}

	/**
	 * @param campoGlosario
	 * @param row
	 */
	@SneakyThrows
	private void createRowCampoGlosario(CampoGlosario campoGlosario, Row row) // creating cells for each row
	{
		LiteralesSingleton literales = LiteralesSingleton.getInstance();

		Cell cell = row.createCell(0);
		cell.setCellValue(campoGlosario.getNombreColumna());

		cell = row.createCell(1);
		cell.setCellValue(campoGlosario.getTipoDato());

		cell = row.createCell(2);
		cell.setCellValue(campoGlosario.getNumeroLongitud().toString());

		cell = row.createCell(3);
		cell.setCellValue(campoGlosario.getNumeroDecimal().toString());

		cell = row.createCell(4);
		String correcto = "N".equals(campoGlosario.getMcaExcepcion()) ? literales.getLiteral("glosarioCampos.correcto")
				: literales.getLiteral("glosarioCampos.error");
		cell.setCellValue(correcto);
	}

	@Override
	@SneakyThrows
	public void generarExcelValidacionNomenclatura(InformeValidacion informeValidacion) {

	}
}
