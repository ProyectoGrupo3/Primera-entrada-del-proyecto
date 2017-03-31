-- Generado por Oracle SQL Developer Data Modeler 4.1.1.888
--   en:        2017-03-30 19:35:50 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Aviso
  (
    Fecha_aviso                 DATE DEFAULT SYSDATE NOT NULL ,
    Texto                       VARCHAR2 (240) NOT NULL ,
    Trabajador_ID_Trabajador    INTEGER NOT NULL ,
    CPARTE_Fecha                DATE NOT NULL ,
    CP_Trabajador_ID_Trabajador INTEGER NOT NULL
  ) ;
COMMENT ON TABLE Aviso
IS
  'Solo el trabajador con la categoría de Administrador puede crear un aviso' ;
CREATE UNIQUE INDEX Aviso__IDX ON Aviso
  (
    CPARTE_Fecha ASC , CP_Trabajador_ID_Trabajador ASC
  )
  ;
ALTER TABLE Aviso ADD CONSTRAINT Aviso_PK PRIMARY KEY ( CPARTE_Fecha, CP_Trabajador_ID_Trabajador, Trabajador_ID_Trabajador ) ;


CREATE TABLE Cabecera_Parte
  (
    Fecha                    DATE NOT NULL ,
    KM_inicio                INTEGER NOT NULL ,
    KM_final                 INTEGER NOT NULL ,
    Gasto_gasoil             NUMBER ,
    Gasto_autopista          NUMBER ,
    Gasto_dietas             NUMBER ,
    Otros_gastos             NUMBER ,
    Incidencias_posibles     VARCHAR2 (240) ,
    Exceso_Horas             DATE ,
    Cerrar_logis             CHAR (1) DEFAULT '0' NOT NULL ,
    Verificación_admin       CHAR (1) DEFAULT '0' NOT NULL ,
    Trabajador_ID_Trabajador INTEGER NOT NULL ,
    Vehiculo_Matricula       VARCHAR2 (9) NOT NULL
  ) ;
CREATE UNIQUE INDEX Cabecera_Parte__IDX ON Cabecera_Parte
  (
    Trabajador_ID_Trabajador ASC
  )
  ;
CREATE UNIQUE INDEX Cabecera_Parte__IDXv1 ON Cabecera_Parte
  (
    Vehiculo_Matricula ASC
  )
  ;
ALTER TABLE Cabecera_Parte ADD CONSTRAINT Cabecera_Parte_PK PRIMARY KEY ( Fecha, Trabajador_ID_Trabajador ) ;


CREATE TABLE Centro_trabajo
  (
    ID_centro     INTEGER NOT NULL ,
    Nombre        VARCHAR2 (30) NOT NULL ,
    Calle         VARCHAR2 (30) NOT NULL ,
    Número        INTEGER NOT NULL ,
    Código_postal VARCHAR2 (5) NOT NULL ,
    Ciudad        VARCHAR2 (30) NOT NULL ,
    Provincia     VARCHAR2 (30) NOT NULL ,
    Teléfono      VARCHAR2 (9) NOT NULL
  ) ;
ALTER TABLE Centro_trabajo ADD CHECK ( ID_centro = 1) ;
ALTER TABLE Centro_trabajo ADD CONSTRAINT Centro_trabajo_PK PRIMARY KEY ( ID_centro ) ;


CREATE TABLE Clave
  (
    Usuario                  VARCHAR2 (20) NOT NULL ,
    Contraseña               VARCHAR2 (20) NOT NULL ,
    Trabajador_ID_Trabajador INTEGER NOT NULL
  ) ;
CREATE UNIQUE INDEX Clave__IDX ON Clave
  (
    Trabajador_ID_Trabajador ASC
  )
  ;
ALTER TABLE Clave ADD CONSTRAINT Clave_PK PRIMARY KEY ( Usuario ) ;


CREATE TABLE Linea_Parte
  (
    Hora_inicio                  DATE NOT NULL ,
    Hora_final                   DATE NOT NULL ,
    Cabecera_Parte_Fecha         DATE NOT NULL ,
    Cabecera_Parte_ID_Trabajador INTEGER NOT NULL
  ) ;
COMMENT ON TABLE Linea_Parte
IS
  'Se creara una linea por cada viaje que el trabajador de logistica realize.' ;
ALTER TABLE Linea_Parte ADD CONSTRAINT Linea_Parte_PK PRIMARY KEY ( Cabecera_Parte_Fecha, Cabecera_Parte_ID_Trabajador, Hora_inicio ) ;


