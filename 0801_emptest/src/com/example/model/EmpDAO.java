package com.example.model;

import java.sql.SQLException;
import java.util.List;

/*
 * Author : Hyerin Lim
 * When : Aug, 01, 2024
 * Objective : 데이터베이스와 상호작용하기 위해 사원 데이타를 등록하고 반환하는 DAO 객체입니다.
 * Environment : Windows 10 22H2(OS build 19045.4651), openjdk 17.0.11, IntelliJ 2024.1.4
 */

public interface EmpDAO {
	/**
	 * 새로운 사원 데이타를 등록한다
	 * 이미 등록된 사원이 있다면 false를 리턴하고, 등록에 성곡하면 true를 리턴한다
	 * @param Emp
	 * @return 등록 성공하면 True, 그렇지 않으면 False
	 */
	boolean createEmp(EmpVO emp) throws SQLException;
	/**
	 * 지금까지 등록된 모든 사원 리스트를 반환한다
	 * @return 사원형 리스트
	 */
	List<EmpVO> readAllEmp() throws SQLException; // 모든 사원 리턴
}
