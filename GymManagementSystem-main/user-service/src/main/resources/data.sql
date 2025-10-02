

CREATE TABLE IF NOT EXISTS USERS (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO USERS (id, name, email) VALUES (1, 'Moath', 'moath@example.com');
INSERT INTO USERS (id, name, email) VALUES (2, 'Mazen', 'mazen@example.com');
