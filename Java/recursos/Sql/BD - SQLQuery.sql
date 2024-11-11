-- Crear la base de datos
CREATE DATABASE Tienda;
GO

-- Usar la base de datos recién creada
USE Tienda;
GO

-- 1. Tabla: Proveedor
CREATE TABLE Proveedor (
    id_proveedor INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    nombre_proveedor VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(50),
    email VARCHAR(100),
    ruc VARCHAR(20)
);
GO

-- 2. Tabla: Producto
CREATE TABLE Producto (
    id_producto INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    nombre_producto VARCHAR(255) NOT NULL,
    descripcion TEXT,
    categoria VARCHAR(100),
    fecha_vencimiento DATE,
    peso DECIMAL(10, 2),
    stock INT,
    precio_costo DECIMAL(10, 2),
    precio_venta DECIMAL(10, 2)
);
GO

-- 3. Tabla: Compra
CREATE TABLE Compra (
    id_compra INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    id_proveedor INT,  -- FK a Proveedor
    fecha_compra DATE NOT NULL,
    total_compra DECIMAL(10, 2) NOT NULL,
    impuesto DECIMAL(5, 2),
    forma_pago VARCHAR(50),
    estado_compra VARCHAR(50),
    condiciones_pago VARCHAR(50),
    monto_a_pagar DECIMAL(10, 2),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);
GO

-- 4. Tabla: Detalle de Compra
CREATE TABLE Detalle_Compra (
    id_detalle INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    id_compra INT,  -- FK a Compra
    id_producto INT,  -- FK a Producto
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_compra) REFERENCES Compra(id_compra),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
GO

-- 5. Tabla: Proveedores_Productos (Relación entre Proveedor y Producto)
CREATE TABLE Proveedores_Productos (
    id_proveedor INT,  -- FK a Proveedor
    id_producto INT,  -- FK a Producto
    PRIMARY KEY (id_proveedor, id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
GO
