CREATE TABLE mycompany.Patient(
	number 			TINYINT 	NOT NULL,
	code 			CHAR(2) 	NOT NULL,
	days			SMALLINT 	NOT NULL,
	age				TINYINT 	NOT NULL,
	dept			VARCHAR(20),
	operfee			INT,
	hospitalfee		INT,
	money			INT,
	CONSTRAINT patient_number_pk PRIMARY KEY(number)
);

-- 모든 환자에 대한 정보
DELIMITER $$
CREATE PROCEDURE sp_select_all_patient()
BEGIN
	SELECT number, dept, operfee, hospitalfee, money
    FROM Patient
    ORDER BY number DESC;
END
$$
DELIMITER ;

-- 환자 1명에 대한 정보
DELIMITER $$
CREATE PROCEDURE sp_select_one_patient
(
	IN v_number TINYINT
)
BEGIN
	SELECT *
    FROM Patient
    WHERE number = v_number;
END
$$
DELIMITER ;

-- 환자 정보 7가지 가져오기
DELIMITER //
CREATE PROCEDURE sp_update_patient
( 	#IN은 생략 가능
	IN	v_number		TINYINT,
    IN  v_code			CHAR(2),
    IN  v_days			SMALLINT,		
    IN  v_age			TINYINT,
    IN  v_dept          VARCHAR(20),
    IN  v_operfee       INT,
    IN  v_hospitalfee   INT,
    IN  v_money			INT
)
BEGIN
	UPDATE Patient
    SET code = v_code, days = v_days, age = v_age,
		dept = v_dept, operfee = v_operfee, hospitalfee = v_hospiratalfee,
        money = v_money
    WHERE number = v_number;
    COMMIT;
END
//
DELIMITER ;
