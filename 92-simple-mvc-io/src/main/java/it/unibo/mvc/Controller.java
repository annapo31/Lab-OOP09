package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    private static final String DEFAULT_FILE = "output.txt";
    private static final String HOME_FOLDER = System.getProperty("user.home");

    /* By default, the current file is "output.txt" inside the user home folder */
    private File currentFile = new File(
            HOME_FOLDER
            + System.getProperty("file.separator")
            + DEFAULT_FILE
        );

    /**
     * Method for setting a File as current file.
     * 
     * @param inputFile the file to set as current file
     */
    public void setFile(final File inputFile) {
        this.currentFile = inputFile;
    }

    /**
     * Method for getting the current File.
     * 
     * @return the current file 
     */
    public File getFile() {
        return this.currentFile;
    }

    /**
     * Method for getting the PATH of the current File.
     * 
     * @return the path of the current file
     */
    public String getPath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Method for getting the PATH of the current File.
     * 
     * @param s the string we wuold like to write
     * 
     * @throws IOException if the writing fails
     */
    public void writeTheString(final String s) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (final IOException e) {
            System.out.println(
                "IOException, inable to write string [" + s + "] in the file"
            );
            e.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }
}
