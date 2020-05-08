package geektrust.tameofthrones.validation.service.implementation;

import geektrust.tameofthrones.validation.service.FileValidation;

import java.io.File;

public class FileValidationImpl implements FileValidation {

    @Override
    public File getValidFile(String filePath) throws IllegalArgumentException {
        File inputFile = new File(filePath);
        if(doesFileNotExist(inputFile))
            throw new IllegalArgumentException("Invalid file path. File does not exists");
        return inputFile;
    }

    private boolean doesFileNotExist(File file) {
        return file.exists() == false;
    }
}
