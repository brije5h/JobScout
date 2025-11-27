CREATE TYPE user_role AS ENUM ('USER', 'ADMIN');

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    role user_role,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    preferred_location VARCHAR(255),
    skills VARCHAR(500),
    resume_link VARCHAR(500)
);
CREATE INDEX idx_user_email ON users(email);
