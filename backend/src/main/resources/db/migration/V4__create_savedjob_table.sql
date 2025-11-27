CREATE TYPE saved_job_status AS ENUM ('SAVED', 'APPLIED', 'SHORTLISTED', 'REJECTED');

CREATE TABLE saved_jobs (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    job_id BIGINT NOT NULL,
    status saved_job_status,
    notes TEXT,
    saved_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_savedjob_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_savedjob_job FOREIGN KEY (job_id) REFERENCES jobs(id) ON DELETE CASCADE,
    UNIQUE(user_id, job_id) -- prevent duplicate saved jobs
);
CREATE INDEX idx_savedjob_user ON saved_jobs(user_id);
CREATE INDEX idx_savedjob_job ON saved_jobs(job_id);
