package org.example.json;

public class BoardDeserializer {
    private String type;
    private int numOfSquares;

    public BoardDeserializer(String type, int numOfSquares) {
        this.type = type;
        this.numOfSquares = numOfSquares;
    }

    public BoardDeserializer() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumOfSquares() {
        return numOfSquares;
    }

    public void setNumOfSquares(int numOfSquares) {
        this.numOfSquares = numOfSquares;
    }
}
