--Creación de las secuencias usadas para los ID de algunas tablas.
CREATE SEQUENCE ID_CENTRO 
  INCREMENT BY 10 START WITH 10 
  NOMAXVALUE
  MINVALUE 10;
  /
  
  CREATE SEQUENCE ID_TRABAJADOR 
  INCREMENT BY 1 START WITH 1 
  NOMAXVALUE
  MINVALUE 1;
  /
  
  CREATE SEQUENCE ID_CLAVE 
  INCREMENT BY 1 START WITH 1 
  NOMAXVALUE
  MINVALUE 1;
  /
  
  
  COMMIT;