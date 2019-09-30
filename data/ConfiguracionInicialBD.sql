-- Inicialización de roles de Usuario:
INSERT INTO Rol(Rol) VALUES('Afiliado');
INSERT INTO Rol(Rol) VALUES('Medico');
INSERT INTO Rol(Rol) VALUES('Recepcionista');
INSERT INTO Rol(Rol) VALUES('Administrador');
INSERT INTO Rol(Rol) VALUES('Gerente');
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
INSERT INTO IPS(Nombre, Localizacion) 
VALUES ('Fundacion Santa Fe de Bogota', 'Cra. 7 ##117 -15');