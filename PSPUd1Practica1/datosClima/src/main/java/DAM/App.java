package DAM;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Path dir = Paths.get("D:\\Users\\dam\\Documents\\Servicios\\ficheros");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path: stream) {
                String content = new String(Files.readAllBytes(path));
                Gson gson = new Gson();
                Diario d = gson.fromJson(content, Diario.class);
                System.out.println(d.nombre + " " + d.fecha);
                //System.out.println(path.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
        
    }
}
