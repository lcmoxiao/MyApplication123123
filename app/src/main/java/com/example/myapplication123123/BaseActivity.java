package com.example.myapplication123123;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;


public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if(annotation != null)
        {
            int main_layout_id = annotation.main_layout_id();
            if(main_layout_id > 0)
            {
                setContentView(main_layout_id);
                ButterKnife.bind(this);
            }
            else throw new RuntimeException("main_layout_id < 0");
        }
        else throw new RuntimeException("annotation == null");
    }
}
