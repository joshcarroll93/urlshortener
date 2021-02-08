Create database URLDB;
use URLDB;

CREATE TABLE urlmap (
id int NOT NULL AUTO_INCREMENT,
originalurl varchar(2083) ,
shorturl varchar(2083),
PRIMARY KEY (id)
);

