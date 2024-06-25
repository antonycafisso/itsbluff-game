package com.project.itsbluff.word;

public class WordMeaningDTO {
    private String definition;
    private String word;
    private boolean valid;

    public WordMeaningDTO() {

    }

    public WordMeaningDTO(String definition, boolean valid, String word) {
        this.definition = definition;
        this.valid = valid;
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
