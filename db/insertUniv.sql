INSERT INTO university (univ_code, university_name)
VALUES (1234,'Anna Univ'),
       (5678,'Annamalai Univ');

INSERT INTO college (`code`, `name`, univ_code, city, state, year_opened, id)
VALUES (1100,'jaya engg college',1234, 'chennai', 'tamilnadu', 1994, 1),
	   (1101,'eswar engg college',1234, 'chennai', 'tamilnadu', 1996, 2),
	   (1102,'sastra engg college',1234, 'coimbatore', 'tamilnadu', 1997, 3),
       (2100,'manas engg college',5678, 'trichy', 'tamilnadu', 1998, 4),
	   (2101,'barathi engg college',5678, 'thiravallur', 'tamilnadu', 2000, 5),
	   (2102,'gandhi engg college',5678, 'madurai', 'tamilnadu', 2002, 6);

INSERT INTO department ( dept_code, dept_name, univ_code)
VALUES ('EC10','electronics and communication engg',1234),
       ('CS20','computer science and engg',1234),
       ('IT30','information and technology',1234),
       ('ME40','mechanical engineering',1234),
       ('MR50','marine engineering',5678),
       ('CS60','computer science and engg',5678),
       ('IT70','information and technology',5678),
       ('CH80','chemical engg',5678);
			     
INSERT INTO designation (id, `name`, rank)
VALUES (12, 'principal', 1),
       (14, 'hod', 2),
       (29, 'lecturer', 3);

INSERT INTO college_department (cdept_id, udept_code, college_id)
VALUES (11, 'EC10', 1),
       (12, 'CS20', 1),
       (13, 'IT30', 1),
	   (14, 'ME40', 2),
	   (15, 'CS20', 2),
	   (16, 'IT30', 2),
	   (17, 'EC10', 3),
	   (18, 'CS20', 3),
	   (19, 'IT30', 3),
	   (20, 'MR50', 4), 
       (21, 'CS60', 4),
       (22, 'IT70', 4),
       (23, 'CH80', 5),
       (24, 'CS60', 5),
       (25, 'IT70', 5),
       (26, 'MR50', 6),
       (27, 'CS60', 6),
       (28, 'IT70', 6);
       
INSERT INTO employee (id, `name`, dob, email, phone, college_id, cdept_id, desig_id)
VALUES (100, 'rajan', '1987-01-10', 'principal14beece@gmail.com', 8126642540, 1, 11, 12),
       (101, 'narayanan', '1977-02-11', 'hod14beece@gmail.com', 8126642541, 1, 12, 14),
       (102, 'varun', '1988-03-12', 'ssr15dsres@gmail.com', 8126642542, 1, 13, 29),
       (109, 'suhil', '1983-04-3', 'bfng65gjnc@gmail.com', 8126042532, 1, 16, 29),
       (110, 'karthi', '1977-05-6', 'hod14beece@gmail.com', 8126642241, 1, 14, 14), 
       (111, 'ram', '1967-08-10', 'ssr15dfres@gmail.com', 8129642542, 1, 12, 29),
       (112, 'narayanan', '1967-06-7', 'bjgc65gjnc@gmail.com', 8126542532, 1, 12, 29),
       (130, 'rajan', '1977-08-9', 'hod14ceece@gmail.com', 8126642941, 2, 15, 14), 
       (131, 'samuel', '1989-09-1', 'ssl15dfres@gmail.com', 8139642542, 2, 14, 29),
       (132, 'rajan', '1980-01-13', 'bjgc64gjnc@gmail.com', 8127542532, 2, 14, 29),
       (146, 'jagan', '1981-02-17', 'bfshf65gjnc@gmail.com', 6126632532, 3, 14, 29),
       (147, 'isaac', '1982-03-19', 'hod14beeme@gmail.com', 8126612041, 3, 13, 14), 
       (148, 'sakthi', '1988-04-2', 'ssr1a5dsdes@gmail.com', 7129642542, 3, 16, 29),
       (149, 'isaac', '1983-04-26', 'bfnw65gjnc@gmail.com', 7526042532, 3, 16, 29),
       (150, 'nirosha', '1986-05-10', 'hod14bejce@gmail.com', 8126643741, 3, 14, 14), 
       (151, 'gowtham', '1987-06-10', 'sdr15dfres@gmail.com', 8729642542, 3, 12, 29),
       (152, 'isaac', '1985-07-18', 'btgc65gjnc@gmail.com', 6126542532, 3, 12, 29),
       (160, 'gowtham', '1980-08-20', 'principal16beece@gmail.com', 8125642540, 4, 23, 12),
       (161, 'harish', '1981-08-16', 'hod11beece@gmail.com', 8126642541, 4, 21, 14), 
       (170, 'sakthi', '1982-08-15', 'hod14bpece@gmail.com', 8126642041, 4, 20, 14), 
       (171, 'isaac', '1983-09-14', 'ssry15dfres@gmail.com', 8329642542, 4, 22, 29),
       (172, 'suhil', '1984-04-19', 'bjgc645gjnc@gmail.com', 6126542532, 4, 22, 29),
       (173, 'nirosha', '1985-04-20', 'principal44beece@gmail.com', 8126642550, 4, 11, 12),
       (187, 'nirosha', '1986-04-22', 'hod14beecse@gmail.com', 8126612341, 5, 23, 14), 
       (188, 'ranjith', '1987-06-4', 'ssrd1qdsdes@gmail.com', 8139642542, 5, 26, 29),
       (189, 'varjith', '1988-08-7', 'bfngas65gjnc@gmail.com', 7626042532, 6, 26, 29),
       (190, 'nirosha', '1989-02-10', 'hod14bpjcel@gmail.com', 8126642141, 6, 20, 14), 
       (191, 'sakthi', '1990-03-6', 'ssry1erdfres@gmail.com', 8029622542, 6, 22, 29),
       (192, 'ranjith', '1981-04-7', 'bjgc645dgjnc@gmail.com', 6726342532, 6, 22, 29),
       (193, 'varjith', '1982-05-3', 'scrz5dkkes@gmail.com', 8428022542, 6, 25, 29),
       (197, 'varjith', '1983-06-9', 'bfcgas65gjnc@gmail.com', 7622042532, 6, 26, 29),
       (198, 'nirosha', '1984-07-20', 'hos14bpecel@gmail.com', 8126142141, 6, 20, 14), 
       (199, 'sakthi', '1985-08-5', 'ssra15cdfres@gmail.com', 6029642542, 6, 22, 29);
 
