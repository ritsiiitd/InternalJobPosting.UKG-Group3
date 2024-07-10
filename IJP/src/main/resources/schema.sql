CREATE TABLE IF NOT EXISTS Employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    dob DATE,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(255),
    role ENUM('EMPLOYEE', 'HR', 'MANAGER')
    );

CREATE TABLE IF NOT EXISTS Hr (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  employee_id BIGINT,
                                  FOREIGN KEY (employee_id) REFERENCES Employee(id)
    );

CREATE TABLE IF NOT EXISTS JobPosting (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          title VARCHAR(255),
    description TEXT,
    min_experience INT,
    min_salary DOUBLE,
    max_salary DOUBLE,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    location_id BIGINT,
    FOREIGN KEY (created_by) REFERENCES Employee(id),
    FOREIGN KEY (location_id) REFERENCES Location(id)
    );

CREATE TABLE IF NOT EXISTS Location (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS Skill (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS CodingLanguage (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS Application (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           status ENUM('APPLIED', 'UNDER_REVIEW', 'ACCEPTED', 'REJECTED'),
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    applicant_id BIGINT,
    job_posting_id BIGINT,
    FOREIGN KEY (applicant_id) REFERENCES Employee(id),
    FOREIGN KEY (job_posting_id) REFERENCES JobPosting(id)
    );

CREATE TABLE IF NOT EXISTS Verification (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            manager_id BIGINT,
                                            hr_id BIGINT,
                                            application_id BIGINT,
                                            verification_timestamp_manager TIMESTAMP,
                                            verification_timestamp_hr TIMESTAMP,
                                            FOREIGN KEY (manager_id) REFERENCES Employee(id),
    FOREIGN KEY (hr_id) REFERENCES Hr(id),
    FOREIGN KEY (application_id) REFERENCES Application(id)
    );

CREATE TABLE IF NOT EXISTS job_posting_skill (
                                                 job_posting_id BIGINT,
                                                 skill_id BIGINT,
                                                 PRIMARY KEY (job_posting_id, skill_id),
    FOREIGN KEY (job_posting_id) REFERENCES JobPosting(id),
    FOREIGN KEY (skill_id) REFERENCES Skill(id)
    );

CREATE TABLE IF NOT EXISTS job_posting_language (
                                                    job_posting_id BIGINT,
                                                    language_id BIGINT,
                                                    PRIMARY KEY (job_posting_id, language_id),
    FOREIGN KEY (job_posting_id) REFERENCES JobPosting(id),
    FOREIGN KEY (language_id) REFERENCES CodingLanguage(id)
    );
