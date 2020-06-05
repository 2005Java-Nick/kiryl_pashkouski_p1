/*******************************************************
 * Tuition Reimbursement Managment System - Version 0.1;
 * Script: script_create_tables.sql;
 * Desciption: creates TRMS_DB;
 * DB Server: PostgreSQL;
 * Author: Kiryl Pashkouski
*******************************************************/
/*******************************************************
	CREATE TABLES
*******************************************************/
drop table if exists employee cascade;
create table employee (
employee_id serial primary key,
first_name varchar,
last_name varchar,
email varchar,
reports_to int references manager (manager_id)
);

drop table if exists employee_login cascade;
create table employee_login (
employee_id int references employee (employee_id),
username varchar unique,
password varchar,
primary key (username, password)
);

drop table if exists account cascade;
create table account (
account_number int primary key,
pending_amount numeric,
awarded_amount numeric,
employee_id int references employee (employee_id)
);

drop table if exists account_log cascade;
create table account_log (
id serial primary key,
account_number int references account (account_number),
previous_balance numeric,
current_balance numeric,
changed_on timestamp
);

drop table if exists event_type cascade;
create table event_type (
event_id serial primary key,
event_name varchar,
reimbursement_ratio int,
is_graded bool
);

drop table if exists manager cascade;
create table manager (
manager_id serial primary key,
first_name varchar,
last_name varchar,
title varchar
);

drop table if exists manager_login cascade;
create table manager_login (
manager_id int references manager (manager_id),
username varchar,
password varchar,
primary key (username, password)
);

drop table if exists request cascade;
create table request (
request_id serial primary key,
employee_id int references employee (employee_id),
first_name varchar,
last_name varchar,
event_name varchar, -- references event_type (event_name),
start_date varchar,
-- available_amount numeric,
requested_amount varchar,
is_urgent bool,
current_status varchar
);

drop table if exists request_status cascade;
create table request_status (
request_id int primary key references request (request_id),
approved_by_ds bool,
approved_by_dh bool,
approved_by_bc bool,
is_granted bool,
manager_id int references manager (manager_id)
);

drop table if exists request_log cascade;
create table request_log (
id serial primary key,
request_id int references request (request_id),
previous_status varchar,
current_status varchar,
changed_on timestamp
);



