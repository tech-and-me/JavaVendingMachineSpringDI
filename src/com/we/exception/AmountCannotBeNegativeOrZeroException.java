package com.we.exception;

public class AmountCannotBeNegativeOrZeroException extends Exception {
	public AmountCannotBeNegativeOrZeroException(String message) {
		super(message);
	}
}
