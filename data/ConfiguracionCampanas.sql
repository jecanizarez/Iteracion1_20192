-- Creación preliminar de campañas.
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campana contra el cancer de mama', 13450);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campana para el sindrome de Down', 13402);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campana contra el linfoma', 65307);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Fundraiser for the children with leukemia', 34708);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campaign against children with the flue', 51032);

INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campana por los ninos con diabetes', 102087);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campana para la investigacion en cancer',68703);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Fundraiser for alzheimer research', 12345);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campaign for STD prevention', 82521);
INSERT INTO CAMPANA(Nombre, IdOrganizador) VALUES ('Campana por la prevencion de dengue', 84638);
COMMIT;

-- Los usuarios son ahora organizadores.
UPDATE Usuario SET Login = 'org1' WHERE Documento = 13450;
UPDATE Usuario SET Rol = 6 WHERE Documento = 13450;
UPDATE Usuario SET Rol = 6 WHERE Documento = 13402;
UPDATE Usuario SET Rol = 6 WHERE Documento = 65307;
UPDATE Usuario SET Rol = 6 WHERE Documento = 34708;
UPDATE Usuario SET Rol = 6 WHERE Documento = 51032;

UPDATE Usuario SET Rol = 6 WHERE Documento = 102087;
UPDATE Usuario SET Rol = 6 WHERE Documento = 68703;
UPDATE Usuario SET Rol = 6 WHERE Documento = 12345;
UPDATE Usuario SET Rol = 6 WHERE Documento = 82521;
UPDATE Usuario SET Rol = 6 WHERE Documento = 84638;
COMMIT;

-- Gente unida a las campañas:
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40000, 1);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40001, 1);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40002, 1);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40003, 1);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40004, 1);

INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40010, 2);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40021, 2);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40032, 2);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40043, 2);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40054, 2);

INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40110, 3);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40221, 4);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40332, 5);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40443, 6);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40554, 7);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40610, 8);
INSERT INTO AFILIADOSCAMPANA(IdAfiliado, IdCampana) VALUES (40721, 9);
COMMIT;