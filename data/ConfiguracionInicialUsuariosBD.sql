@C:\Users\Daniel\Desktop\Generador_datos\dates.sql;

-- 0) Fechas

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
INSERT INTO Recepcionista(Documento, IPS)
VALUES (2, 1);
-- Se agrega un médico:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('med1', 2, 3, 1, 'med1');
INSERT INTO Medico(NumRegistroMed, Documento, Especialidad, IPS)
VALUES (0, 3, 'Cirugia General', 1);
-- Se agrega un afiliado:
INSERT INTO Usuario(Login, Rol, Documento, TipoDocumento, Nombre)
VALUES ('afil1', 1, 4, 1, 'afil1');
INSERT INTO Afiliado(Documento, FechaNacimiento, EPS)
VALUES (4, 1, 1);

COMMIT;

-- 1) Usuarios
-- 2) Medicos
-- 3) Afiliados
-- 4) Servicios
-- 5) PrestanServicio
-- 6) ServicioMedico
-- 7) ServiciosAfiliado