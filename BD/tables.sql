CREATE BIGFILE TABLESPACE TBS_PERM_SAPIENS
  DATAFILE 'bigtbs_sapiens.dat'
  SIZE 20M AUTOEXTEND ON;

CREATE TABLE "SAPIENS"."CAMPO_GLOSARIO" 
   (	"NOM_COLUMNA" VARCHAR2(30), 
	"TIP_DATO" VARCHAR2(40), 
	"NUM_LONGITUD" NUMBER, 
	"NUM_DECIMAL" NUMBER, 
	"COD_GLOSARIO" NUMBER, 
	"MCA_EXCEPTION" VARCHAR2(1), 
	"TXT_COMENTARIOS" VARCHAR2(4000), 
	"TXT_EXCEPTION" VARCHAR2(200), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
  CREATE TABLE "SAPIENS"."DET_VALIDACION" 
   (	"NUM_VALIDACION" NUMBER, 
	"NUM_ELEM_VALID" NUMBER(6,0), 
	"DES_ELEMENTO" VARCHAR2(50), 
	"NOM_ELEMENTO" VARCHAR2(30), 
	"TIP_DATO" VARCHAR2(30), 
	"NUM_LONGITUD" NUMBER, 
	"NUM_DECIMAL" NUMBER, 
	"COD_ESTADO_VALID" NUMBER(2,0), 
	"TXT_DES_VALID" VARCHAR2(200)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
  CREATE TABLE "SAPIENS"."ELEMENTO" 
   (	"COD_ELEMENTO" NUMBER(3,0), 
	"DES_ELEMENTO" VARCHAR2(50), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
 CREATE TABLE "SAPIENS"."ELEMENTO_NORMA" 
   (	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50), 
	"COD_ELEMENTO" NUMBER(3,0), 
	"DES_ELEMENTO" VARCHAR2(50), 
	"VAL_TAM_MAX" NUMBER(2,0), 
	"TXT_FORMATO" VARCHAR2(200), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE, 
	"TXT_FORMATO_DES1" VARCHAR2(200), 
	"TXT_FORMATO_DES2" VARCHAR2(200), 
	"TXT_FORMATO_DES3" VARCHAR2(200)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
 CREATE TABLE "SAPIENS"."GLOSARIO" 
   (	"COD_GLOSARIO" NUMBER(3,0), 
	"DES_GLOSARIO" VARCHAR2(150), 
	"FEC_ALTA" DATE, 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE, 
	 CONSTRAINT "GLOSARIOS_PK" PRIMARY KEY ("COD_GLOSARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;

CREATE UNIQUE INDEX "SAPIENS"."GLOSARIOS_PK" ON "SAPIENS"."GLOSARIO" ("COD_GLOSARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."MODELO" 
   (	"COD_PROYECTO" VARCHAR2(30), 
	"NOM_MODELO" VARCHAR2(100), 
	"NOM_ESQUEMA" VARCHAR2(30), 
	"NOM_BBDD" VARCHAR2(30), 
	"COD_GRUPO_BDS" VARCHAR2(50), 
	"NOM_CARPETA_ADJ" VARCHAR2(100), 
	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50), 
	"NOM_APN_CMDB" VARCHAR2(200), 
	"COD_GLOSARIO" NUMBER(3,0), 
	"DES_GLOSARIO" VARCHAR2(150), 
	"COD_HERRAMIENTA" VARCHAR2(20), 
	"OBS_MODELO" VARCHAR2(200), 
	"COD_USR" VARCHAR2(30), 
	"FEC_ACTU" DATE, 
	"COD_CAPA_USROWN" VARCHAR2(10), 
	"MCA_VARIABLES" VARCHAR2(1), 
	"MCA_GRANT_ALL" VARCHAR2(1), 
	"MCA_GRANT_PUBLIC" VARCHAR2(1), 
	"MCA_INH" VARCHAR2(1)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."NORMA" 
   (	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."PARTICULA" 
   (	"COD_PARTICULA" NUMBER(5,0), 
	"DES_PARTICULA" VARCHAR2(80), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE, 
	"MCA_PROYECTO" VARCHAR2(1), 
	"MCA_SUB_PROY" VARCHAR2(1)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."PARTICULA_NORMA" 
   (	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50), 
	"COD_ELEMENTO" NUMBER(3,0), 
	"DES_ELEMENTO" VARCHAR2(50), 
	"NUM_PARTICULA" NUMBER(2,0), 
	"DES_NUM_PART" VARCHAR2(50), 
	"MCA_OBLIGATORIA" VARCHAR2(1), 
	"MCA_VALIDACION" VARCHAR2(1), 
	"VAL_TAM_MIN" NUMBER(2,0), 
	"VAL_TAM_MAX" NUMBER(2,0), 
	"MCA_VAL_PADRE" VARCHAR2(1), 
	"NUM_PART_PADRE" NUMBER(2,0), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE, 
	"TIP_VALIDACION" VARCHAR2(20), 
	"COD_PARTICULA" NUMBER(5,0), 
	"DES_PARTICULA" VARCHAR2(80), 
	"MCA_PROYECTO" VARCHAR2(1), 
	"TXT_FORMATO_PART" VARCHAR2(200)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."SUBPROYECTO" 
   (	"COD_PROYECTO" VARCHAR2(30), 
	"COD_SUB_PROY" VARCHAR2(30), 
	"DES_SUB_PROY" VARCHAR2(150), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."TIPO_DATO" 
   (	"TIP_DATO" VARCHAR2(30)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."VALIDA_PARTICULA" 
   (	"NUM_PARTICULA" NUMBER(*,0), 
	"TXT_VALIDACION" VARCHAR2(100), 
	"TXT_VALOR" VARCHAR2(100), 
	"DES_ESTADO_VALID" VARCHAR2(60)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
  
CREATE TABLE "SAPIENS"."VAL_PARTICULA" 
   (	"COD_PARTICULA" NUMBER(5,0), 
	"VAL_PARTICULA" VARCHAR2(10), 
	"DES_VAL_PART" VARCHAR2(60), 
	"COD_PROYECTO" VARCHAR2(30), 
	"COD_SUB_PROY" VARCHAR2(30), 
	"VAL_PART_PADRE" VARCHAR2(10), 
	"COD_USR" VARCHAR2(8), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ; 