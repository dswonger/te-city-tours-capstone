BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS attractions;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE attractions (
    id SERIAL,
    name varchar(100) NOT NULL,
    address varchar ( 100000) NOT NULL,
    description varchar (100000) NOT NULL,
    image varchar (100000) NOT NULL,
    rate int,
    type varchar (100000) NOT NULL
);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('National Gallery of Art ', 'Constitution Ave. NW, Washington, DC 20565 ',
'The National Gallery of Art, and its attached Sculpture Garden, is a national art museum in Washington, D.C., United States, located on the National Mall, between 3rd and 9th Streets, at Constitution Avenue NW.',
'src/main/resources/images/museums/National-Gallery-of-Art.jpg ', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Smithsonian National Museum of Natural History', '10th St. & Constitution Ave. NW, Washington, DC 20560', 'The National Museum of Natural History is a natural history museum administered by the Smithsonian Institution, located on the National Mall in Washington, D.C., United States. It has free admission and is open 364 days a year. In 2022, with 3.9 million visitors, it was the most-visited museum in the United States.',
 'src/main/resources/images/museums/Smithsonian-Natural-History.jpg', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('National Air and Space Museum', '600 Independence Ave SW, Washington, DC 20560', 'The National Air and Space Museum of the Smithsonian Institution, is a museum in Washington, D.C., in the United States dedicated to human flight and space exploration. Established in 1946 as the National Air Museum, its main building opened on the National Mall near L''Enfant Plaza in 1976.',
 'src/main/resources/images/museums/National-Air-And-Space.jpg', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('United States Holocaust Memorial Museum', '100 Raoul Wallenberg Pl SW, Washington, DC 20024', 'The United States Holocaust Memorial Museum is the United States'' official memorial to the Holocaust. Adjacent to the National Mall in Washington, D.C., the USHMM provides for the documentation, study, and interpretation of Holocaust history.',
 'src/main/resources/images/museums/Holocaust-Museum.jpg', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('National Museum of African American History and Culture', '1400 Constitution Ave. NW, Washington, DC 20560', 'The National Museum of African American History and Culture, colloquially known as the Blacksonian, is a Smithsonian Institution museum located on the National Mall in Washington, D.C., in the United States. It was established in 2003 and opened its permanent home in 2016 with a ceremony led by President Barack Obama.',
 'src/main/resources/images/museums/National_Museum_of_African_American_History_and_Culture.jpg', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('National Portrait Gallery', '8th St NW & G St NW, Washington, DC 20001', 'The National Portrait Gallery is a historic art museum between 7th, 9th, F, and G Streets NW in Washington, D.C., in the United States. Founded in 1962 and opened to the public in 1968, it is part of the Smithsonian Institution. Its collections focus on images of famous Americans.',
'src/main/resources/images/museums/national-portrait-gallery.jpg', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('The National Archives Museum', '701 Constitution Ave. NW, Washington, DC 20408', 'The museum wing of the National Archives, the National Archives Museum is the home of the Declaration of Independence, Constitution, and Bill of Rights.',
 'src/main/resources/images/museums/National-Archives.jpg', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('International Spy Museum', ' 700 L''Enfant Plaza SW, Washington, DC 20024', 'The International Spy Museum is an independent non-profit history museum which documents the tradecraft, history, and contemporary role of espionage. It holds the largest collection of international espionage artifacts on public display.',
 'src/main/resources/images/museums/International-Spy-Museum.jpg', 'Museum', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Amerigo Vespucci Memorial', '1756-1700 C St NW, Washington, DC 20006', 'Statue of Amerigo Vespucci - an Italian explorer from whose name the term America is derived',
 'src/main/resources/images/monuments/Amerigo-Vespucci.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Jefferson Memorial', '16 E Basin Dr SW, Washington, DC 20242', 'The Jefferson Memorial is a presidential memorial built in Washington, D.C., between 1939 and 1943 in honor of Thomas Jefferson, the principal author of the United States Declaration of Independence.',
 'src/main/resources/images/monuments/Jefferson-Memorial.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Korean War Memorial', '900 Ohio Dr SW, Washington, DC 20024', 'The Korean War Veterans Memorial is located in Washington, D.C.''s West Potomac Park, southeast of the Lincoln Memorial and just south of the Reflecting Pool on the National Mall. It memorializes those who served in the Korean War. The national memorial was dedicated in 1995',
 'src/main/resources/images/monuments/Korean-War-Memorial.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Lincoln Memorial', ' 2 Lincoln Memorial Circle, NW, Washington, D.C.', ' The Lincoln Memorial is a U.S. national memorial that honors the 16th president of the United States, Abraham Lincoln. Built in the form of a neoclassical temple, it is at the western end of the National Mall in Washington, D.C.',
 'src/main/resources/images/monuments/Lincoln-Memorial.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Martin Luther King Jr. Memorial', '1964 Independence Ave SW, Washington, DC 20004', 'The Martin Luther King, Jr. Memorial is a national memorial located in West Potomac Park next to the National Mall in Washington, D.C., United States. It covers four acres and includes the Stone of Hope, a granite statue of Civil Rights Movement leader Martin Luther King Jr. carved by sculptor Lei Yixin. ',
 'src/main/resources/images/monuments/martin-luther-king-jr-memorial.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Titanic Memorial', '41 1st Ave, Southwest Washington, DC 20319', 'Memorial for those who risked their lives to save those on the Titanic.',
 'src/main/resources/images/monuments/Titanic-Memorial.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Tomb of the Unknown Soldier', '1 Wilson Ave, Fort Myer, VA 22211', 'Prominent marble monument in Arlington National Cemetery marking an unknown WWI solider''s grave.',
 'src/main/resources/images/monuments/Tomb-Of-The-Unknown-Soldier.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Vietnam Veterans Memorial', '5 Henry Bacon Dr NW, Washington, DC 20002', 'Monument to Vietnam War service, featuring a wall with over 58,000 names of dead & missing soldiers.',
 'src/main/resources/images/monuments/Vietnam-War-Memorial.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('Washington Monument', '2 15th St NW, Washington, DC 20024', ' Landmark obelisk rising from the National Mall that honors America''s first president.',
 'src/main/resources/images/monuments/Washington-Monument.jpg', 'Monument', 0);

INSERT INTO attractions (name, address, description, image, type, rate)
VALUES ('World War II Memorial', '1750 Independence Ave SW, Washington, DC 20024', 'Iconic outdoor memorial honoring the 16 million Americans who served during World War II.',
 'src/main/resources/images/monuments/World-War-II-Memorial.jpg', 'Monument', 0);


CREATE TABLE itinerary (
    itinerary_id SERIAL,
    Landmark_name varchar (200) NOT NULL,
    Starting_point varchar(200) NOT NULL,
    Date_of_itinerary TIMESTAMP NOT NULL,
    CONSTRAINT PK_itinerary PRIMARY KEY (itinerary_id)

);

COMMIT TRANSACTION;
