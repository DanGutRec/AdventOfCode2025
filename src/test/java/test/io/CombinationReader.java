package test.io;

import java.net.URL;
import java.util.stream.Stream;

public interface CombinationReader {
    public Stream getFile(String path);
}
