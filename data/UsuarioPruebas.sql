-- Script de prueba para usuarios:

-- Primero, sea crean tipos para los documentos:
INSERT INTO TipoDocumento(TipoDocumento) VALUES ('CC');
INSERT INTO TipoDocumento(TipoDocumento) VALUES ('TI');
-- Luego se crean los roles:
INSERT INTO Rol(Rol) VALUES ('Admin');
INSERT INTO Rol(Rol) VALUES ('Medico');
INSERT INTO Rol(Rol) VALUES ('Gerente');
-- Finalmente, se agregan usuarios:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('Ddelcastillo', 1, 201630945, 1, 'Daniel del Castillo A.');

INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('Yaper', 3, 123, 2, 'Yamile Perdomo');

INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('Sandrade', 2, 456, 2, 'Sylvia Andrade');

-- Las siguientes inserciones deberían fallar:
-- Debería fallar debido al login.
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('Ddelcastillo', 1, 789, 1, 'Daniel del Castillo A.');
-- Debería fallar debido al documento.
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('Ddelcastillo2', 1, 201630945, 1, 'Daniel del Castillo A.');
-- Debería fallar debido a que no existe el rol.
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('Ddelcastillo2', 4, 2016309451, 1, 'Daniel del Castillo A.');
-- Debería fallar debido a que no existe el tipo de documento.
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('Ddelcastillo2', 1, 2016309451, 3, 'Daniel del Castillo A.');