SELECT * FROM animal
  JOIN animal_type AS at ON animal.id = at.animal_id
  JOIN breed as b ON at.breed_id = b.id
  JOIN species as s ON b.species_id = s.id

SELECT a.animal_name, b.breed_type, s.species_type, a.age, g.gender_type, a.description, a.receive_date
FROM animal as a
  JOIN gender as g ON a.gender_id = g.id
  JOIN animal_type as at ON a.id = at.animal_id
  JOIN breed as b ON at.breed_id = b.id
  JOIN species as s on b.species_id = s.id where a.animal_name='Pablo';


SELECT * FROM animal
  JOIN animal_type on animal.id = animal_type.animal_id
  JOIN breed ON animal_type.breed_id = breed.id
  JOIN species ON breed.species_id = species.id
  WHERE lower(species.species_type) = 'cat';


SELECT * from animal;



