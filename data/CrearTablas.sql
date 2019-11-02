-- Secuencia de la BD:
CREATE SEQUENCE EPS_sequence;
---------------------------------------------------------------
-- Creación de la tabla de roles, usuarios, fechas y entidades:
---------------------------------------------------------------

-- Tabla de Rol:
CREATE TABLE Rol(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Rol VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT Rol_Rol_Unique UNIQUE (Rol),
CONSTRAINT Rol_PK PRIMARY KEY (ID));

-- Tabla TipoDocumento:
CREATE TABLE TipoDocumento(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
TipoDocumento VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT TD_TipoDocumento_Unique UNIQUE (TipoDocumento),
CONSTRAINT TD_PK PRIMARY KEY(Id));

-- Tabla Usuario:
CREATE TABLE Usuario(
Login VARCHAR2(255 BYTE),
Rol NUMBER,
Documento NUMBER,
TipoDocumento NUMBER,
Nombre VARCHAR2(255 BYTE),
CONSTRAINT Usuario_Login_Unique UNIQUE (Login),
CONSTRAINT Usuario_PK PRIMARY KEY (Login, Documento),
CONSTRAINT Usuario_Documento_CK CHECK(Documento >= 0),
CONSTRAINT Usuario_Documento_Unique UNIQUE (Documento),
CONSTRAINT Rol_Rol_FK FOREIGN KEY (Rol) REFERENCES Rol(Id),
CONSTRAINT Usuario_TipoDocumento_FK FOREIGN KEY (TipoDocumento) REFERENCES TipoDocumento(Id));

-- Tabla de IPS:
CREATE TABLE IPS(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Nombre VARCHAR2(255 BYTE) NOT NULL,
Localizacion VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT IPS_PK PRIMARY KEY (Id),
CONSTRAINT IPS_Nombre_Unique UNIQUE (Nombre));

-- Tabla de Recepcionista:
CREATE TABLE Recepcionista(
Documento NUMBER,
IPS NUMBER,
CONSTRAINT Recepcionista_PK PRIMARY KEY (Documento),
CONSTRAINT Recepcionista_IPS_FK FOREIGN KEY (IPS) REFERENCES IPS(Id),
CONSTRAINT Recepcionista_Documento_FK FOREIGN KEY (Documento) REFERENCES Usuario(Documento));

-- Tabla de Medico:
CREATE TABLE Medico(
NumRegistroMed NUMBER,
Documento NUMBER,
Especialidad VARCHAR2(255 BYTE) NOT NULL,
IPS NUMBER,
CONSTRAINT Medico_Documento_Unique UNIQUE (Documento),
CONSTRAINT Medico_PK PRIMARY KEY (NumRegistroMed, Documento),
CONSTRAINT Medico_IPS_FK FOREIGN KEY (IPS) REFERENCES IPS(Id),
CONSTRAINT Medico_NumRegistroMed_CK CHECK(NumRegistroMed >= 0),
CONSTRAINT Medico_NumRegistroMed_Unique UNIQUE (NumRegistroMed),
CONSTRAINT Medico_Documento_FK FOREIGN KEY (Documento) REFERENCES Usuario(Documento));

-- Tabla de Fecha:
CREATE TABLE Fecha(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Fecha VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT Fecha_PK PRIMARY KEY (Id),
CONSTRAINT Fecha_Fecha_Unique UNIQUE (Fecha));

-- Tabla de EPS:
CREATE TABLE EPS(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Nombre VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT EPS_PK PRIMARY KEY (Id));

-- Tabla de Afiliado:
CREATE TABLE Afiliado(
Documento NUMBER,
FechaNacimiento NUMBER,
EPS NUMBER,
CONSTRAINT Afiliado_PK PRIMARY KEY (Documento),
CONSTRAINT Afiliado_EPS_FK FOREIGN KEY (EPS) REFERENCES EPS(Id),
CONSTRAINT Afiliado_Documento_FK FOREIGN KEY (Documento) REFERENCES Usuario(Documento),
CONSTRAINT Afiliado_FechaNacimiento_FK FOREIGN KEY (FechaNacimiento) REFERENCES Fecha(Id));

-------------------------------------------------------------------------------
-- Creación de la tabla de servicios, relaciones, recetas, ordenes y consultas:
-------------------------------------------------------------------------------

-- Tabla de TipoServicio:
CREATE TABLE TipoServicio(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Tipo VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT TipoServicio_PK PRIMARY KEY (Id),
CONSTRAINT TipoServicio_Tipo_Unique UNIQUE (Tipo),
CONSTRAINT TipoServicio_Tipo_CK CHECK (Tipo IN ('ConsultaEmergencia', 'ConsultaEspecialista', 
    'Terapia', 'ConsultaControl', 'Examenes', 'Hospitalizacion', 'ProcesoMedicoEspecializado')));

-- Tabla de Servicio:
CREATE TABLE Servicio(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Capacidad NUMBER NOT NULL,
HoraInicio NUMBER NOT NULL,
HoraFinal NUMBER NOT NULL,
TipoServicio NUMBER,
IdIPS NUMBER,
CONSTRAINT PS_IdIPS_Unique UNIQUE (IdIPS),
CONSTRAINT Servicio_PK PRIMARY KEY (Id),
CONSTRAINT Servicio_Capacidad_CK CHECK (Capacidad > 0),
CONSTRAINT Servicio_HoraFinal_CK_1 CHECK (HoraFinal >= 0),
CONSTRAINT Servicio_HoraFinal_CK_2 CHECK (HoraFinal <= 24),
CONSTRAINT Servicio_HoraInicio_CK_1 CHECK (HoraInicio >= 0),
CONSTRAINT Servicio_HoraInicio_CK_2 CHECK (HoraInicio <= 24),
CONSTRAINT Servicio_HoraFinal_CK_3 CHECK (HoraFinal > HoraInicio));

