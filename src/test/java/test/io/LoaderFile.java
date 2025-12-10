package test.io;

import java.io.File;
import java.util.stream.Stream;

public interface LoaderFile {
    public Stream getFile(String path);
}
