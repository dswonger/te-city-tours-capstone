BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('National Gallery of Art', 'Art Museum', true);
INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('Smithsonian National Museum of Natural History', 'Science Museum', true);
INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('National Air and Space Museum', 'Science Museum', true);
INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('United States Holocaust Memorial Museum', 'History Museum', true);
INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('National Museum of African American History and Culture','History Museum', true);
INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('National Portrait Gallery', 'Art Museum', true);
INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('The National Archives Museum', 'History Museum', true);
INSERT INTO museums (museum_name, museum_type, clicked)
    VALUES ('International Spy Museum', 'History Museum', true);

COMMIT TRANSACTION;
