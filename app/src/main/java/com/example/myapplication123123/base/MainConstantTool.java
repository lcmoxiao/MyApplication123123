package com.example.myapplication123123.base;

import androidx.annotation.IntDef;

import static com.example.myapplication123123.base.MainConstantTool.BEIJING;
import static com.example.myapplication123123.base.MainConstantTool.SHANGHAI;
import static com.example.myapplication123123.base.MainConstantTool.HANGZHOU;
import static com.example.myapplication123123.base.MainConstantTool.SHENZHEN;


//常亮注释
@IntDef({SHANGHAI,HANGZHOU,BEIJING,SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
