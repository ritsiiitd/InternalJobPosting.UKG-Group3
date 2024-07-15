-- CREATE TABLE IF NOT EXISTS employee  (
--     employee_id INT PRIMARY KEY AUTO_INCREMENT,
--     first_name VARCHAR(255),
--     last_name VARCHAR(255),
--     dob DATE,
--     email VARCHAR(255) NOT NULL,
--     password VARCHAR(255),
--     e_role VARCHAR(255),
--     reports_to VARCHAR(255)
--     );

-- Drop existing tables if they exist
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS job_posting CASCADE;
DROP TABLE IF EXISTS application CASCADE;
DROP TABLE IF EXISTS location CASCADE;
DROP TABLE IF EXISTS coding_language CASCADE;
DROP TABLE IF EXISTS location_junction CASCADE;

-- Create Employee table
CREATE TABLE employee (
      employee_id INT AUTO_INCREMENT PRIMARY KEY,
      first_name VARCHAR(255),
      last_name VARCHAR(255),
      dob DATE,
      email VARCHAR(255) UNIQUE,
      password VARCHAR(255),
      e_role VARCHAR(255),
      reports_to INT,
      FOREIGN KEY (reports_to) REFERENCES employee(employee_id)
);

-- Create Location table
CREATE TABLE location (
      location_id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255)
);

-- Create Job Posting table
CREATE TABLE job_posting (
     job_pos_id INT AUTO_INCREMENT PRIMARY KEY,
     description VARCHAR(255),
     min_exp INT,
     min_sal INT,
     max_sal INT,
     is_active BOOLEAN,
     designation VARCHAR(255),
     created_by INT,
     location_id INT,
     skill_id INT,
     language_id INT,
     deadline DATE,
     FOREIGN KEY (created_by) REFERENCES employee(employee_id),
     FOREIGN KEY (location_id) REFERENCES location(location_id)
);

-- Create Coding Language table
CREATE TABLE coding_language (
     language_id INT AUTO_INCREMENT PRIMARY KEY,
     job_pos_id INT,
     lang_name VARCHAR(255),
     skill_level VARCHAR(255),
     FOREIGN KEY (job_pos_id) REFERENCES job_posting(job_pos_id)
);

-- Create Application table
CREATE TABLE application (
     app_id INT AUTO_INCREMENT PRIMARY KEY,
     employee_id INT,
     job_pos_id INT,
     status VARCHAR(255),
     verified_by_hr BOOLEAN,
     verified_by_manager BOOLEAN,
     FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
     FOREIGN KEY (job_pos_id) REFERENCES job_posting(job_pos_id)
);

-- Create Location Junction table
CREATE TABLE location_junction (
   location_id INT,
   job_pos_id INT,
   PRIMARY KEY (location_id, job_pos_id),
   FOREIGN KEY (location_id) REFERENCES location(location_id),
   FOREIGN KEY (job_pos_id) REFERENCES job_posting(job_pos_id)
);
