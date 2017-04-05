--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: action; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE action (
    id integer NOT NULL,
    action_type character varying(20) NOT NULL
);


ALTER TABLE action OWNER TO josh;

--
-- Name: action_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE action_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE action_id_seq OWNER TO josh;

--
-- Name: action_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE action_id_seq OWNED BY action.id;


--
-- Name: animal; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE animal (
    id integer NOT NULL,
    animal_name character varying(30) NOT NULL,
    age integer,
    description character varying(400) NOT NULL,
    receive_date date DEFAULT now(),
    release_date date,
    isvisible boolean DEFAULT true,
    gender_id integer
);


ALTER TABLE animal OWNER TO josh;

--
-- Name: animal_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animal_id_seq OWNER TO josh;

--
-- Name: animal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE animal_id_seq OWNED BY animal.id;


--
-- Name: animal_type; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE animal_type (
    animal_id integer NOT NULL,
    breed_id integer NOT NULL
);


ALTER TABLE animal_type OWNER TO josh;

--
-- Name: breed; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE breed (
    id integer NOT NULL,
    breed_type character varying(30),
    species_id integer
);


ALTER TABLE breed OWNER TO josh;

--
-- Name: breed_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE breed_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE breed_id_seq OWNER TO josh;

--
-- Name: breed_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE breed_id_seq OWNED BY breed.id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE employee (
    id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(25) NOT NULL,
    username character varying(10) NOT NULL,
    password character varying(10) NOT NULL,
    security_level_id integer NOT NULL,
    gender_id integer
);


ALTER TABLE employee OWNER TO josh;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employee_id_seq OWNER TO josh;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;


--
-- Name: employee_tracking; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE employee_tracking (
    employee_id integer NOT NULL,
    animal_id integer NOT NULL,
    action_id integer NOT NULL,
    datetime timestamp without time zone
);


ALTER TABLE employee_tracking OWNER TO josh;

--
-- Name: gender; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE gender (
    id integer NOT NULL,
    gender_type character varying(20) NOT NULL
);


ALTER TABLE gender OWNER TO josh;

--
-- Name: gender_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE gender_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE gender_id_seq OWNER TO josh;

--
-- Name: gender_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE gender_id_seq OWNED BY gender.id;


--
-- Name: notes; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE notes (
    id integer NOT NULL,
    animal_id integer,
    employee_id integer,
    note character varying(400) NOT NULL,
    datetime timestamp without time zone
);


ALTER TABLE notes OWNER TO josh;

--
-- Name: notes_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE notes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE notes_id_seq OWNER TO josh;

--
-- Name: notes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE notes_id_seq OWNED BY notes.id;


--
-- Name: security_level; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE security_level (
    id integer NOT NULL,
    security_type character varying(20) NOT NULL
);


ALTER TABLE security_level OWNER TO josh;

--
-- Name: security_level_config; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE security_level_config (
    security_level_id integer NOT NULL,
    action_id integer NOT NULL
);


ALTER TABLE security_level_config OWNER TO josh;

--
-- Name: security_level_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE security_level_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE security_level_id_seq OWNER TO josh;

--
-- Name: security_level_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE security_level_id_seq OWNED BY security_level.id;


--
-- Name: species; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE species (
    id integer NOT NULL,
    species_type character varying(30)
);


ALTER TABLE species OWNER TO josh;

--
-- Name: species_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE species_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE species_id_seq OWNER TO josh;

--
-- Name: species_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE species_id_seq OWNED BY species.id;


--
-- Name: action id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY action ALTER COLUMN id SET DEFAULT nextval('action_id_seq'::regclass);


--
-- Name: animal id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY animal ALTER COLUMN id SET DEFAULT nextval('animal_id_seq'::regclass);


--
-- Name: breed id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY breed ALTER COLUMN id SET DEFAULT nextval('breed_id_seq'::regclass);


--
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);


--
-- Name: gender id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY gender ALTER COLUMN id SET DEFAULT nextval('gender_id_seq'::regclass);


--
-- Name: notes id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY notes ALTER COLUMN id SET DEFAULT nextval('notes_id_seq'::regclass);


--
-- Name: security_level id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY security_level ALTER COLUMN id SET DEFAULT nextval('security_level_id_seq'::regclass);


--
-- Name: species id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY species ALTER COLUMN id SET DEFAULT nextval('species_id_seq'::regclass);


--
-- Data for Name: action; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY action (id, action_type) FROM stdin;
1	View Animal
2	Add Animal
3	Edit Animal
4	Delete Animal
\.


--
-- Name: action_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('action_id_seq', 4, true);


