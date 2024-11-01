CREATE TABLE messages (
    id SERIAL PRIMARY KEY,
    timestamp TIMESTAMP NOT NULL,
    message VARCHAR(255) NOT NULL
);

