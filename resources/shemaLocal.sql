DROP TABLE IF EXISTS USUARIOS;
CREATE TABLE IF NOT EXISTS USUARIOS
(    USUARIOS             VARCHAR(20) NOT NULL
    ,CONTRASENA        VARCHAR(100)NOT NULL
);
------------------------------------------------------------------------
INSERT INTO USUARIOS   (USUARIOS, CONTRASENA )
            VALUES      ('Profe', '1234'); 
INSERT INTO USUARIOS   (USUARIOS, CONTRASENA )
            VALUES      ('Usuario', 'contrasena'); 
------------------------------------------------------------------------
SELECT * FROM USUARIOS;
