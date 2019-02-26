CREATE TABLE communication (
        sender_name VARCHAR(30),
      receiver_name VARCHAR(50), 
                 id INT		
); 
CREATE TABLE mobile (
        slimslot INT(2),
		   brand VARCHAR(20) 
);
CREATE TABLE television (
        inches INT(60),
		weight FLOAT(50) NOT NULL
);	
CREATE TABLE verbal (
		lang VARCHAR(20) PRIMARY KEY,
  voice_tone VARCHAR(10) 
);
				          