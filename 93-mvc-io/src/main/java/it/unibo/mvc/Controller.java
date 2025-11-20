package it.unibo.mvc;

import java.util.List;

/**
 * Controller: model a simple controller
 * responsible of I/O access.
 */
public interface Controller {
    /* It considers only the standard output, and it is able to print on it. */

    /**
     * This method sets the next string to print.
     * 
     * @param nextString th string we want to print
     */
    void setNextString(String nextString);

    /**
     * This method gets the next string to print.
     * 
     * @return the next string to print
     */
    String getNextString();

    /**
     * This method gets the next history of the printed strings.
     * 
     * @return the history of the printed strings
     */
    List<String> getHistory();

    /**
     * This method prints the current string.
     */
    void printCurrentString();
}
