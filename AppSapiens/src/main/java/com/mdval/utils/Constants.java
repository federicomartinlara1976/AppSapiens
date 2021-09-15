package com.mdval.utils;

/**
 * @author federico
 *
 */
public class Constants {
	
	/**
	 * App globals
	 */
	public static final String COD_USR = "CodUsr";
	public static final String SPRING_CONTEXT = "SPRING_CONTEXT";
	public static final String SERVICE_ERROR = "SERVICE_ERROR";
	public static final String ERROR = "ERROR";
	public static final String SI = "SI";
	public static final String NO = "NO";
	public static final String S = "S";
	public static final String N = "N";

	/**
	 * Report templates
	 */
	public static final String CAMPO_GLOSARIO_TEMPLATE_LOCATION = "/templates/glosarioCamposModelo.xlt";
	public static final String NOMENCLATURA_ERRORES_TEMPLATE_LOCATION = "/templates/validacionNomenclatura.xltx";
	public static final String NOMENCLATURA_OTRA_DEFINICION_TEMPLATE_LOCATION = "/templates/validacionNomenclatura.xltx";
	public static final String NOMENCLATURA_GLOSARIO_TEMPLATE_LOCATION = "/templates/validacionGlosario.xltx";
	
	/**
	 * Bean names
	 */
	public static final String EXCEL_GENERATOR_SERVICE = "excelGeneratorService";
	public static final String VALIDACION_SERVICE = "validacionService";
	public static final String VALOR_PARTICULA_SERVICE = "valorParticulaService";
	public static final String PARTICULA_NORMA_SERVICE = "particulaNormaService";
	public static final String TIPO_ELEMENTO_SERVICE = "tipoElementoService";
	public static final String TIPO_DATO_SERVICE = "tipoDatoService";
	public static final String TIPO_PARTICULA_SERVICE = "tipoParticulaService";
	public static final String MODELO_SERVICE = "modeloService";
	public static final String GLOSARIO_SERVICE = "glosarioService";
	public static final String CAMPOS_GLOSARIO_SERVICE = "camposGlosarioService";
	public static final String NORMA_SERVICE = "normaService";
	public static final String ELEMENTO_NORMA_SERVICE = "elementoNormaService";
	public static final String INFORME_SERVICE = "informeService";

	/**
	 * DataBase Types
	 */
	public static final String T_T_LINEA = "T_T_LINEA";
	public static final String T_T_VALIDA_PARTICULA = "T_T_VALIDA_PARTICULA";
	public static final String T_T_VAL_PARTICULA = "T_T_VAL_PARTICULA";
	public static final String T_T_ELEMENTO = "T_T_ELEMENTO";
	public static final String T_T_NORMA = "T_T_NORMA";
	public static final String T_T_PARTICULA = "T_T_PARTICULA";
	public static final String T_T_TIPO_DATO = "T_T_TIPO_DATO";
	public static final String T_T_SUBPROYECTO = "T_T_SUBPROYECTO";
	public static final String T_T_MODELO = "T_T_MODELO";
	public static final String T_T_CAMPO_GLOSARIO = "T_T_CAMPO_GLOSARIO";
	public static final String T_T_DET_VALIDACION = "T_T_DET_VALIDACION";
	public static final String T_T_ELEMENTO_NORMA = "T_T_ELEMENTO_NORMA";
	public static final String T_T_PARTICULA_NORMA = "T_T_PARTICULA_NORMA";
	public static final String T_T_GLOSARIO = "T_T_GLOSARIO";
	public static final String T_T_ERROR = "T_T_ERROR";
	
	
	 // CONSTANTES DE UI
	
	// Tecla Enter, para los botones
	public static final String KEY_ENTER = "ENTER";
	
