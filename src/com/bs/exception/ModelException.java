package com.bs.exception;

public class ModelException extends Exception{
	private int error;//�������
	public int getError() {
		return error;
	}
	public ModelException(int error,String message) {
		super(message);
	    this.error = error;
	}
}
