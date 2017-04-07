--Procedimiento de Busqueda de centros de trabajo
CREATE OR REPLACE PROCEDURE BUSCTTOTAL (B OUT SYS_REFCURSOR)
IS
BEGIN
OPEN B FOR
SELECT *  FROM TCENTRO_TRABAJO;
 
END;




--Procedimiento de Busqueda de un Centro de trabajo concreto
CREATE OR REPLACE PROCEDURE BUSCTUNICO ( ID_C IN TCENTRO_TRABAJO.ID_CENTRO%TYPE, C OUT TCENTRO_TRABAJO%ROWTYPE)
AS

BEGIN
SELECT * INTO C FROM TCENTRO_TRABAJO 
WHERE ID_CENTRO = ID_C;

END;

--Procedimiento de Busqueda de todos los Trabajadores
CREATE PROCEDURE BUSCTRATOTAL ()
AS

BEGIN

END;
--Procedimiento de Busqueda de un Trabajador
CREATE PROCEDURE BUSCTRAUNICO ()
AS

BEGIN

END;
--Procedimiento de comprobación del login de usuario
CREATE PROCEDURE COMPROBARLOGIN ()
AS

BEGIN

END;

