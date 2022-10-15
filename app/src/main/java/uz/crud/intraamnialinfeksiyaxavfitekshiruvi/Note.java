package uz.crud.intraamnialinfeksiyaxavfitekshiruvi;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Note {

    private int questionId;
    private String questionTitle;
    private int questionType;
    private String[] questionOptions;
    private int[] questionOptionsBall;

    public Note(int questionId, String questionTitle, int questionType, String[] questionOptions, int[] questionOptionsBall) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionType = questionType;
        this.questionOptions = questionOptions;
        this.questionOptionsBall = questionOptionsBall;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String[] getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String[] questionOptions) {
        this.questionOptions = questionOptions;
    }

    public int[] getQuestionOptionsBall() {
        return questionOptionsBall;
    }

    public void setQuestionOptionsBall(int[] questionOptionsBall) {
        this.questionOptionsBall = questionOptionsBall;
    }
}
