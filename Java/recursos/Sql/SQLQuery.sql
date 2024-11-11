CREATE DATABASE SistemaMatriculas;
GO

USE SistemaMatriculas;
GO

CREATE TABLE Estudiantes (
    id_estudiante INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) NOT NULL,
    apellido NVARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    direccion NVARCHAR(100),
    telefono NVARCHAR(15),
    email NVARCHAR(100)
);

CREATE TABLE Cursos (
    id_curso INT PRIMARY KEY IDENTITY(1,1),
    nombre_curso NVARCHAR(100) NOT NULL,
    descripcion NVARCHAR(255),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    profesor NVARCHAR(100),
    horarios NVARCHAR(50)
);

CREATE TABLE Matriculas (
    id_matricula INT PRIMARY KEY IDENTITY(1,1),
    id_estudiante INT NOT NULL,
    id_curso INT NOT NULL,
    fecha_matricula DATE NOT NULL,
    estado NVARCHAR(20) DEFAULT 'Activo',
    notas NVARCHAR(255),

    -- Definir claves foráneas para las relaciones
    FOREIGN KEY (id_estudiante) REFERENCES Estudiantes(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);