CREATE TABLE Trabajador
  (
    ID_Trabajador            INTEGER NOT NULL ,
    DNI                      VARCHAR2 (9) NOT NULL ,
    Nombre                   VARCHAR2 (30) NOT NULL ,
    Apellidos_1              VARCHAR2 (30) NOT NULL ,
    Apellido_2               VARCHAR2 (30) NOT NULL ,
    Calle                    VARCHAR2 (30) ,
    Portal                   VARCHAR2 (5) ,
    Piso                     VARCHAR2 (2) NOT NULL ,
    Mano                     VARCHAR2 (10) NOT NULL ,
    Telefono_personal        VARCHAR2 (9) ,
    Movil_empresa            VARCHAR2 (9) NOT NULL ,
    Salario                  NUMBER ,
    Fecha_nacimiento         DATE ,
    Categoría                VARCHAR2 (15) NOT NULL ,
    Centro_trabajo_ID_centro INTEGER NOT NULL ,
    Clave_Usuario            VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Trabajador ADD CHECK ( ID_Trabajador = 1) ;
ALTER TABLE Trabajador ADD CHECK ( Categoría IN ('Administracion', 'Logistica')) ;
COMMENT ON TABLE Trabajador
IS
  'La categoría de los trabajadores esta definida con una lista de valores con dos posibilidades: Administrador o loglistica.
Hemos creado el id_trabajador como campo clave en lugar del campo DNI.' ;
CREATE UNIQUE INDEX Trabajador__IDX ON Trabajador ( Clave_Usuario ASC ) ;
ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_PK PRIMARY KEY ( ID_Trabajador ) ;


CREATE TABLE Vehiculo
  (
    Matricula                   VARCHAR2 (9) NOT NULL ,
    Marca                       VARCHAR2 (20) NOT NULL ,
    Modelo                      VARCHAR2 (20) NOT NULL ,
    Color                       VARCHAR2 (20) NOT NULL ,
    KM_totales                  INTEGER NOT NULL ,
    Cabecera_Parte_Fecha        DATE NOT NULL ,
    CP_Trabajador_ID_Trabajador INTEGER NOT NULL
  ) ;
CREATE UNIQUE INDEX Vehiculo__IDX ON Vehiculo
  (
    Cabecera_Parte_Fecha ASC , CP_Trabajador_ID_Trabajador ASC
  )
  ;
ALTER TABLE Vehiculo ADD CONSTRAINT Vehiculo_PK PRIMARY KEY ( Matricula ) ;


ALTER TABLE Aviso ADD CONSTRAINT Aviso_Cabecera_Parte_FK FOREIGN KEY ( CPARTE_Fecha, CP_Trabajador_ID_Trabajador ) REFERENCES Cabecera_Parte ( Fecha, Trabajador_ID_Trabajador ) ;

ALTER TABLE Aviso ADD CONSTRAINT Aviso_Trabajador_FK FOREIGN KEY ( Trabajador_ID_Trabajador ) REFERENCES Trabajador ( ID_Trabajador ) ;

ALTER TABLE Cabecera_Parte ADD CONSTRAINT Cabecera_Parte_Trabajador_FK FOREIGN KEY ( Trabajador_ID_Trabajador ) REFERENCES Trabajador ( ID_Trabajador ) ;

ALTER TABLE Cabecera_Parte ADD CONSTRAINT Cabecera_Parte_Vehiculo_FK FOREIGN KEY ( Vehiculo_Matricula ) REFERENCES Vehiculo ( Matricula ) ;

ALTER TABLE Clave ADD CONSTRAINT Clave_Trabajador_FK FOREIGN KEY ( Trabajador_ID_Trabajador ) REFERENCES Trabajador ( ID_Trabajador ) ;

ALTER TABLE Linea_Parte ADD CONSTRAINT Linea_Parte_Cabecera_Parte_FK FOREIGN KEY ( Cabecera_Parte_Fecha, Cabecera_Parte_ID_Trabajador ) REFERENCES Cabecera_Parte ( Fecha, Trabajador_ID_Trabajador ) ;

ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Centro_trabajo_FK FOREIGN KEY ( Centro_trabajo_ID_centro ) REFERENCES Centro_trabajo ( ID_centro ) ON
DELETE CASCADE ;

ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Clave_FK FOREIGN KEY ( Clave_Usuario ) REFERENCES Clave ( Usuario ) ;

ALTER TABLE Vehiculo ADD CONSTRAINT Vehiculo_Cabecera_Parte_FK FOREIGN KEY ( Cabecera_Parte_Fecha, CP_Trabajador_ID_Trabajador ) REFERENCES Cabecera_Parte ( Fecha, Trabajador_ID_Trabajador ) ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             6
-- ALTER TABLE                             19
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
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
