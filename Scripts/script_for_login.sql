/*
 * query for login
 */
select first_name, last_name from employee where employee_id = (select employee_id from employee_login el where username = 'yeoj' and password = 'onagol');