/*******************************************************
	INSERT INTO MANAGER TABLES 
*******************************************************/
insert into manager (first_name, last_name, title)
values 
		('Roger', 'Penske', 'departement head'),
		('Joe', 'Gibbs', 'departement head'),
		('Jim', 'France', 'benefits coordinator');
	
insert into manager_login (username, password, manager_id )
	values 	
		('roger', 'penske', (select manager_id from manager where last_name = 'Penske' and first_name = 'Roger')),
		('joe', 'gibbs', (select manager_id from manager where last_name = 'Gibbs' and first_name = 'Joe')),
		('jim', 'france', (select manager_id from manager where last_name = 'France' and first_name = 'Jim'));


select * from manager m natural join manager_login;