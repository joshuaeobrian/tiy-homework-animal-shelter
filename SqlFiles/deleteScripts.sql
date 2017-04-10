DELETE FROM animal WHERE id = 1;

-- deletes all animals that are a specific species
DELETE FROM animal where id IN (
  SELECT animal.id from animal
  JOIN animal_type on animal.id = animal_type.animal_id
  JOIN breed ON animal_type.breed_id = breed.id
  JOIN species ON breed.species_id = species.id
  WHERE lower(species.species_type) = 'cat'
);
