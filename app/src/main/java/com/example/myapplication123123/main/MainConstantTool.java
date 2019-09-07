package com.example.myapplication123123.main;

import androidx.annotation.IntDef;

import static com.example.myapplication123123.main.MainConstantTool.BEIJING;
import static com.example.myapplication123123.main.MainConstantTool.SHANGHAI;
import static com.example.myapplication123123.main.MainConstantTool.HANGZHOU;
import static com.example.myapplication123123.main.MainConstantTool.SHENZHEN;

@IntDef({SHANGHAI,HANGZHOU,BEIJING,SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
