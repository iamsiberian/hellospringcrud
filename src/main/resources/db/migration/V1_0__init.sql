CREATE TABLE items (
  id bigserial PRIMARY KEY,
  firstName varchar,
  lastName VARCHAR
  );

INSERT INTO items (firstName, lastName)
  VALUES ('Ivan', 'Ivanov');

INSERT INTO items (firstName, lastName)
  VALUES ('Petr', 'Petrov');

INSERT INTO items (firstName, lastName)
  VALUES ('Sidr', 'Sidorov');
