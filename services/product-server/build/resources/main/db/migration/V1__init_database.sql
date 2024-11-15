SELECT current_timestamp as date_heure_now;

create table if not exists category
(
    id integer not null primary key,
    description varchar(255) not null,
    name varchar(255)
);

create table if not exists product
(
    id integer not null primary key,
    name varchar(255) not null,
    description varchar(255),
    available_quantity double precision not null,
    price numeric(38, 2),
    category_id integer constraint fk_category references category
);

create sequence if not exists category_seq increment by 1;
create sequence if not exists product_seq increment by 1;

select '# All Migrations has been run.';