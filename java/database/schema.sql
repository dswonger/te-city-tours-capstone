BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS monuments;
CREATE TABLE monuments (
         Monument_id SERIAL,
         Name varchar(200) NOT NULL,
         Description varchar (2000) NOT NULL,
         Available_days varchar(50) NOT NULL,
     	Available_hours TIME NOT NUll,
         Year_built TIMESTAMP NOT NULL,
         Rate numeric NOT NULL,
         Review varchar (1000),
         CONSTRAINT PK_monuments PRIMARY KEY (Monument_id)
);


COMMIT TRANSACTION;
