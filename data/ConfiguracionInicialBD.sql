-- Inicialización de roles de Usuario:
INSERT INTO Rol(Rol) VALUES('Afiliado');
INSERT INTO Rol(Rol) VALUES('Medico');
INSERT INTO Rol(Rol) VALUES('Recepcionista');
INSERT INTO Rol(Rol) VALUES('Administrador');
INSERT INTO Rol(Rol) VALUES('Gerente');
INSERT INTO Rol(Rol) VALUES('OrganizadorCampaña');
-- Inicialización de los TipoDocumento:
INSERT INTO TipoDocumento(TipoDocumento) VALUES ('CC');
INSERT INTO TipoDocumento(TipoDocumento) VALUES ('CE');
INSERT INTO TipoDocumento(TipoDocumento) VALUES ('TI');
-- Inicialización de los TipoServicio:
INSERT INTO TipoServicio(Tipo) VALUES ('ConsultaEmergencia');
INSERT INTO TipoServicio(Tipo) VALUES ('ConsultaEspecialista');
INSERT INTO TipoServicio(Tipo) VALUES ('Terapia');
INSERT INTO TipoServicio(Tipo) VALUES ('ConsultaControl');
INSERT INTO TipoServicio(Tipo) VALUES ('Examenes');
INSERT INTO TipoServicio(Tipo) VALUES ('Hospitalizacion');
INSERT INTO TipoServicio(Tipo) VALUES ('ProcesoMedicoEspecializado');
-- Inicialización de la Prioridad:
INSERT INTO Prioridad(Prioridad) VALUES ('Baja');
INSERT INTO Prioridad(Prioridad) VALUES ('Media');
INSERT INTO Prioridad(Prioridad) VALUES ('Alta');
-- Inicialización de la EPS:
INSERT INTO EPS(Nombre) VALUES ('EPSAndes');
-- Inicialización de las IPS:
INSERT INTO IPS(Nombre, Localizacion) VALUES ('Fundacion Santa Fe de Bogota', 'Carrera 7 #117 15');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('COUNTRY SCAN LTDA', 'Carrera 16A # 82 37');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('EFI CIENCIA OCUPACIONAL LTDA', 'Carrera 20 A # 72 09');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('SOCIEDAD DE CIRUGIA OCULAR', 'AV Calle 134 # 7B 83');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('CENTRO NEUROLOGICO DE BOGOTA LIMITADA', 'Carrera 16 # 82 95');

INSERT INTO IPS(Nombre, Localizacion) VALUES ('FORJA EMPRESAS SAS', 'TV 21 # 98 71');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('City Ambulancias SAS', 'Calle 77 # 58 23');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('DENTAL LINE E.U.', 'TV 34 A BIS # 40 67 SUR');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('CORVESALUD SAS', 'Carrera 13 # 37 37');
INSERT INTO IPS(Nombre, Localizacion) VALUES ('ORL BOSQUE LTDA', 'AV Calle 134 # 7 B 83');
-- Trabajan:
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 1);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 2);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 3);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 4);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 5);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 6);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 7);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 8);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 9);
INSERT INTO Trabajan(IdEPS, IdIPS) VALUES (1, 10);
COMMIT;