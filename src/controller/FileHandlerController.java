package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandlerController {

    public static void writeObject(String pathName, Object object) {
        Path path = Paths.get(pathName);

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T readObject(String pathName) {
        Path path = Paths.get(pathName);
        T object = null;

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            object = (T) ois.readObject();
        } catch (Exception e ) {
            e.printStackTrace();
        }

        return object;
    }
}
