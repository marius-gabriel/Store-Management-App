create table if not exists public.products(
    id SERIAL not null primary key,
    name varchar(20) not null unique,
    price INT not null
);

insert into public.products(name, price) values('pencil', 200);
insert into public.products(name, price) values('pen', 300);
insert into public.products(name, price) values('fountain pen', 10000);