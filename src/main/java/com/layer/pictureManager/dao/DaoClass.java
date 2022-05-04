package com.layer.pictureManager.dao;

public class DaoClass {

	public int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
}
