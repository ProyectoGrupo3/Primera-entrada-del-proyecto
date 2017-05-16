-- Generado por Oracle SQL Developer Data Modeler 4.1.5.907
--   en:        2017-04-05 21:11:32 CEST
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c


CREATE
  TABLE Centro_trabajo
  (
    ID_centro     INTEGER NOT NULL ,
    Nombre        VARCHAR2 (30) NOT NULL ,
    Calle         VARCHAR2 (30) NOT NULL ,
    Numero        INTEGER NOT NULL ,
    Codigo_postal VARCHAR2 (5) NOT NULL ,
    Ciudad        VARCHAR2 (30) NOT NULL ,
    Provincia     VARCHAR2 (30) NOT NULL ,
    Telefono      VARCHAR2 (9) NOT NULL
  ) ;

ALTER TABLE Centro_trabajo ADD CONSTRAINT Centro_trabajo_PK PRIMARY KEY (
ID_centro ) ;

CREATE
  TABLE Trabajador
  (
    ID_Trabajador            INTEGER NOT NULL ,
    DNI                      VARCHAR2 (9) NOT NULL ,
    Nombre                   VARCHAR2 (30) NOT NULL ,
    Apellido_1               VARCHAR2 (30) NOT NULL ,
    Apellido_2               VARCHAR2 (30) NOT NULL ,
    Calle                    VARCHAR2 (30) ,
    Portal                   VARCHAR2 (5) ,
    Piso                     VARCHAR2 (2) NOT NULL ,
    Mano                     VARCHAR2 (10) NOT NULL ,
    Telefono_personal        VARCHAR2 (9) ,
    Movil_empresa            VARCHAR2 (9) NOT NULL ,
    Salario                  NUMBER ,
    Fecha_nacimiento         DATE ,
    Categoria                VARCHAR2 (15) NOT NULL ,
    Centro_trabajo_ID_centro INTEGER NOT NULL
  ) ;
ALTER TABLE Trabajador ADD CHECK ( Categoria IN ('ADMINISTRADOR', 'LOGISTICA')
) ;
COMMENT ON TABLE Trabajador
IS
  'La categoria de los trabajadores esta definida con una lista de valores con dos posibilidades: Administrador o loglistica.
Hemos creado el id_trabajador como campo clave en lugar del campo DNI.'
  ;
ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_PK PRIMARY KEY ( ID_Trabajador
) ;

CREATE
  TABLE Clave
  (
    ID_Clave                 INTEGER NOT NULL ,
    Usuario                  VARCHAR2 (30) NOT NULL ,
    Contrasenya               VARCHAR2 (30) NOT NULL ,
    Fecha                    DATE NOT NULL ,
    Trabajador_ID_Trabajador INTEGER NOT NULL
  ) ;
  (
    Trabajador_ID_Trabajador ASC
  )
  ;
ALTER TABLE Clave ADD CONSTRAINT Clave_PK PRIMARY KEY ( ID_Clave ) ;


CREATE
  TABLE CP
  (
    Fecha                    DATE NOT NULL ,
    KM_inicio                NUMBER NOT NULL ,
    KM_final                 NUMBER NOT NULL ,
    Gasto_gasoil             NUMBER ,
    Gasto_autopista          NUMBER ,
    Gasto_dietas             NUMBER ,
    Otros_gastos             NUMBER ,
    Incidencias_posibles     VARCHAR2 (240) ,
    Exceso_Horas             NUMBER ,
    Cerrar_logis             CHAR (1) DEFAULT '0' NOT NULL ,
    Verificacion_admin       CHAR (1) DEFAULT '0' NOT NULL ,
    Trabajador_ID_Trabajador INTEGER NOT NULL ,
    Vehiculo_Matricula       VARCHAR2 (9) NOT NULL
  ) ;
ALTER TABLE CP ADD CHECK ( KM_inicio       >= 0) ;
ALTER TABLE CP ADD CHECK ( KM_final        >= 0) ;
ALTER TABLE CP ADD CHECK ( Gasto_gasoil    >= 0) ;
ALTER TABLE CP ADD CHECK ( Gasto_autopista >= 0) ;
ALTER TABLE CP ADD CHECK ( Gasto_dietas    >= 0) ;
ALTER TABLE CP ADD CHECK ( Otros_gastos    >= 0) ;
ALTER TABLE CP ADD CONSTRAINT CP_PK PRIMARY KEY ( Fecha,
Trabajador_ID_Trabajador ) ;


