SELECT roll_number, s.`name`, s.dob, s.gender, s.email, s.phone, s.address, c.`name`, dept_name, e.`name`
  FROM university AS u
       INNER JOIN college AS c
       ON u.univ_code = c.univ_code
       INNER JOIN department AS d
       ON d.univ_code = u.univ_code
       INNER JOIN college_department AS cd
       ON cd.udept_code = d.dept_code
       INNER JOIN employee AS e
       ON (e.college_id = c.id) AND (e.cdept_id = cd.cdept_id)
       INNER JOIN student AS s
       ON (s.college_id = c.id) AND (s.cdept_id = cd.cdept_id)
 WHERE university_name = 'Anna Univ' 
   AND e.desig_id = 14      