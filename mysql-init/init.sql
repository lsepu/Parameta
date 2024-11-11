CREATE TABLE IF NOT EXISTS employees.employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  document_type VARCHAR(255),
  document_number VARCHAR(255),
  birth_date DATE,
  joining_date DATE,
  position VARCHAR(255),
  salary FLOAT(53)
);
