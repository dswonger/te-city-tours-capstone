BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS attractions;
DROP TABLE IF EXISTS hour_day;
DROP TABLE IF EXISTS itinerary;
DROP TABLE IF EXISTS itinerary_attraction;
DROP TABLE IF EXISTS review;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE attractions (
    id SERIAL,
    name varchar(100) NOT NULL,
    address varchar ( 100000) NOT NULL,
    description varchar (100000) NOT NULL,
    image varchar (100000),
    rate int,
    type varchar (100000) NOT NULL,
	 CONSTRAINT PK_attractions PRIMARY KEY (id)
);




CREATE TABLE hour_day(
    attraction_id int NOT NULL,
    mon_open varchar (100) NOT NUll,
    mon_close varchar (100) NOT NUll,
    tues_open varchar (100) NOT NUll,
    tues_close varchar (100) NOT NUll,
    wed_open varchar (100) NOT NUll,
    wed_close varchar (100) NOT NUll,
    thurs_open varchar (100) NOT NUll,
    thurs_close varchar (100) NOT NUll,
    fri_open varchar (100) NOT NUll,
    fri_close varchar (100) NOT NUll,
    sat_open varchar (100) NOT NUll,
    sat_close varchar (100) NOT NUll,
    sun_open varchar (100) NOT NUll,
    sun_close varchar (100) NOT NUll,
    CONSTRAINT FK_hour_day_attractions_id  FOREIGN KEY ( attraction_id) REFERENCES attractions(id)
);

CREATE SEQUENCE seq_itinerary_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;
CREATE TABLE itinerary (
    itinerary_id SERIAL,
    Starting_point int,
    Date_of_itinerary date NOT NULL,
    user_id int NOT NULL,
    itinerary_name varchar (10000) NOT NULL,
    CONSTRAINT PK_itinerary PRIMARY KEY (itinerary_id),
    CONSTRAINT FK_itinerary_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)

);

CREATE TABLE itinerary_attraction(
    itinerary_id int NOT NULL,
    attraction_id int NOT NULL,
    CONSTRAINT FK_itinerary_attraction_attraction_id  FOREIGN KEY (attraction_id) REFERENCES attractions(id),
    CONSTRAINT FK_itinerary_attraction_itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itinerary(itinerary_id)
);

CREATE TABLE review(
    review_id SERIAL,
    attraction_id int NOT NULL,
    review_note varchar(1000) NOT NULL,
    CONSTRAINT FK_review_attractions_id  FOREIGN KEY ( attraction_id) REFERENCES attractions(id)

);


INSERT INTO hour_day (attraction_id, mon_open, tues_open, wed_open, thurs_open, fri_open, sat_open, sun_open, mon_close, tues_close, wed_close, thurs_close, fri_close, sat_close, sun_close )
VALUES
(1,
'10:00 AM','10:00 AM','10:00 AM','10:00 AM','10:00 AM','10:00 AM','10:00 AM',
'5:00 PM', '5:00 PM','5:00 PM','5:00 PM','5:00 PM','5:00 PM','5:00 PM' ),

(2,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(3,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(4,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(5,
'12:00 PM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM'),

(6,
'11:30 AM','11:30 AM',	'11:30 AM',	'11:30 AM',	'11:30 AM',	'11:30 AM',	'11:30 AM',
'7:00 PM',	'7:00 PM', '7:00 PM',	'7:00 PM',	'7:00 PM',	'7:00 PM',	'7:00 PM' ),


(7,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',
'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM',	'5:30 PM' ),


(8,
'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'10:00 AM',	'9:00 AM',	'9:00 AM',
'6:00 PM',	'6:00 PM',	'6:00 PM',	'6:00 PM',	'6:00 PM',	'7:00 PM',	'6:00 PM'),


(9,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(10,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),

(11,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(12,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(13,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(14,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(15,
'8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM', '8:00 AM',
'5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM'),


(16,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS'),


(17,
'9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM', '9:00 AM',
'5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM', '5:00 PM'),


(18,
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS',
'OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS','OPEN 24 HOURS');

COMMIT TRANSACTION;
