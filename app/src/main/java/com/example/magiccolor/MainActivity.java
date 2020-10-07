package com.example.magiccolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int color= R.color.colorAccent;
        int color2= R.color.colorPrimary;
        int color3= R.color.colorPrimaryDark;
        setContentView(R.layout.activity_main);

//        MagicText magicText = findViewById(R.id.text);
//        String test = "My name is Khan";
//        String[] sub_string = {"ha", "a"};
//        String[] style = {"Italic", "Bold"};
//        int[] size = {23, 12, 45};
//        int[] color = {R.color.colorPrimary, R.color.colorAccent,};
//
//        magicText.change(test, color, size, style, sub_string);
    }
}
