CREATE TABLE departments (
       department_number serial,
	name varchar(64) NOT NULL,
	employees_id integer NOT NULL,
	CONSTRAINT pk_departments_department_number PRIMARY KEY (department_number)
 );
 
 CREATE TABLE job_titles
(
	job_titles serial,
	title varchar(64) NOT NULL,
	CONSTRAINT pk_job_titles_id PRIMARY KEY (job_titles)
);
 
CREATE TABLE employees
(
        employee_number serial,
	job_title_id integer NOT NULL,
	first_name varchar(32) NOT NULL,
	last_name varchar(32) NOT NULL,
	gender varchar(20),
	date_of_birth_id integer NOT NULL,
	date_of_hire_id integer NOT NULL,
	department_id integer NOT NULL,
	CONSTRAINT pk_employees_employee_number PRIMARY KEY (employee_number),
	CONSTRAINT fk_employees_job_title_id FOREIGN KEY (job_title_id) REFERENCES job_titles (id),
	CONSTRAINT fk_employees_date_of_birth_id FOREIGN KEY (date_of_birth_id) REFERENCES dates (id),
	CONSTRAINT fk_employees_date_of_hire_id FOREIGN KEY (date_of_hire_id) REFERENCES dates (id),
	CONSTRAINT fk_employees_department_id FOREIGN KEY (department_id) REFERENCES departments (department_number)
);

CREATE TABLE projects (
        project_number serial,
        name varchar(255) NOT NULL UNIQUE,
        start_date date NOT NULL,
        employees_id integer NOT NULL,
        CONSTRAINT pk_projects_id PRIMARY KEY (id),
        CONSTRAINT fk_employees_id FOREIGN KEY (employees_id) REFERENCES employees(id)
);


 INSERT INTO departments (name) VALUES ('Molecular Genetics');
 INSERT INTO departments (name) VALUES ('Cell Biology'); 
 INSERT INTO departments (name) VALUES ('Biochemistry');
 
 INSERT INTO job_titles (title) VALUES ('Director');
 INSERT INTO job_titles (title) VALUES ('Lab Manager');
 INSERT INTO job_titles (title) VALUES ('Researcher');
 INSERT INTO job_titles (title) VALUES ('Research Assistant');
 
 INSERT INTO employees (first_name,last_name,date_of_hire,departments_id,job_titles_id) VALUES ('Ann','Smith','1999-05-09',1,2);
 INSERT INTO employees (first_name,last_name,date_of_hire,departments_id,job_titles_id) VALUES ('Ronald','Drumpf','2013-01-07',2,1);
 INSERT INTO employees (first_name,last_name,date_of_hire,departments_id,job_titles_id) VALUES ('Frank','Gray','2018-11-01',3,4);
 INSERT INTO employees (first_name,last_name,date_of_hire,departments_id,job_titles_id) VALUES ('Andrew','Graham','2016-04-02',1,3);
 INSERT INTO employees (first_name,last_name,date_of_hire,departments_id,job_titles_id) VALUES ('Bob','Black','2016-04-02',2,2);
 INSERT INTO employees (first_name,last_name,date_of_hire,departments_id,job_titles_id) VALUES ('Betty','White','2016-04-02',3,2);
 INSERT INTO employees (first_name,last_name,date_of_hire,departments_id,job_titles_id) VALUES ('Malcolm','X','2016-04-02',3,2);

INSERT INTO projects (name,employees_id,startdate) VALUES ('Neuroblastoma',1,'2016-06-05');
INSERT INTO projects (name,employees_id,startdate) VALUES ('Leukemia',2,'2017-09-19');
INSERT INTO projects (name,employees_id,startdate) VALUES ('Melanoma',3,'2019-06-21');
INSERT INTO projects (name,employees_id,startdate) VALUES ('Retinoblastoma',4,'2017-04-16');

SELECT * FROM departments
SELECT * FROM job_titles
SELECT * FROM employees
SELECT * FROM projects
 