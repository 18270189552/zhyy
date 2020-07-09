package com.two.zhyy.patient.exception;

import java.math.BigDecimal;

public class NoMoneyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoMoneyException(int from,BigDecimal money) {
		super(String.format("账号: %d, 转账: %.2f 余额不足", from,money.doubleValue()));
	}
	
	public NoMoneyException() {
		super(String.format("该患者已挂号"));
	}

}