CREATE
  TABLE LP
  (
    Hora_inicio                 VARCHAR2 NOT NULL ,
    Hora_final                  VARCHAR2 NOT NULL ,
    CP_Fecha                    DATE NOT NULL ,
    CP_Trabajador_ID_Trabajador INTEGER NOT NULL
  ) ;
COMMENT ON TABLE LP
IS
  'Se creara una linea por cada viaje que el trabajador de logistica realize.'
  ;
ALTER TABLE LP ADD CONSTRAINT LP_PK PRIMARY KEY ( CP_Fecha,
CP_Trabajador_ID_Trabajador, Hora_inicio ) ;


CREATE
  TABLE Aviso
  (
    Fecha_aviso                 DATE DEFAULT SYSDATE NOT NULL ,
    Texto                       VARCHAR2 (240) NOT NULL ,
    Trabajador_ID_Trabajador    INTEGER NOT NULL ,
    CP_Fecha                    DATE NOT NULL ,
    CP_Trabajador_ID_Trabajador INTEGER NOT NULL
  ) ;
COMMENT ON TABLE Aviso
IS
  'Solo el trabajador con la categoria de Administrador puede crear un aviso' ;
  (
    CP_Fecha ASC , CP_Trabajador_ID_Trabajador ASC
  )
  ;
ALTER TABLE Aviso ADD CONSTRAINT Aviso_PK PRIMARY KEY ( CP_Fecha,
CP_Trabajador_ID_Trabajador, Trabajador_ID_Trabajador ) ;


CREATE
  TABLE Vehiculo
  (
    Matricula  VARCHAR2 (9) NOT NULL ,
    Marca      VARCHAR2 (20) NOT NULL ,
    Modelo     VARCHAR2 (20) NOT NULL ,
    Color      VARCHAR2 (20) NOT NULL ,
    KM_totales INTEGER NOT NULL
  ) ;
ALTER TABLE Vehiculo ADD CHECK ( KM_totales >= 0) ;
ALTER TABLE Vehiculo ADD CONSTRAINT Vehiculo_PK PRIMARY KEY ( Matricula ) ;


ALTER TABLE Aviso ADD CONSTRAINT Aviso_CP_FK FOREIGN KEY ( CP_Fecha,
CP_Trabajador_ID_Trabajador ) REFERENCES CP ( Fecha, Trabajador_ID_Trabajador )
;

ALTER TABLE Aviso ADD CONSTRAINT Aviso_Trabajador_FK FOREIGN KEY (
Trabajador_ID_Trabajador ) REFERENCES Trabajador ( ID_Trabajador ) ;

ALTER TABLE CP ADD CONSTRAINT CP_Trabajador_FK FOREIGN KEY (
Trabajador_ID_Trabajador ) REFERENCES Trabajador ( ID_Trabajador ) ;

ALTER TABLE CP ADD CONSTRAINT CP_Vehiculo_FK FOREIGN KEY ( Vehiculo_Matricula )
REFERENCES Vehiculo ( Matricula ) ON delete set null;

ALTER TABLE Clave ADD CONSTRAINT Clave_Trabajador_FK FOREIGN KEY (
Trabajador_ID_Trabajador ) REFERENCES Trabajador ( ID_Trabajador ) ON
DELETE CASCADE ;

ALTER TABLE LP ADD CONSTRAINT LP_CP_FK FOREIGN KEY ( CP_Fecha,
CP_Trabajador_ID_Trabajador ) REFERENCES CP ( Fecha, Trabajador_ID_Trabajador )ON
DELETE CASCADE ;

ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Centro_trabajo_FK FOREIGN KEY
( Centro_trabajo_ID_centro ) REFERENCES Centro_trabajo ( ID_centro ) ON
DELETE CASCADE ;



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             4
-- ALTER TABLE                             23
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
