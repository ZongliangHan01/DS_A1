package server;

import java.util.List;
import java.util.ArrayList;

public class Word {
    private String word;
    private String meaning;
//    private List<String> stringList = new ArrayList<>();

    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public Word() {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}