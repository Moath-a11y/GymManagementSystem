CREATE TABLE IF NOT EXISTS GYMS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(255),
    location VARCHAR(255)
);

INSERT INTO GYMS (name, location) VALUES ('Gold Gym', 'Ramallah');
INSERT INTO GYMS (name, location) VALUES ('Fitness World', 'Nablus');