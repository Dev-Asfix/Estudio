-- Crear la base de datos
CREATE DATABASE BD_Tienda;
GO

-- Usar la base de datos reci�n creada
USE BD_Tienda;
GO

-- Tabla: Proveedor
CREATE TABLE Proveedor (
    id_proveedor INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    nombre_proveedor VARCHAR(255) NOT NULL,  -- Nombre del proveedor
    direccion VARCHAR(255),  -- Direcci�n del proveedor
    telefono VARCHAR(50),  -- Tel�fono de contacto
    email VARCHAR(100),  -- Email del proveedor
    ruc VARCHAR(20),  -- Registro �nico de Contribuyentes
    pais VARCHAR(100),  -- Pa�s del proveedor
    ciudad VARCHAR(100),  -- Ciudad del proveedor
    codigo_postal VARCHAR(10),  -- C�digo postal del proveedor
    tipo_proveedor VARCHAR(50),  -- Tipo de proveedor (local/internacional)
    contacto_principal VARCHAR(255),  -- Persona de contacto principal
    telefono_contacto_principal VARCHAR(50),  -- Tel�fono del contacto principal
    email_contacto_principal VARCHAR(100),  -- Email del contacto principal
    metodo_pago_preferido VARCHAR(50),  -- M�todo de pago preferido (transferencia bancaria, tarjeta de cr�dito, etc.)
    numero_cuenta_bancaria VARCHAR(50),  -- N�mero de cuenta bancaria
    banco VARCHAR(100),  -- Banco del proveedor
    observaciones TEXT  -- Notas adicionales sobre el proveedor
);
GO

-- Tabla: Producto
CREATE TABLE Producto (
    id_producto INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    nombre_producto VARCHAR(255) NOT NULL,  -- Nombre del producto
    descripcion TEXT,  -- Descripci�n del producto
    categoria VARCHAR(100),  -- Categor�a del producto
    fecha_vencimiento DATE,  -- Fecha de vencimiento del producto
    peso DECIMAL(10, 2),  -- Peso del producto
    dimensiones VARCHAR(50),  -- Dimensiones del producto (largo x ancho x alto)
    stock INT,  -- Cantidad en inventario
    precio_costo DECIMAL(10, 2),  -- Precio de costo del producto
    precio_venta DECIMAL(10, 2),  -- Precio de venta del producto
    codigo_barras VARCHAR(100),  -- C�digo de barras del producto
    sku VARCHAR(50),  -- SKU del producto
    fabricante VARCHAR(100),  -- Nombre del fabricante
    marca VARCHAR(100),  -- Marca del producto
    pais_origen VARCHAR(100),  -- Pa�s de origen del producto
    fecha_fabricacion DATE,  -- Fecha de fabricaci�n
    vida_util INT,  -- Vida �til del producto en meses
    costo_envio DECIMAL(10, 2),  -- Costo estimado de env�o
    garantia VARCHAR(50),  -- Garant�a del producto
    estado_producto VARCHAR(50),  -- Estado del producto (nuevo, usado, reacondicionado)
    clasificacion_aduanera VARCHAR(100),  -- Clasificaci�n aduanera del producto
    impuestos DECIMAL(5, 2)  -- Impuesto asociado al producto
);
GO

-- Tabla: Compra
CREATE TABLE Compra (
    id_compra INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    id_proveedor INT,  -- FK a Proveedor
    fecha_compra DATE NOT NULL,  -- Fecha en la que se realiza la compra
    total_compra DECIMAL(10, 2) NOT NULL,  -- Importe total de la compra
    impuesto DECIMAL(5, 2),  -- Impuesto aplicado a la compra
    forma_pago VARCHAR(50),  -- M�todo de pago (efectivo, tarjeta, transferencia, etc.)
    estado_compra VARCHAR(50),  -- Estado de la compra (pendiente, completada, cancelada)
    condiciones_pago VARCHAR(50),  -- Condiciones de pago (contado, cr�dito)
    monto_a_pagar DECIMAL(10, 2),  -- Monto total a pagar
    fecha_pago DATE,  -- Fecha en la que se realiza el pago
    descuento DECIMAL(5, 2),  -- Descuento aplicado a la compra
    observaciones TEXT,  -- Notas sobre la compra
    numero_factura VARCHAR(50),  -- N�mero de factura asociado
    tracking_envio VARCHAR(100),  -- N�mero de seguimiento del env�o
    fecha_envio DATE,  -- Fecha de env�o
    fecha_entrega_estimada DATE,  -- Fecha estimada de entrega
    fecha_entrega_real DATE,  -- Fecha real de entrega
    estado_envio VARCHAR(50),  -- Estado del env�o (en tr�nsito, entregado, etc.)
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);
GO

-- Tabla: Detalle_Compra
CREATE TABLE Detalle_Compra (
    id_detalle INT PRIMARY KEY IDENTITY(1,1),  -- PK autoincremental
    id_compra INT,  -- FK a Compra
    id_producto INT,  -- FK a Producto
    cantidad INT NOT NULL,  -- Cantidad comprada del producto
    precio_unitario DECIMAL(10, 2) NOT NULL,  -- Precio negociado por unidad del producto
    subtotal DECIMAL(10, 2),  -- Subtotal (cantidad * precio_unitario)
    fecha_entrega DATE,  -- Fecha en la que se entrega este producto en particular
    estado_detalle VARCHAR(50),  -- Estado del detalle de la compra (pendiente, entregado, etc.)
    FOREIGN KEY (id_compra) REFERENCES Compra(id_compra),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
GO

-- Tabla: Proveedores_Productos
CREATE TABLE Proveedores_Productos (
    id_proveedor INT,  -- FK a Proveedor
    id_producto INT,  -- FK a Producto
    fecha_asociacion DATE,  -- Fecha en la que el proveedor comenz� a suministrar este producto
    precio_acordado DECIMAL(10, 2),  -- Precio acordado entre el proveedor y la empresa
    tiempo_entrega_estimada INT,  -- Tiempo estimado de entrega en d�as
    PRIMARY KEY (id_proveedor, id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
GO
