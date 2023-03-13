update psp_general.branch set branch_id = 'SG1' where branch_id = 'SG-1';
update psp_general.branch set branch_id = 'HN1' where branch_id = 'HN-1';
update psp_general.branch set branch_id = 'DN1' where branch_id = 'DN-1';

DELETE FROM booking;

insert into booking (booking_id, customer_name, phone_number, email, number_of_guests, reservation_date, branch_id, special_notes, created_date, created_by) values
	 ('SG1-230103-1','John Dallas','+8488899101','john@hotmail.com',2,'2023-01-03 00:00:00','SG1',null,'2023-01-03 17:00:00','John'),
	 ('HN1-230104-1','Wilson Dohn','+8716371538','dohn@hotmail.com',3,'2023-01-04 00:00:00','HN1',NULL,'2023-01-04 17:00:00','Dohn'),
	 ('DN1-230104-1','Marry Jean','+8716371538','marry@hotmail.com',3,'2023-01-05 00:00:00','DN1',NULL,'2023-01-06 17:00:00','marry'),
	 ('SG1-230103-2','Minh Duc','+8488899101','duc@hotmail.com',2,'2023-01-03 00:00:00','SG1',null,'2023-01-03 18:00:00','John'),
     ('HN1-230104-2','Beo Beo','+8716371538','beo@hotmail.com',3,'2023-01-04 00:00:00','HN1',NULL,'2023-01-04 20:00:00','Dohn'),
     ('DN1-230104-2','Upeity','+8716371538','up@hotmail.com',3,'2023-01-05 00:00:00','DN1',NULL,'2023-01-06 19:00:00','marry');