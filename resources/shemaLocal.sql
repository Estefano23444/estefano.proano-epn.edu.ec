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
INSERT INTO USUARIOS   (USUARIOS, CONTRASENA )
            VALUES      ('estefano.proano@epn.edu.ec', '1724156219');
------------------------------------------------------------------------
SELECT * FROM USUARIOS;
