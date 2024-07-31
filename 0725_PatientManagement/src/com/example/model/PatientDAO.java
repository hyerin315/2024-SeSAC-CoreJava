package com.example.model;

import java.sql.SQLException;
import java.util.List;

public interface PatientDAO {
	/**
	 * 새로운 환자를 등록한다
	 * 이미 등록된 환자가 있다면 false를 리턴하고, 등록에 성곡하면 true를 리턴한다
	 * @param Patient
	 * @return 등록 성공하면 True, 그렇지 않으면 False
	 */
	boolean createPatient(PatientVO p) throws SQLException;
	/**
	 * 환자 등록번호를 입력받아서 해당  번호의 환자 한 명을 리턴한다
	 * @param 환자 등록번호
	 * @return 해당 환자 1명
	 */
	PatientVO readPatient(int number) throws SQLException;
	/**
	 * 지금까지 등록된 모든 환자 리스트를 반환한다
	 * @return 환자형 리스트
	 */
	List<PatientVO> readAllPatient() throws SQLException; // 모든 환자 리턴
	/**
	 * 수정할 환자정보를 입력받아서 수정성공하면 true를 리턴하고, 실패하면 false를 리턴한다
	 * @param 수정할 환자
	 * @return 성공여부
	 */
	boolean updatePatient(PatientVO p) throws SQLException;
	/**
	 * 환자 등록번호를 입력 받아서 해당 환자를 삭제한다
	 * @param 삭제할 환자 등록번호
	 * @return 성공여부
	 */
	boolean deletePatient(int number) throws SQLException;

}
