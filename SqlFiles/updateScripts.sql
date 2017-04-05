UPDATE animal SET
  isvisible= NOT (SELECT issvisible FROM animal WHERE animal_name='Pablo');