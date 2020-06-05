/*******************************************************
	INSERT INTO REQUEST TABLE
*******************************************************/
insert into request (employee_id, event_id, start_date, requested_amount, is_urgent)
values 
		(1, 1, '2020-09-21', '500', true);
		
select * from request natural join employee ; 