create database example;
use example;

create table user(
id int primary key auto_increment,
nombre varchar(100) not null
);

select * from user;

select * from pedidos;

create table pedidos(
 id int primary key auto_increment,
 usuario_id int ,
 producto varchar(100) not null,
 foreign key (usuario_id) references user(id)
);

insert into user(nombre) values('Pablo'), ('Jack'), ('Back');
insert into pedidos(usuario_id, producto) values (1, 'Tomate'), (2,'opi');

select user.nombre , pedidos.producto
from pedidos
inner join user on pedidos.usuario_id = user.id;

SELECT user.nombre, pedidos.producto 
FROM user
LEFT JOIN pedidos ON user.id = pedidos.usuario_id;