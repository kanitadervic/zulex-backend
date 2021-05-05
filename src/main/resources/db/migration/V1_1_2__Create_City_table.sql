create table City
(
    id       int auto_increment
        primary key,
    name varchar(128) not null,
    cantonId int not null
);
