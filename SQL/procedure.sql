DELIMITER $$

CREATE PROCEDURE obtener_usuarios()
BEGIN
    SELECT * FROM usuarios;
END $$

DELIMITER ;
