package com.mdval.bussiness.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.DetValidacion;
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

		InputStream inputStream = getClass().getResourceAsStream(Constants.CAMPO_GLOSARIO_TEMPLATE_LOCATION);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(hoja);

		int rownum = 4; // row to start writting
		for (CampoGlosario campoGlosario : camposGlosario) {
			Row row = sheet.createRow(rownum++);
			createRowCampoGlosario(campoGlosario, row);
		}

		setupCabeceraGlosario(sheet);

		DateFormat formatter = new SimpleDateFormat(dateFormatReporte);
		String fecha = formatter.format(new Date(System.currentTimeMillis()));

		String format = "%s_%s_%s_%s.xls";
		String fileName = String.format(format, fecha, nombreReporteGlosario, codigoGlosario, nombreGlosario);
		LogWrapper.debug(log, "Archivo: %s", fileName);
		FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
		workbook.write(outputStream);
		workbook.close();
		outputStream.flush();
		outputStream.close();

	}

	@SneakyThrows
	private void setupCabeceraGlosario(Sheet sheet) {
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
		Cell comentarioCell = headerRow.getCell(5);
		comentarioCell.setCellValue(literales.getLiteral("glosarioCampos.comentario"));
		Cell comentarioErrorCell = headerRow.getCell(6);
		comentarioErrorCell.setCellValue(literales.getLiteral("glosarioCampos.comentarioExcepcion"));
		Cell codUsrCell = headerRow.getCell(7);
		codUsrCell.setCellValue(literales.getLiteral("glosarioCampos.codUsr"));
		Cell fecActuCell = headerRow.getCell(8);
		fecActuCell.setCellValue(literales.getLiteral("glosarioCampos.fecActu"));
	}

	/**
	 * @param campoGlosario
	 * @param row
	 */
	@SneakyThrows
	private void createRowCampoGlosario(CampoGlosario campoGlosario, Row row) // creating cells for each row
	{
		Cell cell = row.createCell(0);
		cell.setCellValue(campoGlosario.getNombreColumna());

		cell = row.createCell(1);
		cell.setCellValue(campoGlosario.getTipoDato());

		cell = row.createCell(2);
		cell.setCellValue(campoGlosario.getNumeroLongitud().toString());

		cell = row.createCell(3);
		cell.setCellValue(campoGlosario.getNumeroDecimal().toString());

		cell = row.createCell(4);
		String correcto = campoGlosario.getMcaExcepcion();
		cell.setCellValue(correcto);
		
		cell = row.createCell(5);
		cell.setCellValue(campoGlosario.getTxtComentario());
		
		cell = row.createCell(6);
		cell.setCellValue(campoGlosario.getTxtExcepcion());
		
		cell = row.createCell(7);
		cell.setCellValue(campoGlosario.getCodigoUsuario());
		
		cell = row.createCell(8);
		cell.setCellValue(dateFormatter.dateToString(campoGlosario.getFechaActualizacion()));
	}

	@Override
	@SneakyThrows
	public void generarExcelValidacionNomenclatura(InformeValidacion informeValidacion, String path) {

		List<DetValidacion> listaError = informeValidacion.getListaErroneos();  //nombreReporteValidacionErroneos
		List<DetValidacion> listaOtraDefinicion = informeValidacion.getListaOtraDefinicion(); //nombreReporteValidacionOtraDefinicion
		List<CampoGlosario> listaGlosario = informeValidacion.getListaDefinicionGlosario(); //nombreReporteValidacionGlosario

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String nombreReporteValidacionErroneos = configuration.getConfig("nombreReporteValidacionErroneos");
		String nombreHojaValidacionErroneos = configuration.getConfig("nombreHojaValidacionErroneos");

		String nombreReporteValidacionOtraDefinicion = configuration.getConfig("nombreReporteValidacionOtraDefinicion");
		String nombreHojaValidacionOtraDefinicion = configuration.getConfig("nombreHojaValidacionOtraDefinicion");

		String nombreReporteValidacionGlosario = configuration.getConfig("nombreReporteValidacionGlosario");
		String nombreHojaValidacionGlosario = configuration.getConfig("nombreHojaValidacionGlosario");

		generateReporteValidacionErroneos(listaError, nombreReporteValidacionErroneos, nombreHojaValidacionErroneos, path);
		generateReporteValidacionGlosario(listaGlosario, nombreReporteValidacionGlosario, nombreHojaValidacionGlosario, path);
		generateReporteValidacionOtraDefinicion(listaOtraDefinicion, nombreReporteValidacionOtraDefinicion, nombreHojaValidacionOtraDefinicion, path);

	}

	@SneakyThrows
	private void generateReporteValidacionErroneos(List<DetValidacion> listaErroneos, String nombreReporteValidacionErroneos, String nombreHojaValidacionErroneos, String path) {
		InputStream inputStream = getClass().getResourceAsStream(Constants.NOMENCLATURA_OTRA_DEFINICION_TEMPLATE_LOCATION);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(nombreHojaValidacionErroneos);

		int rownum = 4; // row to start writting
		for (DetValidacion detValidacion : listaErroneos) {
			Row row = sheet.createRow(rownum++);
			createRowValidacionErroneos(detValidacion, row);
		}

		setupCabeceraValidacionErroneos(sheet);

		String format = "%s.xls";
		String fileName = String.format(format, nombreReporteValidacionErroneos);
		LogWrapper.debug(log, "Archivo: %s", fileName);
		FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
		workbook.write(outputStream);
		workbook.close();
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * @param detValidacion
	 * @param row
	 */
	private void createRowValidacionErroneos(DetValidacion detValidacion, Row row) // creating cells for each row
	{
		Cell cell = row.createCell(0);
		cell.setCellValue(detValidacion.getTipoDato());

		cell = row.createCell(1);
		cell.setCellValue(detValidacion.getNombreElemento());

		cell = row.createCell(2);
		cell.setCellValue(detValidacion.getTxtDescripcionValid());
	}

	@SneakyThrows
	private void setupCabeceraValidacionErroneos(Sheet sheet) {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();

		Row titleRow = sheet.getRow(1);
		Cell titleCell = titleRow.getCell(1);
		titleCell.setCellValue(literales.getLiteral("validacionErroneos.titulo"));

		Row headerRow = sheet.getRow(3);
		Cell tipoElementoCell = headerRow.getCell(0);
		tipoElementoCell.setCellValue(literales.getLiteral("validacionErroneos.tipoElemento"));
		Cell nombreCell = headerRow.getCell(1);
		nombreCell.setCellValue(literales.getLiteral("validacionErroneos.nombre"));
		Cell resultadoCell = headerRow.getCell(2);
		resultadoCell.setCellValue(literales.getLiteral("validacionErroneos.resultado"));
	}

	@SneakyThrows
	private void generateReporteValidacionGlosario(List<CampoGlosario> listaDefinicionGlosario, String nombreReporteValidacionGlosario, String nombreHojaValidacionGlosario, String path) {
		InputStream inputStream = getClass().getResourceAsStream(Constants.NOMENCLATURA_GLOSARIO_TEMPLATE_LOCATION);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(nombreHojaValidacionGlosario);

		int rownum = 7; // row to start writting
		for (CampoGlosario campoGlosario : listaDefinicionGlosario) {
			Row row = sheet.createRow(rownum++);
			createRowValidacionGlosario(campoGlosario, row);
		}

		setupCabeceraValidacionGlosario(sheet);

		String format = "%s.xls";
		String fileName = String.format(format, nombreReporteValidacionGlosario);
		LogWrapper.debug(log, "Archivo: %s", fileName);
		FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
		workbook.write(outputStream);
		workbook.close();
		outputStream.flush();
		outputStream.close();
	}

	private void createRowValidacionGlosario(CampoGlosario campoGlosario, Row row) {
		Cell cell = row.createCell(0);
		cell.setCellValue(campoGlosario.getNombreColumna());

		cell = row.createCell(1);
		cell.setCellValue(campoGlosario.getTipoDato());

		cell = row.createCell(2);
		String longitud = (!Objects.isNull(campoGlosario.getNumeroLongitud())) ? campoGlosario.getNumeroLongitud().toString() : StringUtils.EMPTY;
		cell.setCellValue(longitud);

		cell = row.createCell(3);
		String decimales = (!Objects.isNull(campoGlosario.getNumeroDecimal())) ? campoGlosario.getNumeroDecimal().toString() : StringUtils.EMPTY;
		cell.setCellValue(decimales);
	}

	@SneakyThrows
	private void setupCabeceraValidacionGlosario(Sheet sheet) {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();

		Row titleRow = sheet.getRow(1);
		Cell titleCell = titleRow.getCell(1);
		titleCell.setCellValue(literales.getLiteral("validacionGlosario.titulo"));

		Row descripcion1Row = sheet.getRow(3);
		Cell descripcion1Cell = descripcion1Row.getCell(1);
		descripcion1Cell.setCellValue(literales.getLiteral("validacionGlosario.descripcion1"));

		Row descripcion2Row = sheet.getRow(4);
		Cell descripcion2Cell = descripcion2Row.getCell(1);
		descripcion2Cell.setCellValue(literales.getLiteral("validacionGlosario.descripcion2"));

		Row headerRow = sheet.getRow(6);

		Cell nombreCell = headerRow.getCell(0);
		nombreCell.setCellValue(literales.getLiteral("validacionGlosario.nombre"));
		Cell tipoDatoCell = headerRow.getCell(1);
		tipoDatoCell.setCellValue(literales.getLiteral("validacionGlosario.tipoDato"));
		Cell longitudCell = headerRow.getCell(2);
		longitudCell.setCellValue(literales.getLiteral("validacionGlosario.longitud"));
		Cell decimalCell = headerRow.getCell(3);
		decimalCell.setCellValue(literales.getLiteral("validacionGlosario.decimal"));
	}

	@SneakyThrows
	private void generateReporteValidacionOtraDefinicion(List<DetValidacion> listaOtraDefinicion, String nombreReporteValidacionOtraDefinicion, String nombreHojaValidacionOtraDefinicion, String path) {
		InputStream inputStream = getClass().getResourceAsStream(Constants.NOMENCLATURA_ERRORES_TEMPLATE_LOCATION);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(nombreHojaValidacionOtraDefinicion);

		int rownum = 4; // row to start writting
		for (DetValidacion detValidacion : listaOtraDefinicion) {
			Row row = sheet.createRow(rownum++);
			createRowValidacionOtraDefinicion(detValidacion, row);
		}

		setupCabeceraValidacionOtraDefinicion(sheet);

		String format = "%s.xls";
		String fileName = String.format(format, nombreReporteValidacionOtraDefinicion);
		LogWrapper.debug(log, "Archivo: %s", fileName);
		FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
		workbook.write(outputStream);
		workbook.close();
		outputStream.flush();
		outputStream.close();
	}

	private void createRowValidacionOtraDefinicion(DetValidacion detValidacion, Row row) {
		Cell cell = row.createCell(0);
		cell.setCellValue(detValidacion.getTipoDato());

		cell = row.createCell(1);
		cell.setCellValue(detValidacion.getNombreElemento());

		cell = row.createCell(2);
		cell.setCellValue(detValidacion.getTxtDescripcionValid());
	}

	@SneakyThrows
	private void setupCabeceraValidacionOtraDefinicion(Sheet sheet) {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();

		Row titleRow = sheet.getRow(1);
		Cell titleCell = titleRow.getCell(1);
		titleCell.setCellValue(literales.getLiteral("validacionOtraDefinicion.titulo"));

		Row headerRow = sheet.getRow(3);
		Cell tipoElementoCell = headerRow.getCell(0);
		tipoElementoCell.setCellValue(literales.getLiteral("validacionOtraDefinicion.tipoElemento"));
		Cell nombreCell = headerRow.getCell(1);
		nombreCell.setCellValue(literales.getLiteral("validacionOtraDefinicion.nombre"));
		Cell resultadoCell = headerRow.getCell(2);
		resultadoCell.setCellValue(literales.getLiteral("validacionOtraDefinicion.resultado"));
	}

}
