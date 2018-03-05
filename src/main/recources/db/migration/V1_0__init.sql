CREATE TABLE items (
  id bigserial PRIMARY KEY,
  firstName varchar,
  lastName VARCHAR
  );

INSERT INTO item (firstName, lastName)
  VALUES ('Ivan', 'Ivanov');

INSERT INTO item (firstName, lastName)
  VALUES ('Petr', 'Petrov');

INSERT INTO item (firstName, lastName)
  VALUES ('Sidr', 'Sidorov');
