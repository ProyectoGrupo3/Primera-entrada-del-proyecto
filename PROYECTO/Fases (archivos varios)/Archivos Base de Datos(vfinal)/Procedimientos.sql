--Procedimiento de Busqueda de todos los Trabajadores
CREATE OR REPLACE PROCEDURE BUSCAR_TOTAL_T (B OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN B FOR
  SELECT * FROM TRABAJADOR;
  COMMIT;
END;
CREATE PUBLIC SYNONYM BUSCAR_TRABAJADORES FOR BUSCAR_TOTAL_T;


--Procedimiento de Busqueda de un Trabajador
CREATE OR REPLACE PROCEDURE BUSCAR_UN_TRABAJADOR ( ID_C IN TRABAJADOR.CENTRO_TRABAJO_ID_CENTRO%TYPE,  UNO OUT NUMBER, DOS OUT VARCHAR2, TRES OUT VARCHAR2, CUATRO OUT VARCHAR2, CINCO OUT VARCHAR2, SEIS OUT VARCHAR2, SIETE OUT VARCHAR2, OCHO OUT VARCHAR2, NUEVE OUT VARCHAR2, DIEZ OUT VARCHAR2, ONCE OUT VARCHAR2, DOCE OUT NUMBER, TRECE OUT DATE, CATORCE OUT VARCHAR2, QUINCE OUT NUMBER)
IS
LINEA TTRABAJADOR%ROWTYPE;
BEGIN
  SELECT * INTO LINEA FROM TRABAJADOR 
  WHERE CENTRO_TRABAJO_ID_CENTRO = ID_C;
  UNO:=LINEA.ID_TRABAJADOR;
  DOS:=LINEA.DNI;
  TRES:=LINEA.NOMBRE;
  CUATRO:=LINEA.APELLIDO_1;
  CINCO:=LINEA.APELLIDO_2;
  SEIS:=LINEA.CALLE;
  SIETE:=LINEA.PORTAL;
  OCHO:=LINEA.PISO;
  NUEVE:=LINEA.MANO;
  DIEZ:=LINEA.TELEFONO_PERSONAL;
  ONCE:=LINEA.MOVIL_EMPRESA;
  DOCE:=LINEA.SALARIO;
  TRECE:=LINEA.FECHA_NACIMIENTO;
  CATORCE:=LINEA.CATEGORIA;
  QUINCE:=LINEA.CENTRO_TRABAJO_ID_CENTRO;
    EXCEPTION 
  WHEN NO_DATA_FOUND THEN
  RAISE_APPLICATION_ERROR( -20000  , 'Error', TRUE);
  WHEN TOO_MANY_ROWS THEN
  RAISE_APPLICATION_ERROR( -20000  , 'Error', TRUE);
  COMMIT;
END;
CREATE PUBLIC SYNONYM BUSCAR_UN_T FOR BUSCAR_UN_TRABAJADOR;


--Procedimiento de comprobación del login de usuario
create or replace PROCEDURE COMPROBAR_LOGIN (USU IN VARCHAR2 , PASS IN VARCHAR2, CLAVE1 OUT NUMBER, CLAVE2 OUT VARCHAR2, CLAVE3 OUT VARCHAR2, CLAVE4 OUT DATE, CLAVE5 OUT NUMBER, UNO OUT NUMBER, DOS OUT VARCHAR2, TRES OUT VARCHAR2, CUATRO OUT VARCHAR2, CINCO OUT VARCHAR2, SEIS OUT VARCHAR2, SIETE OUT VARCHAR2, OCHO OUT VARCHAR2, NUEVE OUT VARCHAR2, DIEZ OUT VARCHAR2, ONCE OUT VARCHAR2, DOCE OUT NUMBER, TRECE OUT DATE, CATORCE OUT VARCHAR2, QUINCE OUT NUMBER, hay out number)
AS
LINEACLAVE CLAVE%ROWTYPE;
LINEATRABAJADOR TRABAJADOR%ROWTYPE;
ID_TRA NUMBER;
BEGIN
SELECT * INTO LINEACLAVE FROM TCLAVE
  WHERE USU = CLAVE.USUARIO
  AND CLAVE.CONTRASENYA = PASS;
  ID_TRA:= LINEACLAVE.TRABAJADOR_ID_TRABAJADOR;
  SELECT * INTO LINEATRABAJADOR FROM TRABAJADOR
  WHERE ID_TRABAJADOR = ID_TRA;
  
  CLAVE1:= LINEACLAVE.ID_CLAVE;
  CLAVE2:= LINEACLAVE.USUARIO;
  CLAVE3:= LINEACLAVE.CONTRASENYA;
  CLAVE4:= LINEACLAVE.FECHA;
  CLAVE5:= LINEACLAVE.TRABAJADOR_ID_TRABAJADOR;
  UNO:=LINEATRABAJADOR.ID_TRABAJADOR;
  DOS:=LINEATRABAJADOR.DNI;
  TRES:=LINEATRABAJADOR.NOMBRE;
  CUATRO:=LINEATRABAJADOR.APELLIDO_1;
  CINCO:=LINEATRABAJADOR.APELLIDO_2;
  SEIS:=LINEATRABAJADOR.CALLE;
  SIETE:=LINEATRABAJADOR.PORTAL;
  OCHO:=LINEATRABAJADOR.PISO;
  NUEVE:=LINEATRABAJADOR.MANO;
  DIEZ:=LINEATRABAJADOR.TELEFONO_PERSONAL;
  ONCE:=LINEATRABAJADOR.MOVIL_EMPRESA;
  DOCE:=LINEATRABAJADOR.SALARIO;
  TRECE:=LINEATRABAJADOR.FECHA_NACIMIENTO;
  CATORCE:=LINEATRABAJADOR.CATEGORIA;
  QUINCE:=LINEATRABAJADOR.CENTRO_TRABAJO_ID_CENTRO;
  hay := 1;
  EXCEPTION 
  WHEN NO_DATA_FOUND THEN
  hay := 0;
  WHEN TOO_MANY_ROWS THEN
  hay := 0;
  COMMIT;
END;
CREATE PUBLIC SYNONYM LOGIN FOR COMPROBAR_LOGIN;


--INSERTAR O UPDATE TRABAJADOR
create or replace PROCEDURE  INSERT_Y_UPDATE_T(
P_T_ID TRABAJADOR.ID_TRABAJADOR%TYPE,
P_T_DNI TRABAJADOR.DNI%TYPE,
P_T_NOMBRE TRABAJADOR.NOMBRE%TYPE,
P_T_APE1 TRABAJADOR.APELLIDO_1%TYPE,
P_T_APE2 TRABAJADOR.APELLIDO_2%TYPE,
P_T_CALLE TRABAJADOR.CALLE%TYPE,
P_T_PORTAL TRABAJADOR.PORTAL%TYPE,
P_T_PISO TRABAJADOR.PISO%TYPE,
P_T_MANO TRABAJADOR.MANO%TYPE,
P_T_TP TRABAJADOR.TELEFONO_PERSONAL%TYPE,
P_T_ME TRABAJADOR.MOVIL_EMPRESA%TYPE,
P_T_SALARIO TRABAJADOR.SALARIO%TYPE,
P_T_FN TRABAJADOR.FECHA_NACIMIENTO%TYPE,
P_T_CATE TRABAJADOR.CATEGORIA%TYPE,
P_T_CT TRABAJADOR.CENTRO_TRABAJO_ID_CENTRO%TYPE)
AS
BEGIN
      UPDATE TRABAJADOR
      SET
            DNI = P_T_DNI,
            NOMBRE = P_T_NOMBRE,
            APELLIDO_1 = P_T_APE1,
            APELLIDO_2 = P_T_APE2,
            CALLE = P_T_CALLE,
            PORTAL = P_T_PORTAL,
            PISO = P_T_PISO,
            MANO = P_T_MANO,
            TELEFONO_PERSONAL = P_T_TP,
            MOVIL_EMPRESA = P_T_ME,
            SALARIO = P_T_SALARIO,
            FECHA_NACIMIENTO = P_T_FN,
            CATEGORIA = P_T_CATE,
            CENTRO_TRABAJO_ID_CENTRO = P_T_CT

      where ID_TRABAJADOR = P_T_ID;

IF sql%notfound
THEN
INSERT INTO TRABAJADOR(ID_TRABAJADOR, DNI, NOMBRE, APELLIDO_1, APELLIDO_2, CALLE, PORTAL, PISO,
MANO, TELEFONO_PERSONAL, MOVIL_EMPRESA, SALARIO, FECHA_NACIMIENTO, CATEGORIA, CENTRO_TRABAJO_ID_CENTRO)
VALUES (P_T_ID, P_T_DNI, P_T_NOMBRE, P_T_APE1, P_T_APE2, P_T_CALLE, P_T_PORTAL, P_T_PISO, P_T_MANO,
P_T_TP, P_T_ME, P_T_SALARIO, P_T_FN, P_T_CATE, P_T_CT);
COMMIT;
END IF;
END;
CREATE PUBLIC SYNONYM INSERTAR_UPDATE_TRABAJADOR FOR INSERT_Y_UPDATE_T;


--INSERTAR O UPDATE CENTRO DE TRABAJO
 CREATE OR REPLACE PROCEDURE INSERT_Y_UPDATE_CT(
P_CT_ID CENTRO_TRABAJO.ID_CENTRO%TYPE,
P_CT_NOMBRE CENTRO_TRABAJO.NOMBRE%TYPE,
P_CT_CALLE CENTRO_TRABAJO.CALLE%TYPE,
P_CT_NUMERO CENTRO_TRABAJO.NUMERO%TYPE,
P_CT_CP CENTRO_TRABAJO.CODIGO_POSTAL%TYPE,
P_CT_CIUDAD CENTRO_TRABAJO.CIUDAD%TYPE,
P_CT_PROVINCIA CENTRO_TRABAJO.PROVINCIA%TYPE,
P_CT_TELEFONO CENTRO_TRABAJO.TELEFONO%TYPE)
AS
BEGIN
      UPDATE CENTRO_TRABAJO
      SET
            NOMBRE=P_CT_NOMBRE,
            CALLE=P_CT_CALLE,
            NUMERO=P_CT_NUMERO,
            CODIGO_POSTAL=P_CT_CP,
            CIUDAD = P_CT_CIUDAD,
            PROVINCIA = P_CT_PROVINCIA,
            TELEFONO = P_CT_TELEFONO
      where ID_CENTRO=P_CT_ID;
IF sql%notfound
THEN
	INSERT INTO CENTRO_TRABAJO(ID_CENTRO, NOMBRE, CALLE, NUMERO, CODIGO_POSTAL, CIUDAD, PROVINCIA, TELEFONO)
	VALUES (P_CT_ID, P_CT_NOMBRE, P_CT_CALLE, P_CT_NUMERO, P_CT_CP, P_CT_CIUDAD, P_CT_PROVINCIA, P_CT_TELEFONO);
COMMIT;
END IF;
END;
CREATE PUBLIC SYNONYM UPDATE_INSERT_CENTRO FOR INSERT_Y_UPDATE_CT;


--BORRAR CENTRO DE TRABAJO
create or replace PROCEDURE DELETE_CT(
CT_ID IN CENTRO_TRABAJO.ID_CENTRO%TYPE)
AS
BEGIN
      DELETE FROM CENTRO_TRABAJO WHERE ID_CENTRO = CT_ID;
COMMIT;
END;
CREATE PUBLIC SYNONYM BORRAR_CENTRO FOR DELETE_CT;


--BORRAR TRABAJADOR
create or replace PROCEDURE DELETE_TRABAJADOR(
P_T_ID IN TRABAJADOR.ID_TRABAJADOR%TYPE)
AS
BEGIN
      DELETE FROM TRABAJADOR WHERE ID_TRABAJADOR = P_T_ID;
COMMIT;
END;
CREATE PUBLIC SYNONYM BORRAR_TRABAJADOR FOR DELETE_TRABAJADOR;

--insertar_clave
CREATE OR REPLACE PROCEDURE INSERT_CLAVE_CREAR_USER (NOMBRE IN VARCHAR2, ID_T IN NUMBER)
AS
CONTRA := 'Himevico12345';
BEGIN
INSERT INTO CLAVE VALUES (ID_CLAVE.NEXTVAL,NOMBRE,CONTRA,SYSDATE,ID_T);
COMMIT;
END;
CREATE PUBLIC SYNONYM INSERTAR_CLAVE FOR INSERT_CLAVE_CREAR_USER;



CREATE OR REPLACE PROCEDURE MODIFICAR_CONTRA(
CLAVE_ID in CLAVE.ID_CLAVE%TYPE,
C_CONTRA in CLAVE.CONTRASENYA%TYPE,
C_FECHA in CLAVE.FECHA%TYPE)
AS
BEGIN
      UPDATE CLAVE
      SET
            CONTRASENYA=C_CONTRA,
            FECHA=C_FECHA          
      where ID_CLAVE=CLAVE_ID;
	  
COMMIT;
END;
CREATE PUBLIC SYNONYM CAMBIAR_CONTRA FOR MODIFICAR_CONTRA;


--COMPROBAR SI HAY ALGUN PARTE ABIERTO Y SI HAY, DEVOLVERLO
create or replace PROCEDURE COMPROBAR_PARTES_ABIERTOS(
ID_TRA IN NUMBER,
FECHA OUT CP.FECHA%TYPE,
KM_INICIO OUT CP.KM_INICIO%TYPE,
KM_FINAL OUT CP.KM_FINAL%TYPE,
GASTO_GASOIL OUT CP.GASTO_GASOIL%TYPE,
GASTO_AUTOPISTA OUT CP.GASTO_AUTOPISTA%TYPE,
GASTO_DIETAS OUT CP.GASTO_DIETAS%TYPE,
OTROS_GASTOS OUT CP.OTROS_GASTOS%TYPE,
INCIDENCIAS_POSIBLES OUT CP.INCIDENCIAS_POSIBLES%TYPE,
EXCESO_HORAS OUT CP.EXCESO_HORAS%TYPE,
CERRAR_LOGIS OUT CP.CERRAR_LOGIS%TYPE,
VERIFICACION_ADMIN OUT CP.VERIFICACION_ADMIN%TYPE,
TRABAJADOR_ID_TRABAJADOR OUT CP.TRABAJADOR_ID_TRABAJADOR%TYPE,
VEHICULO_MATRICULA OUT CP.VEHICULO_MATRICULA%TYPE,
SI_DEVUELVE OUT NUMBER
)
AS
LINEA CP%ROWTYPE;
BEGIN
      SELECT * INTO LINEA FROM CP 
      WHERE TRABAJADOR_ID_TRABAJADOR = ID_TRA AND VERIFICACION_ADMIN = 0;
      FECHA:= LINEA.FECHA;
      KM_INICIO:=LINEA.KM_INICIO;
      KM_FINAL := LINEA.KM_FINAL;
      GASTO_GASOIL:= LINEA.GASTO_GASOIL;
      GASTO_AUTOPISTA:= LINEA.GASTO_AUTOPISTA;
      GASTO_DIETAS:= LINEA.GASTO_DIETAS;
      OTROS_GASTOS:= LINEA.OTROS_GASTOS;
      INCIDENCIAS_POSIBLES:= LINEA.INCIDENCIAS_POSIBLES;
      EXCESO_HORAS:= LINEA.EXCESO_HORAS;
      CERRAR_LOGIS:= LINEA.CERRAR_LOGIS;
      VERIFICACION_ADMIN:= LINEA.VERIFICACION_ADMIN;
      TRABAJADOR_ID_TRABAJADOR:= LINEA.TRABAJADOR_ID_TRABAJADOR;
      VEHICULO_MATRICULA:= LINEA.VEHICULO_MATRICULA;
      SI_DEVUELVE:=1;
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
  SI_DEVUELVE:=0;
      
COMMIT;
END;
CREATE PUBLIC SYNONYM TRAER_PARTE_ABIERTO FOR COMPROBAR_PARTES_ABIERTOS;


--traer lineas
CREATE OR REPLACE PROCEDURE TRAER_LINEAS (
FECHA_C IN DATE,
ID_T IN NUMBER,
LINEA OUT SYS_REFCURSOR
)
AS
BEGIN
OPEN LINEA FOR 
SELECT * FROM LP WHERE ID_T = CP_TRABAJADOR_ID_TRABAJADOR
AND FECHA_C = CP_FECHA;

COMMIT;
END;
CREATE PUBLIC SYNONYM PASAR_LINEA FOR TRAER_LINEAS;


--insert update cabecera
CREATE OR REPLACE PROCEDURE INSERT_Y_UPDATE_CABECERA(
CP_FECHA IN CP.FECHA%TYPE,
CP_KM_INICIO IN CP.KM_INICIO%TYPE,
CP_KM_FIN IN CP.KM_FINAL%TYPE,
CP_GASOIL IN CP.GASTO_GASOIL%TYPE,
CP_AUTOPISTA IN CP.GASTO_AUTOPISTA%TYPE,
CP_DIETAS IN CP.GASTO_DIETAS%TYPE,
CP_OTROS IN CP.OTROS_GASTOS%TYPE,
CP_INCIDENCIAS IN CP.INCIDENCIAS_POSIBLES%TYPE,
CP_EXCESO_HORAS IN CP.EXCESO_HORAS%TYPE,
CP_CERRAR_PARTE IN CP.CERRAR_LOGIS%TYPE,
CP_VERIFICAR IN CP.VERIFICACION_ADMIN%TYPE,
CP_ID_TRA IN CP.TRABAJADOR_ID_TRABAJADOR%TYPE,
CP_MATRICULA IN CP.VEHICULO_MATRICULA%TYPE
)
AS
BEGIN
      UPDATE CP
      SET
            FECHA=CP_FECHA,
            KM_INICIO=CP_KM_INICIO,
            KM_FINAL=CP_KM_FIN,
            GASTO_GASOIL=CP_GASOIL,
            GASTO_AUTOPISTA = CP_AUTOPISTA,
            GASTO_DIETAS = CP_DIETAS,
            OTROS_GASTOS = CP_OTROS,
            INCIDENCIAS_POSIBLES = CP_INCIDENCIAS,
            EXCESO_HORAS = CP_EXCESO_HORAS,
            CERRAR_LOGIS = CP_CERRAR_PARTE,
            VERIFICACION_ADMIN = CP_VERIFICAR,
            TRABAJADOR_ID_TRABAJADOR = CP_ID_TRA,
            VEHICULO_MATRICULA = CP_MATRICULA

      where FECHA=CP_FECHA AND TRABAJADOR_ID_TRABAJADOR = CP_ID_TRA AND VEHICULO_MATRICULA = CP_MATRICULA;
IF sql%notfound
THEN
	INSERT INTO CP(FECHA, KM_INICIO, KM_FINAL, GASTO_GASOIL, GASTO_AUTOPISTA, GASTO_DIETAS, OTROS_GASTOS, INCIDENCIAS_POSIBLES, EXCESO_HORAS, CERRAR_LOGIS, VERIFICACION_ADMIN, TRABAJADOR_ID_TRABAJADOR, VEHICULO_MATRICULA)
	VALUES (CP_FECHA, CP_KM_INICIO, CP_KM_FIN, CP_GASOIL, CP_AUTOPISTA, CP_DIETAS, CP_OTROS, CP_INCIDENCIAS, CP_EXCESO_HORAS, CP_CERRAR_PARTE, CP_VERIFICAR, CP_ID_TRA, CP_MATRICULA);
COMMIT;
END IF;
END;
CREATE PUBLIC SYNONYM INSERT_UPDATE_CABECERA FOR INSERT_Y_UPDATE_CABECERA;


--INSERTAR O UPDATE LINEAS PARTE.
CREATE OR REPLACE PROCEDURE INSERT_Y_UPDATE_LINEAS(
LP_HORA_INICIO IN LP.HORA_INICIO%TYPE,
LP_HORA_FIN IN LP.HORA_FINAL%TYPE,
LP_CP_FECHA IN LP.CP_FECHA%TYPE,
LP_CP_TRABAJADOR_ID_TRABAJADOR IN LP.CP_TRABAJADOR_ID_TRABAJADOR%TYPE
)
AS
BEGIN
      UPDATE LP
      SET
            HORA_INICIO=LP_HORA_INICIO,
            HORA_FINAL=LP_HORA_FIN,
            CP_FECHA=LP_CP_FECHA,
            CP_TRABAJADOR_ID_TRABAJADOR=LP_CP_TRABAJADOR_ID_TRABAJADOR
            
      where HORA_INICIO = LP_HORA_INICIO AND CP_FECHA=LP_CP_FECHA AND CP_TRABAJADOR_ID_TRABAJADOR = LP_CP_TRABAJADOR_ID_TRABAJADOR;
IF sql%notfound
THEN
	INSERT INTO LP(HORA_INICIO, HORA_FINAL, CP_FECHA, CP_TRABAJADOR_ID_TRABAJADOR)
	VALUES (LP_HORA_INICIO, LP_HORA_FIN, LP_CP_FECHA, LP_CP_TRABAJADOR_ID_TRABAJADOR);
COMMIT;
END IF;
END;
CREATE PUBLIC SYNONYM INSERT_O_UPDATE_LINEAS FOR INSERT_Y_UPDATE_LINEAS;


COMMIT;