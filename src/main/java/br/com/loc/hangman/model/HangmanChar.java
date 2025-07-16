package br.com.loc.hangman.model;


public class HangmanChar {

    private final char character;
    private boolean isVisible;
    private int position;


    public HangmanChar(char character) {
        this.character = character;
        this.isVisible = false;
    }

    public HangmanChar(char character, int position) {
        this.character = character;
        this.position = position;
        this.isVisible = true;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isInvisible() {
        return !isVisible;
    }

    public void enableVisibility() {
        isVisible = true;
    }

    public int getPosition() {
        return position;
    }


    public void setPosition(int position) {
        this.position = position;
    }


    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof HangmanChar that)) return false;

        return getCharacter() == that.getCharacter() && isVisible() == that.isVisible() && getPosition() == that.getPosition();
    }

    @Override
    public int hashCode() {
        int result = getCharacter();
        result = 31 * result + Boolean.hashCode(isVisible());
        result = 31 * result + getPosition();
        return result;
    }

    @Override
    public String toString() {
        return "hangmanChar{" +
                "character=" + character +
                ", isVisible=" + isVisible +
                ", position=" + position +
                '}';
    }
}
