package com.example.rosvinz.myminesweeper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    MyCustomview[][] buttons;
    GridLayout grid = (GridLayout) findViewById(R.id.gridlay);
    boolean ingame = true;
    int i;
    int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        int r1;
        int r2;


        for(i = 1; i <= 10; i++) {
            for (j = 1; j <= 10; j++) {
                buttons[i][j] = new MyCustomview((Button) grid.getChildAt(i * 10 + j));
            }
        }

        for(int b = 1; b <= 20; b++) {
            r1 = random.nextInt(10);
            r2 = random.nextInt(10);
            buttons[r1][r2].setbomb();
        }

        for(i = 1; i <= 10; i++) {
            for (j = 1; j <= 10; j++) {
                buttons[i][j].button.setText(" ");
                setnumber(buttons[i][j],i,j);
                buttons[i][j].button.setTextColor(Color.BLACK);
                buttons[i][j].button.setOnClickListener(new View.OnClickListener() {
                    int k = i;
                    int l = j;

                    @Override
                    public void onClick(View v) {

                        if(buttons[k][l].isbomb()) {
                            buttons[k][l].button.setText("M");
                            ingame = false;
                        }
                        else {
                            buttons[k][l].button.setText(buttons[k][l].getnumber());
                        }
                    }
                });
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setnumber(MyCustomview v, int i, int j) {
        int c = 0;
        if (!((j - 1) % 10 == 0 || i == 1)) { //top left case
            c += v.intisbomb();
        }
        if (!(i == 1)) { //top case
            c += v.intisbomb();
        }
        if (!((j - 1) % 10 == 9 || i == 1)) { //top right case
            c += v.intisbomb();
        }
        if (!((j - 1) % 10 == 0)) { //left case
            c += v.intisbomb();
        }
        if (!((j - 1) % 10 == 9)) { //right case
            c += v.intisbomb();
        }
        if (!((j - 1) % 10 == 0 || i == 10)) { //bot left case
            c += v.intisbomb();
        }
        if (!(i == 10)) { //bot case
            c += v.intisbomb();
        }
        if (!((j - 1) % 10 == 9 || i == 10)) {
            c += v.intisbomb();
        }
        v.setnumber(c);
    }
}
