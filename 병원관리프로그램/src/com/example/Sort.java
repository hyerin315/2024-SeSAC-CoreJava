package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
	private List<Patient> list;
	
	public Sort(List<Patient> list) {
		this.list = list;
	}

	public void quickSort() {
		Collections.sort(this.list, new Comparator<Patient>() {
			@Override
			public int compare(Patient front, Patient back) {
				return front.getNumber() - back.getNumber();
			}
		});
	}

}