--
-- Data for Name: animal; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY animal (id, animal_name, age, description, receive_date, release_date, isvisible, gender_id) FROM stdin;
1	Pablo	3	Likes to eat and lay around	2017-04-03	\N	t	1
2	Bob	2	Likes to lay in the sun all day	2017-04-04	\N	t	2
3	Lilly	5	Likes to chase ball around the cage and go for walks	2017-04-04	\N	t	2
5	Larry	12	Likes to chase his tail	2017-04-04	\N	t	1
4	mika	8	Likes to meow	2017-04-04	\N	t	2
6	mo	2	walks	2017-04-04	\N	t	1
\.


--
-- Name: animal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('animal_id_seq', 6, true);


--
-- Data for Name: animal_type; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY animal_type (animal_id, breed_id) FROM stdin;
1	5
2	3
3	61
4	47
5	55
6	5
\.


--
-- Data for Name: breed; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY breed (id, breed_type, species_id) FROM stdin;
1	British Shorthair	1
3	Siamese	1
4	Persian	1
5	Maine Coon	1
6	Ragdoll	1
7	American Shorthair	1
8	Abyssinian	1
9	Burmese	1
10	Bengal	1
11	Sphynx	1
12	Exotic Shorthair	1
13	Birman	1
14	Scottish Fold	1
15	American Bobtail	1
16	Russian Blue	1
17	Siberian	1
18	American Curl	1
19	Ocicat	1
20	Turkish Angora	1
21	Egyptian Mau	1
22	Cornish Rex	1
23	Himalayan	1
24	Norwegian Forset	1
25	Tonkinese	1
26	Devon Rex	1
27	Chartreux	1
28	Bombay	1
29	Japanese Bobtail	1
30	Selkirk Rex	1
31	Manx	1
32	Korat	1
33	Balinese	1
34	Singapura	1
35	Turkish Van	1
36	Somali	1
37	LaPerm	1
38	American Wirehair	1
39	Savannah	1
40	Ragamuffin	1
41	Munchkin	1
42	Havana Brown	1
43	Toyger	1
44	Oriental Shorthair	1
45	Pixie-bob	1
46	Javanese	1
47	Nebelung	1
48	Peterbald	1
49	Cymric	1
50	Snowshoe	1
51	Colorpoint Shorthair	1
52	Chausie	1
53	Siberian Husky	2
54	Pug	2
55	Labrador Retriever	2
56	Beagle	2
57	German Shepard	2
58	Rottweiler	2
59	Bulldog	2
60	Poodle	2
61	Pit bull	2
62	Shih Tzu	2
63	Doberman Pinscher	2
64	Boxer	2
65	Chihuahua	2
66	Chow Chow	2
67	Yorkshire Terrier	2
68	Great Dane	2
69	Dachshund	2
70	Maltese	2
71	English Mastiff	2
72	Pomeranian	2
73	Akita	2
74	St. Bernard	2
75	Greyhound	2
76	Jack Russell Terrier	2
77	Pekingese	2
78	Havanese	2
79	Australian Shepherd	2
80	Alaskan Malamute	2
81	Cavalier King Charles Spaniel	2
82	English Cocker Spaniel	2
83	West Highland White Terrier	2
84	Golden Retriever	2
85	French Bulldog	2
86	Australian Cattle Dog	2
87	Pointer	2
88	Bichon Frise	2
89	Basset Hound	2
90	Shar Pei	2
91	Papillon	2
92	Shetland Sheepdog	2
93	American Pit Bull Terrier	2
94	Shiba Inu	2
95	Border Collie	2
96	Pembroke Welsh Corgi	2
97	Bull Terrier	2
98	Old English Sheepdog	2
99	Schnauzer	2
100	Chinese Crested Dog	2
101	Lhasa Apso	2
102	Irish Wolfhound	2
\.


--
-- Name: breed_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('breed_id_seq', 102, true);


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY employee (id, first_name, last_name, username, password, security_level_id, gender_id) FROM stdin;
1000	Admin	Admin	admin	admin	4	1
\.


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('employee_id_seq', 1000, true);


--
-- Data for Name: employee_tracking; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY employee_tracking (employee_id, animal_id, action_id, datetime) FROM stdin;
\.


--
-- Data for Name: gender; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY gender (id, gender_type) FROM stdin;
1	Male
2	Female
3	Other
\.


--
-- Name: gender_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('gender_id_seq', 3, true);


--
-- Data for Name: notes; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY notes (id, animal_id, employee_id, note, datetime) FROM stdin;
\.


--
-- Name: notes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('notes_id_seq', 1, false);


--
-- Data for Name: security_level; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY security_level (id, security_type) FROM stdin;
1	Guest
2	Standard
3	Manager
4	Administrator
\.


--
-- Data for Name: security_level_config; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY security_level_config (security_level_id, action_id) FROM stdin;
4	1
4	2
4	3
4	4
1	1
2	1
2	2
2	3
3	1
3	2
3	3
3	4
\.


--
-- Name: security_level_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('security_level_id_seq', 4, true);


