package com.example.rosvinz.myminesweeper;

import android.content.Context;
import android.widget.Button;

/**
 * Created by rosvinz on 30/03/2016.
 */
public class MyCustomview {
    public Button button;
    private boolean bomb;
    private int number;

    public MyCustomview(Button button){
        this.button = button;
        bomb = false;
        number = 0;
    }

    public void setbomb(){
        bomb = true;
    }

    public boolean isbomb() {
        return bomb;
    }

    public int intisbomb() {
        if (bomb)
            return 1;
        return 0;
    }

    public void setnumber(int a) {
        number = a;
    }

    public int getnumber() {
        return number;
    }
}