INSERT INTO syllabus (id, cdept_id, syllabus_code, syllabus_name) 
VALUES (1000, 11, 'OP10', 'oops'),
       (1001, 11, 'CP11', 'cp'),
       (1002, 12, 'PO12', 'pom'),
       (1003, 13, 'EM12', 'electromehanics'),
       (1004, 14, 'PE13', 'proethics'),
       (1005, 15, 'MG14', 'management'),
       (1006, 16, 'ME15', 'mechanisms'),
       (1007, 17, 'JS16', 'javascript'),
       (1008, 18, 'CT17', 'circuittheory'),
       (1009, 19, 'CH18', 'chemistry'),
       (1010, 20, 'PH19', 'physics'),
       (1011, 21, 'MB20', 'mobility'),
       (1012, 22, 'CS21', 'computersci'),
       (1013, 23, 'AE22', 'aeronautics'),
       (1014, 24, 'CA23', 'comparchitecture'),
       (1015, 25, 'DS24', 'dsp'),
       (1016, 26, 'PM25', 'promanagement'),
       (1017, 27, 'PS26', 'circuitwires'),
       (1018, 28, 'ED27', 'edc'),
       (1019, 22, 'KE28', 'kineticenergy'),
       (1020, 21, 'VS29', 'vlsi');

INSERT INTO professor_syllabus (emp_id, syllabus_id, semester)
VALUES (100, 1000, 1),
       (101, 1001, 2),
       (102, 1002, 3),
       (109, 1003, 4),
       (110, 1004, 5),
       (111, 1005, 6),
       (112, 1006, 7),
       (130, 1007, 8);
       
