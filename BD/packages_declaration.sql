CREATE OR REPLACE PACKAGE SAPIENS.SM2_K_VALIDATOR_JAVA3 
	AS
	/**---------------------------------------------------------------------------------------------------
  || Paquete que se utiliza para validar de scripts 
  */
	---------------------------------------------------------------------------------------------------
	-- Constantes
	C_RESULTADO_OK CONSTANT NUMBER(1) := 1;

	C_RESULTADO_NOK CONSTANT NUMBER(1) := 0;

	C_RESULTADO_AVISO CONSTANT NUMBER(1) := 2;
	-- Colecciones para intercambio con Java
	TYPE t_r_linea IS RECORD(
    	txt_linea VARCHAR2(32000));

  	TYPE t_t_linea IS TABLE OF t_r_linea INDEX BY BINARY_INTEGER;

  	TYPE t_r_error_particula IS RECORD(
    	val_particula VARCHAR2(30),
    	cod_error     NUMBER(2));

  	TYPE t_t_error_particula IS TABLE OF t_r_error_particula INDEX BY BINARY_INTEGER;

	TYPE t_r_valida_particula IS RECORD(
	    num_particula INTEGER,
	    txt_validacion VARCHAR2(100),
	    txt_valor VARCHAR2(100),
	    des_estado_valid VARCHAR2(60));

	TYPE t_t_valida_particula IS TABLE OF t_r_valida_particula INDEX BY BINARY_INTEGER;

	TYPE t_r_error IS RECORD(txt_error VARCHAR2(200));

	TYPE t_t_error IS TABLE OF t_r_error INDEX BY BINARY_INTEGER;

	TYPE t_r_tipo_dato IS RECORD(tip_dato VARCHAR2(30));

	TYPE t_t_tipo_dato IS TABLE OF t_r_tipo_dato INDEX BY BINARY_INTEGER;

	TYPE t_r_glosario IS RECORD(
	    cod_glosario NUMBER(3),
	    des_glosario VARCHAR2(150),
	    fec_alta DATE,
	    cod_usr VARCHAR2(8),
    	fec_actu DATE);

	TYPE t_t_glosario IS TABLE OF t_r_glosario INDEX BY BINARY_INTEGER;

	TYPE t_r_campo_glosario IS RECORD(
		nom_columna VARCHAR2(30),
    	tip_dato VARCHAR2(40),
    	num_longitud NUMBER,
    	num_decimal NUMBER,
    	cod_glosario NUMBER(3),
    	mca_excepcion VARCHAR2(1),
    	txt_comentarios VARCHAR2(4000),
    	txt_excepcion VARCHAR2(200),
    	cod_usr VARCHAR2(8),
    	fec_actu DATE);

	TYPE t_t_campo_glosario IS TABLE OF t_r_campo_glosario INDEX BY BINARY_INTEGER;

	TYPE t_r_modelo IS RECORD(
    	cod_proyecto VARCHAR2(30),
    	nom_modelo VARCHAR2(100),
   	 	nom_esquema VARCHAR2(30),
    	nom_bbdd VARCHAR2(30),
    	cod_grupo_bds VARCHAR2(50),
    	nom_carpeta_adj VARCHAR2(100),
    	cod_norma NUMBER(2),
    	des_norma VARCHAR2(50),
    	nom_apn_cmdb VARCHAR2(200),
    	cod_glosario NUMBER(3),
    	des_glosario VARCHAR2(150),
    	cod_herramienta VARCHAR2(20),
    	obs_modelo VARCHAR2(200),
    	cod_usr VARCHAR2(30),
    	fec_actu DATE,
    	cod_capa_usrown VARCHAR2(10),
    	mca_variables VARCHAR2(1),
    	mca_grant_all VARCHAR2(1),
   	 	mca_grant_public VARCHAR2(1),
   	 	mca_inh VARCHAR2(1));

	TYPE t_t_modelo IS TABLE OF t_r_modelo INDEX BY BINARY_INTEGER;

	TYPE t_r_norma IS RECORD(
    	cod_norma NUMBER(2),
    	des_norma VARCHAR2(50),
    	cod_usr VARCHAR2(8),
    	fec_actu DATE);

	TYPE t_t_norma IS TABLE OF t_r_norma INDEX BY BINARY_INTEGER;

	TYPE t_r_particula IS RECORD(
    	cod_particula NUMBER(5),
    	des_particula VARCHAR2(80),
    	cod_usr VARCHAR2(8),
    	fec_actu DATE,
    	mca_proyecto VARCHAR2(1),
    	mca_sub_proy VARCHAR2(1));

	TYPE t_t_particula IS TABLE OF t_r_particula INDEX BY BINARY_INTEGER;

	TYPE t_r_particula_norma IS RECORD(
    	cod_norma NUMBER(2),
    	des_norma VARCHAR2(50),
    	cod_elemento NUMBER(3),
    	des_elemento VARCHAR2(50),
    	num_particula NUMBER(2),
    	des_num_part VARCHAR2(50),
    	mca_obligatoria VARCHAR2(1),
    	mca_validacion VARCHAR2(1),
    	val_tam_min NUMBER(2),
    	val_tam_max NUMBER(2),
    	mca_val_padre VARCHAR2(1),
    	num_part_padre NUMBER(2),
    	cod_usr VARCHAR2(8),
    	fec_actu DATE,
    	tip_validacion VARCHAR2(20),
    	cod_particula NUMBER(5),
    	des_particula VARCHAR2(80),
    	mca_proyecto VARCHAR2(1),
    	txt_formato_part VARCHAR2(200));

	TYPE t_t_particula_norma IS TABLE OF t_r_particula_norma INDEX BY BINARY_INTEGER;

	TYPE t_r_elemento_norma IS RECORD(
	    cod_norma NUMBER(2),
	    des_norma VARCHAR2(50),
	    cod_elemento NUMBER(3),
	    des_elemento VARCHAR2(50),
	    val_tam_max NUMBER(2),
	    txt_formato VARCHAR2(200),
	    cod_usr VARCHAR2(8),
	    fec_actu DATE,
	    txt_formato_des1 VARCHAR2(200),
	    txt_formato_des2 VARCHAR2(200),
	    txt_formato_des3 VARCHAR2(200));

	TYPE t_t_elemento_norma IS TABLE OF t_r_elemento_norma INDEX BY BINARY_INTEGER;

	TYPE t_r_elemento IS RECORD(
	    cod_elemento NUMBER(3),
	    des_elemento VARCHAR2(50),
	    cod_usr VARCHAR2(8),
	    fec_actu DATE);

	TYPE t_t_elemento IS TABLE OF t_r_elemento INDEX BY BINARY_INTEGER;

	TYPE t_r_val_particula IS RECORD(
	    cod_particula NUMBER(5),
	    val_particula VARCHAR2(10),
	    des_val_part VARCHAR2(60),
	    cod_proyecto VARCHAR2(30),
	    cod_sub_proy VARCHAR2(30),
	    val_part_padre VARCHAR2(10),
	    cod_usr VARCHAR2(8),
	    fec_actu DATE);

	TYPE t_t_val_particula IS TABLE OF t_r_val_particula INDEX BY BINARY_INTEGER;

	TYPE t_r_subproyecto IS RECORD(
	    cod_proyecto VARCHAR2(30),
	    cod_sub_proy VARCHAR2(30),
	    des_sub_proy VARCHAR2(150),
	    cod_usr VARCHAR2(8),
	    fec_actu DATE);

	TYPE t_t_subproyecto IS TABLE OF t_r_subproyecto INDEX BY BINARY_INTEGER;

	TYPE t_r_det_validacion IS RECORD(
	    num_validacion NUMBER,
	    num_elem_valid NUMBER(6),
	    des_elemento VARCHAR2(50),
	    nom_tabla VARCHAR2(60),
	    nom_elemento VARCHAR2(60),
	    tip_dato VARCHAR2(60),
	    num_longitud NUMBER,
	    num_decimal NUMBER,
	    cod_estado_valid NUMBER(2),
	    txt_des_valid VARCHAR2(200));

	TYPE t_t_det_validacion IS TABLE OF t_r_det_validacion INDEX BY BINARY_INTEGER;

	/*----------------------------------------------------------------------------------------
  || Procedimiento que inserta un elemento procedente de una validaci�n el glosario 
  || Entrada:
  || p_num_validacion  : N�mero de validaci�n 
  || p_num_elem_valid  : N�mero de elemento validado 
  || p_cod_usr         : Usuario que ha realizado la validaci�n
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
	PROCEDURE p_insertar_en_glosario(p_num_validacion IN NUMBER,
                                   p_num_elem_valid IN NUMBER,
                                   p_cod_usr        IN VARCHAR2,
                                   p_resultado      IN OUT NOCOPY INTEGER,
                                   p_lista_errores  IN OUT NOCOPY t_t_error);
                                  
   /*----------------------------------------------------------------------------------------
  || Procedimiento que inserta un elemento procedente de una validaci�n como excepci�n en el glosario 
  || Entrada:
  || p_num_validacion  : N�mero de validaci�n 
  || p_num_elem_valid  : N�mero de elemento validado 
  || p_txt_excepcion   : Texto descriptivo de la excepci�n
  || p_cod_usr         : Usuario que ha realizado la validaci�n
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_insertar_excepcion(p_num_validacion IN NUMBER,
                                 p_num_elem_valid IN NUMBER,
                                 p_txt_excepcion  IN VARCHAR2,
                                 p_cod_usr        IN VARCHAR2,
                                 p_resultado      IN OUT NOCOPY INTEGER,
                                 p_lista_errores  IN OUT NOCOPY t_t_error);
                                
  /*----------------------------------------------------------------------------------------
  || Procedimiento que valida un elemento (para pantalla de validaci�n de un elemento)
  || Entrada:
  || p_cod_norma       : C�digo de norma
  || p_cod_proyecto    : C�digo de proyecto
  || p_cod_sub_proy    : C�digo de subproyecto
  || p_cod_elemento    : Tipo de elemento
  || p_nom_elemento    : Nombre del elemento  
  || Salida:
  || p_lista_val_particulas:  : Lista de part�culas con su detalle de validaci�n
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  PROCEDURE p_validar_elemento(p_cod_norma            IN NUMBER,
                               p_cod_proyecto         IN VARCHAR2,
                               p_cod_sub_proy         IN VARCHAR2,
                               p_cod_elemento         IN NUMBER,
                               p_nom_elemento         IN VARCHAR2,
                               p_lista_val_particulas OUT NOCOPY t_t_valida_particula,
                               p_resultado            IN OUT NOCOPY INTEGER,
                               p_lista_errores        IN OUT NOCOPY t_t_error);

	/*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo campo en el glosario 
  || Entrada:
  || p_cod_glosario       : C�digo de glosario
  || p_nom_columna        : Nombre del campo
  || p_tip_dato           : Tipo de dato
  || p_num_longitud       : Longitud
  || p_num_decimal        : Decimales
  || p_mca_excepcion      : Indicador de excepci�n (S/N)
  || p_txt_excepcion      : Descripci�n de excepci�n  
  || p_txt_comentarios    : Observaciones
  || p_cod_usr            : Usuario que realiza el alta    
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_alta_campo_glosario(p_cod_glosario    IN NUMBER,
                                  p_nom_columna     IN VARCHAR2,
                                  p_tip_dato        IN VARCHAR2,
                                  p_num_longitud    IN NUMBER,
                                  p_num_decimal     IN NUMBER,
                                  p_mca_excepcion   IN VARCHAR2,
                                  p_txt_excepcion   IN VARCHAR2,
                                  p_txt_comentarios IN VARCHAR2,
                                  p_cod_usr         IN VARCHAR2,
                                  p_resultado       IN OUT NOCOPY INTEGER,
                                  p_lista_errores   IN OUT NOCOPY t_t_error);
                                 
	 /*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo glosario 
  || Entrada:
  || p_des_glosario       : Descripción
  || p_cod_usr            : Usuario que realiza el alta    
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------   
	PROCEDURE p_alta_glosario(p_des_glosario  IN VARCHAR2,
                            	p_cod_usr       IN VARCHAR2,
                           	 	p_resultado     IN OUT NOCOPY INTEGER,
                            	p_lista_errores IN OUT NOCOPY t_t_error);
                            
	/*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo modelo, junto con sus submodelos 
  || Entrada:
  || p_cod_proyecto       : C�digo de modelo
  || p_nom_modelo         : Nombre de modelo
  || p_cod_norma          : C�digo de norma
  || p_cod_glosario       : C�digo de glosario
  || p_nom_esquema        : Esquema
  || p_nom_bbdd           : Base de datos
  || p_nom_carpeta_adj    : Carpeta
  || p_cod_grupo_bds      : Grupo
  || p_cod_herramienta    : Herramienta 
  || p_obs_modelo         : Observaciones
  || p_cod_usr            : Usuario que realiza el alta  
  || p_nom_apn_cmdb       : Aplicaci�n desde la que se usa el modelo 
  || p_mca_grant_all      : Grant All
  || p_mca_grant_public   : Grant Public
  || p_mca_variables      : Genera Variables
  || p_cod_capa_usrown    : Variables con capa (S/N)
  || --p_cod_RF           : C�digo de petici�n
  || --p_cod_SD           : C�digo de solicitud
  || p_lista_subproyectos : Lista de subproyectos
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_alta_modelo(p_cod_proyecto    IN VARCHAR2,
                          p_nom_modelo      IN VARCHAR2,
                          p_cod_norma       IN NUMBER,
                          p_cod_glosario    IN NUMBER,
                          p_nom_esquema     IN VARCHAR2,
                          p_nom_bbdd        IN VARCHAR2,
                          p_nom_carpeta_adj IN VARCHAR2,
                          p_cod_grupo_bds   IN VARCHAR2, 
                          p_cod_herramienta IN VARCHAR2,
                          p_obs_modelo      IN VARCHAR2,                             
                          p_cod_usr          IN VARCHAR2,
                          p_nom_apn_cmdb     IN VARCHAR2,
                          p_mca_grant_all    IN VARCHAR2,
                          p_mca_grant_public IN VARCHAR2,
                          p_mca_variables    IN VARCHAR2,
                          p_cod_capa_usrown  IN VARCHAR2,
                          p_lista_subproyectos IN t_t_subproyecto,
                          p_resultado          IN OUT NOCOPY INTEGER,
                          p_lista_errores      IN OUT NOCOPY t_t_error);
     
	/*----------------------------------------------------------------------------------------
   || Procedimiento que da de alta un nuevo tipo de elemento 
   || Entrada:
   || p_des_elemento    : Descripcipci�n
   || p_cod_usr         : Usuario que realiza el alta    
   || Salida:
   || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
   || p_lista_errores   : Lista de errores
   */ ---------------------------------------------------------------------------------------
  procedure p_alta_tipo_elemento(p_des_elemento  IN VARCHAR2,
                                 p_cod_usr       IN VARCHAR2,
                                 p_resultado     IN OUT NOCOPY INTEGER,
                                 p_lista_errores IN OUT NOCOPY t_t_error);     
                                
	/*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo tipo de part�cula 
  || Entrada:
  || p_des_particula   : Descripci�n
  || p_cod_usr         : Usuario que realiza el alta    
  || p_mca_proyecto    : Distingue por proyecto (S/N)
  || p_mca_sub_proy    : Distingue por subproyecto (S/N)
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_alta_tipo_particula(p_des_particula IN VARCHAR2,
                                  p_cod_usr       IN VARCHAR2,
                                  p_mca_proyecto  IN VARCHAR2,
                                  p_mca_sub_proy  IN VARCHAR2,
                                  p_resultado     IN OUT NOCOPY INTEGER,
                                  p_lista_errores IN OUT NOCOPY t_t_error);

	/*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo valor de part�cula 
  || Entrada:
  || p_cod_particula   : C�digo de part�cula
  || p_val_particula   : Valor
  || p_des_val_part    : Descripci�n
  || p_cod_proyecto    : C�digo de proyecto
  || p_cod_sub_proy    : C�digo de subproyecto
  || p_val_part_padre  : C�digo de part�cula padre
  || p_cod_usr         : Usuario que realiza el alta    
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_alta_valor_particula(p_cod_particula  IN NUMBER,
                                   p_val_particula  IN VARCHAR2,
                                   p_des_val_part   IN VARCHAR2,
                                   p_cod_proyecto   IN VARCHAR2,
                                   p_cod_sub_proy   IN VARCHAR2,
                                   p_val_part_padre IN VARCHAR2,
                                   p_cod_usr        IN VARCHAR2,
                                   p_resultado      IN OUT NOCOPY INTEGER,
                                   p_lista_errores  IN OUT NOCOPY t_t_error);
                                  
	/*----------------------------------------------------------------------------------------
  || Procedimiento que da de baja un campo del glosario 
  || Entrada:
  || p_cod_glosario       : C�digo de glosario
  || p_nom_columna        : Nombre del campo
  || p_tip_dato           : Tipo de dato
  || p_num_longitud       : Longitud
  || p_num_decimal        : Decimales
  || p_cod_usr            : Usuario que realiza la baja  
  || p_cod_RF             : C�digo RF
  || p_cod_SD             : C�digo SD
  || p_txt_comentario     : Comentario
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error, 3-Aviso)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_baja_campo_glosario(p_cod_glosario   IN NUMBER,
                                  p_nom_columna    IN VARCHAR2,
                                  p_tip_dato       IN VARCHAR2,
                                  p_num_longitud   IN NUMBER,
                                  p_num_decimal    IN NUMBER,
                                  p_cod_usr        IN VARCHAR2,
                                  p_cod_RF         IN VARCHAR2,
                                  p_cod_SD         IN VARCHAR2,
                                  p_txt_comentario IN VARCHAR2,
                                  p_resultado      IN OUT NOCOPY INTEGER,
                                  p_lista_errores  IN OUT NOCOPY t_t_error);
                                 
	/*----------------------------------------------------------------------------------------
  || Procedimiento que realiza la baja (l�gica) de un modelo
  || Entrada:
  || p_cod_proyecto       : C�digo de modelo
  || p_cod_usr            : Usuario que realiza la baja  
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_baja_logica_modelo(p_cod_proyecto  IN VARCHAR2,
                                 p_cod_usr       IN VARCHAR2,
                                 p_resultado     IN OUT NOCOPY INTEGER,
                                 p_lista_errores IN OUT NOCOPY t_t_error);
                                 
	/*-------------------------------------------------------------------------------
	  || Busca los glosarios cuya descripción contenga un texto recibido como parámetro de entrada
	  || Si el texto de entrada está vacío, se devuelve la lista completa de glosarios
	  || Entrada:
	  ||         p_txt_des_glosario: texto para realizar la búsqueda
	  || Salida:
	  ||         p_lista_glosarios: Tabla con los datos de los glosarios encontrados
	  ||         p_resultado      : Indica si el procedimiento se ha ejecutado correctamente (1-Correcto, 0- Error)
	  ||         p_lista_errores  : Tabla con los textos de los errores producidos
	   */ -----------------------------------------------------------------------------
	PROCEDURE p_buscar_glosarios(p_txt_des_glosario IN VARCHAR2,
	                               p_lista_glosarios OUT NOCOPY t_t_glosario,
	                               p_resultado OUT NOCOPY INTEGER,
	                               p_lista_errores OUT NOCOPY t_t_error);
	                              
	/*----------------------------------------------------------------------------------------
  || Procedimiento que realiza la b�squeda de campos de un glosario 
  || Entrada:
  || p_cod_glosario       : C�digo de glosario (Obligatorio)
  || p_nom_columna        : Nombre del campo (Opcional): Si est� informado, se buscan las filas cuyo nombre de columna contengan ese texto
  || p_tip_dato           : Tipo de dato (Opcional): Si est� informado, se filtran los campos que sean de ese tipo
  || p_mostrar_excepciones: Mostrar Excepciones (Obligatorio): Indica si se muestran las excepciones, seg�n los valores S(defecto)/N
  || Salida:
  || p_lista_campos    : Lista de los campos que cumplen la condici�n de b�squeda
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_campos_glosario(p_cod_glosario        IN NUMBER,
                                  p_tip_dato            IN VARCHAR2,
                                  p_nom_columna         IN VARCHAR2,
                                  p_mostrar_excepciones IN VARCHAR2,
                                  p_lista_campos        OUT NOCOPY t_t_campo_glosario,
                                  p_resultado           IN OUT NOCOPY INTEGER,
                                  p_lista_errores       IN OUT NOCOPY t_t_error);
                                 
	/*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de las definiciones de elementos por norma
  || Entrada:
  || p_cod_norma       : C�digo de norma
  || p_cod_elemento    : Tipo de elemento
  || Salida:
  || p_lista_elem_norma: Lista de elementos
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_def_elem_norma(p_cod_norma        IN NUMBER,
                                 p_cod_elemento     IN NUMBER,
                                 p_lista_elem_norma OUT NOCOPY t_t_elemento_norma,
                                 p_resultado        IN OUT NOCOPY INTEGER,
                                 p_lista_errores    IN OUT NOCOPY t_t_error);
                                
	/*----------------------------------------------------------------------------------------
  || Procedimiento de b�squeda de part�culas por tipo de elemento y norma 
  || Entrada:
  || p_cod_norma       : C�digo de norma
  || p_cod_elemento    : Tipo de elemento
  || Salida:
  || p_lista_part_norma: Lista de part�culas
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_def_part_norma_elemento(p_cod_norma        IN NUMBER,
                                          p_cod_elemento     IN NUMBER,
                                          p_lista_part_norma OUT NOCOPY t_t_particula_norma,
                                          p_resultado        IN OUT NOCOPY INTEGER,
                                          p_lista_errores    IN OUT NOCOPY t_t_error);
                                         
	/*----------------------------------------------------------------------------------------
  || Procedimiento que busca tipos de part�culas por descripci�n
  || Entrada:
  || p_des_particula   : Texto de b�squeda. Si no se rellena, se devuelven todos los tipos
  || Salida:
  || p_lista_particulas: Lista de tipos de part�culas
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_def_tipos_particulas(p_des_particula    IN VARCHAR2,
                                       p_lista_particulas IN OUT NOCOPY t_t_particula,
                                       p_resultado        IN OUT NOCOPY INTEGER,
                                       p_lista_errores    IN OUT NOCOPY t_t_error);
                                      
	/*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de elementos correctos de una validaci�n
  || Entrada:
  || p_num_validacion   : N�mero de validaci�n
  || Salida:
  || p_lista_correctos: Lista de elementos correctos
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_elem_correctos_valid(p_num_validacion  IN NUMBER,
                                       p_lista_correctos OUT NOCOPY t_t_det_validacion,
                                       p_resultado       IN OUT NOCOPY INTEGER,
                                       p_lista_errores   IN OUT NOCOPY t_t_error);
                                      
	/*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de elementos con errores de una validaci�n
  || Entrada:
  || p_num_validacion   : N�mero de validaci�n
  || Salida:
  || p_lista_erroneos: Lista de elementos err�neos
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_elem_errores_validacion(p_num_validacion IN NUMBER,
                                          p_lista_erroneos OUT NOCOPY t_t_det_validacion,
                                          p_resultado      IN OUT NOCOPY INTEGER,
                                          p_lista_errores  IN OUT NOCOPY t_t_error);
                                         
	/*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de excepciones de una validaci�n
  || Entrada:
  || p_num_validacion   : N�mero de validaci�n
  || Salida:
  || p_lista_excepciones: Lista de excepciones
  || p_resultado        : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores    : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_elem_excepciones_valid(p_num_validacion    IN NUMBER,
                                         p_lista_excepciones OUT NOCOPY t_t_det_validacion,
                                         p_resultado         IN OUT NOCOPY INTEGER,
                                         p_lista_errores     IN OUT NOCOPY t_t_error);
                                        
	/*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de elementos que no est�n en el glosario de una validaci�n
  || Entrada:
  || p_num_validacion   : N�mero de validaci�n
  || Salida:
  || p_lista_no_glosario: Lista de elementos que no est�n en el glosario
  || p_resultado        : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores    : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_elem_no_glosario_valid(p_num_validacion    IN NUMBER,
                                         p_lista_no_glosario OUT NOCOPY t_t_det_validacion,
                                         p_resultado         IN OUT NOCOPY INTEGER,
                                         p_lista_errores     IN OUT NOCOPY t_t_error);
                                        
	/*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de elementos de una norma
  || Entrada:
  || p_cod_norma        : C�digo de norma
  || Salida:
  || p_lista_elem_norma : Lista de elementos de la norma
  || p_resultado        : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores    : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_elem_norma(p_cod_norma        IN NUMBER,
                             p_lista_elem_norma OUT NOCOPY t_t_elemento_norma,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error);
                            
	/*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de un modelo
  || Entrada:
  || p_cod_proyecto       : C�digo de modelo
  || Salida:
  || p_nom_modelo         : Nombre de modelo
  || p_cod_norma          : C�digo de norma
  || p_cod_glosario       : C�digo de glosario
  || p_des_glosario       : Descripci�n de glosario
  || p_nom_esquema        : Esquema
  || p_nom_bbdd           : Base de datos
  || p_nom_carpeta_adj    : Carpeta
  || p_cod_grupo_bds      : Grupo
  || p_cod_herramienta    : Herramienta 
  || p_nom_apn_cmdb       : Aplicaci�n
  || p_cod_usr            : Usuario de �ltima modificaci�n 
  || p_fec_actu           : Fecha de �ltima actualizaci�n
  || p_cod_capa_usrown    : Variables con capa (S/N)
  || p_mca_grant_all      : Grant All (S/N)
  || p_mca_grant_public   : Grant Public (S/N)
  || p_mca_variables      : Genera Variables (S/N)
  || p_obs_modelo         : Observaciones
  || p_lista_subproyectos : Lista de subproyectos  
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_modelo(p_cod_proyecto    IN VARCHAR2,
                         p_nom_modelo      OUT NOCOPY VARCHAR2,
                         p_cod_norma       OUT NOCOPY NUMBER,
                         p_cod_glosario    OUT NOCOPY NUMBER,
                         p_des_glosario    OUT NOCOPY VARCHAR2,
                         p_nom_esquema     OUT NOCOPY VARCHAR2,
                         p_nom_bbdd        OUT NOCOPY VARCHAR2,
                         p_nom_carpeta_adj OUT NOCOPY VARCHAR2,
                         p_cod_grupo_bds   OUT NOCOPY VARCHAR2,
                         p_nom_apn_cmdb    OUT NOCOPY VARCHAR2,
                         p_cod_herramienta OUT NOCOPY VARCHAR2,
                         p_cod_usr  OUT NOCOPY VARCHAR2,
                         p_fec_actu OUT NOCOPY DATE,
                         p_cod_capa_usrown  OUT NOCOPY VARCHAR2,
                         p_mca_grant_all    OUT NOCOPY VARCHAR2,
                         p_mca_grant_public OUT NOCOPY VARCHAR2,
                         p_mca_variables    OUT NOCOPY VARCHAR2,
                         p_obs_modelo       OUT NOCOPY VARCHAR2,
                         p_lista_subproyectos OUT NOCOPY t_t_subproyecto,
                         p_resultado          IN OUT NOCOPY INTEGER,
                         p_lista_errores      IN OUT NOCOPY t_t_error);
                        
	/*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de modelos pertenecientes a un glosario
  || Entrada:
  || p_cod_glosario    : C�digo de glosario
  || Salida:
  || p_lista_modelos   : Lista de modelos 
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_modelos_glosario(p_cod_glosario  IN NUMBER,
                                   p_lista_modelos OUT NOCOPY t_t_modelo,
                                   p_resultado     IN OUT NOCOPY INTEGER,
                                   p_lista_errores IN OUT NOCOPY t_t_error);
                                  
	/*----------------------------------------------------------------------------------------
  || Procedimiento de b�squeda de part�culas 
  || Entrada:
  || p_cod_particula   : C�digo de tipo de part�cula
  || p_des_particula   : Texto para buscar por descripci�n 
  || p_mca_proyecto    : Distingue por proyecto (S/N)
  || p_mca_sub_proy    : Distingue por subproyecto (S/N)
  || Salida:
  || p_lista_particulas   : Lista de part�culas que cumplen los criterios de b�squeda
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_particulas(p_cod_particula    IN NUMBER,
                             p_des_particula    IN VARCHAR2,
                             p_mca_proyecto     IN VARCHAR2,
                             p_mca_sub_proy     IN VARCHAR2,
                             p_lista_particulas OUT NOCOPY t_t_particula,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error);
                            
	/*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de part�culas de un elemento y norma
  || Entrada:
  || p_cod_norma       : C�digo de norma
  || p_cod_elemento    : C�digo de elemento
  || Salida:
  || p_lista_part_norma: Lista de part�culas de ese elemento y norma
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_particulas_elemento(p_cod_norma        IN NUMBER,
                                      p_cod_elemento     IN NUMBER,
                                      p_lista_part_norma IN OUT NOCOPY t_t_particula_norma,
                                      p_resultado        IN OUT NOCOPY INTEGER,
                                      p_lista_errores    IN OUT NOCOPY t_t_error);
                                     
	/*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de un tipo de elemento  
  || Entrada:
  || p_cod_elemento    : C�digo de tipo de elemento
  || Salida:
  || p_des_elemento    : Descripcipci�n
  || p_cod_usr         : Usuario que realiz� la �ltima modificaci�n  
  || p_fec_actu        : Fecha de la �ltima modificaci�n  
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_tipo_elemento(p_cod_elemento  IN NUMBER,
                                p_des_elemento  OUT NOCOPY VARCHAR2,
                                p_cod_usr       OUT NOCOPY VARCHAR2,
                                p_fec_actu      OUT NOCOPY DATE,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error);
                               
	/*----------------------------------------------------------------------------------------
  || Procedimiento de b�squeda por descripci�n de tipos de elementos  
  || Entrada:
  || p_des_elemento    : Texto para la b�squeda. Si no se rellena, se devuelven todos los tipos.
  || Salida:
  || p_lista_elementos : Lista de tipos de elementos
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_tipos_elementos(p_des_elemento    IN VARCHAR2,
                                  p_lista_elementos OUT NOCOPY t_t_elemento,
                                  p_resultado       IN OUT NOCOPY INTEGER,
                                  p_lista_errores   IN OUT NOCOPY t_t_error);
                                 
	/*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de valores de un tipo de part�cula 
  || Entrada:
  || p_cod_particula  : C�digo de tipo de part�cula.
  || Salida:
  || p_lista_val_particulas : Lista de valores
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_valores_particula(p_cod_particula        IN NUMBER,
                                    p_lista_val_particulas OUT NOCOPY t_t_val_particula,
                                    p_resultado            IN OUT NOCOPY INTEGER,
                                    p_lista_errores        IN OUT NOCOPY t_t_error);
                                   
	/*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de un glosario
  || Entrada:
  || p_cod_glosario  : C�digo de glosario.
  || Salida:
  || p_des_glosario    : Descripci�n
  || p_fec_alta        : Fecha de alta  
  || p_cod_usr         : Usuario que realiz� la �ltima modificaci�n  
  || p_fec_actu        : Fecha de la �ltima modificaci�n 
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_consulta_glosario(p_cod_glosario  IN NUMBER,
                                p_des_glosario  OUT NOCOPY VARCHAR2,
                                p_fec_alta      OUT NOCOPY DATE,
                                p_cod_usr       OUT NOCOPY VARCHAR2,
                                p_fec_actu      OUT NOCOPY DATE,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error);
                               
	/*----------------------------------------------------------------------------------------
  || Procedimiento de b�squeda de modelos
  || Entrada:
  || p_cod_proyecto       : C�digo de modelo
  || p_nom_modelo         : Texto para buscar por nombre de modelo
  || p_cod_norma          : C�digo de norma
  || p_cod_glosario       : C�digo de glosario
  || p_nom_esquema        : Esquema
  || p_nom_bbdd           : Base de datos
  || p_mostrar_inh        : Mostrar modlos inhabilitados (S/N)
  || Salida:
  || p_lista_modelos   : Lista de modelos que cumplen las condiciones de b�squeda
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_consulta_modelos(p_cod_proyecto  IN VARCHAR2,
                               p_nom_modelo    IN VARCHAR2,
                               p_cod_norma     IN NUMBER,
                               p_cod_glosario  IN NUMBER,
                               p_nom_esquema   IN VARCHAR2,
                               p_nom_bbdd      IN VARCHAR2,
                               p_mostrar_inh   IN VARCHAR2,
                               p_lista_modelos OUT NOCOPY t_t_modelo,
                               p_resultado     IN OUT NOCOPY INTEGER,
                               p_lista_errores IN OUT NOCOPY t_t_error);
                            
  /*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de una norma 
  || Entrada:
  || p_cod_norma       : C�digo de norma 
  || Salida:
  || p_des_norma       : Descripci�n
  || p_cod_usr         : Usuario que realiz� la �ltima modificaci�n  
  || p_fec_actu        : Fecha de la �ltima modificaci�n 
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_consulta_norma(p_cod_norma IN NUMBER,
                             p_des_norma OUT NOCOPY VARCHAR2,     
                             p_cod_usr       OUT NOCOPY VARCHAR2,
                             p_fec_actu      OUT NOCOPY DATE,
                             p_resultado     IN OUT NOCOPY INTEGER,
                             p_lista_errores IN OUT NOCOPY t_t_error);
   
	/*----------------------------------------------------------------------------------------
  || Procedimiento de b�squeda de normas, por descrpci�n 
  || Entrada:
  || p_des_norma       : Texto para la b�squeda. Si no se rellena, se devuelven todas
  || Salida:
  || p_lista_normas    : Lista de normas cuya descripci�n contienen el texto 
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_consulta_normas(p_des_norma     IN VARCHAR2,
                              p_lista_normas  OUT NOCOPY t_t_norma,
                              p_resultado     IN OUT NOCOPY INTEGER,
                              p_lista_errores IN OUT NOCOPY t_t_error);
   
	/*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de tipos de datos
  || Salida:
  || p_lista_tipos_datos: Lista de tipos de datos
  || p_resultado        : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores    : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_consulta_tipos_datos(p_lista_tipos_datos OUT t_t_tipo_dato,
                                   p_resultado         IN OUT NOCOPY INTEGER,
                                   p_lista_errores     IN OUT NOCOPY t_t_error);
  
	/*----------------------------------------------------------------------------------------
  || Procedimiento de que devuelve las listas necesarias para componer los informes Excel de validaci�n
  || Entrada:
  || p_num_validacion   : N�mero de validaci�n
  || Salida:
  || p_lista_erroneos   : Lista de elementos con errores de nomenclatura
  || p_lista_otra_def   : Lista de elementos que existen en el glosario con otra definici�n 
  || p_lista_def_glosario: Definici�n que existe en el glosario para la lista de elementos con otra definici�n
  
  || p_resultado        : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores    : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_generar_informe_val(p_num_validacion     NUMBER,
                                  p_lista_erroneos     OUT NOCOPY t_t_det_validacion,
                                  p_lista_otra_def     OUT NOCOPY t_t_det_validacion,
                                  p_lista_def_glosario OUT NOCOPY t_t_campo_glosario,
                                  p_resultado          IN OUT NOCOPY INTEGER,
                                  p_lista_errores      IN OUT NOCOPY t_t_error);
                                 
	/*----------------------------------------------------------------------------------------
  || Procedimiento de modificaci�n de un tipo de part�cula 
  || Entrada:
  || p_cod_particula   : C�digo de tipo de part�cula
  || p_des_particula   : Descripci�n
  || p_cod_usr         : Usuario que realiza la modificaci�n   
  || p_mca_proyecto    : Distingue por proyecto (S/N)
  || p_mca_sub_proy    : Distingue por subproyecto (S/N)
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_modifcar_tipo_particula(p_cod_particula IN NUMBER,
                                      p_des_particula IN VARCHAR2,
                                      p_cod_usr       IN VARCHAR2,
                                      p_mca_proyecto  IN VARCHAR2,
                                      p_mca_sub_proy  IN VARCHAR2,
                                      p_resultado     IN OUT NOCOPY INTEGER,
                                      p_lista_errores IN OUT NOCOPY t_t_error);
                                  
    /*----------------------------------------------------------------------------------------
  || Procedimiento de modificaci�n de un glosario 
  || Entrada:
  || p_cod_glosario       : C�digo de glosario
  || p_des_glosario       : Descripci�n
  || p_cod_usr            : Usuario que realiza la modificaci�n  
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */
---------------------------------------------------------------------------------------
	PROCEDURE p_modifica_glosario(p_cod_glosario IN NUMBER,
                                p_des_glosario IN VARCHAR2,
                                p_cod_usr IN VARCHAR2,
                                p_resultado IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error);
                                  
	/*----------------------------------------------------------------------------------------
  || Procedimiento de modificaci�n de un modelo
  || Entrada:
   || Entrada:
  || p_cod_proyecto       : C�digo de modelo
  || p_nom_modelo         : Nombre de modelo
  || p_cod_norma          : C�digo de norma
  || p_cod_glosario       : C�digo de glosario
  || p_nom_esquema        : Esquema
  || p_nom_bbdd           : Base de datos
  || p_nom_carpeta_adj    : Carpeta
  || p_cod_grupo_bds      : Grupo
  || p_cod_herramienta    : Herramienta 
  || p_obs_modelo         : Observaciones
  || p_cod_usr            : Usuario que realiza el alta  
  || p_nom_apn_cmdb       : Aplicaci�n desde la que se usa el modelo 
  || p_mca_grant_all      : Grant All
  || p_mca_grant_public   : Grant Public
  || p_mca_variables      : Genera Variables
  || p_cod_capa_usrown    : Variables con capa (S/N)
  || p_lista_subproyectos : Lista de subproyectos
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_modifica_modelo(p_cod_proyecto    IN VARCHAR2,
                              p_nom_modelo      IN VARCHAR2,
                              p_cod_norma       IN NUMBER,
                              p_cod_glosario    IN NUMBER,
                              p_nom_esquema     IN VARCHAR2,
                              p_nom_bbdd        IN VARCHAR2,
                              p_nom_carpeta_adj IN VARCHAR2,
                              p_cod_grupo_bds   IN VARCHAR2, 
                              p_cod_herramienta IN VARCHAR2,
                              p_obs_modelo      IN VARCHAR2,                           
                              p_cod_usr          IN VARCHAR2,
                              p_nom_apn_cmdb     IN VARCHAR2,
                              p_mca_grant_all    IN VARCHAR2,
                              p_mca_grant_public IN VARCHAR2,
                              p_mca_variables    IN VARCHAR2,
                              p_cod_capa_usrown  IN VARCHAR2,
                              p_lista_subproyectos IN t_t_subproyecto,
                              p_resultado          IN OUT NOCOPY INTEGER,
                              p_lista_errores      IN OUT NOCOPY t_t_error);    
                             
	/*----------------------------------------------------------------------------------------
  || Procedimiento que modifica un campo del glosario 
  || Entrada:
  || p_cod_glosario       : C�digo de glosario
  || p_nom_columna_ant    : Nombre del campo (valor anterior)
  || p_tip_dato_ant       : Tipo de dato (valor anterior)
  || p_num_longitud_ant   : Longitud (valor anterior)
  || p_num_decimal_ant    : Decimales (valor anterior)
  || p_nom_columna        : Nombre del campo (valor nuevo)
  || p_tip_dato           : Tipo de dato (valor nuevo)
  || p_num_longitud       : Longitud (valor nuevo)
  || p_num_decimal        : Decimales (valor nuevo)
  || p_mca_excepcion      : Indicador de excepci�n (S/N) (valor nuevo)
  || p_txt_excepcion      : Descripci�n de excepci�n (valor nuevo)
  || p_txt_comentarios    : Observaciones (valor nuevo)
  || p_cod_usr            : Usuario que realiza la modificaci�n    
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error, 3-Aviso)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_modificar_campo_glosario(p_cod_glosario      IN NUMBER,
                                       p_nom_columna_ant   IN VARCHAR2,
                                       p_tip_dato_ant      IN VARCHAR2,
                                       p_num_longitud_ant  IN NUMBER,
                                       p_num_decimal_ant   IN NUMBER,
                                       p_nom_columna       IN VARCHAR2,
                                       p_tip_dato          IN VARCHAR2,
                                       p_num_longitud      IN NUMBER,
                                       p_num_decimal       IN NUMBER,
                                       p_mca_excepcion     IN VARCHAR2,
                                       p_txt_excepcion     IN VARCHAR2,
                                       p_txt_comentarios   IN VARCHAR2,
                                       p_cod_usr           IN VARCHAR2,
                                       p_resultado     IN OUT NOCOPY INTEGER,
                                       p_lista_errores IN OUT NOCOPY t_t_error);
                                      
	/*----------------------------------------------------------------------------------------
  || Procedimiento que modifica un tipo de elemento 
  || Entrada:
  || p_cod_elemento    : C�digo de elemento
  || p_des_elemento    : Descripcipci�n
  || p_cod_usr         : Usuario que realiza la modificaci�n
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_modificar_tipo_elemento(p_cod_elemento  IN NUMBER,
                                      p_des_elemento  IN VARCHAR2,
                                      p_cod_usr       IN VARCHAR2,
                                      p_resultado     IN OUT NOCOPY INTEGER,
                                      p_lista_errores IN OUT NOCOPY t_t_error);
                                     
	/*----------------------------------------------------------------------------------------
  || Procedimiento que modifica un valor de part�cula 
  || Entrada:
  || p_cod_particula   : C�digo de part�cula
  || p_val_particula_ant   : Valor anterior
  || p_cod_proyecto_ant    : C�digo de proyecto (valor anterior)
  || p_cod_sub_proy_ant    : C�digo de subproyecto (valor anterior)
  || p_val_particula   : Valor nuevo
  || p_des_val_part    : Descripci�n (nuevo valor)
  || p_cod_proyecto    : C�digo de proyecto (nuevo valor)
  || p_cod_sub_proy    : C�digo de subproyecto (nuevo valor)
  || p_val_part_padre  : C�digo de part�cula padre (nuevo valor)
  || p_cod_usr         : Usuario que realiza la modificaci�n   
  || Salida:
  || p_resultado       : Resultado de la operaci�n (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_modificar_valor_particula(p_cod_particula     IN NUMBER,
                                        p_val_particula_ant IN VARCHAR2,
                                        p_cod_proyecto_ant  IN VARCHAR2,
                                        p_cod_sub_proy_ant  IN VARCHAR2,
                                        p_val_particula     IN VARCHAR2,
                                        p_des_val_part      IN VARCHAR2,
                                        p_cod_proyecto      IN VARCHAR2,
                                        p_cod_sub_proy      IN VARCHAR2,
                                        p_val_part_padre    IN VARCHAR2,
                                        p_cod_usr           IN VARCHAR2,
                                        p_resultado         IN OUT NOCOPY INTEGER,
                                        p_lista_errores     IN OUT NOCOPY t_t_error);
                                       
	/*----------------------------------------------------------------------------------------
  || Procedimiento de validación de un script
  || Entrada:
  || p_script               : Conjunto de líneas que forman el script para validar. No se enviarán líneas que no contengan caracteres (con espacios en blanco, tabuladores o retornos de carro). 
  || p_cod_RF                : Código de demanda
  || p_cod_SD                : Código de SD
  || p_cod_proyecto          : Código de modelo
  || p_cod_sub_proy          : Código de submodelo
  || p_cod_usr               : Código de usuario
  || p_nom_fichero           : Nombre del script a validar (incluye la ruta)
  || Salida:
  || p_num_validacion        : Número de la validación 
  || p_lista_elementos_valid : Lista de elementos validados, para mostrar como resultado de la validación
  || p_elementos_no_glosario : Indica si dentro del script hay elementos que cumplen la nomenclatura, pero no están incluidos en el glosario. Valores S/N 
  || p_elementos_errores     : Indica si dentro del script hay elementos que no cumplen la nomenclatura o que están definidos de forma diferente en el glosario. Valores S/N.
  || p_resultado             : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores         : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_valida_script(p_script                IN t_t_linea,
                            p_cod_RF                IN VARCHAR2,
                            p_cod_SD                IN VARCHAR2,
                            p_cod_proyecto          IN VARCHAR2,
                            p_cod_sub_proy          IN VARCHAR2,
                            p_cod_usr               IN VARCHAR2,
                            p_nom_fichero           IN VARCHAR2,
                            p_num_validacion        OUT NOCOPY NUMBER,
                            p_lista_elementos_valid OUT NOCOPY t_t_det_validacion,
                            p_elementos_no_glosario OUT NOCOPY VARCHAR2,
                            p_elementos_errores     OUT NOCOPY VARCHAR2,
                            p_resultado             IN OUT NOCOPY INTEGER,
                            p_lista_errores         IN OUT NOCOPY t_t_error);
	
END SM2_K_VALIDATOR_JAVA3; 
