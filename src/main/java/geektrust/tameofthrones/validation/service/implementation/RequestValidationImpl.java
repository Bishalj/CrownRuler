package geektrust.tameofthrones.validation.service.implementation;

import geektrust.tameofthrones.validation.service.RequestValidation;

public class RequestValidationImpl implements RequestValidation {

    @Override
    public boolean isFilePathPresent(String[] arguments) {
        return arguments.length != 0;
    }
}
