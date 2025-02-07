create table pedidos_historial (
	id int primary key auto_increment,
    usuario_id int,
    producto varchar(100),
    eliminado_en timestamp default current_timestamp
);

delimiter //

create trigger before_pedidos_delete
before DELETE on pedidos
for each row
begin 
	insert into pedidos_historial (usuario_id, producto)
    values (OLD.usuario_id, OLD.producto);
    END;

// 
delimiter ;

select * from pedidos;

delete from pedidos where id = 1;
select * from pedidos_historial;
