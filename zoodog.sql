
create table Dog(
id serial not null,
name varchar(100) not null,
gro varchar(100) not null,
personality varchar(100) not null,
energylevel varchar(100) not null,
description varchar (100) not null,
image varchar(250) not null,
primary key(id)
);

insert into dog (name,gro,personality,energylevel,description,image) values ('labrador','blanco','active','high','beauty','https://www.webconsultas.com/sites/default/files/styles/encabezado_articulo/public/temas/caracteristicas-perro-labrador.jpg?itok=ANTovkRk');
create table Comentario(
id serial not null,
autor varchar(100) not null,
fecha Date not null,
comentario varchar(100) not null,
id_dog int not null,
primary key(id),
foreign key(id_dog) references Dog (id)
);
select * from dog;

insert into dog (name,gro,personality,energylevel,description,image) values ('Golden Retriever','herding','smart','very active','beauty','https://t1.ea.ltmcdn.com/es/razas/5/5/0/img_55_golden-retriever-o-cobrador-dorado_0_orig.jpg');