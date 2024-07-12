-- Insert sample data into Employee table
-- Create Employee table
CREATE TABLE IF NOT EXISTS employee  (
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


INSERT INTO employee (employee_id, first_name, last_name, dob, email, password, role) VALUES
      (1, 'John', 'Doe', '1990-01-01', 'john.doe@example.com', 'password', 'EMPLOYEE'),
      (2, 'Jane', 'Doe', '1990-02-01', 'jane.doe@example.com', 'password123', 'MANAGER');

-- Update reports_to value after all employees are inserted
UPDATE employee SET reports_to = 2 WHERE employee_id = 1;