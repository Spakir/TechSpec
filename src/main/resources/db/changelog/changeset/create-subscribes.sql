CREATE TABLE IF NOT EXISTS subscribes
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT      NOT NULL,
    service_type VARCHAR(50) NOT NULL,
    start_date   DATE        NOT NULL,
    end_date     DATE        NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);