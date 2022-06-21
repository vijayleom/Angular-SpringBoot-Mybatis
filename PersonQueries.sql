create database details;

use details;

drop table IF EXISTS PERSON;

create table PERSON(IdPerson INT UNSIGNED NOT NULL AUTO_INCREMENT,PRIMARY KEY (IdPerson), FirstName varchar(255), LastName varchar(255));

drop table IF EXISTS PERSON_ADDRESS;

create table PERSON_ADDRESS(IdAddress INT UNSIGNED NOT NULL AUTO_INCREMENT,PRIMARY KEY (IdAddress), IdPerson INT, constraint idPersonAddressFk FOREIGN KEY (IdAddress) references PERSON(IdPerson) ON DELETE CASCADE, Address varchar(255));

drop table IF EXISTS PERSON_CONTACT;

create table PERSON_CONTACT(IdContact INT UNSIGNED NOT NULL AUTO_INCREMENT,PRIMARY KEY (IdContact),IdPerson INT, constraint idPersonPhoneFk FOREIGN KEY (IdContact) references PERSON(IdPerson) ON DELETE CASCADE, Phone varchar(255));