SELECT s.id, s.roll_number, s.`name`, s.dob, s.gender,c.`name`,sr.semester, s.email, s.phone, s.address, s.academic_year, s.cdept_id, s.college_id, sr.credits, sr.grade, sr.credits * 10/10 AS gpa
  FROM student AS s
       INNER JOIN semester_result AS sr
       ON sr.stud_id = s.id 
       INNER JOIN college AS c
       ON s.college_id = c.id
 ORDER BY c.`name`, semester
 LIMIT 10