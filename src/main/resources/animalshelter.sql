-- create species
CREATE TABLE species(
    id SERIAL PRIMARY KEY NOT NULL,
    species_type VARCHAR(30)
);
CREATE UNIQUE INDEX species_id_unique ON species(id);
CREATE UNIQUE INDEX species_species_type_unique ON species(species_type);

--cat
INSERT INTO species(species_type)VALUES (
    'Cat'
);
INSERT INTO species(species_type)VALUES (
    'Dog'
);
--create breed
CREATE TABLE breed(
    id SERIAL PRIMARY KEY NOT NULL,
    breed_type VARCHAR(30),
    species_id INTEGER REFERENCES species(id)
);
CREATE UNIQUE INDEX breed_id_unique ON breed(id);
CREATE UNIQUE INDEX breed_breed_type_unique ON breed(breed_type);


INSERT INTO breed(breed_type, species_id)VALUES (
    'Maine coon',
    (Select id from species where species_type='Cat')
);
--creates animal
CREATE TABLE animal(
    id SERIAL PRIMARY KEY NOT NULL ,
    animal_name VARCHAR(30) NOT NULL ,
    age INTEGER NULL,
    description VARCHAR(400) NOT NULL ,
    receive_date DATE DEFAULT now(),
    release_date DATE null,
    isVisible BOOLEAN default true,
    gender_id INTEGER
);

CREATE UNIQUE INDEX animal_id_unique ON animal(id);

CREATE TABLE animal_type (
    animal_id INTEGER NOT NULL REFERENCES animal(id),
    breed_id INTEGER NOT NULL REFERENCES breed(id)

);


--Gender
CREATE TABLE gender(
    id SERIAL PRIMARY KEY,
    gender_type VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX gender_id_unique on gender(id);
CREATE UNIQUE INDEX  gender_gender_type_unique on gender(gender_type);

INSERT INTO gender(gender_type) VALUES(
    'Male'
);
INSERT INTO gender(gender_type) VALUES(
    'Female'
);
INSERT INTO gender(gender_type) VALUES(
    'Other'
);



--pre define some animals
INSERT INTO animal(animal_name, age, description, receive_date, gender_id) VALUES (
    'Pablo',
    3,
    'Likes to drink milk',
    '2017-03-01',
    (SELECT id from gender where gender_type='Male')
);
INSERT INTO animal_type(animal_id, breed_id)VALUES (
    (SELECT id FROM animal where animal_name='Pablo'),
    (select id from breed where breed_type='Maine coon')
);

INSERT INTO animal(animal_name, age, description, receive_date, gender_id) VALUES (
    'Leo',
    4,
    'Likes to lay around like a clown',
    '2017-03-10',
    (SELECT id from gender where gender_type='Male')
);
INSERT INTO animal_type(animal_id, breed_id)VALUES (
    (SELECT id FROM animal where animal_name='Leo'),
    (select id from breed where breed_type='Maine coon')
);
