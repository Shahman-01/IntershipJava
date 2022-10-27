DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER SEQUENCE global_seq2 RESTART WITH 200000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (dateTime, description, calories, user_id)
VALUES ('2020-01-30 10:00:0', 'Завтрак', 554, 100000),
       ('2020-01-30 14:00:0', 'Обед', 1200, 100000),
       ('2020-01-31 10:00:0', 'Завтрак', 670, 100000);
CREATE INDEX meals_id_index ON meals (id);