package org.example.Model;


public interface Board {
    void display();
    void reset();
    boolean isValidPosition(Cell cell);
}