INSERT INTO student (id, roll_number, `name`, dob, gender, email, phone, address, academic_year, cdept_id, college_id)
VALUES (653760, 74643, 'ragavan', '1977-02-11', 'm', 'ragav14beece@gmail.com', 8126642541, 'chennai', 2014, 11, 1),  
       (653761, 74640, 'indra', '1987-01-10', 'm', 'indral14beece@gmail.com', 8126642540, 'coimbatore', 2014, 11, 1),  
       (653762, 74641, 'aishwarya', '1988-03-12', 'f', 'ssr15dsres@gmail.com', 8126642542, 'trichy', 2015, 12, 2),  
       (653763, 74642, 'kannan', '1983-04-3', 'm', 'bfng65gjnc@gmail.com', 8126042532, 'chennai', 2015, 13, 2),  
       (653764, 74644, 'keerthi', '1977-05-6', 'f', 'keerthi14beece@gmail.com', 8126642241, 'chennai', 2016, 14, 2),  
       (653765, 74645, 'ramu', '1967-08-10', 'm', 'ssr15dfres@gmail.com', 8129642542, 'madurai', 2016, 14, 3),  
       (653766, 74646, 'sam', '1967-06-7', 'm', 'bjgc65gjnc@gmail.com', 8126542532, 'chennai', 2016, 15, 3),  
       (653767, 74647, 'reshma', '1977-08-9', 'f', 'reshma14ceece@gmail.com', 8126642941, 'chennai', 2017, 16, 4),  
       (653768, 74648, 'barath', '1989-09-1', 'm', 'ssl15dfres@gmail.com', 8139642542, 'chennai', 2017, 17, 4),  
       (653769, 74649, 'vinoth', '1980-01-13', 'm', 'bjgc64gjnc@gmail.com', 8127542532, 'salem', 2014, 18, 1),  
       (653705, 74614, 'jagan', '1981-02-17', 'm', 'bfshf65gjnc@gmail.com', 6126632532, 'chennai', 2014, 18, 2),
       (653715, 74603, 'ajish', '1982-03-19', 'm', 'hod14beeme@gmail.com', 8126612041, 'chennai', 2015, 19, 3),  
       (653725, 74613, 'veera', '1988-04-2', 'm', 'ssr1a5dsdes@gmail.com', 7129642542, 'trichy', 2015, 19, 3),  
       (653735, 74623, 'gopu', '1983-04-26', 'm', 'bfnw65gjnc@gmail.com', 7526042532, 'chennai', 2016, 20, 4),  
       (653745, 74636, 'sashi', '1986-05-10', 'm', 'hod14bejce@gmail.com', 8126643741, 'chennai', 2016, 20, 5),  
       (653755, 74643, 'david', '1987-06-10', 'm', 'sdr15dfres@gmail.com', 8729642542, 'chennai', 2016, 21, 5),  
       (653756, 74653, 'rajesh', '1985-07-18', 'm', 'btgc65gjnc@gmail.com', 6126542532, 'chennai', 2017, 21, 4),  
       (653775, 74663, 'dinesh', '1980-08-20', 'm', 'dinesh16beece@gmail.com', 8125642540, 'chennai', 2017, 22, 6),  
       (653785, 74673, 'harish', '1981-08-16', 'm', 'hod11beece@gmail.com', 8126642541, 'chennai', 2014, 22, 4),  
       (653795, 74686, 'vignesh', '1982-08-15', 'm', 'hod14bpece@gmail.com', 8126642041, 'chennai', 2014, 22, 6),  
       (653065, 74693, 'vijayan', '1983-09-14', 'm', 'ssry15dfres@gmail.com', 8329642542, 'chennai', 2015, 23, 5),  
       (653165, 74043, 'nishanth', '1984-04-19', 'm', 'bjgc645gjnc@gmail.com', 6126542532, 'chennai', 2015, 23, 5),  
       (653265, 74143, 'kumar', '1985-04-20', 'm', 'pkumarl44beece@gmail.com', 8126642550, 'chennai', 2016, 24, 6),  
       (653365, 74243, 'tamil', '1986-04-22', 'm', 'tam14beecse@gmail.com', 8126612341, 'salem', 2016, 24, 6),  
       (699965, 74346, 'balaji', '1987-06-4', 'm', 'ssrd1qdsdes@gmail.com', 8139642542, 'chennai', 2016, 25, 4),  
       (653565, 74443, 'saravana', '1988-08-7', 'm', 'bfngas65gjnc@gmail.com', 7626042532, 'chennai', 2017, 25, 4),
       (653665, 74543, 'sathya', '1989-02-10', 'm', 'sat14bpjcel@gmail.com', 8126642141, 'chennai', 2017, 26, 5),  
       (653465, 74643, 'sakthi', '1990-03-6', 'm', 'ssry1erdfres@gmail.com', 8029622542, 'trichy', 2014, 27, 4),  
       (653865, 74743, 'ranji', '1981-04-7', 'm', 'bjgc645dgjnc@gmail.com', 6726342532, 'chennai', 2014, 27, 5),  
       (653965, 74846, 'varjith', '1982-05-3', 'm', 'scrz5dkkes@gmail.com', 8428022542, 'chennai', 2015, 28, 5),  
       (650765, 74943, 'guru', '1983-06-9', 'm', 'bfcgas65gjnc@gmail.com', 7622042532, 'chennai', 2015, 28, 6),  
       (651765, 70643, 'giri', '1984-07-20', 'm', 'hos14bpecel@gmail.com', 8126142141, 'madurai', 2016, 28, 4),  
       (652765, 71643, 'sanjay', '1985-08-5', 'm', 'ssra15cdfres@gmail.com', 6029642542, 'chennai', 2016, 28, 6);  

INSERT INTO semester_fee (cdept_id, stud_id, semester, amount, paid_year, paid_status)
VALUES (11, 653760, 6, 12000, 2016, 'paid'),
       (13, 653763, 4, 34000, 2015, 'paid'),
       (16, 653767, 7, 10000, 2017, 'unpaid'),
       (23, 653065, 3, 50000, 2015, 'unpaid'),
       (28, 651765, 2, 30000, 2014, 'paid');
          
INSERT INTO semester_result ( stud_id, syllabus_id, semester, grade, credits, result_date)
VALUES (653760, 1000, 6, 's', 4, '2018-04-12'),
       (653763, 1002, 4, 'a', 3, '2018-03-17'),      
       (653767, 1006, 7, 'c', 1, '2018-09-17'),  
       (653065, 1016, 3, 'b', 2, '2018-08-17'),  
       (651765, 1018, 2, 'c', 1, '2018-03-17');   
                                                                                                                        




























              
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
		      