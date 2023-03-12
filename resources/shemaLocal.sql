DROP TABLE IF EXISTS USUARIOS;
CREATE TABLE IF NOT EXISTS USUARIOS
(    USUARIOS             VARCHAR(20) NOT NULL
    ,CONTRASENA           VARCHAR(100)NOT NULL
    ,FECHA_CREACION       VARCHAT(20) DEFAULT(datetime('now'))
);
------------------------------------------------------------------------
INSERT INTO USUARIOS   (USUARIOS, CONTRASENA )
            VALUES      ('profe', 'nJxJL7JAy5T/3TFkLy1IVQ=='); 
INSERT INTO USUARIOS   (USUARIOS, CONTRASENA )
            VALUES      ('estefano.proano@epn.edu.ec', '1cg3sCKjDt6f7uLuUBf8fw==');
------------------------------------------------------------------------
SELECT * FROM USUARIOS;