	/**
	 * Menu de la aplicación
	 */
	public static final String MNU_DEF_GLOSARIOS = "MNU_DEF_GLOSARIOS";
	public static final String MNU_DATOS_GLOSARIO_CAMPOS = "MNU_DATOS_GLOSARIO_CAMPOS";
	public static final String MNU_DEF_NORMAS = "MNU_DEF_NORMAS";
	public static final String MNU_DEF_ELEMENTOS = "MNU_DEF_ELEMENTOS";
	public static final String MNU_DEF_ELEMENTOS_NORMA = "MNU_DEF_ELEMENTOS_NORMA";
	public static final String MNU_DEF_TIPOS_PARTICULAS = "MNU_DEF_TIPOS_PARTICULAS";
	public static final String MNU_DEF_PARTICULAS_NORMA_ELEMENTO = "MNU_DEF_PARTICULAS_NORMA_ELEMENTO";
	public static final String MNU_VALORES_PARTICULAS = "MNU_VALORES_PARTICULAS";
	public static final String MNU_COMPROBAR_NOMBRE_ELEMENTO = "MNU_COMPROBAR_NOMBRE_ELEMENTO";
	public static final String MNU_MODELOS = "MNU_MODELOS";
	
	/**
	 * Comandos que activan dialogos
	 */
	public static final String CMD_INICIAR_APP = "CMD_INICIAR_APP";
	public static final String CMD_PANEL_PRINCIPAL_TAB_EXCEPCIONES = "CMD_PANEL_PRINCIPAL_TAB_EXCEPCIONES";
	public static final String CMD_ALTA_GLOSARIOS = "CMD_ALTA_GLOSARIOS";
	public static final String CMD_MODIFICACION_GLOSARIOS = "CMD_MODIFICACION_GLOSARIOS";
	public static final String CMD_BAJA_GLOSARIO_CAMPOS = "CMD_BAJA_GLOSARIO_CAMPOS";
	public static final String CMD_ALTA_GLOSARIO_CAMPOS = "CMD_ALTA_GLOSARIO_CAMPOS";
	public static final String CMD_MODIFICACION_GLOSARIO_CAMPOS = "CMD_MODIFICACION_GLOSARIO_CAMPOS";
	public static final String CMD_ALTA_NORMAS = "CMD_ALTA_NORMAS";
	public static final String CMD_MODIFICACION_NORMAS = "CMD_MODIFICACION_NORMAS";
	public static final String CMD_ALTA_ELEMENTOS = "CMD_ALTA_ELEMENTOS";
	public static final String CMD_MODIFICACION_ELEMENTOS = "CMD_MODIFICACION_ELEMENTOS";
	public static final String CMD_ALTA_TIPOS_PARTICULA = "CMD_ALTA_TIPOS_PARTICULA";
	public static final String CMD_MODIFICACION_TIPOS_PARTICULA = "CMD_MODIFICACION_TIPOS_PARTICULA";
	public static final String CMD_ALTA_VALORES_PARTICULAS = "CMD_ALTA_VALORES_PARTICULAS";
	public static final String CMD_BAJA_VALORES_PARTICULAS = "CMD_BAJA_VALORES_PARTICULAS";
	public static final String CMD_MODIFICACION_VALORES_PARTICULAS = "CMD_MODIFICACION_VALORES_PARTICULAS";
	public static final String CMD_ALTA_MANTENIMIENTO_PARTICULAS = "CMD_ALTA_MANTENIMIENTO_PARTICULAS";
	public static final String CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS = "CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS";
	public static final String CMD_ALTA_MODELOS = "CMD_ALTA_MODELOS";
	public static final String CMD_MODIFICACION_MODELOS = "CMD_MODIFICACION_MODELOS";
	public static final String CMD_ERROR = "CMD_ERROR";
	public static final String CMD_BUSCAR_MODELOS = "CMD_BUSCAR_MODELOS";
	
