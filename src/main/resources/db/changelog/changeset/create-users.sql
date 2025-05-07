CREATE TABLE IF NOT EXISTS users
(
    id            BIGSERIAL PRIMARY KEY,
    username      VARCHAR(50) UNIQUE NOT NULL,
    registered_at TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    birth_date    DATE               NOT NULL
);