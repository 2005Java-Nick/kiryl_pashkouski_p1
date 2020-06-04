/*******************************************************
	INSERT INTO TABLES FEW DEFAULT ENTRIES
*******************************************************/
insert into employee (first_name, last_name, email, reports_to ) 
	values 	
			('Joey', 'Logano', 'joey.logano@company.com', 1),
			('Kyle', 'Bush', 'kyle.bush@company.com', 2),
			('Chase', 'Elliott', 'chase.elliott@company.com', 2),
			('Jimmie', 'Johnson', 'jimmie.johnson@company.com', 1),
			('Martin', 'TruexJr', 'martin.truexjr@company.com', 2);
			
insert into employee_login (username, password, employee_id )
	values 	
			('yeoj', 'onagol', (select employee_id from employee where last_name = 'Logano' and first_name = 'Joey')),
			('elyk', 'hsub', (select employee_id from employee where last_name = 'Bush' and first_name = 'Kyle')),
	 		('esahc', 'ttiolle', (select employee_id from employee where last_name = 'Elliott' and first_name = 'Chase')),
	 		('eimmij', 'nosnhoj', (select employee_id from employee where last_name = 'Johnson' and first_name = 'Jimmie')),
	 		('nitram', 'rjxeurt', (select employee_id from employee where last_name = 'TruexJr' and first_name = 'Martin'));
	 	
	 	select * from employee e natural join employee_login el;
	 		