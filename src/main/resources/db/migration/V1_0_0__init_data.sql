CREATE TABLE IF NOT EXISTS record (
    id SERIAL PRIMARY KEY,
    data VARCHAR(32),
    created timestamp
);

INSERT INTO record (data,created)
VALUES ('Some Data',current_timestamp);

INSERT INTO record (data,created)
VALUES ('Other Data',current_timestamp);

INSERT INTO record (data,created)
VALUES ('More Data',current_timestamp);

INSERT INTO record (data,created)
VALUES ('Some Data?',current_timestamp);

INSERT INTO record (data,created)
VALUES ('What is Data?',current_timestamp);

INSERT INTO record (data,created)
VALUES ('Data',current_timestamp);

INSERT INTO record (data,created)
VALUES ('Some Data Again',current_timestamp);

INSERT INTO record (data,created)
VALUES ('Must Have Data',current_timestamp);

INSERT INTO record (data,created)
VALUES ('Example',current_timestamp);

INSERT INTO record (data,created)
VALUES ('What is this?',current_timestamp);

INSERT INTO record (data,created)
VALUES ('Here is data',current_timestamp);

INSERT INTO record (data,created)
VALUES ('???',current_timestamp);