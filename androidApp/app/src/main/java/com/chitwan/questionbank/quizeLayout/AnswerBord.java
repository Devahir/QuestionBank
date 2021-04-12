package com.chitwan.questionbank.quizeLayout;

public class AnswerBord {
    String[] optino={"1000","0100","0010","0001"};
    String Ans;
    public AnswerBord(String s){
        this.Ans=s;
    }
    public boolean check(String op){
        if(Ans.equals(op)){
            return true;
        }
        return false;
    }
}
