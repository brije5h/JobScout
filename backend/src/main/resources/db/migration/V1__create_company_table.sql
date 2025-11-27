CREATE TABLE company (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    industry VARCHAR(100),
    location VARCHAR(255),
    website VARCHAR(500),
    description TEXT,
    employee_count INTEGER,
    rating DOUBLE PRECISION
);
CREATE INDEX idx_company_name ON company(name);
