CREATE OR REPLACE PACKAGE BODY SAPIENS.SM2_K_VALIDATOR_JAVA3
AS

	procedure p_insertar_en_glosario(p_num_validacion IN NUMBER,
                                   p_num_elem_valid IN NUMBER,
                                   p_cod_usr        IN VARCHAR2,
                                   p_resultado      IN OUT NOCOPY INTEGER,
                                   p_lista_errores  IN OUT NOCOPY t_t_error)
 	IS
 	BEGIN
		p_resultado := C_RESULTADO_OK;
  	END p_insertar_en_glosario;        
  
  	procedure p_insertar_excepcion(p_num_validacion IN NUMBER,
                                 p_num_elem_valid IN NUMBER,
                                 p_txt_excepcion  IN VARCHAR2,
                                 p_cod_usr        IN VARCHAR2,
                                 p_resultado      IN OUT NOCOPY INTEGER,
                                 p_lista_errores  IN OUT NOCOPY t_t_error)
    IS
 	BEGIN
		p_resultado := C_RESULTADO_OK;
  	END p_insertar_excepcion;     
  
  	PROCEDURE p_validar_elemento(p_cod_norma            IN NUMBER,
                               p_cod_proyecto         IN VARCHAR2,
                               p_cod_sub_proy         IN VARCHAR2,
                               p_cod_elemento         IN NUMBER,
                               p_nom_elemento         IN VARCHAR2,
                               p_lista_val_particulas OUT NOCOPY t_t_valida_particula,
                               p_resultado            IN OUT NOCOPY INTEGER,
                               p_lista_errores        IN OUT NOCOPY t_t_error)
	IS
 	BEGIN
		p_resultado := C_RESULTADO_OK;
  	END p_validar_elemento;  
  
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
                                  p_lista_errores   IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		INSERT INTO CAMPO_GLOSARIO 
		VALUES
  			(p_nom_columna, p_tip_dato, p_num_longitud, p_num_decimal, p_cod_glosario, p_mca_excepcion, p_txt_comentarios, p_txt_excepcion, p_cod_usr, SYSDATE);
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_campo_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_alta_campo_glosario;

	procedure p_alta_glosario(p_des_glosario  IN VARCHAR2,
                            p_cod_usr       IN VARCHAR2,
                            p_resultado     IN OUT NOCOPY INTEGER,
                            p_lista_errores IN OUT NOCOPY t_t_error)
    IS
    	v_sysdate DATE;
 	BEGIN
	 	p_resultado := C_RESULTADO_OK;
	 	v_sysdate := SYSDATE;
	
		INSERT INTO GLOSARIO
		VALUES
  			(SEQ_GLOSARIOS.NEXTVAL, p_des_glosario, v_sysdate, p_cod_usr, v_sysdate);
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  	END p_alta_glosario;    
  
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
                          p_lista_errores      IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_modelo: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_alta_modelo;    

	procedure p_alta_tipo_elemento(p_des_elemento  IN VARCHAR2,
                                 p_cod_usr       IN VARCHAR2,
                                 p_resultado     IN OUT NOCOPY INTEGER,
                                 p_lista_errores IN OUT NOCOPY t_t_error)
	IS
    	v_sysdate DATE;
 	BEGIN
	 	p_resultado := C_RESULTADO_OK;
	 	v_sysdate := SYSDATE;
	
		INSERT INTO ELEMENTO
		VALUES
  			(SEQ_TIPO_ELEMENTO.NEXTVAL, p_des_elemento, p_cod_usr, v_sysdate);
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_tipo_elemento: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_alta_tipo_elemento;

	procedure p_alta_tipo_particula(p_des_particula IN VARCHAR2,
                                  p_cod_usr       IN VARCHAR2,
                                  p_mca_proyecto  IN VARCHAR2,
                                  p_mca_sub_proy  IN VARCHAR2,
                                  p_resultado     IN OUT NOCOPY INTEGER,
                                  p_lista_errores IN OUT NOCOPY t_t_error)
    IS
    	v_sysdate DATE;
	BEGIN
		p_resultado := C_RESULTADO_OK;
		v_sysdate := SYSDATE;
	
		INSERT INTO PARTICULA 
		VALUES
  			(SEQ_TIPO_PARTICULA.NEXTVAL, p_des_particula, p_cod_usr, v_sysdate, p_mca_proyecto, p_mca_sub_proy);
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_tipo_particula: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_alta_tipo_particula;
    
	procedure p_alta_valor_particula(p_cod_particula  IN NUMBER,
                                   p_val_particula  IN VARCHAR2,
                                   p_des_val_part   IN VARCHAR2,
                                   p_cod_proyecto   IN VARCHAR2,
                                   p_cod_sub_proy   IN VARCHAR2,
                                   p_val_part_padre IN VARCHAR2,
                                   p_cod_usr        IN VARCHAR2,
                                   p_resultado      IN OUT NOCOPY INTEGER,
                                   p_lista_errores  IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_valor_particula: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_alta_valor_particula;

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
                                  p_lista_errores  IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_baja_campo_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_baja_campo_glosario;

	procedure p_baja_logica_modelo(p_cod_proyecto  IN VARCHAR2,
                                 p_cod_usr       IN VARCHAR2,
                                 p_resultado     IN OUT NOCOPY INTEGER,
                                 p_lista_errores IN OUT NOCOPY t_t_error)
    IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_baja_logica_modelo: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_baja_logica_modelo;                             
                                  
	PROCEDURE p_buscar_glosarios(p_txt_des_glosario IN VARCHAR2,
	                               p_lista_glosarios OUT NOCOPY t_t_glosario,
	                               p_resultado OUT NOCOPY INTEGER,
	                               p_lista_errores OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		IF p_txt_des_glosario IS NOT NULL THEN
		-- Obtenemos los glosarios de la busqueda, con un like
		      SELECT
					g.cod_glosario,
		            g.des_glosario,
		            g.fec_alta,
		            g.cod_usr,
		            g.fec_actu
		        BULK COLLECT
		        INTO p_lista_glosarios
				FROM GLOSARIO g
				WHERE
					upper(g.des_glosario) LIKE '%' || upper(p_txt_des_glosario) || '%'
				ORDER BY g.cod_glosario;
		ELSE
		-- Si el parametro de busqueda esta vacio, sacamos todos los glosarios
		      SELECT
					g.cod_glosario,
		            g.des_glosario,
		            g.fec_alta,
		            g.cod_usr,
		            g.fec_actu
		        BULK COLLECT
		        INTO p_lista_glosarios
				FROM GLOSARIO g
				ORDER BY g.cod_glosario;
		END IF;

	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_buscar_glosarios: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_buscar_glosarios;

	procedure p_con_campos_glosario(p_cod_glosario        IN NUMBER,
                                  p_tip_dato            IN VARCHAR2,
                                  p_nom_columna         IN VARCHAR2,
                                  p_mostrar_excepciones IN VARCHAR2,
                                  p_lista_campos        OUT NOCOPY t_t_campo_glosario,
                                  p_resultado           IN OUT NOCOPY INTEGER,
                                  p_lista_errores       IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		IF p_nom_columna IS NOT NULL THEN
		-- Obtenemos los glosarios de la busqueda, con un like
			SELECT
				cg.nom_columna,
				cg.tip_dato,
				cg.num_longitud,
				cg.num_decimal,
				cg.cod_glosario,
				cg.mca_exception,
				cg.txt_comentarios,
				cg.txt_exception,
				cg.cod_usr,
				cg.fec_actu
		  	BULK COLLECT
		  	INTO p_lista_campos
			FROM 
				CAMPO_GLOSARIO cg 
			WHERE
				upper(cg.nom_columna) LIKE '%' || upper(p_nom_columna) || '%'
				AND cg.cod_glosario = p_cod_glosario
			ORDER BY cg.nom_columna;
		ELSE
		-- Si el parametro de busqueda esta vacio, sacamos todos los glosarios
		  	SELECT
				cg.nom_columna,
				cg.tip_dato,
				cg.num_longitud,
				cg.num_decimal,
				cg.cod_glosario,
				cg.mca_exception,
				cg.txt_comentarios,
				cg.txt_exception,
				cg.cod_usr,
				cg.fec_actu
		  	BULK COLLECT
		  	INTO p_lista_campos
			FROM 
				CAMPO_GLOSARIO cg 
			WHERE
				cg.cod_glosario = p_cod_glosario
			ORDER BY cg.nom_columna;
		END IF;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_campos_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_campos_glosario;

	procedure p_con_def_elem_norma(p_cod_norma        IN NUMBER,
                                 p_cod_elemento     IN NUMBER,
                                 p_lista_elem_norma OUT NOCOPY t_t_elemento_norma,
                                 p_resultado        IN OUT NOCOPY INTEGER,
                                 p_lista_errores    IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_def_elem_norma: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_def_elem_norma;

	procedure p_con_def_part_norma_elemento(p_cod_norma        IN NUMBER,
                                          p_cod_elemento     IN NUMBER,
                                          p_lista_part_norma OUT NOCOPY t_t_particula_norma,
                                          p_resultado        IN OUT NOCOPY INTEGER,
                                          p_lista_errores    IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_def_part_norma_elemento: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_def_part_norma_elemento;

	procedure p_con_def_tipos_particulas(p_des_particula    IN VARCHAR2,
                                       p_lista_particulas IN OUT NOCOPY t_t_particula,
                                       p_resultado        IN OUT NOCOPY INTEGER,
                                       p_lista_errores    IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		IF p_des_particula IS NOT NULL THEN
		-- Obtenemos los glosarios de la busqueda, con un like
			SELECT
				p.cod_particula,
				p.des_particula,
				p.cod_usr,
				p.fec_actu,
				p.mca_proyecto,
				p.mca_sub_proy
		  	BULK COLLECT
		  	INTO p_lista_particulas
			FROM 
				PARTICULA p 
			WHERE
				upper(p.des_particula) LIKE '%' || upper(p_des_particula) || '%'
			ORDER BY p.cod_particula;
		ELSE
		-- Si el parametro de busqueda esta vacio, sacamos todos los glosarios
		  	SELECT
				p.cod_particula,
				p.des_particula,
				p.cod_usr,
				p.fec_actu,
				p.mca_proyecto,
				p.mca_sub_proy		
		  	BULK COLLECT
		  	INTO p_lista_particulas
			FROM 
				PARTICULA p
			ORDER BY p.cod_particula;
		END IF;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_def_tipos_particulas: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_def_tipos_particulas;

	procedure p_con_elem_correctos_valid(p_num_validacion  IN NUMBER,
                                       p_lista_correctos OUT NOCOPY t_t_det_validacion,
                                       p_resultado       IN OUT NOCOPY INTEGER,
                                       p_lista_errores   IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_elem_correctos_valid: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_elem_correctos_valid;

	procedure p_con_elem_errores_validacion(p_num_validacion IN NUMBER,
                                          p_lista_erroneos OUT NOCOPY t_t_det_validacion,
                                          p_resultado      IN OUT NOCOPY INTEGER,
                                          p_lista_errores  IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_elem_errores_validacion: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_elem_errores_validacion;

	procedure p_con_elem_excepciones_valid(p_num_validacion    IN NUMBER,
                                         p_lista_excepciones OUT NOCOPY t_t_det_validacion,
                                         p_resultado         IN OUT NOCOPY INTEGER,
                                         p_lista_errores     IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_elem_excepciones_valid: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_elem_excepciones_valid;

	procedure p_con_elem_no_glosario_valid(p_num_validacion    IN NUMBER,
                                         p_lista_no_glosario OUT NOCOPY t_t_det_validacion,
                                         p_resultado         IN OUT NOCOPY INTEGER,
                                         p_lista_errores     IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_elem_no_glosario_valid: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_elem_no_glosario_valid;

	procedure p_con_elem_norma(p_cod_norma        IN NUMBER,
                             p_lista_elem_norma OUT NOCOPY t_t_elemento_norma,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		SELECT
			en.cod_norma,
			en.des_norma,
			en.cod_elemento,
			en.des_elemento,
			en.val_tam_max,
			en.txt_formato,
			en.cod_usr,
			en.fec_actu,
			en.txt_formato_des1,
			en.txt_formato_des2,
			en.txt_formato_des3
		BULK COLLECT
		INTO p_lista_elem_norma
		FROM 
			ELEMENTO_NORMA en
		WHERE
			en.cod_norma = p_cod_norma
		ORDER BY en.cod_elemento;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_elem_norma: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_elem_norma;

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
                         p_lista_errores      IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_modelo: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_modelo;

	procedure p_con_modelos_glosario(p_cod_glosario  IN NUMBER,
                                   p_lista_modelos OUT NOCOPY t_t_modelo,
                                   p_resultado     IN OUT NOCOPY INTEGER,
                                   p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_modelos_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_modelos_glosario;

	procedure p_con_particulas(p_cod_particula    IN NUMBER,
                             p_des_particula    IN VARCHAR2,
                             p_mca_proyecto     IN VARCHAR2,
                             p_mca_sub_proy     IN VARCHAR2,
                             p_lista_particulas OUT NOCOPY t_t_particula,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		IF p_des_particula IS NOT NULL THEN
		-- Obtenemos los glosarios de la busqueda, con un like
			SELECT
				p.cod_particula,
				p.des_particula,
				p.cod_usr,
				p.fec_actu,
				p.mca_proyecto,
				p.mca_sub_proy
		  	BULK COLLECT
		  	INTO p_lista_particulas
			FROM 
				PARTICULA p 
			WHERE
				upper(p.des_particula) LIKE '%' || upper(p_des_particula) || '%'
			ORDER BY p.cod_particula;
		ELSE
		-- Si el parametro de busqueda esta vacio, sacamos todos los glosarios
		  	SELECT
				p.cod_particula,
				p.des_particula,
				p.cod_usr,
				p.fec_actu,
				p.mca_proyecto,
				p.mca_sub_proy		
		  	BULK COLLECT
		  	INTO p_lista_particulas
			FROM 
				PARTICULA p
			ORDER BY p.cod_particula;
		END IF;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_particulas: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_particulas;

	procedure p_con_particulas_elemento(p_cod_norma        IN NUMBER,
                                      p_cod_elemento     IN NUMBER,
                                      p_lista_part_norma IN OUT NOCOPY t_t_particula_norma,
                                      p_resultado        IN OUT NOCOPY INTEGER,
                                      p_lista_errores    IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		SELECT
			pn.cod_norma,
			pn.des_norma,
			pn.cod_elemento,
			pn.des_elemento,
			pn.num_particula,
			pn.des_num_part,
			pn.mca_obligatoria,
			pn.mca_validacion,
			pn.val_tam_min,
			pn.val_tam_max,
			pn.mca_val_padre,
			pn.num_part_padre,
			pn.cod_usr,
			pn.fec_actu,
			pn.tip_validacion,
			pn.cod_particula,
			pn.des_particula,
			pn.mca_proyecto,
			pn.txt_formato_part
		BULK COLLECT
		INTO p_lista_part_norma
		FROM 
			PARTICULA_NORMA pn
		WHERE
			pn.cod_norma = p_cod_norma
		AND 
			pn.cod_elemento = p_cod_elemento
		ORDER BY pn.cod_particula;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_particulas_elemento: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_particulas_elemento;

	procedure p_con_tipo_elemento(p_cod_elemento  IN NUMBER,
                                p_des_elemento  OUT NOCOPY VARCHAR2,
                                p_cod_usr       OUT NOCOPY VARCHAR2,
                                p_fec_actu      OUT NOCOPY DATE,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_tipo_elemento: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_tipo_elemento;

	procedure p_con_tipos_elementos(p_des_elemento    IN VARCHAR2,
                                  p_lista_elementos OUT NOCOPY t_t_elemento,
                                  p_resultado       IN OUT NOCOPY INTEGER,
                                  p_lista_errores   IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		IF p_des_elemento IS NOT NULL THEN
		-- Obtenemos los glosarios de la busqueda, con un like
			SELECT
				e.cod_elemento,
		      	e.des_elemento,
		      	e.cod_usr,
		       	e.fec_actu
		  	BULK COLLECT
		  	INTO p_lista_elementos
			FROM 
				ELEMENTO e 
			WHERE
				upper(e.des_elemento) LIKE '%' || upper(p_des_elemento) || '%'
			ORDER BY 
				e.cod_elemento;
		ELSE
		-- Si el parametro de busqueda esta vacio, sacamos todos los glosarios
			SELECT
				e.cod_elemento,
		     	e.des_elemento,
		      	e.cod_usr,
		      	e.fec_actu
		 	BULK COLLECT
			INTO p_lista_elementos
			FROM 
				ELEMENTO e
			ORDER BY 
				e.cod_elemento;
		END IF;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_tipos_elementos: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_tipos_elementos;

	procedure p_con_valores_particula(p_cod_particula        IN NUMBER,
                                    p_lista_val_particulas OUT NOCOPY t_t_val_particula,
                                    p_resultado            IN OUT NOCOPY INTEGER,
                                    p_lista_errores        IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		SELECT
			vp.cod_particula,
			vp.val_particula,
			vp.des_val_part,
			vp.cod_proyecto,
			vp.cod_sub_proy,
			vp.val_part_padre,
			vp.cod_usr,
			vp.fec_actu
		BULK COLLECT
		INTO p_lista_val_particulas
		FROM 
			VAL_PARTICULA vp 
		WHERE
			vp.cod_particula = p_cod_particula;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_valores_particula: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_con_valores_particula;

	procedure p_consulta_glosario(p_cod_glosario  IN NUMBER,
                                p_des_glosario  OUT NOCOPY VARCHAR2,
                                p_fec_alta      OUT NOCOPY DATE,
                                p_cod_usr       OUT NOCOPY VARCHAR2,
                                p_fec_actu      OUT NOCOPY DATE,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_consulta_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_consulta_glosario;

	procedure p_consulta_modelos(p_cod_proyecto  IN VARCHAR2,
                               p_nom_modelo    IN VARCHAR2,
                               p_cod_norma     IN NUMBER,
                               p_cod_glosario  IN NUMBER,
                               p_nom_esquema   IN VARCHAR2,
                               p_nom_bbdd      IN VARCHAR2,
                               p_mostrar_inh   IN VARCHAR2,
                               p_lista_modelos OUT NOCOPY t_t_modelo,
                               p_resultado     IN OUT NOCOPY INTEGER,
                               p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		SELECT 
			m.COD_PROYECTO, m.NOM_MODELO, m.NOM_ESQUEMA, m.NOM_BBDD, 
			m.COD_GRUPO_BDS, m.NOM_CARPETA_ADJ, m.COD_NORMA, 
			m.DES_NORMA, m.NOM_APN_CMDB, m.COD_GLOSARIO, 
			m.DES_GLOSARIO, m.COD_HERRAMIENTA, m.OBS_MODELO, 
			m.COD_USR, m.FEC_ACTU, m.COD_CAPA_USROWN, m.MCA_VARIABLES, 
			m.MCA_GRANT_ALL, m.MCA_GRANT_PUBLIC, m.MCA_INH
		BULK COLLECT
		  	INTO p_lista_modelos
		FROM 
			MODELO m;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_consulta_modelos: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_consulta_modelos;

	procedure p_consulta_norma(p_cod_norma IN NUMBER,
                             p_des_norma OUT NOCOPY VARCHAR2,     
                             p_cod_usr       OUT NOCOPY VARCHAR2,
                             p_fec_actu      OUT NOCOPY DATE,
                             p_resultado     IN OUT NOCOPY INTEGER,
                             p_lista_errores IN OUT NOCOPY t_t_error)
    IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		SELECT
			n.des_norma, n.cod_usr, n.fec_actu
		INTO 
			p_des_norma, p_cod_usr, p_fec_actu
		FROM 
			NORMA n
		WHERE
			n.cod_norma = p_cod_norma;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_consulta_norma: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_consulta_norma;     

	procedure p_consulta_normas(p_des_norma     IN VARCHAR2,
                              p_lista_normas  OUT NOCOPY t_t_norma,
                              p_resultado     IN OUT NOCOPY INTEGER,
                              p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		IF p_des_norma IS NOT NULL THEN
		-- Obtenemos los glosarios de la busqueda, con un like
			SELECT
				n.cod_norma,
		   		n.des_norma,
		     	n.cod_usr,
		     	n.fec_actu
		  	BULK COLLECT
		 	INTO p_lista_normas
			FROM 
				NORMA n
			WHERE
				upper(n.des_norma) LIKE '%' || upper(p_des_norma) || '%'
			ORDER BY 
				n.cod_norma;
		ELSE
		-- Si el parametro de busqueda esta vacio, sacamos todos los glosarios
			SELECT
				n.cod_norma,
		      	n.des_norma,
		     	n.cod_usr,
		     	n.fec_actu
			BULK COLLECT
		  	INTO p_lista_normas
			FROM 
				NORMA n
			ORDER BY 
				n.cod_norma;
		END IF;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_consulta_normas: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_consulta_normas;

	procedure p_consulta_tipos_datos(p_lista_tipos_datos OUT t_t_tipo_dato,
                                   p_resultado         IN OUT NOCOPY INTEGER,
                                   p_lista_errores     IN OUT NOCOPY t_t_error)
    IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		SELECT
			td.tip_dato
		  	BULK COLLECT
		   	INTO p_lista_tipos_datos
		FROM 
			TIPO_DATO td
		ORDER BY 
			td.tip_dato;
		
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_consulta_tipos_datos: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_consulta_tipos_datos;     

	procedure p_generar_informe_val(p_num_validacion     NUMBER,
                                  p_lista_erroneos     OUT NOCOPY t_t_det_validacion,
                                  p_lista_otra_def     OUT NOCOPY t_t_det_validacion,
                                  p_lista_def_glosario OUT NOCOPY t_t_campo_glosario,
                                  p_resultado          IN OUT NOCOPY INTEGER,
                                  p_lista_errores      IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_generar_informe_val: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_generar_informe_val;

	procedure p_modifcar_tipo_particula(p_cod_particula IN NUMBER,
                                      p_des_particula IN VARCHAR2,
                                      p_cod_usr       IN VARCHAR2,
                                      p_mca_proyecto  IN VARCHAR2,
                                      p_mca_sub_proy  IN VARCHAR2,
                                      p_resultado     IN OUT NOCOPY INTEGER,
                                      p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		UPDATE PARTICULA 
		SET 
			DES_PARTICULA = p_des_particula,
			MCA_PROYECTO = p_mca_proyecto,
			MCA_SUB_PROY = p_mca_sub_proy,
			COD_USR = p_cod_usr,
			FEC_ACTU = SYSDATE 
		WHERE
			COD_PARTICULA = p_cod_particula;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_modifcar_tipo_particula: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_modifcar_tipo_particula;
   
  	PROCEDURE p_modifica_glosario(p_cod_glosario  IN NUMBER,
                                p_des_glosario  IN VARCHAR2,
                                p_cod_usr       IN VARCHAR2,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error)
                                
  	IS
 	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		UPDATE GLOSARIO
		SET 
			DES_GLOSARIO = p_des_glosario,
			COD_USR = p_cod_usr,
			FEC_ACTU = SYSDATE 
		WHERE
			COD_GLOSARIO = p_cod_glosario;
		
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_modifica_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  	END p_modifica_glosario;
  
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
                              p_lista_errores      IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		UPDATE MODELO 
		SET
			NOM_ESQUEMA = p_nom_esquema,
			NOM_BBDD = p_nom_bbdd,
			NOM_CARPETA_ADJ = p_nom_carpeta_adj,
			COD_HERRAMIENTA = p_cod_herramienta,
			OBS_MODELO = p_obs_modelo,
			COD_USR = p_cod_usr,
			NOM_APN_CMDB = p_nom_apn_cmdb,
			MCA_GRANT_ALL = p_mca_grant_all,
			MCA_GRANT_PUBLIC = p_mca_grant_public,
			MCA_VARIABLES = p_mca_variables,
			COD_CAPA_USROWN = p_cod_capa_usrown,
			FEC_ACTU = SYSDATE 
		WHERE
			COD_PROYECTO = p_cod_proyecto
		AND
			NOM_modelo = p_nom_modelo;
	
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_modifica_modelo: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_modifica_modelo;

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
                                       p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		UPDATE CAMPO_GLOSARIO 
		SET
			NOM_COLUMNA = p_nom_columna,
			TIP_DATO = p_tip_dato,
			NUM_LONGITUD = p_num_longitud,
			NUM_DECIMAL = p_num_decimal,
			MCA_EXCEPTION = p_mca_excepcion,
			TXT_COMENTARIOS = p_txt_comentarios,
			TXT_EXCEPTION = p_txt_excepcion,
			COD_USR = p_cod_usr,
			FEC_ACTU = SYSDATE 
		WHERE
			COD_GLOSARIO = p_cod_glosario
		AND
			NOM_COLUMNA = p_nom_columna_ant;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_modificar_campo_glosario: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_modificar_campo_glosario;

	procedure p_modificar_tipo_elemento(p_cod_elemento  IN NUMBER,
                                      p_des_elemento  IN VARCHAR2,
                                      p_cod_usr       IN VARCHAR2,
                                      p_resultado     IN OUT NOCOPY INTEGER,
                                      p_lista_errores IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		UPDATE ELEMENTO 
		SET 
			DES_ELEMENTO = p_des_elemento,
			COD_USR = p_cod_usr,
			FEC_ACTU = SYSDATE 
		WHERE
			COD_ELEMENTO = p_cod_elemento;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_modificar_tipo_elemento: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_modificar_tipo_elemento;

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
                                        p_lista_errores     IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
		UPDATE VAL_PARTICULA 
		SET
			VAL_PARTICULA = p_val_particula,
			DES_VAL_PART = p_des_val_part,
			COD_PROYECTO = p_cod_proyecto,
			COD_SUB_PROY = p_cod_sub_proy,
			VAL_PART_PADRE = p_val_part_padre,
			COD_USR = p_cod_usr,
			FEC_ACTU = SYSDATE 
		WHERE
			COD_PARTICULA = p_cod_particula;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_modificar_valor_particula: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_modificar_valor_particula;

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
                            p_lista_errores         IN OUT NOCOPY t_t_error)
	IS
	BEGIN
		p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_valida_script: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
	END p_valida_script;
  
END SM2_K_VALIDATOR_JAVA3; 
