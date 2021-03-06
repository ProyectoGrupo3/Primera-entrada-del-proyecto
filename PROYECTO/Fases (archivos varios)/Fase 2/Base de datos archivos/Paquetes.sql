--PAQUETE de Busqueda de centros de trabajo
--CABECERA DEL PAQUETE
CREATE OR REPLACE PACKAGE PAQUETE_BUSCAR_CT IS
PROCEDURE BUSCAR_TOTAL_CT (B OUT SYS_REFCURSOR);
END;
/
 
--CUERPO DEL PAQUETE
CREATE OR REPLACE PACKAGE BODY PAQUETE_BUSCAR_CT IS
PROCEDURE BUSCAR_TOTAL_CT(B OUT SYS_REFCURSOR)
IS
BEGIN
OPEN B FOR
SELECT *  FROM CENTRO_TRABAJO;
END;
END;
/
CREATE PUBLIC SYNONYM CONSULTA_CT FOR PAQUETE_BUSCAR_CT ;
/


--PAQUETE de Busqueda de un Centro de trabajo concreto
--CABECERA DEL PAQUETE
CREATE OR REPLACE PACKAGE PAQUETE_BUSCAR_UN_CENTRO IS
PROCEDURE BUSCAR_UN_CENTRO ( ID_C IN CENTRO_TRABAJO.ID_CENTRO%TYPE, UNO OUT NUMBER, DOS OUT VARCHAR2, TRES OUT VARCHAR2, CUATRO OUT NUMBER, CINCO OUT VARCHAR2, SEIS OUT VARCHAR2, SIETE OUT VARCHAR2, OCHO OUT VARCHAR2);
END;
/
 
--CUERPO DEL PAQUETE
CREATE OR REPLACE PACKAGE BODY PAQUETE_BUSCAR_UN_CENTRO IS
PROCEDURE BUSCAR_UN_CENTRO ( ID_C IN CENTRO_TRABAJO.ID_CENTRO%TYPE,  UNO OUT NUMBER, DOS OUT VARCHAR2, TRES OUT VARCHAR2, CUATRO OUT NUMBER, CINCO OUT VARCHAR2, SEIS OUT VARCHAR2, SIETE OUT VARCHAR2, OCHO OUT VARCHAR2)
IS
LINEA CENTRO_TRABAJO%ROWTYPE;
BEGIN

  SELECT * INTO LINEA FROM CENTRO_TRABAJO 
  WHERE ID_CENTRO = ID_C;
  UNO:=LINEA.ID_CENTRO;
  DOS:=LINEA.NOMBRE;
  TRES:=LINEA.CALLE;
  CUATRO:=LINEA.NUMERO;
  CINCO:=LINEA.CODIGO_POSTAL;
  SEIS:=LINEA.CIUDAD;
  SIETE:=LINEA.PROVINCIA;
  OCHO:=LINEA.TELEFONO;
  
  EXCEPTION 
  WHEN NO_DATA_FOUND THEN
  RAISE_APPLICATION_ERROR( -20000  , 'Error', TRUE);
  WHEN TOO_MANY_ROWS THEN
  RAISE_APPLICATION_ERROR( -20000  , 'Error', TRUE);
END;
END;
/
CREATE PUBLIC SYNONYM CONSULTA_UN_CT FOR PAQUETE_BUSCAR_UN_CENTRO;
/

COMMIT;