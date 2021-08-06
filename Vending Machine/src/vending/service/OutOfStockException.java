package vending.service;


public class OutOfStockException extends Exception {

    public OutOfStockException() {
    }

    public OutOfStockException(String msg) {
        super(msg);
    }
}
