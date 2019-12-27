package com.bawei.week_one.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(inniLayout() );
        inniVIew();
        inniDate();

    }

    protected abstract void inniDate();
    protected abstract void inniVIew();

    protected abstract int inniLayout();

}
