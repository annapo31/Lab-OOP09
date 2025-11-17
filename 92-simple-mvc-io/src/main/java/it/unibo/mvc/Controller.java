package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_FILE = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";

    private File currentFile;
    
    /* Method for setting a File as current file */
    public void setFile (final File inputFile) {
        this.currentFile = inputFile;
    }

    /* Method for getting the current File */
    public File getFile () {
        return this.currentFile;
    }

    /* Method for getting the PATH of the current File */
    public String getPath () {
        return this.currentFile.getAbsolutePath();
    }

    /* Method that gets a `String` as input and saves its content on the current file */
    public void writeTheString (final String s) throws IOException{
        try (PrintStream ps = new PrintStream(DEFAULT_FILE, StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (final IOException e) {
            System.out.println("This function cause an IoException");
            e.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }
}
