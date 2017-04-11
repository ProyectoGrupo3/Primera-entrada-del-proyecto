DROP PUBLIC SYNONYM CONSULTA_CT;
DROP PUBLIC SYNONYM CONSULTA_UN_CT;
DROP PUBLIC SYNONYM CONSULTA_T;
DROP PUBLIC SYNONYM CONSULTA_UN_T;
DROP PUBLIC SYNONYM LOGIN;

--PAQUETE de Busqueda de centros de trabajo

--CABECERA DEL PAQUETE
 
CREATE OR REPLACE PACKAGE PAQUETE_BUSCAR_CT IS
PROCEDURE BUSCAR_TOTAL_CT (B OUT SYS_REFCURSOR);
END;
 
--CUERPO DEL PAQUETE
 
CREATE OR REPLACE PACKAGE BODY PAQUETE_BUSCAR_CT IS
PROCEDURE BUSCAR_TOTAL_CT(B OUT SYS_REFCURSOR)
IS
BEGIN
OPEN B FOR
SELECT *  FROM TCENTRO_TRABAJO;
END;
END;

--PAQUETE de Busqueda de un Centro de trabajo concreto
--CABECERA DEL PAQUETE
 
CREATE OR REPLACE PACKAGE PAQUETE_BUSCAR_UN_CT IS
PROCEDURE BUSCAR_UN_CENTRO ( ID_C IN TCENTRO_TRABAJO.ID_CENTRO%TYPE, B OUT TCENTRO_TRABAJO%ROWTYPE);
END;
 
--CUERPO DEL PAQUETE
 
CREATE OR REPLACE PACKAGE BODY PAQUETE_BUSCAR_UN_CT IS
PROCEDURE BUSCAR_UN_CENTRO ( ID_C IN TCENTRO_TRABAJO.ID_CENTRO%TYPE, B OUT TCENTRO_TRABAJO%ROWTYPE)
IS
BEGIN
  SELECT * INTO B FROM TCENTRO_TRABAJO 
  WHERE ID_CENTRO = ID_C;
END;
END;

--Procedimiento de Busqueda de todos los Trabajadores
CREATE OR REPLACE PROCEDURE BUSCAR_TOTAL_T (B OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN B FOR
  SELECT * FROM TTRABAJADOR;
END;

--Procedimiento de Busqueda de un Trabajador
CREATE OR REPLACE PROCEDURE BUSCAR_UN_T (ID_T IN TTRABAJADOR.ID_TRABAJADOR%TYPE, B OUT TTRABAJADOR%ROWTYPE)
AS
BEGIN
  SELECT * INTO B FROM TTRABAJADOR
  WHERE ID_TRABAJADOR = ID_T;
END;

--Procedimiento de comprobación del login de usuario
create or replace PROCEDURE COMPROBAR_LOGIN (USU IN VARCHAR2 , PASS IN VARCHAR2, V OUT number )
AS
LINEA TCLAVE%ROWTYPE;
BEGIN
  SELECT * INTO LINEA FROM TCLAVE
  WHERE USU = TCLAVE.USUARIO
  and TCLAVE.CONTRASEÑA = PASS;
  IF LINEA.USUARIO = USU THEN
  V:= 1;
  END IF;
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
      v:=0;
END;



CREATE PUBLIC SYNONYM CONSULTA_CT FOR PAQUETE_BUSCAR_CT ;
CREATE PUBLIC SYNONYM CONSULTA_UN_CT FOR PAQUETE_BUSCAR_UN_CT;
CREATE PUBLIC SYNONYM CONSULTA_T FOR BUSCAR_TOTAL_T;
CREATE PUBLIC SYNONYM CONSULTA_UN_T FOR BUSCAR_UN_T;
CREATE PUBLIC SYNONYM LOGIN FOR COMPROBAR_LOGIN ;

