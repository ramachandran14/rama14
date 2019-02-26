 UPDATE semester_fee 
    SET semester_fee.paid_status = 'paid',
        semester_fee.paid_year = 2017
  WHERE semester_fee.stud_id = 
(SELECT id
   FROM student AS s      
  WHERE s.roll_number = 74647);     

