-- psp_general.booking definition

-- Drop table

--DROP TABLE IF EXISTS booking;

create TABLE IF NOT exists booking (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	booking_id varchar(25) NOT NULL,
	customer_name varchar(100) NOT NULL,
	phone_number varchar(50) NULL,
	email varchar(100) NOT NULL,
	number_of_guests int4 NOT NULL,
	reservation_time timestamp NOT NULL,
	branch_id varchar(25) NOT NULL,
	special_notes varchar(1000) NULL,
	created_date timestamp NOT NULL,
	created_by varchar(10) NOT NULL,
	CONSTRAINT "BOOKING_pkey" PRIMARY KEY (id),
	CONSTRAINT booking_booking_id_key UNIQUE (booking_id)
);

-- psp_general.branch definition

-- Drop table

-- DROP TABLE branch;
--DROP TABLE IF EXISTS branch;

create TABLE IF NOT exists branch (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	branch_id varchar(25) NOT NULL,
	branch_name varchar(50) NOT NULL,
	address varchar(50) NULL,
	created_date timestamp NOT NULL,
	created_by varchar(10) NOT NULL,
	last_update_date timestamp NULL,
	last_update_by varchar(10) NULL,
	CONSTRAINT "BRANCH_pkey" PRIMARY KEY (id),
	CONSTRAINT branch_branch_id_key UNIQUE (branch_id)
);



insert into booking (booking_id, customer_name, phone_number, email, number_of_guests, reservation_time, branch_id, special_notes, created_date, created_by) values
	 ('TB-SG-03032023-1','John Dallas','+8488899101','john@hotmail.com',2,'2023-01-03 00:00:00','SG-1',null,'2023-01-03 00:00:00','John'),
	 ('TB-HN-03032023-1','Wilson Dohn','+8716371538','dohn@hotmail.com',3,'2023-01-04 00:00:00','HN-1',NULL,'2023-01-04 00:00:00','Dohn'),
	 ('TB-DN-03032023-1','Marry Jean','+8716371538','marry@hotmail.com',3,'2023-01-05 00:00:00','DN-1',NULL,'2023-01-06 00:00:00','marry');

insert into branch (branch_id, branch_name, address, created_date, created_by, last_update_date, last_update_by) values
	 ('SG-1','Sushi Tuyenbeoo Saigon','1A Ton Duc Thang, Ben Nghe ward, Ho Chi minh city','2023-01-03 00:00:00','Minh Duc',null,null),
	 ('HN-1','Sushi Tuyenbeoo Hanoi','35 Trang Tien, Hoan Kiem ward, Hanoi','2023-01-03 00:00:00','Minh Duc',NULL,NULL),
	 ('DN-1','Sushi Tuyenbeoo Da Nang','366 Phuoc Ninh, Hai Chau ward, Da Nang','2023-01-03 00:00:00','Minh Duc',NULL,NULL);