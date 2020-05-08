package geektrust.tameofthrones.validation.service;

import java.io.File;

public interface FileValidation {

    File getValidFile(String filePath)throws IllegalArgumentException;
}
