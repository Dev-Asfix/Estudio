create database FormularioDB;
go

USE FormularioDB;
Go

create TAble DatosPersonales(
	id int primary key identity(1,1),
	nombre nvarchar(50),
	apellido nvarchar(50)
)

SElect * from DatosPersonales;

Alter Table DatosPersonales
ADD correo nvarchar(100),
	contraseña nvarchar(100);

exec sp_columns DatosPersonales;

Alter table DatosPersonales
add usuario nvarchar(50);