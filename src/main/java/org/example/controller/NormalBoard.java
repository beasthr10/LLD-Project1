package org.example.controller;

import java.util.List;

public class NormalBoard implements Board{
    private int size;
    private List<List<Cell>> board;

    @Override
    public void display() {}

    @Override
    public void reset() {

    }

    @Override
    public boolean isValidPosition(Position position) {
        return false;
    }
}
