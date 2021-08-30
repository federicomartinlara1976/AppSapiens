CREATE OR REPLACE PACKAGE sm2_k_validador_JAVA2 IS

  /**---------------------------------------------------------------------------------------------------
  || Paquete que se utiliza para validar de scripts 
  */ ---------------------------------------------------------------------------------------------------
  -- Constantes
  C_RESULTADO_OK  CONSTANT NUMBER(1) := 1;
  C_RESULTADO_NOK CONSTANT NUMBER(1) := 0;
  C_RESULTADO_AVISO  CONSTANT NUMBER(1) := 2;

  -- Colecciones para intercambio con Java
   TYPE t_r_error IS RECORD(
    txt_error VARCHAR2(200));
    
  TYPE t_t_error IS TABLE OF t_r_error INDEX BY BINARY_INTEGER;


  TYPE t_r_glosario IS RECORD(
    cod_glosario NUMBER(3),
    des_glosario VARCHAR2(150),
    fec_alta     DATE,
    cod_usr      VARCHAR2(8),
    fec_actu     DATE);
  TYPE t_t_glosario IS TABLE OF t_r_glosario INDEX BY BINARY_INTEGER;

  TYPE t_r_campo_glosario IS RECORD(
    nom_columna   VARCHAR2(30),
    tip_dato      VARCHAR2(40),
    num_longitud  NUMBER,
    num_decimal   NUMBER,
    cod_glosario  NUMBER(3),
    mca_excepcion VARCHAR2(1),
    txt_comentarios VARCHAR2(4000),
    txt_excepcion VARCHAR2(200),
    cod_usr  VARCHAR2(8),
    fec_actu DATE);


  TYPE t_t_campo_glosario IS TABLE OF t_r_campo_glosario INDEX BY BINARY_INTEGER;

  TYPE t_r_norma IS RECORD(
    cod_norma NUMBER(2),
    des_norma VARCHAR2(50),
    cod_usr  VARCHAR2(8),
    fec_actu DATE);

  TYPE t_t_norma IS TABLE OF t_r_norma INDEX BY BINARY_INTEGER;

  TYPE t_r_particula IS RECORD(
    cod_particula NUMBER(5),
    des_particula VARCHAR2(80),
    cod_usr       VARCHAR2(8),
    fec_actu      DATE,
    mca_proyecto  VARCHAR2(1),
    mca_sub_proy  VARCHAR2(1));

  TYPE t_t_particula IS TABLE OF t_r_particula INDEX BY BINARY_INTEGER;

  TYPE t_r_particula_norma IS RECORD(
    cod_norma        NUMBER(2),
    des_norma        VARCHAR2(50),
    cod_elemento     NUMBER(3),
    des_elemento     VARCHAR2(50),
    num_particula    NUMBER(2),
    des_num_part     VARCHAR2(50),
    mca_obligatoria  VARCHAR2(1),
    mca_validacion   VARCHAR2(1),
    val_tam_min      NUMBER(2),
    val_tam_max      NUMBER(2),
    mca_val_padre    VARCHAR2(1),
    num_part_padre   NUMBER(2),
    cod_usr          VARCHAR2(8),
    fec_actu         DATE,
    tip_validacion   VARCHAR2(20),
    cod_particula    NUMBER(5),
    des_particula    VARCHAR2(80), 
    mca_proyecto     VARCHAR2(1),
    txt_formato_part VARCHAR2(200));

  TYPE t_t_particula_norma IS TABLE OF t_r_particula_norma INDEX BY BINARY_INTEGER;

  TYPE t_r_elemento_norma IS RECORD(
    cod_norma        NUMBER(2),
    des_norma        VARCHAR2(50),
    cod_elemento     NUMBER(3),
    des_elemento     VARCHAR2(50),
    val_tam_max      NUMBER(2),
    txt_formato      VARCHAR2(200),
    cod_usr          VARCHAR2(8),
    fec_actu         DATE,
    txt_formato_des1 VARCHAR2(200),
    txt_formato_des2 VARCHAR2(200),
    txt_formato_des3 VARCHAR2(200));

  TYPE t_t_elemento_norma IS TABLE OF t_r_elemento_norma INDEX BY BINARY_INTEGER;

  TYPE t_r_elemento IS RECORD(
    cod_elemento NUMBER(3),
    des_elemento VARCHAR2(50),
    cod_usr      VARCHAR2(8),
    fec_actu     DATE);

  TYPE t_t_elemento IS TABLE OF t_r_elemento INDEX BY BINARY_INTEGER;

  /*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo campo en el glosario 
  || Entrada:
  || p_cod_glosario       : Código de glosario
  || p_nom_columna        : Nombre del campo
  || p_tip_dato           : Tipo de dato
  || p_num_longitud       : Longitud
  || p_num_decimal        : Decimales
  || p_mca_excepcion      : Indicador de excepción (S/N)
  || p_txt_excepcion      : Descripción de excepción  
  || p_txt_comentarios    : Observaciones
  || p_cod_usr            : Usuario que realiza el alta    
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
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
  || p_cod_glosario       : Código de glosario
  || p_des_glosario       : Descripción
  || p_cod_usr            : Usuario que realiza el alta    
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_alta_glosario(p_cod_glosario  IN NUMBER,
                            p_des_glosario  IN VARCHAR2,
                            p_cod_usr       IN VARCHAR2,
                            p_resultado     IN OUT NOCOPY INTEGER,
                            p_lista_errores IN OUT NOCOPY t_t_error);

 
  /*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo tipo de elemento 
  || Entrada:
  || p_cod_elemento    : Código de elemento
  || p_des_elemento    : Descripcipción
  || p_cod_usr         : Usuario que realiza el alta    
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_alta_tipo_elemento(p_cod_elemento  IN NUMBER,
                                 p_des_elemento  IN VARCHAR2,
                                 p_cod_usr       IN VARCHAR2,
                                 p_resultado     IN OUT NOCOPY INTEGER,
                                 p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que da de alta un nuevo tipo de partícula
  || Entrada:
  || p_cod_particula   : Código de tipo de partícula
  || p_des_particula   : Descripción
  || p_cod_usr         : Usuario que realiza el alta    
  || p_mca_proyecto    : Distingue por proyecto (S/N)
  || p_mca_sub_proy    : Distingue por subproyecto (S/N)
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_alta_tipo_particula(p_cod_particula IN NUMBER,
                                  p_des_particula IN VARCHAR2,
                                  p_cod_usr       IN VARCHAR2,
                                  p_mca_proyecto  IN VARCHAR2,
                                  p_mca_sub_proy  IN VARCHAR2,
                                  p_resultado     IN OUT NOCOPY INTEGER,
                                  p_lista_errores IN OUT NOCOPY t_t_error);


  /*----------------------------------------------------------------------------------------
  || Procedimiento que da de baja un campo del glosario 
  || Entrada:
  || p_cod_glosario       : Código de glosario
  || p_nom_columna        : Nombre del campo
  || p_tip_dato           : Tipo de dato
  || p_num_longitud       : Longitud
  || p_num_decimal        : Decimales
  || p_cod_usr            : Usuario que realiza la baja  
  || p_cod_RF             : Código RF
  || p_cod_SD             : Código SD
  || p_txt_comentario     : Comentario
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_baja_campo_glosario(p_cod_glosario  IN NUMBER,
                                  p_nom_columna   IN VARCHAR2,
                                  p_tip_dato      IN VARCHAR2,
                                  p_num_longitud  IN NUMBER,
                                  p_num_decimal   IN NUMBER,
                                  p_cod_usr       IN VARCHAR2,
                                  p_cod_RF        IN VARCHAR2,
                                  p_cod_SD        IN VARCHAR2,
                                  p_txt_comentario IN VARCHAR2,
                                  p_resultado     IN OUT NOCOPY INTEGER,
                                  p_lista_errores IN OUT NOCOPY t_t_error);
                                  

  /*----------------------------------------------------------------------------------------
  || Procedimiento que realiza una búsqueda de glosarios, devolviendo aquellos cuya descripción 
  || contenga el texto recibido como parámetro. Si el texto de entrada está vacío, devuelve 
  || toda la lista de glosarios.
  || Entrada:
  || p_txt_des_glosario: Texto de búsqueda
  || Salida:
  || p_lista_glosarios : Lista de los glosarios que cumplen la condición de búsqueda
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_buscar_glosarios(p_txt_des_glosario IN VARCHAR2,
                               p_lista_glosarios  OUT NOCOPY t_t_glosario,
                               p_resultado        IN OUT NOCOPY INTEGER,
                               p_lista_errores    IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que realiza la búsqueda de campos de un glosario 
  || Entrada:
  || p_cod_glosario       : Código de glosario (Obligatorio)
  || p_nom_columna        : Nombre del campo (Opcional): Si está informado, se buscan las filas cuyo nombre de columna contengan ese texto
  || p_tip_dato           : Tipo de dato (Opcional): Si está informado, se filtran los campos que sean de ese tipo
  || p_mostrar_excepciones: Mostrar Excepciones (Obligatorio): Indica si se muestran las excepciones, según los valores S(defecto)/N
  || Salida:
  || p_lista_campos    : Lista de los campos que cumplen la condición de búsqueda
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
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
  || p_cod_norma       : Código de norma
  || p_cod_elemento    : Tipo de elemento
  || Salida:
  || p_lista_elem_norma: Lista de elementos
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_def_elem_norma(p_cod_norma        IN NUMBER,
                                 p_cod_elemento     IN NUMBER,
                                 p_lista_elem_norma OUT NOCOPY t_t_elemento_norma,
                                 p_resultado        IN OUT NOCOPY INTEGER,
                                 p_lista_errores    IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento de búsqueda de partículas por tipo de elemento y norma 
  || Entrada:
  || p_cod_norma       : Código de norma
  || p_cod_elemento    : Tipo de elemento
  || Salida:
  || p_lista_part_norma: Lista de partículas
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_def_part_norma_elemento(p_cod_norma        IN NUMBER,
                                          p_cod_elemento     IN NUMBER,
                                          p_lista_part_norma OUT NOCOPY t_t_particula_norma,
                                          p_resultado        IN OUT NOCOPY INTEGER,
                                          p_lista_errores    IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que busca tipos de partículas por descripción
  || Entrada:
  || p_des_particula   : Texto de búsqueda. Si no se rellena, se devuelven todos los tipos
  || Salida:
  || p_lista_particulas: Lista de tipos de partículas
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_def_tipos_particulas(p_des_particula    IN VARCHAR2,
                                       p_lista_particulas IN OUT NOCOPY t_t_particula,
                                       p_resultado        IN OUT NOCOPY INTEGER,
                                       p_lista_errores    IN OUT NOCOPY t_t_error);

  
  /*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la lista de elementos de una norma
  || Entrada:
  || p_cod_norma        : Código de norma
  || Salida:
  || p_lista_elem_norma : Lista de elementos de la norma
  || p_resultado        : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores    : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_elem_norma(p_cod_norma        IN NUMBER,
                             p_lista_elem_norma OUT NOCOPY t_t_elemento_norma,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error);

  
  /*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de partículas de un elemento y norma
  || Entrada:
  || p_cod_norma       : Código de norma
  || p_cod_elemento    : Código de elemento
  || Salida:
  || p_lista_part_norma: Lista de partículas de ese elemento y norma
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
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
  || p_cod_elemento    : Código de tipo de elemento
  || Salida:
  || p_des_elemento    : Descripcipción
  || p_cod_usr         : Usuario que realizó la última modificación  
  || p_fec_actu        : Fecha de la última modificación  
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_tipo_elemento(p_cod_elemento  IN NUMBER,
                                p_des_elemento  OUT NOCOPY VARCHAR2,
                                p_cod_usr       OUT NOCOPY VARCHAR2,
                                p_fec_actu      OUT NOCOPY DATE,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento de búsqueda por descripción de tipos de elementos  
  || Entrada:
  || p_des_elemento    : Texto para la búsqueda. Si no se rellena, se devuelven todos los tipos.
  || Salida:
  || p_lista_elementos : Lista de tipos de elementos
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_tipos_elementos(p_des_elemento    IN VARCHAR2,
                                  p_lista_elementos OUT NOCOPY t_t_elemento,
                                  p_resultado       IN OUT NOCOPY INTEGER,
                                  p_lista_errores   IN OUT NOCOPY t_t_error);

 

  /*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de un glosario
  || Entrada:
  || p_cod_glosario  : Código de glosario.
  || Salida:
  || p_des_glosario    : Descripción
  || p_fec_alta        : Fecha de alta  
  || p_cod_usr         : Usuario que realizó la última modificación  
  || p_fec_actu        : Fecha de la última modificación 
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
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
  || Procedimiento de consulta de una norma 
  || Entrada:
  || p_cod_norma       : Código de norma 
  || Salida:
  || p_des_norma       : Descripción
  || p_cod_usr         : Usuario que realizó la última modificación  
  || p_fec_actu        : Fecha de la última modificación 
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_consulta_norma(p_cod_norma IN NUMBER,
                             p_des_norma OUT NOCOPY VARCHAR2,
                             --p_num_particulas IN NUMBER,         
                             --p_val_separador IN VARCHAR2,        
                             p_cod_usr       OUT NOCOPY VARCHAR2,
                             p_fec_actu      OUT NOCOPY DATE,
                             p_resultado     IN OUT NOCOPY INTEGER,
                             p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento de búsqueda de normas, por descrpción
  || Entrada:
  || p_des_norma       : Texto para la búsqueda. Si no se rellena, se devuelven todas
  || Salida:
  || p_lista_normas    : Lista de normas cuya descripción contienen el texto 
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_consulta_normas(p_des_norma     IN VARCHAR2,
                              p_lista_normas  OUT NOCOPY t_t_norma,
                              p_resultado     IN OUT NOCOPY INTEGER,
                              p_lista_errores IN OUT NOCOPY t_t_error);



  /*----------------------------------------------------------------------------------------
  || Procedimiento de modificación de un tipo de partícula 
  || Entrada:
  || p_cod_particula   : Código de tipo de partícula
  || p_des_particula   : Descripción
  || p_cod_usr         : Usuario que realiza la modificación   
  || p_mca_proyecto    : Distingue por proyecto (S/N)
  || p_mca_sub_proy    : Distingue por subproyecto (S/N)
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
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
  || Procedimiento de modificación de un glosario 
  || Entrada:
  || p_cod_glosario       : Código de glosario
  || p_des_glosario       : Descripción
  || p_cod_usr            : Usuario que realiza la modificación  
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------                                  
  procedure p_modifica_glosario(p_cod_glosario  IN NUMBER,
                                p_des_glosario  IN VARCHAR2,
                                p_cod_usr       IN VARCHAR2,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error);


  /*----------------------------------------------------------------------------------------
  || Procedimiento que modifica un campo del glosario 
  || Entrada:
  || p_cod_glosario       : Código de glosario
  || p_nom_columna_ant    : Nombre del campo (valor anterior)
  || p_tip_dato_ant       : Tipo de dato (valor anterior)
  || p_num_longitud_ant   : Longitud (valor anterior)
  || p_num_decimal_ant    : Decimales (valor anterior)
  || p_mca_excepcion_ant  : Indicador de excepción (S/N) (valor anterior)
  || p_nom_columna        : Nombre del campo (valor nuevo)
  || p_tip_dato           : Tipo de dato (valor nuevo)
  || p_num_longitud       : Longitud (valor nuevo)
  || p_num_decimal        : Decimales (valor nuevo)
  || p_mca_excepcion      : Indicador de excepción (S/N) (valor nuevo)
  || p_txt_excepcion      : Descripción de excepción (valor nuevo)
  || p_txt_comentarios    : Observaciones (valor nuevo)
  || p_cod_usr            : Usuario que realiza la modificación    
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_modificar_campo_glosario(p_cod_glosario      IN NUMBER,
                                       p_nom_columna_ant   IN VARCHAR2,
                                       p_tip_dato_ant      IN VARCHAR2,
                                       p_num_longitud_ant  IN NUMBER,
                                       p_num_decimal_ant   IN NUMBER,
                                       p_mca_excepcion_ant IN VARCHAR2,
                                       p_nom_columna       IN VARCHAR2,
                                       p_tip_dato          IN VARCHAR2,
                                       p_num_longitud      IN NUMBER,
                                       p_num_decimal       IN NUMBER,
                                       p_mca_excepcion     IN VARCHAR2,
                                       p_txt_excepcion     IN VARCHAR2,
                                       p_txt_comentarios   IN VARCHAR2,
                                       p_cod_usr           IN VARCHAR2,
                                       --p_cod_RF       IN VARCHAR2,    
                                       --p_cod_SD       IN VARCHAR2
                                       p_resultado     IN OUT NOCOPY INTEGER,
                                       p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que modifica un tipo de elemento 
  || Entrada:
  || p_cod_elemento    : Código de elemento
  || p_des_elemento    : Descripcipción
  || p_cod_usr         : Usuario que realiza la modificación
  || Salida:
  || p_resultado       : Resultado de la operación (1- Correcto, 0-Error)
  || p_lista_errores   : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_modificar_tipo_elemento(p_cod_elemento  IN NUMBER,
                                      p_des_elemento  IN VARCHAR2,
                                      p_cod_usr       IN VARCHAR2,
                                      p_resultado     IN OUT NOCOPY INTEGER,
                                      p_lista_errores IN OUT NOCOPY t_t_error);

 

END sm2_k_validador_JAVA2;
/