	/**
	 * Panel principal
	 */
	public static final String PANEL_PRINCIPAL_BTN_SEARCH = "PANEL_PRINCIPAL_BTN_SEARCH";
	public static final String PANEL_PRINCIPAL_BTN_LOAD_SCRIPT = "PANEL_PRINCIPAL_BTN_LOAD_SCRIPT";
	public static final String PANEL_PRINCIPAL_BTN_VALIDAR = "PANEL_PRINCIPAL_BTN_VALIDAR";
	public static final String PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION = "PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION";
	public static final String PANEL_PRINCIPAL_BTN_LIMPIAR_TODO = "PANEL_PRINCIPAL_BTN_LIMPIAR_TODO";
	
	/**
	 * DlgIdentificador
	 */
	public static final String DLG_IDENTIFICADOR_BTN_ACEPTAR = "DLG_IDENTIFICADOR_BTN_ACEPTAR";
	
	/**
	 * DlgExcepciones
	 */
	public static final String DLG_EXCEPCIONES_BTN_ACEPTAR = "DLG_EXCEPCIONES_BTN_ACEPTAR";
	public static final String DLG_EXCEPCIONES_BTN_CANCELAR = "DLG_EXCEPCIONES_BTN_CANCELAR";
	
	/**
	 * DlgDefinicionGlosarios constantes
	 */
	public static final String FRM_DEFINICION_GLOSARIOS_SELECCIONADO = "FRM_DEFINICION_GLOSARIOS_SELECCIONADO";
	public static final String FRM_DEFINICION_GLOSARIOS_TABLA_GLOSARIOS_CABECERA = "FRM_DEFINICION_GLOSARIOS_TABLA_GLOSARIOS_CABECERA";
	public static final String FRM_DEFINICION_GLOSARIOS_BTN_BUSCAR = "FRM_DEFINICION_GLOSARIOS_BTN_BUSCAR";
	public static final String FRM_DEFINICION_GLOSARIOS_BTN_ALTA = "FRM_DEFINICION_GLOSARIOS_BTN_ALTA";
	public static final String FRM_DEFINICION_GLOSARIOS_BTN_MODIFICACION = "FRM_DEFINICION_GLOSARIOS_BTN_MODIFICACION";
	public static final String FRM_DEFINICION_GLOSARIOS_BTN_SELECCIONAR = "FRM_DEFINICION_GLOSARIOS_BTN_SELECCIONAR";
	
	/**
	 * DlgAltaModificacionGlosarios
	 */
	public static final String DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR = "DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR";
	public static final String DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR = "DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR";

	/**
	 * FrmGlosarioCampos
	 */
	public static final String FRM_GLOSARIO_CAMPOS_CAMPO_SELECCIONADO = "FRM_GLOSARIO_CAMPOS_CAMPO_SELECCIONADO";
	public static final String FRM_GLOSARIO_CAMPOS_GLOSARIO_SELECCIONADO = "FRM_GLOSARIO_CAMPOS_GLOSARIO_SELECCIONADO";
	public static final String FRM_GLOSARIO_CAMPOS_TABLA_CAMPO_CABECERA = "FRM_GLOSARIO_CAMPOS_TABLA_CAMPO_CABECERA";
	public static final String FRM_GLOSARIO_CAMPOS_TABLA_MODELO_CABECERA = "FRM_GLOSARIO_CAMPOS_TABLA_MODELO_CABECERA";
	public static final String FRM_GLOSARIO_CAMPOS_BTN_BUSCAR_GLOSARIO = "FRM_GLOSARIO_CAMPOS_BTN_BUSCAR_GLOSARIO";
	public static final String FRM_GLOSARIO_CAMPOS_BTN_BUSCAR = "FRM_GLOSARIO_CAMPOS_BTN_BUSCAR";
	public static final String FRM_GLOSARIO_CAMPOS_BTN_ALTA = "FRM_GLOSARIO_CAMPOS_BTN_ALTA";
	public static final String FRM_GLOSARIO_CAMPOS_BTN_BAJA = "FRM_GLOSARIO_CAMPOS_BTN_BAJA";
	public static final String FRM_GLOSARIO_CAMPOS_BTN_MODIFICACION = "FRM_GLOSARIO_CAMPOS_BTN_MODIFICACION";
	public static final String FRM_GLOSARIO_CAMPOS_BTN_IMPRIMIR = "FRM_GLOSARIO_CAMPOS_BTN_IMPRIMIR";
	
