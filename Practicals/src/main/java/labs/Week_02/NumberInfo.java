package main.java.labs.Week_02;

public class NumberInfo {
    private int limit;
    private int value;

    public NumberInfo(int limit){
        this.limit = limit;
    }

    public void increment() {
        this.value++;
        this.value = (this.value) % this.limit;
    }

    public int getValue() {
        return value;
    }
}
