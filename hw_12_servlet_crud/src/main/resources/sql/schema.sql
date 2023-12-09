create schema autos default character set utf8;

use autos;

create table cars
(
    id bigint auto_increment primary key,
    brand varchar(45),
    model varchar(45),
    age int
);

create table parks
(
    id bigint auto_increment primary key,
    name varchar(45)
);

create table car_parks
(
    park_id bigint not null,
    car_id bigint not null,
    primary key (park_id, car_id),
    foreign key (park_id) references parks(id),
    foreign key (car_id) references cars(id)
);
