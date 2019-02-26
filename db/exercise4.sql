SELECT e.id, e.`name`, e.dob, e.email, e.phone, c.`code`, c.`name`, d.dept_name, c.city, c.state, c.year_opened
  FROM university AS u
       INNER JOIN college AS c
       ON c.univ_code = u.univ_code
       INNER JOIN department AS d
       ON d.univ_code = u.univ_code
       INNER JOIN college_department AS cd
       ON d.dept_code = cd.udept_code
       INNER JOIN employee AS e
       ON (e.college_id = c.id) AND (e.cdept_id = cd.cdept_id)
 WHERE university_name = 'Anna Univ'     