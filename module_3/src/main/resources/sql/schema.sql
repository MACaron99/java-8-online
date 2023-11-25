create schema bank default character set utf8;

use bank;

create table users
(
    id bigint auto_increment primary key,
    name varchar(45)
);

create table accounts
(
    id bigint auto_increment primary key,
    user_id bigint not null,
    amount bigint not null,
    block boolean not null default false,
    foreign key (user_id) references users(id)
);

create table operations
(
    id bigint auto_increment primary key,
    date_time varchar(45),
    from_account_id bigint not null,
    to_account_id bigint not null,
    amount bigint not null,
    foreign key (from_account_id) references accounts(id),
    foreign key (to_account_id) references accounts(id)
);

create table categories
(
    id bigint auto_increment primary key,
    name varchar(45)
);

create table histories
(
    id bigint auto_increment primary key,
    account_id bigint not null,
    category_id bigint not null,
    operation_id bigint not null,
    foreign key (account_id) references accounts(id),
    foreign key (category_id) references categories(id),
    foreign key (operation_id) references operations(id)
);