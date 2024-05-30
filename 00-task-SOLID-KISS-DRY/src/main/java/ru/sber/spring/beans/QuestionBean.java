package ru.sber.spring.beans;

import com.opencsv.bean.CsvBindByName;

public class QuestionBean extends CsvBean {

    @CsvBindByName(column = "question")
    private String question;

    @CsvBindByName(column = "answer")
    private String answer;

    @CsvBindByName(column = "correct")
    private Boolean correct;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return  "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", correct=" + correct;
    }
}