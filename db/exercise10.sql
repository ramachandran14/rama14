SELECT s.id, s.roll_number, s.`name`, s.dob, s.gender, s.email, s.phone, s.address, s.academic_year, s.cdept_id, s.college_id
  FROM student AS s 
       INNER JOIN semester_result AS sr
       ON sr.stud_id = s.id
 WHERE credits = 2
  