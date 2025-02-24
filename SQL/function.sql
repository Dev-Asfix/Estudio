select rand() * 8;
Set global log_bin_trust_function_creators = 1;

-- CREATE DEFINER=`root`@`localhost` FUNCTION `f_aleatorio`(min INT, max INt) RETURNS int
-- BEGIN
-- DECLARE vresultado INT;
-- SELECT FLOOR((RAND() * (max-min+1))+min) INTO vresultado;
-- RETURN vresultado;
-- END

select f_aleatorio(1,3) As resultado;

select f_cliente_aleatorio() as cliente;

SELECT f_cliente_aleatorio() AS CLIENTE, 
f_producto_aleatorio() AS PRODUCTO,
f_vendedor_aleatorio() AS VENDEDOR;

CALL sp_venta('20210619', 15, 100);



CREATE TABLE facturas(
NUMERO INT NOT NULL,
FECHA DATE,
DNI VARCHAR(11) NOT NULL,
MATRICULA VARCHAR(5) NOT NULL,
IMPUESTO FLOAT,
PRIMARY KEY (NUMERO),
FOREIGN KEY (DNI) REFERENCES clientes(DNI),
FOREIGN KEY (MATRICULA) REFERENCES vendedores(MATRICULA)
);
CREATE TABLE items(
NUMERO INT NOT NULL,
CODIGO VARCHAR(10) NOT NULL,
CANTIDAD INT,
PRECIO FLOAT,
PRIMARY KEY (NUMERO, CODIGO),
FOREIGN KEY (NUMERO) REFERENCES facturas(NUMERO),
FOREIGN KEY (CODIGO) REFERENCES productos(CODIGO)
);



INSERT INTO facturas
SELECT NUMERO, FECHA_VENTA AS CODIGO, DNI, MATRICULA, IMPUESTO
FROM jugos_ventas.facturas;

INSERT INTO items
SELECT NUMERO, CODIGO_DEL_PRODUCTO AS CODIGO, CANTIDAD, PRECIO
FROM jugos_ventas.items_facturas;

CALL sp_venta('20210619', 3, 100);
