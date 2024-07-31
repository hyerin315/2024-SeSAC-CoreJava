CREATE TABLE mycompany.Patient(
	number 			TINYINT 	NOT NULL,
	code 			CHAR(2) 	NOT NULL,
	days			SMALLINT 	NOT NULL,
	age				TINYINT 	NOT NULL,
	dept			VARCHAR(20),
	operfee			INT,
	hospitalfee		INT,
	money			INT,
	CONSTARINT patient_number_pk PRIMARY KEY(number)
);