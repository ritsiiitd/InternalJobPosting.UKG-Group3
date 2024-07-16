-- Insert demo data into Employee table
INSERT INTO employee (first_name, last_name, dob, email, password, e_role, reports_to) VALUES
   ('Alice', 'Smith', '1985-04-23', 'alice.smith@example.com', 'password1', 'MANAGER', NULL),
   ('Bob', 'Johnson', '1987-07-15', 'bob.johnson@example.com', 'password2', 'HR', NULL),
   ('Carol', 'Williams', '1990-02-01', 'carol.williams@example.com', 'password3', 'EMPLOYEE', 1),
   ('Dave', 'Brown', '1992-11-30', 'dave.brown@example.com', 'password4', 'EMPLOYEE', 1),
   ('Eve', 'Davis', '1988-08-24', 'eve.davis@example.com', 'password5', 'EMPLOYEE', 1),
   ('Frank', 'Miller', '1993-06-03', 'frank.miller@example.com', 'password6', 'EMPLOYEE', 1),
   ('Grace', 'Wilson', '1989-03-17', 'grace.wilson@example.com', 'password7', 'EMPLOYEE', 1),
   ('Hank', 'Moore', '1991-12-12', 'hank.moore@example.com', 'password8', 'EMPLOYEE', 1),
   ('Ivy', 'Taylor', '1986-05-25', 'ivy.taylor@example.com', 'password9', 'MANAGER', NULL),
   ('Jake', 'Anderson', '1994-10-09', 'jake.anderson@example.com', 'password10', 'EMPLOYEE', 9),
   ('Kara', 'Thomas', '1995-01-19', 'kara.thomas@example.com', 'password11', 'EMPLOYEE', 9),
   ('Liam', 'Jackson', '1984-09-29', 'liam.jackson@example.com', 'password12', 'EMPLOYEE', 9),
   ('Mia', 'White', '1996-04-14', 'mia.white@example.com', 'password13', 'EMPLOYEE', 9),
   ('Noah', 'Harris', '1983-03-03', 'noah.harris@example.com', 'password14', 'EMPLOYEE', 9),
   ('Olivia', 'Martin', '1997-07-22', 'olivia.martin@example.com', 'password15', 'EMPLOYEE', 9);


-- -- Insert demo data into Location table
-- -- Insert demo data into CodingLanguage table
INSERT INTO coding_language (lang_name, skill_level) VALUES
('Java', 'Intermediate'),
('Python', 'Beginner'),
('C#', 'Advanced'),
('JavaScript', 'Intermediate');
--
-- -- -- Insert demo data into Location table
INSERT INTO location (name) VALUES
('New York'),
('San Francisco'),
('Berlin'),
('Tokyo');

INSERT INTO job_posting (description, min_exp, min_sal, max_sal, is_active, designation, created_by, deadline) VALUES
('Software Developer for Web Applications', 2, 50000, 70000, TRUE, 'Software Developer', 2, '2024-12-31'),
('Senior Data Analyst', 5, 60000, 90000, TRUE, 'Data Analyst', 2, '2024-11-15'),
('HR Manager', 3, 55000, 80000, TRUE, 'HR Manager', 2, '2024-10-20'),
('Junior Software Developer', 1, 40000, 60000, TRUE, 'Software Developer', 2, '2024-12-10'),
('Marketing Specialist', 4, 45000, 70000, TRUE, 'Marketing Specialist', 2, '2024-09-30'),
('Project Manager', 6, 70000, 100000, TRUE, 'Project Manager', 2, '2024-08-25'),
('System Administrator', 2, 50000, 75000, TRUE, 'System Administrator', 2, '2024-11-05'),
('UI/UX Designer', 3, 55000, 85000, TRUE, 'UI/UX Designer', 2, '2024-10-15'),
('DevOps Engineer', 4, 60000, 90000, TRUE, 'DevOps Engineer', 2, '2024-12-01'),
('Technical Support Specialist', 1, 35000, 50000, TRUE, 'Technical Support', 2, '2024-09-20');


--
--
INSERT INTO application (employee_id, job_pos_id, status, verified_by_manager) VALUES
(3, 1, 'APPLIED',  FALSE),
(4, 2, 'APPLIED',  FALSE),
(5, 3, 'APPLIED',  FALSE),
(6, 4, 'APPLIED',  FALSE),
(7, 5, 'APPLIED',  FALSE);
