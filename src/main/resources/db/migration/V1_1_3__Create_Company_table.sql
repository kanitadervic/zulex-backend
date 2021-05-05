create table Company
(
    id       int auto_increment
        primary key,
    cityId int not null,
    name varchar(128) not null,
    address varchar(256) not null,
    phoneNumber varchar(128) not null,
    faxNumber varchar(128) not null,
    webUrl varchar(256) not null,
    mail varchar(256) not null,
    formOfOwnership varchar(128) not null,
    foundingDate varchar(128) not null,
    idb varchar(128) not null,
    vatNumber varchar(128) not null,
    predominantActivity varchar(256) not null,
    contactPerson varchar(128) not null,
    employeeId int not null,
    editedBy int
);