-- Tabla de ServicioMedico:
CREATE TABLE ServicioMedico(
IdMedico NUMBER,
IdServicio NUMBER,
CONSTRAINT SM_IdMedico_Unique UNIQUE (IdMedico),
CONSTRAINT SM_IdServicio_Unique UNIQUE (IdServicio),
CONSTRAINT SM_PK PRIMARY KEY (IdMedico, IdServicio),
CONSTRAINT SM_IdMedico_PK FOREIGN KEY (IdMedico) REFERENCES Medico(Documento),
CONSTRAINT SM_IdServicio_FK FOREIGN KEY (IdServicio) REFERENCES Servicio(Id));

-- Tabla de PrestanServicio:
CREATE TABLE PrestanServicio(
IdIPS NUMBER,
IdServicio NUMBER,
IdMedico NUMBER,
CONSTRAINT PS_PK_Unique PRIMARY KEY (IdIPS, IdServicio),
CONSTRAINT PS_IdMedico FOREIGN KEY (IdIPS) REFERENCES IPS(Id),
CONSTRAINT PS_IdServicio FOREIGN KEY (IdServicio) REFERENCES Servicio(Id));

-- Tabla de ServiciosAfiliado:
CREATE TABLE ServiciosAfiliado(
--IdServicio NUMBER,
IdTipoServicio NUMBER,
IdAfiliado NUMBER,
FechaAsistida VARCHAR2(255 BYTE) NOT NULL,
IPS NUMBER,
CONSTRAINT SA_PK PRIMARY KEY (IdTipoServicio, IdAfiliado),
CONSTRAINT SA_IPS_FK FOREIGN KEY (IPS) REFERENCES IPS(Id),
CONSTRAINT SA_IdTipoServicio FOREIGN KEY (IdTipoServicio) REFERENCES TipoServicio(Id),
CONSTRAINT SA_IdAfiliado FOREIGN KEY (IdAfiliado) REFERENCES Afiliado(Documento));

-- Tabla de Trabajan:
CREATE TABLE Trabajan(
IdEPS NUMBER,
IdIPS NUMBER,
CONSTRAINT Trabajan_IdEPS_Unique UNIQUE (IdEPS),
CONSTRAINT Trabajan_IdIPS_Unique UNIQUE (IdIPS),
CONSTRAINT Trabajan_PK PRIMARY KEY (IdEPS, IdIPS),
CONSTRAINT Trabajan_IdEPS_FK FOREIGN KEY (IdEPS) REFERENCES EPS(Id),
CONSTRAINT Trabajan_IdIPS_FK FOREIGN KEY (IdIPS) REFERENCES IPS(Id));

-- Tabla de Receta:
CREATE TABLE Receta(
IdUsuario NUMBER,
Descripcion VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT Receta_PK PRIMARY KEY (IdUsuario),
CONSTRAINT Receta_IdUsuario_FK FOREIGN KEY (IdUsuario) REFERENCES Afiliado(Documento));

-- Tabla de Ordenes:
CREATE TABLE Ordenes(
IdAfiliado NUMBER,
IdMedico NUMBER,
TipoServicio NUMBER,
CONSTRAINT Ordenes_IdMedico_Unique UNIQUE (IdMedico),
CONSTRAINT Ordenes_IdAfiliado_Unique UNIQUE (IdAfiliado),
CONSTRAINT Ordenes_PK PRIMARY KEY (IdAfiliado, IdMedico),
CONSTRAINT Ordenes_IdMedico_FK FOREIGN KEY (IdMedico) REFERENCES Medico(Documento),
CONSTRAINT Ordenes_IdAfiliado_FK FOREIGN KEY (IdAfiliado) REFERENCES Afiliado(Documento),
CONSTRAINT Ordenes_TipoServicio_FK FOREIGN KEY (TipoServicio) REFERENCES TipoServicio(Id));

-- Tabla de Prioridad:
CREATE TABLE Prioridad(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Prioridad VARCHAR2(255 BYTE) NOT NULL,
CONSTRAINT Prioridad_PK PRIMARY KEY (Id),
CONSTRAINT Prioridad_Prioridad_Unique UNIQUE (Prioridad),
CONSTRAINT Prioridad_Prioridad_CK CHECK (Prioridad IN ('Baja', 'Media', 'Alta')));

-- Tabla de ConsultaEmergencia:
CREATE TABLE ConsultaEmergencia(
IdServicio NUMBER,
Triage NUMBER,
CONSTRAINT ConsultaEM_PK PRIMARY KEY (IdServicio),
CONSTRAINT ConsultaEM_Triage_FK FOREIGN KEY (Triage) REFERENCES Prioridad(Id),
CONSTRAINT ConsultaEM_IdServicio_FK FOREIGN KEY (IdServicio) REFERENCES Servicio(Id));

-- Tabla de Citas:
CREATE TABLE Citas(
Id NUMBER GENERATED ALWAYS AS IDENTITY,
Hora NUMBER NOT NULL,
Fecha NUMBER,
IdServicio NUMBER,
CONSTRAINT Citas_PK PRIMARY KEY (Id),
CONSTRAINT Citas_Fecha_FK FOREIGN KEY (Fecha) REFERENCES Fecha(Id),
CONSTRAINT Citas_IdServicio_FK FOREIGN KEY (IdServicio) REFERENCES Servicio(Id));