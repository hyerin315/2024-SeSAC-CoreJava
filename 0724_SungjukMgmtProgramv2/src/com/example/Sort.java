package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
	private List<StudentVO> list ;

	public Sort(List<StudentVO> list) {
		this.list = list;
	}
	public void quickSorting() {
		Collections.sort(this.list, (front,  back) -> back.getTot() - front.getTot());
	}
}