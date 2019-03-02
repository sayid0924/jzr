package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/16.
 */

public class CheckedListBean {

    private  String title;
    private  int titleId;
    private List<Answer> answers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }




    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public static class  Answer{
        private  String answer;
        private  int id;

       public String getAnswer() {
           return answer;
       }

       public void setAnswer(String answer) {
           this.answer = answer;
       }

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }
   }

}
