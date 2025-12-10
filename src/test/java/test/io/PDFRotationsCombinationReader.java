package test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class PDFRotationsCombinationReader implements CombinationReader {
    @Override
    public  Stream getFile(String path) {
        try {
            return new FileReader(path).readAllLines().stream();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static PDFRotationsCombinationReader instance() {
        return new PDFRotationsCombinationReader();
    }
}
