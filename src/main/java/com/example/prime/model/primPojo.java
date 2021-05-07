package com.example.prime.model;

import java.util.List;

public class primPojo {

	private int initial;
	private List<Integer> priimes;

	public primPojo(int initial, List<Integer> priimes) {
		this.initial = initial;
		this.priimes = priimes;
		 
	}

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public List<Integer> getPriimes() {
		return priimes;
	}

	public void setPriimes(List<Integer> priimes) {
		this.priimes = priimes;
	}

}