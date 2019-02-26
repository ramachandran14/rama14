SELECT `code`, c.`name`, university_name, city, state, dept_name, year_opened, e.`name` AS hod_name
  FROM college AS c
       INNER JOIN university AS u
       ON c.univ_code = u.univ_code
       INNER JOIN department AS d
       ON u.univ_code = d.univ_code
       INNER JOIN employee AS e
       ON e.college_id = c.id
 WHERE dept_name = 'COMPUTER SCIENCE AND ENGG'
   AND e.desig_id = 14
   AND e.cdept_id IN (12, 15, 18, 21)
   
   
   
   
   