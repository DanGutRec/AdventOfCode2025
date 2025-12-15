package test.io;

import java.io.FileReader;
import java.util.stream.Stream;

public class TXTRotationsCombinationReader implements CombinationReader {
    private static TXTRotationsCombinationReader instance;
    @Override
    public  Stream getFile(String path) {
        try {
            return new FileReader(path).readAllLines().stream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static TXTRotationsCombinationReader instance() {
        if (instance== null ) instance = new TXTRotationsCombinationReader();
        return instance;
    }
}
