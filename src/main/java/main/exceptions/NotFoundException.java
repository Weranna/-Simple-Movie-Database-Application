package main.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Integer id) {
        super("Could not found the entity with id " + id);
    }
}
