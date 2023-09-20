create table if not exists products(
    id bigint not null auto_increment,
    name varchar(20) not null,
    price bigint not null
);

insert into products(name, price) values('pencil', 200);
insert into products(name, price) values('pen', 300);
insert into products(name, price) values('fountain pen', 10000);