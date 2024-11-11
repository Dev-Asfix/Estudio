create database SistemaVentas;
GO

USE SistemaVentas;
GO

create TABLE Usuarios (
    ID_Usuario INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    Contraseña VARCHAR(255) NOT NULL,
    Fecha_Creacion DATETIME DEFAULT GETDATE(),
    Activo BIT DEFAULT 1
);

select * from Usuarios;

CREATE TABLE Roles (
    ID_Rol INT PRIMARY KEY IDENTITY(1,1),
    Nombre_Rol VARCHAR(50) NOT NULL,
    Descripción VARCHAR(255)
);

SELECT * from Roles;

CREATE TABLE Usuario_Rol (
    ID_Usuario INT,
    ID_Rol INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario),
    FOREIGN KEY (ID_Rol) REFERENCES Roles(ID_Rol),
    PRIMARY KEY (ID_Usuario, ID_Rol)
);

CREATE TABLE Productos (
    ID_Producto INT PRIMARY KEY IDENTITY(1,1),
    Nombre_Producto VARCHAR(100) NOT NULL,
    Descripción VARCHAR(255),
    Precio DECIMAL(10,2) NOT NULL,
    Stock INT NOT NULL,
    Activo BIT DEFAULT 1
);

CREATE TABLE Ventas (
    ID_Venta INT PRIMARY KEY IDENTITY(1,1),
    ID_Usuario INT,
    Fecha_Venta DATETIME DEFAULT GETDATE(),
    Total DECIMAL(10,2),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario)
);

CREATE TABLE Detalles_Venta (
    ID_Detalle INT PRIMARY KEY IDENTITY(1,1),
    ID_Venta INT,
    ID_Producto INT,
    Cantidad INT NOT NULL,
    Precio_Unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (ID_Venta) REFERENCES Ventas(ID_Venta),
    FOREIGN KEY (ID_Producto) REFERENCES Productos(ID_Producto)
);

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña) 
VALUES ('Juan', 'Perez', 'juan.perez@example.com', HASHBYTES('SHA2_256', 'contraseña123'));

select * from Usuarios;
SELECT HASHBYTES('SHA2_256', 'contraseña123');
0x29A54E89F6C4A529BA88B6634BD1842922FDE73A308C0A5ADBAB56D70645ACEC

SELECT * FROM Usuarios WHERE Email = 'juan.perez@example.com' AND Contraseña = HASHBYTES('SHA2_256', 'contraseña123') AND Activo = 1;

SELECT Email, 
       CONVERT(VARCHAR(64), Contraseña, 2) AS ContraseñaHex
FROM Usuarios
WHERE Email = 'juan.perez@example.com';

DECLARE @Email NVARCHAR(100) = 'juan.perez@example.com';
DECLARE @Password NVARCHAR(255) = 'contraseña123';

SELECT *
FROM Usuarios
WHERE Email = @Email
  AND CONVERT(VARCHAR(64), Contraseña, 2) = CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2)
  AND Activo = 1;

SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', 'contraseña123'), 2) AS HashedPassword;

DECLARE @Password NVARCHAR(255) = 'contraseña123';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS HashedPassword;

DECLARE @Password NVARCHAR(255) = 'contraseña123';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS HashedPassword;

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña) 
VALUES ('Juan', 'Perez', 'juan.perez@example.com', HASHBYTES('SHA2_256', 'contraseña123'));

DECLARE @Password NVARCHAR(255) = 'contraseña123';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS HashedPassword;

DECLARE @Password NVARCHAR(255) = 'contraseña123';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS HashedPassword;

DECLARE @Password NVARCHAR(255) = 'contraseña123';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS HashedPassword;

DECLARE @TestPassword NVARCHAR(255) = 'testPassword';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @TestPassword), 2) AS TestHashedPassword;

DECLARE @TestPassword NVARCHAR(255) = 'testPassword';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @TestPassword), 2) AS TestHashedPassword;

DECLARE @TestPassword NVARCHAR(255) = 'contraseña123'; -- Usa el texto exacto que estás usando en Java
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @TestPassword), 2) AS TestHashedPassword;

DECLARE @TestPassword NVARCHAR(255) = 'contraseña123'; -- Texto exacto usado en Java
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @TestPassword), 2) AS TestHashedPassword;

DECLARE @Password NVARCHAR(255) = 'contraseña123';
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS HashedPassword;

DECLARE @Password NVARCHAR(255) = 'contraseña123'; -- Usa el texto exacto que estás usando en Java
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS TestHashedPassword;


DECLARE @Password NVARCHAR(255) = 'contraseña123'; -- Usa el texto exacto que estás usando en Java
SELECT CONVERT(VARCHAR(64), HASHBYTES('SHA2_256', @Password), 2) AS TestHashedPassword;

select * from Usuarios;

ALTER TABLE Usuarios
ALTER COLUMN Contraseña VARBINARY(64);

ALTER TABLE Usuarios
ALTER COLUMN Contraseña VARBINARY(64);

ALTER TABLE Usuarios
ALTER COLUMN Contraseña VARBINARY(32);  -- 32 bytes para SHA-256

ALTER TABLE Usuarios
ADD ContraseñaHash VARBINARY(32);

UPDATE Usuarios
SET ContraseñaHash = HASHBYTES('SHA2_256', CONVERT(NVARCHAR(255), Contraseña));

ALTER TABLE Usuarios
DROP COLUMN Contraseña;

EXEC sp_rename 'Usuarios.ContraseñaHash', 'Contraseña', 'COLUMN';

ALTER TABLE Usuarios
ALTER COLUMN Contraseña VARCHAR(255);  -- Almacenar contraseñas en texto plano

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña)
VALUES ('Juan', 'Perez', 'juan.perez@example.com', 'contraseña123');

DELETE FROM Usuarios
WHERE Email = 'juan.perez@example.com';

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña)
VALUES ('Juan', 'Perez', 'juan.perez@example.com', 'contraseña123');

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña)
VALUES ('Alejandro', 'Landa', 'landa@gmail.com', 'contraseña123');

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña)
VALUES ('Alejandro', 'Gomez', 'gomez@gmail.com', 'contraseña123');

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña)
VALUES ('Jack', 'Perez', 'jack@gmail.com', 'contraseña123');

INSERT INTO Usuarios (Nombre, Apellido, Email, Contraseña)
VALUES ('Pablo', 'Rosas', 'pablo@gmail.com', 'contraseña123');

SELECT ID_Usuario, Nombre, Apellido, Email, Contraseña FROM Usuarios