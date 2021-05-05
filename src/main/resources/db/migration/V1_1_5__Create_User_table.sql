create table User
(
    id       int auto_increment
        primary key,
    name varchar(128) null,
    lastName varchar(128) null,
    phone varchar(128) null,
    email    varchar(256) not null,
    username varchar(256) not null,
    password varchar(256) not null,
    role     varchar(64) not null,
    constraint User_email_uindex
        unique (email),
    constraint User_username_uindex
        unique (username)
);
