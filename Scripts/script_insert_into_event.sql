/*******************************************************
	INSERT INTO EVENT TABLE
*******************************************************/
insert into event_type (event_name, reimbursement_ratio, is_graded )
values 
		('University Courses', 80, true),
		('Seminars', 60, false),
		('Certification Preparation Classes ', 75, false),
		('Certification', 100, true),
		('Technical Training', 90, true),
		('Other', 30, false);
		
select * from event_type et;