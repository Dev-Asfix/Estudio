CREATE TABLE Departamentos (
    id_departamento INT PRIMARY KEY IDENTITY(1,1),
    nombre_departamento VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

Create Table Roles(
	id_rol int primary key identity(1,1),
	nombre_rol varchar(50) not null,
	descripcion varchar(255)
);

create table HistorialAcceso(
	id_acceso int primary key identity(1,1),
	id_usuario INT,
	fecha_acceso DATETIME default CURRENT_TIMESTAMP,
	FOREIGN KEY (id_usuario) REFERENCES DatosPersonales(id_usuario)
);

ALTER TABLE DatosPersonales 
ADD FOREIGN KEY (id_departamento) REFERENCES Departamentos(id_departamento),
    FOREIGN KEY (id_rol) REFERENCES Roles(id_rol);

