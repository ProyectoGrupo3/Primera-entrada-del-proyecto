--DISPARADOR PARA PONER ID AL TRABAJADOR
create or replace TRIGGER T_ID_Trabajador
BEFORE INSERT
ON TRABAJADOR
FOR EACH ROW
BEGIN
:new.ID_TRABAJADOR := ID_TRABAJADOR.NEXTVAL;
END;


--DISPARADOR PARA PONER ID AL CENTRO TRABAJO
CREATE OR REPLACE TRIGGER T_ID_CT
BEFORE INSERT
ON CENTRO_TRABAJO
FOR EACH ROW
BEGIN
:new.ID_CENTRO := ID_CENTRO.NEXTVAL;
END;


--CUANDO SE INSERTE UN "TRABAJADOR" CREAR UN REGISTRO EN "CLAVE"
CREATE OR REPLACE TRIGGER INSERTAR_TRABAJADOR
AFTER INSERT
ON TRABAJADOR
FOR EACH ROW
BEGIN
  --INSERT INTO CLAVE VALUES (ID_CLAVE.NEXTVAL,:new.nombre,'himevico12345',SYSDATE,:new.id_trabajador);
   insertar_clave(:new.nombre, :new.id_trabajador);
END;

--DISPARADOR PARA SABER SI HAY EXCESO DE HORAS O NO
create or replace TRIGGER EXCESO_HORAS_AL_VERIFICAR
BEFORE INSERT OR UPDATE
ON CP
FOR EACH ROW
DECLARE
BEGIN
IF :NEW.EXCESO_HORAS BETWEEN 0 AND 539 THEN
:NEW.EXCESO_HORAS :=0
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 540 AND 599 THEN
:NEW.EXCESO_HORAS :=1
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 600 AND 659 THEN
:NEW.EXCESO_HORAS :=2
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 600 AND 659 THEN
:NEW.EXCESO_HORAS :=2
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 660 AND 719 THEN
:NEW.EXCESO_HORAS :=3
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 720 AND 779 THEN
:NEW.EXCESO_HORAS :=4
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 780 AND 839 THEN
:NEW.EXCESO_HORAS :=5
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 840 AND 899 THEN
:NEW.EXCESO_HORAS :=6
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 900 AND 959 THEN
:NEW.EXCESO_HORAS :=7
;
ELSE IF :NEW.EXCESO_HORAS BETWEEN 960 AND 1019 THEN
:NEW.EXCESO_HORAS :=8
;
ELSE IF :NEW.EXCESO_HORAS > 1020  THEN
:NEW.EXCESO_HORAS :=9999
;
END IF;
END IF;
END IF;
END IF;
END IF;
END IF;
END IF;
END IF;
END IF;
END IF;
END IF;
END;

--DISPARADOR PARA ACTUALIZAR LOS KM TOTALES DEL VEHICULO
CREATE OR REPLACE TRIGGER ACTUALIZAR_KM_TOTALES
AFTER INSERT OR UPDATE
ON CP
FOR EACH ROW
DECLARE
KMTOTAL NUMBER;
BEGIN 
	IF :NEW.CERRAR_LOGIS = 1 THEN
	KMTOTAL:= :NEW.KM_FINAL - :NEW.KM_INICIO;
    UPDATE  VEHICULO
	SET 
	KM_TOTALES = KM_TOTALES + KMTOTAL
	WHERE MATRICULA = :NEW.VEHICULO_MATRICULA;
	END IF;
END;


COMMIT;