	/**
	 * DlgAltaModificacionCampos
	 */
	public static final String DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR = "DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR";
	public static final String DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR = "DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR";
	
	public static final String DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR = "DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR";
	public static final String DLG_BAJA_CAMPO_GLOSARIO_BTN_CANCELAR = "DLG_BAJA_CAMPO_GLOSARIO_BTN_CANCELAR";
	
	/**
	 * DlgBajaGlosario
	 */
	public static final String DLG_BAJA_GLOSARIO_BTN_ACEPTAR = "DLG_BAJA_GLOSARIO_BTN_ACEPTAR";
	public static final String DLG_BAJA_GLOSARIO_BTN_CANCELAR = "DLG_BAJA_GLOSARIO_BTN_CANCELAR";
	
	/**
	 * FrmDefinicionNormas
	 */
	public static final String FRM_DEFINICION_NORMAS_SELECCIONADA = "FRM_DEFINICION_NORMAS_SELECCIONADA";
	public static final String FRM_DEFINICION_NORMAS_TABLA_NORMAS_CABECERA = "FRM_DEFINICION_NORMAS_TABLA_NORMAS_CABECERA";
	public static final String FRM_DEFINICION_NORMAS_BTN_BUSCAR = "FRM_DEFINICION_NORMAS_BTN_BUSCAR";
	public static final String FRM_DEFINICION_NORMAS_BTN_ALTA = "FRM_DEFINICION_NORMAS_BTN_ALTA";
	public static final String FRM_DEFINICION_NORMAS_BTN_MODIFICACION = "FRM_DEFINICION_NORMAS_BTN_MODIFICACION";
	
	/**
	 * DlgAltaModificacionNormas
	 */
	public static final String DLG_MODIFICACION_NORMAS_ELEMENTO_SELECCIONADO = "DLG_MODIFICACION_NORMAS_ELEMENTO_SELECCIONADO";
	public static final String DLG_MODIFICACION_NORMAS_TABLA_ELEMENTOS_CABECERA = "DLG_MODIFICACION_NORMAS_TABLA_ELEMENTOS_CABECERA";
	public static final String DLG_MODIFICACION_NORMAS_TABLA_PARTICULAS_CABECERA = "DLG_MODIFICACION_NORMAS_TABLA_PARTICULAS_CABECERA";
	public static final String DLG_MODIFICACION_NORMAS_BTN_ALTA_ELEMENTO = "DLG_MODIFICACION_NORMAS_BTN_ALTA_ELEMENTO";
	public static final String DLG_MODIFICACION_NORMAS_BTN_BAJA_ELEMENTO = "DLG_MODIFICACION_NORMAS_BTN_BAJA_ELEMENTO";
	public static final String DLG_MODIFICACION_NORMAS_BTN_MODIFICACION_ELEMENTO = "DLG_MODIFICACION_NORMAS_BTN_MODIFICACION_ELEMENTO";
	public static final String DLG_MODIFICACION_NORMAS_BTN_ACEPTAR = "DLG_MODIFICACION_NORMAS_BTN_ACEPTAR";
	public static final String DLG_MODIFICACION_NORMAS_BTN_CANCELAR = "DLG_MODIFICACION_NORMAS_BTN_CANCELAR";
	
