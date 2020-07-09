package com.two.zhyy.patient.exception;

public class OverLoadException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OverLoadException(String time) {
		super(String.format(time+"未到挂号时间请，请重新选则"));
	}

	public OverLoadException() {
		super(String.format("挂号人员已满,请选择其他医师或者其他时间段"));
	}
}
