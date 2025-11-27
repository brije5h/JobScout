CREATE TYPE job_status AS ENUM ('ACTIVE', 'EXPIRED', 'CLOSED');

CREATE TABLE jobs (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    company_name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    employment_type VARCHAR(50),
    experience_level VARCHAR(50),
    salary_range VARCHAR(100),
    job_description TEXT,
    requirements TEXT,
    apply_link VARCHAR(1000),
    source VARCHAR(50),
    date_posted DATE,
    status job_status,
    ai_score DOUBLE PRECISION,
    remote_option BOOLEAN,
    company_id BIGINT,
    CONSTRAINT fk_job_company FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE SET NULL
);
CREATE INDEX idx_job_title ON jobs(title);
CREATE INDEX idx_job_company ON jobs(company_id);
