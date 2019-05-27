CREATE TABLE regions
( 	region_id	TINYINT(1)  AUTO_INCREMENT,
	region_name VARCHAR(25) NOT NULL,
    PRIMARY KEY(region_id)
);

CREATE TABLE countries 
( 	country_id  CHAR(2) NOT NULL,
	country_name	VARCHAR(40) NOT NULL,
	region_id		TINYINT(1) NOT NULL,
    PRIMARY KEY(country_id),
    FOREIGN KEY (region_id) REFERENCES regions(region_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE locations
( 	location_id	INTEGER(4) AUTO_INCREMENT,
	street_address 	VARCHAR(40),
	postal_code  	VARCHAR(12),
	city  		VARCHAR(30) NOT NULL,
	state_province VARCHAR(25),
	country_id     CHAR(2) NOT NULL,
    PRIMARY KEY (location_id),
    INDEX (city),
    INDEX (state_province),
    FOREIGN KEY (country_id) REFERENCES countries(country_id) ON UPDATE CASCADE ON DELETE CASCADE
) ;
ALTER TABLE locations AUTO_INCREMENT = 3300;

CREATE TABLE departments
( 	department_id	INTEGER(4) AUTO_INCREMENT,
	department_name	VARCHAR(30) NOT NULL,
	manager_id    	INTEGER(6),
	location_id    	INTEGER(4),
    PRIMARY KEY (department_id),
    FOREIGN KEY (location_id) REFERENCES locations(location_id) ON UPDATE CASCADE ON DELETE CASCADE
) ;
ALTER TABLE departments AUTO_INCREMENT = 280;

CREATE TABLE jobs
( 	job_id         VARCHAR(10),
	job_title      VARCHAR(35) NOT NULL,
	min_salary     INTEGER(6),
	max_salary     INTEGER(6),
    PRIMARY KEY (job_id)
) ;

CREATE TABLE employees
( 	employee_id INTEGER(6) AUTO_INCREMENT,
	first_name	VARCHAR(20),
    last_name 	VARCHAR(25) NOT NULL,
    email		VARCHAR(25) NOT NULL,
    phone_number VARCHAR(20),
    hire_date 	DATE NOT NULL,
    job_id 		VARCHAR(10) NOT NULL,
	salary		DECIMAL(8,2),
    commission_pct DECIMAL(2,2),
    manager_id 	INTEGER(6),
    department_id  INTEGER(4),
    PRIMARY KEY (employee_id),
    INDEX (last_name, first_name),
    FOREIGN KEY (department_id) REFERENCES departments(department_id),
    FOREIGN KEY (job_id) REFERENCES jobs(job_id),
    FOREIGN KEY (manager_id) REFERENCES employees(employee_id)
) ;
ALTER TABLE employees AUTO_INCREMENT = 207;

#ALTER TABLE departments ADD FOREIGN KEY (manager_id) REFERENCES employees (employee_id) ;

CREATE TABLE job_history
( 	employee_id INTEGER(6) NOT NULL,
	start_date 	DATE NOT NULL,
	end_date  	DATE NOT NULL,
	job_id     	VARCHAR(10) NOT NULL,
	department_id INTEGER(4), 
	PRIMARY KEY (employee_id, start_date),
    INDEX (employee_id),
    FOREIGN KEY (job_id) REFERENCES jobs(job_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
) ;

