package org.example.controller;


public interface Board {
    void display();
    void reset();
    boolean isValidPosition(Position position);
}
