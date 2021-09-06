package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.InformeValidacion;
import com.mdval.bussiness.service.ExcelGeneratorService;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hcarreno
 */
@Service(Constants.EXCEL_GENERATOR_SERVICE)
@Log4j
public class ExcelGeneratorServiceImpl extends ServiceSupport implements ExcelGeneratorService {

    @Override
    @SneakyThrows
    public void generarExcelGlosarioCampoModelo(List<CampoGlosario> camposGlosario, String path, BigDecimal codigoGlosario, String descripcionGlosario) {

        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String dateFormatReporte = configuration.getConfig("dateFormatReporte");
        String nombreReporteGlosario = configuration.getConfig("nombreReporteGlosario");
        String hoja = configuration.getConfig("nombreHojaGlosario");

        List<CampoGlosario> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CampoGlosario campoGlosario = CampoGlosario.builder()
                    .tipoDato("tipoDato"+i) // Tipo
                    .nombreColumna("nombre"+i) //Campo
                    .numeroLongitud(BigDecimal.valueOf(i)) //Longitud
                    .numeroDecimal(BigDecimal.valueOf(i)) //Decimales
                    .mcaExcepcion("mcaEx"+i) //Excepcion
                    .txtComentario("comentario"+i) //Comentario
                    .txtExcepcion("comentarioExcepcion"+i) //Comentario Excepcion
                    .codigoUsuario("usuario"+i) //COD_USR
                    .fechaActualizacion(new Date()) // FEC_ACTU
                    .build();
            lista.add(campoGlosario);
        }

        FileInputStream inputStream = new FileInputStream(new File(Constants.CAMPO_GLOSARIO_TEMPLATE_LOCATION));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(hoja);

        int rownum = 4; // row to start writting
        for (CampoGlosario campoGlosario : lista) {
            Row row = sheet.createRow(rownum++);
            createRowCampoGlosario(campoGlosario, row);
        }

        Row headerRow = sheet.getRow(1);
        Cell headerCell = headerRow.getCell(2);
        headerCell.setCellValue(descripcionGlosario); //TODO que se pone aqui?

        DateFormat formatter = new SimpleDateFormat(dateFormatReporte);
        String fecha = formatter.format(new Date(System.currentTimeMillis()));
        System.out.println(fecha);

        //String format = "%s\\%s_%s_%s_%s.xlsx"; windows format for slash pre fileName

        String format = "%s/%s_%s_%s_%s.xlsx"; //TODO verificar como obtener path en windows los usuarios escriben todo? C:\\... ?
        String fileName = String.format(format, path, fecha, nombreReporteGlosario, codigoGlosario, descripcionGlosario);
        System.out.println(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileName);
        workbook.write(outputStream);
        workbook.close();

    }

    private static void createRowCampoGlosario(CampoGlosario campoGlosario, Row row) // creating cells for each row
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
        cell.setCellValue(campoGlosario.getMcaExcepcion());
    }

    @Override
    @SneakyThrows
    public void generarExcelValidacionNomenclatura(InformeValidacion informeValidacion) {

    }
}
