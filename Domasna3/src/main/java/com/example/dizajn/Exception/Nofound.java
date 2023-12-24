package com.example.dizajn.Exception;

public class Nofound extends RuntimeException{

    public Nofound() {
        super("User is not found!");
    }
}
