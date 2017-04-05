CREATE TABLE species(
  id SERIAL PRIMARY KEY NOT NULL,
  species VARCHAR(30)
);
CREATE UNIQUE INDEX species_id_unique ON species(id);
CREATE UNIQUE INDEX species_species_type_unique ON species(species_type);

CREATE TABLE breed(
  id SERIAL PRIMARY KEY NOT NULL,
  breed_type VARCHAR(30),
  species_id INTEGER REFERENCES species(id)
);
CREATE UNIQUE INDEX breed_id_unique ON breed(id);
CREATE UNIQUE INDEX breed_breed_type_unique ON breed(breed_type);
CREATE UNIQUE INDEX  breed_breed_species_unique ON breed(species_id);

CREATE TABLE animal_type (
  animal_id INTEGER NOT NULL REFERENCES animal(id),
  breed_id INTEGER NOT NULL REFERENCES breed(id)

);

CREATE TABLE animal(
  id SERIAL PRIMARY KEY NOT NULL ,
  animal_name VARCHAR(30) NOT NULL ,
  age INTEGER NULL,
  description VARCHAR(400) NOT NULL ,
  receive_date DATE DEFAULT now(),
  release_date DATE null,
  isVisible BOOLEAN default true
);
CREATE UNIQUE INDEX animal_id_unique ON animal(id);

CREATE TABLE employee(
  id SERIAL PRIMARY KEY NOT NULL ,
  first_name VARCHAR(20) NOT NULL ,
  last_name VARCHAR(25)NOT NULL ,
  username VARCHAR(10)NOT NULL ,
  password VARCHAR(10)NOT NULL
);
CREATE UNIQUE INDEX employee_id_unique ON employee(id);

CREATE TABLE notes(
  id SERIAL PRIMARY KEY,
  animal_id INTEGER REFERENCES animal(id),
  employee_id INTEGER REFERENCES employee(id),
  note VARCHAR(400) NOT NULL,
  datetime TIMESTAMP WITHOUT TIME ZONE
);

CREATE UNIQUE INDEX notes_id_unique ON notes(id);

CREATE TABLE action (
  id SERIAL PRIMARY KEY NOT NULL,
  action_type VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX  action_id_unique on action(id);
CREATE UNIQUE INDEX  action_action_type_unique on action(action_type);

CREATE TABLE employee_tracking(
  employee_id INTEGER REFERENCES employee(id) NOT NULL ,
  animal_id INTEGER REFERENCES animal(id) NOT NULL,
  action_id INTEGER REFERENCES action(id) NOT NULL,
  datetime TIMESTAMP WITHOUT TIME ZONE
);


INSERT INTO action(action_type) VALUES ('View Animal');
INSERT INTO action(action_type) VALUES ('Add Animal');
INSERT INTO action(action_type) VALUES ('Edit Animal');
INSERT INTO action(action_type) VALUES ('Delete Animal');


CREATE TABLE security_level(
  id SERIAL PRIMARY KEY NOT NULL,
  security_type VARCHAR(20) NOT NULL

);

CREATE UNIQUE INDEX security_level_id_unique on security_level(id);
CREATE UNIQUE INDEX security_level_security_type_unique on security_level(security_type);


CREATE TABLE security_level_config(
  security_level_id INTEGER REFERENCES security_level(id) NOT NULL,
  action_id INTEGER REFERENCES action(id) NOT NULL
);


CREATE TABLE gender(
  id SERIAL PRIMARY KEY,
  gender_type VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX gender_id_unique on gender(id);
CREATE UNIQUE INDEX  gender_gender_type_unique on gender(gender_type);



INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Siberian Husky'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Pug'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Labrador Retriever'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Beagle'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'German Shepard'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Rottweiler'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Bulldog'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Poodle'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Pit bull'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Shih Tzu'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Doberman Pinscher'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Boxer'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Chihuahua'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Chow Chow'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Yorkshire Terrier'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Great Dane'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Dachshund'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Maltese'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'English Mastiff'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Pomeranian'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Akita'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'St. Bernard'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Greyhound'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Jack Russell Terrier'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Pekingese'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Havanese'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Australian Shepherd'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Alaskan Malamute'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Cavalier King Charles Spaniel'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'English Cocker Spaniel'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'West Highland White Terrier'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Golden Retriever'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'French Bulldog'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Australian Cattle Dog'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Pointer'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Bichon Frise'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Basset Hound'
);


INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Shar Pei'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Papillon'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Shetland Sheepdog'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'American Pit Bull Terrier'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Shiba Inu'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Border Collie'
);

INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Pembroke Welsh Corgi'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Bull Terrier'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Old English Sheepdog'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Schnauzer'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Chinese Crested Dog'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Lhasa Apso'
);
INSERT INTO breed(species_id,breed_type) VALUES (
  (select id from species where species_type='Dog'),
  'Irish Wolfhound'
);

ALTER SEQUENCE employee_id_seq RESTART 1000;