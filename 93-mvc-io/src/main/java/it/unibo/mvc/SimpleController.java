package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SimpleController.
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String nextString;

    @Override
    public void setNextString(final String nextString) {
        Objects.requireNonNull(nextString, "The input string can't be null");
        this.nextString = nextString;
    }

    @Override
    public String getNextString() {
        controlOnnextString();
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(this.history);
    }

    @Override
    public void printCurrentString() {
        controlOnnextString();
        System.out.println("The current string is : " + nextString); //NOPMD
        // The exercise need output on console
        history.add(nextString);
    }

    private void controlOnnextString() {
        if (this.nextString == null) {
            throw new IllegalStateException("The next string is unset");
        }
    }
}
