BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS museums;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE museums (
    museum_id SERIAL,
    museum_name varchar(100) NOT NULL,
    museum_description varchar (100) NOT NULL,
    museum_type varchar (100) NOT NULL,
    museum_price numeric(3,2) NOT NULL,
    clicked boolean NOT NULL
);


DROP TABLE IF EXISTS monuments;
CREATE TABLE monuments (
    Monument_id SERIAL,
    Name varchar(200) NOT NULL,
    Description varchar (2000) NOT NULL,
    Year_built TIMESTAMP NOT NULL,
    CONSTRAINT PK_monuments PRIMARY KEY (Monument_id)
);




COMMIT TRANSACTION;