	/**
	 * FrmDefinicionElementos
	 */
	public static final String FRM_DEFINICION_ELEMENTOS_SELECCIONADO = "FRM_DEFINICION_ELEMENTOS_SELECCIONADO";
	public static final String FRM_DEFINICION_ELEMENTOS_TABLA_TIPOS_ELEMENTO_CABECERA = "FRM_DEFINICION_ELEMENTOS_TABLA_TIPOS_ELEMENTO_CABECERA";
	public static final String FRM_DEFINICION_ELEMENTOS_BTN_BUSCAR = "FRM_DEFINICION_ELEMENTOS_BTN_BUSCAR";
	public static final String FRM_DEFINICION_ELEMENTOS_BTN_ALTA = "FRM_DEFINICION_ELEMENTOS_BTN_ALTA";
	public static final String FRM_DEFINICION_ELEMENTOS_BTN_MODIFICACION = "FRM_DEFINICION_ELEMENTOS_BTN_MODIFICACION";
	
	/**
	 * DlgAltaModificacionTiposElemento
	 */
	public static final String DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_ACEPTAR = "DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_ACEPTAR";
	public static final String DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_CANCELAR = "DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_CANCELAR";
	
	/**
	 * FrmDefinicionElementosNorma
	 */
	public static final String FRM_DEFINICION_ELEMENTOS_NORMA_TABLA_ELEMENTOS_CABECERA = "FRM_DEFINICION_ELEMENTOS_NORMA_TABLA_ELEMENTOS_CABECERA";
	public static final String FRM_DEFINICION_ELEMENTOS_NORMA_BTN_BUSCAR = "FRM_DEFINICION_ELEMENTOS_NORMA_BTN_BUSCAR";
	
	public static final String FRM_DEFINICION_TIPOS_PARTICULA_SELECCIONADO = "FRM_DEFINICION_TIPOS_PARTICULA_SELECCIONADO";
	public static final String FRM_DEFINICION_TIPOS_PARTICULA_TABLA_TIPOS_CABECERA = "FRM_DEFINICION_TIPOS_PARTICULA_TABLA_TIPOS_CABECERA";
	public static final String FRM_DEFINICION_TIPOS_PARTICULA_BTN_BUSCAR = "FRM_DEFINICION_TIPOS_PARTICULA_BTN_BUSCAR";
	public static final String FRM_DEFINICION_TIPOS_PARTICULA_BTN_ALTA = "FRM_DEFINICION_TIPOS_PARTICULA_BTN_ALTA";
	public static final String FRM_DEFINICION_TIPOS_PARTICULA_BTN_MODIFICACION = "FRM_DEFINICION_TIPOS_PARTICULA_BTN_MODIFICACION";
	
	public static final String DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_ACEPTAR = "DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_ACEPTAR";
	public static final String DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_CANCELAR = "DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_CANCELAR";
	
	public static final String FRM_DEFINICION_PARTICULAS_NORMA_CABECERA = "FRM_DEFINICION_PARTICULAS_NORMA_CABECERA";
	public static final String FRM_DEFINICION_PARTICULAS_NORMA_BTN_BUSCAR = "FRM_DEFINICION_PARTICULAS_NORMA_BTN_BUSCAR";
	
	public static final String FRM_VALORES_PARTICULAS_CABECERA = "FRM_VALORES_PARTICULAS_CABECERA";
	public static final String FRM_VALORES_PARTICULAS_SELECCIONADA = "FRM_VALORES_PARTICULAS_SELECCIONADA";
	public static final String FRM_VALORES_PARTICULAS_BTN_BUSCAR = "FRM_VALORES_PARTICULAS_BTN_BUSCAR";
	public static final String FRM_VALORES_PARTICULAS_BTN_ALTA = "FRM_VALORES_PARTICULAS_BTN_ALTA";
	public static final String FRM_VALORES_PARTICULAS_BTN_MODIFICACION = "FRM_VALORES_PARTICULAS_BTN_MODIFICACION";
	
