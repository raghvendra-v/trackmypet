package com.trackmypet.demo.model;

public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
