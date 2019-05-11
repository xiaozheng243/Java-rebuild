package javabasic;

public enum  EnumDemo {

    EDIT(0),SUBMITED(1),DONE(3){
//        int getInnerValue(){
//
//        }
    };

    private int value1;
    EnumDemo(int value1){
        this.value1=value1;
    }
}
