SELECT * FROM animal
  JOIN animal_type AS at ON animal.id = at.animal_id
  JOIN breed as b ON at.breed_id = b.id
  JOIN species as s ON b.species_id = s.id