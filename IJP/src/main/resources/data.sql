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