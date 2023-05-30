package com.we.exception;

public class ItemOutOfStockException extends Exception {
	public ItemOutOfStockException(String message) {
        super(message);
    }
}
