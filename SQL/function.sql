select rand() * 8;
Set global log_bin_trust_function_creators = 1;

-- CREATE DEFINER=`root`@`localhost` FUNCTION `f_aleatorio`(min INT, max INt) RETURNS int
-- BEGIN
-- DECLARE vresultado INT;
-- SELECT FLOOR((RAND() * (max-min+1))+min) INTO vresultado;
-- RETURN vresultado;
-- END

select f_aleatorio(1,3) As resultado;