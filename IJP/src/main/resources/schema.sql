-- Drop existing tables if they exist
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS job_posting CASCADE;
DROP TABLE IF EXISTS application CASCADE;
DROP TABLE IF EXISTS location CASCADE;
DROP TABLE IF EXISTS coding_language CASCADE;
DROP TABLE IF EXISTS location_junction CASCADE;

-- Create Employee table
CREATE TABLE employee (
    employee_id BIGINT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    dob DATE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    reports_to BIGINT,
    FOREIGN KEY (reports_to) REFERENCES employee(employee_id)
);

-- Create Location table
CREATE TABLE location (
    location_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Create Job Posting table
CREATE TABLE job_posting (
     job_pos_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     description TEXT,
     min_exp INT,
     min_sal INT,
     max_sal INT,
     is_active BOOLEAN,
     designation VARCHAR(255),
     created_by BIGINT,
     location_id BIGINT,
     skill_id BIGINT,
     language_id BIGINT,
     deadline DATE,
     FOREIGN KEY (created_by) REFERENCES employee(employee_id),
     FOREIGN KEY (location_id) REFERENCES location(location_id)
);

-- Create Coding Language table
CREATE TABLE coding_language (
     language_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     job_pos_id BIGINT,
     lang_name VARCHAR(255),
     skill_level VARCHAR(255),
     FOREIGN KEY (job_pos_id) REFERENCES job_posting(job_pos_id)
);

-- Create Application table
CREATE TABLE application (
     app_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     employee_id BIGINT,
     job_pos_id BIGINT,
     status VARCHAR(255),
     verified_by_manager BOOLEAN,
     FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
     FOREIGN KEY (job_pos_id) REFERENCES job_posting(job_pos_id)
);

-- Create Location Junction table
CREATE TABLE location_junction (
       location_id BIGINT,
       job_pos_id BIGINT,
       PRIMARY KEY (location_id, job_pos_id),
       FOREIGN KEY (location_id) REFERENCES location(location_id),
       FOREIGN KEY (job_pos_id) REFERENCES job_posting(job_pos_id)
);