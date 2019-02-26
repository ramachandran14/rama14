SELECT roll_number, s.`name`, dob, gender, email, phone, address, c.`name`, university_name
  FROM student AS s
       INNER JOIN college AS c
       ON s.college_id = c.id
       INNER JOIN university AS u
       ON u.univ_code = c.univ_code
       INNER JOIN department AS d
       ON d.univ_code = u.univ_code
 WHERE academic_year = 2017