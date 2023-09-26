BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO museums (museum_name, museum_description, museum_type, clicked)
    VALUES ('National Gallery of Art', 'The National Gallery of Art, founded as a gift to the nation, serves as a center of visual art, education, and culture. Our collection of more than 150,000 paintings, sculpture, decorative arts, photographs, prints, and drawings spans the history of Western art and showcases some of the triumphs of human creativity. Across 363 days a year, the National Gallery offers a full spectrum of special exhibitions and public programs free of charge.',
    'Art Museum', true);
INSERT INTO museums (museum_name, museum description, museum_type, clicked)
    VALUES ('Smithsonian National Museum of Natural History', "The National Museum of Natural History is a natural history museum administered by the Smithsonian Institution, located on the National Mall in Washington, D.C., United States. It has free admission and is open 364 days a year. In 2022, with 3.9 million visitors, it was the most-visited museum in the United States.", 'Science Museum', true);
INSERT INTO museums (museum_name, museum_description, museum_type, clicked)
    VALUES ('National Air and Space Museum', "The National Air and Space Museum maintains the world's largest collection of historic aircraft and spacecraft. It is also a vital center for historical research on aviation and spaceflight and related science and technology, and home to the Center for Earth and Planetary Studies, which performs original research.", 'Science Museum', true);
INSERT INTO museums (museum_name, museum_description, museum_type, clicked)
    VALUES ('United States Holocaust Memorial Museum', "The United States Holocaust Memorial Museum is the United States' official memorial to the Holocaust. Adjacent to the National Mall in Washington, D.C., the USHMM provides for the documentation, study, and interpretation of Holocaust history. ", 'History Museum', true);
INSERT INTO museums (museum_name, museum_description, museum_type, clicked)
    VALUES ('National Museum of African American History and Culture',"The National Museum of African American History and Culture, colloquially known as the Blacksonian, is a Smithsonian Institution museum located on the National Mall in Washington, D.C., in the United States. It was established in 2003 and opened its permanent home in 2016 with a ceremony led by President Barack Obama.",'History Museum', true);
INSERT INTO museums (museum_name, museum_description, museum_type, clicked)
    VALUES ('National Portrait Gallery', "The National Portrait Gallery is a historic art museum between 7th, 9th, F, and G Streets NW in Washington, D.C., in the United States. Founded in 1962 and opened to the public in 1968, it is part of the Smithsonian Institution. Its collections focus on images of famous Americans.", 'Art Museum', true);
INSERT INTO museums (museum_name, museum_description, museum_type, clicked)
    VALUES ('The National Archives Museum', "Repository where the most important historical documents of the United States are held, such as the original Declaration of Independence, Bill of Rights, Constitution and the 1297 version of the Magna Carta.", 'History Museum', true);
INSERT INTO museums (museum_name, museum_description, museum_type, clicked)
    VALUES ('International Spy Museum', "The International Spy Museum is an independent non-profit history museum which documents the tradecraft, history, and contemporary role of espionage. It holds the largest collection of international espionage artifacts on public display.",'History Museum', true);

COMMIT TRANSACTION;
