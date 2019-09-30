-- Este archivo debe ejecutarse después de ConfiguracionInicialBD.
-- Un admin:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('admin1', 4, 0, 1, 'admin1');
-- Un gerente:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('gerente1', 5, 1, 1, 'gerente1');
-- Un recepcionista:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('recep1', 3, 2, 1, 'recep1');
-- Se agrega a la IPS 1:
INSERT INTO Recepcionista(Documento, IPS)
VALUES (2, 1);
-- Se agrega 4 médicos a la IPS 1:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('med1', 2, 3, 1, 'med1');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('med2', 2, 4, 1, 'med2');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('med3', 2, 5, 1, 'med3');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('med4', 2, 6, 1, 'med4');
INSERT INTO Medico(NumRegistroMed, Documento, Especialidad, IPS)
VALUES (0, 3, 'Cirugia General', 1);
INSERT INTO Medico(NumRegistroMed, Documento, Especialidad, IPS)
VALUES (1, 4, 'Cirugia Laparoscopica', 1);
INSERT INTO Medico(NumRegistroMed, Documento, Especialidad, IPS)
VALUES (2, 5, 'Neurocirugia', 1);
INSERT INTO Medico(NumRegistroMed, Documento, Especialidad, IPS)
VALUES (3, 6, 'Anesteciologo', 1);
-- Se agrega 15 afiliados a la EPS:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil1', 1, 7, 1, 'afil1');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil2', 1, 8, 1, 'afil2');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil3', 1, 9, 1, 'afil3');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil4', 1, 10, 1, 'afil4');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil5', 1, 11, 1, 'afil5');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil6', 1, 12, 1, 'afil6');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil7', 1, 13, 1, 'afil7');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil8', 1, 14, 1, 'afil8');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil9', 1, 15, 1, 'afil9');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil10', 1, 16, 1, 'afil10');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil11', 1, 17, 1, 'afil11');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil12', 1, 18, 1, 'afil12');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil13', 1, 19, 1, 'afil13');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil14', 1, 20, 1, 'afil14');
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil15', 1, 21, 1, 'afil15');
-- Se crea una fecha de nacimiento genérica:
INSERT INTO Fecha(Fecha) VALUES ('15-12-97');
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (7, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (8, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (9, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (10, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (11, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (12, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (13, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (14, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (15, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (16, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (17, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (18, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (19, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (20, 1, 1);
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (21, 1, 1);