	public static final String FRM_MANTENIMIENTO_PARTICULAS_TIPO_SELECCIONADO = "FRM_MANTENIMIENTO_PARTICULAS_TIPO_SELECCIONADO";
	public static final String FRM_MANTENIMIENTO_PARTICULAS_VALOR_SELECCIONADO = "FRM_MANTENIMIENTO_PARTICULAS_VALOR_SELECCIONADO";
	public static final String FRM_MANTENIMIENTO_PARTICULAS_BTN_ALTA = "FRM_MANTENIMIENTO_PARTICULAS_BTN_ALTA";
	public static final String FRM_MANTENIMIENTO_PARTICULAS_BTN_BAJA = "FRM_MANTENIMIENTO_PARTICULAS_BTN_BAJA";
	public static final String FRM_MANTENIMIENTO_PARTICULAS_BTN_MODIFICACION = "FRM_MANTENIMIENTO_PARTICULAS_BTN_MODIFICACION";
	public static final String FRM_MANTENIMIENTO_PARTICULAS_BTN_ACEPTAR = "FRM_MANTENIMIENTO_PARTICULAS_BTN_ACEPTAR";
	public static final String FRM_MANTENIMIENTO_PARTICULAS_BTN_CANCELAR = "FRM_MANTENIMIENTO_PARTICULAS_BTN_CANCELAR";
	
	public static final String DLG_ALTA_MODIFICACION_VALORES_PARTICULA_BTN_ACEPTAR = "DLG_ALTA_MODIFICACION_VALORES_PARTICULA_BTN_ACEPTAR";
	public static final String DLG_ALTA_MODIFICACION_VALORES_PARTICULA_BTN_CANCELAR = "DLG_ALTA_MODIFICACION_VALORES_PARTICULA_BTN_CANCELAR";
	
	public static final String FRM_DEFINICION_MODELOS_SELECCIONADO = "FRM_DEFINICION_MODELOS_SELECCIONADO";
	public static final String FRM_DEFINICION_MODELOS_TABLA_CABECERA = "FRM_DEFINICION_MODELOS_TABLA_CABECERA";
	public static final String FRM_DEFINICION_MODELOS_BTN_BUSCAR = "FRM_DEFINICION_MODELOS_BTN_BUSCAR";
	public static final String FRM_DEFINICION_MODELOS_BTN_ALTA = "FRM_DEFINICION_MODELOS_BTN_ALTA";
	public static final String FRM_DEFINICION_MODELOS_BTN_BAJA = "FRM_DEFINICION_MODELOS_BTN_BAJA";
	public static final String FRM_DEFINICION_MODELOS_BTN_MODIFICACION = "FRM_DEFINICION_MODELOS_BTN_MODIFICACION";
	
	public static final String FRM_MANTENIMIENTO_MODELOS_SUBPROYECTO_TABLA_CABECERA = "FRM_MANTENIMIENTO_MODELOS_SUBPROYECTO_TABLA_CABECERA";
	public static final String FRM_MANTENIMIENTO_MODELOS_BTN_BUSCAR_GLOSARIO = "FRM_MANTENIMIENTO_MODELOS_BTN_BUSCAR_GLOSARIO";
	public static final String FRM_MANTENIMIENTO_MODELOS_BTN_ADD_SUBMODELO = "FRM_MANTENIMIENTO_MODELOS_BTN_ADD_SUBMODELO";
	public static final String FRM_MANTENIMIENTO_MODELOS_BTN_REMOVE_SUBMODELO = "FRM_MANTENIMIENTO_MODELOS_BTN_REMOVE_SUBMODELO";
	public static final String FRM_MANTENIMIENTO_MODELOS_BTN_ACEPTAR = "FRM_MANTENIMIENTO_MODELOS_BTN_ACEPTAR";
	public static final String FRM_MANTENIMIENTO_MODELOS_BTN_CANCELAR = "FRM_MANTENIMIENTO_MODELOS_BTN_CANCELAR";
	
	public static final String FRM_COMPROBACION_NOMBRE_ELEMENTO_TABLA_CABECERA = "FRM_COMPROBACION_NOMBRE_ELEMENTO_TABLA_CABECERA";
	public static final String FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_BUSCAR = "FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_BUSCAR";
	public static final String FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_COMPROBAR = "FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_COMPROBAR";
	
}
