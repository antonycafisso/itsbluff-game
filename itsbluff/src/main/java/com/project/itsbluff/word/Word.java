package com.project.itsbluff.word;

public class Word {
    String content;
    boolean exits;
    String meaning;

    public Word() {

    }

    public Word(String content) {
        this.content = content;
    }

    public Word(String content, boolean exits) {
        this.content = content;
        this.exits = exits;
    }

    public Word(String content, boolean exits, String meaning) {
        this.content = content;
        this.exits = exits;
        this.meaning = meaning;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isExits() {
        return exits;
    }

    public void setExits(boolean exits) {
        this.exits = exits;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(content);
        return sb.toString();
    }

}