--
-- Data for Name: species; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY species (id, species_type) FROM stdin;
1	Cat
2	Dog
3	Bird
4	Goat
5	Chicken
6	Llama
7	Fish
8	Snake
9	Lizard
10	Monkey
\.


--
-- Name: species_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('species_id_seq', 10, true);


--
-- Name: action action_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY action
    ADD CONSTRAINT action_pkey PRIMARY KEY (id);


--
-- Name: animal animal_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (id);


--
-- Name: animal_type animal_type_animal_id_breed_id_pk; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY animal_type
    ADD CONSTRAINT animal_type_animal_id_breed_id_pk PRIMARY KEY (animal_id, breed_id);


--
-- Name: breed breed_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY breed
    ADD CONSTRAINT breed_pkey PRIMARY KEY (id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: gender gender_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY gender
    ADD CONSTRAINT gender_pkey PRIMARY KEY (id);


--
-- Name: notes notes_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY notes
    ADD CONSTRAINT notes_pkey PRIMARY KEY (id);


--
-- Name: security_level_config security_level_config_security_level_id_action_id_pk; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY security_level_config
    ADD CONSTRAINT security_level_config_security_level_id_action_id_pk PRIMARY KEY (security_level_id, action_id);


--
-- Name: security_level security_level_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY security_level
    ADD CONSTRAINT security_level_pkey PRIMARY KEY (id);


--
-- Name: species species_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY species
    ADD CONSTRAINT species_pkey PRIMARY KEY (id);


--
-- Name: action_action_type_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX action_action_type_unique ON action USING btree (action_type);


--
-- Name: action_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX action_id_unique ON action USING btree (id);


--
-- Name: animal_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX animal_id_unique ON animal USING btree (id);


--
-- Name: breed_breed_type_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX breed_breed_type_unique ON breed USING btree (breed_type);


--
-- Name: breed_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX breed_id_unique ON breed USING btree (id);


--
-- Name: employee_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX employee_id_unique ON employee USING btree (id);


--
-- Name: gender_gender_type_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX gender_gender_type_unique ON gender USING btree (gender_type);


--
-- Name: gender_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX gender_id_unique ON gender USING btree (id);


--
-- Name: notes_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX notes_id_unique ON notes USING btree (id);


--
-- Name: security_level_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX security_level_id_unique ON security_level USING btree (id);


--
-- Name: security_level_security_type_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX security_level_security_type_unique ON security_level USING btree (security_type);


--
-- Name: species_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX species_id_unique ON species USING btree (id);


--
-- Name: species_species_type_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX species_species_type_unique ON species USING btree (species_type);


--
-- Name: animal animal_gender_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY animal
    ADD CONSTRAINT animal_gender_id_fk FOREIGN KEY (gender_id) REFERENCES gender(id);


--
-- Name: animal_type animal_type_animal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY animal_type
    ADD CONSTRAINT animal_type_animal_id_fkey FOREIGN KEY (animal_id) REFERENCES animal(id);


--
-- Name: animal_type animal_type_breed_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY animal_type
    ADD CONSTRAINT animal_type_breed_id_fkey FOREIGN KEY (breed_id) REFERENCES breed(id);


--
-- Name: breed breed_species_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY breed
    ADD CONSTRAINT breed_species_id_fkey FOREIGN KEY (species_id) REFERENCES species(id);


--
-- Name: employee employee_gender_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_gender_id_fk FOREIGN KEY (gender_id) REFERENCES gender(id);


--
-- Name: employee employee_security_level_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_security_level_id_fk FOREIGN KEY (security_level_id) REFERENCES security_level(id);


--
-- Name: employee_tracking employee_tracking_action_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY employee_tracking
    ADD CONSTRAINT employee_tracking_action_id_fkey FOREIGN KEY (action_id) REFERENCES action(id);


--
-- Name: employee_tracking employee_tracking_animal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY employee_tracking
    ADD CONSTRAINT employee_tracking_animal_id_fkey FOREIGN KEY (animal_id) REFERENCES animal(id);


--
-- Name: employee_tracking employee_tracking_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY employee_tracking
    ADD CONSTRAINT employee_tracking_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- Name: notes notes_animal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY notes
    ADD CONSTRAINT notes_animal_id_fkey FOREIGN KEY (animal_id) REFERENCES animal(id);


--
-- Name: notes notes_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY notes
    ADD CONSTRAINT notes_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- Name: security_level_config security_level_config_action_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY security_level_config
    ADD CONSTRAINT security_level_config_action_id_fkey FOREIGN KEY (action_id) REFERENCES action(id);


--
-- Name: security_level_config security_level_config_security_level_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY security_level_config
    ADD CONSTRAINT security_level_config_security_level_id_fkey FOREIGN KEY (security_level_id) REFERENCES security_level(id);


--
-- PostgreSQL database dump complete
--

