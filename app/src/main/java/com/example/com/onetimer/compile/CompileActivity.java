package com.example.com.onetimer.compile;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.onetimer.R;

import java.io.File;

public class CompileActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView clean;
    private ImageView videobtn;
    private ImageView duanzibtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compile);
        clean =findViewById(R.id.clean);
        clean.setOnClickListener(this);
        videobtn = findViewById(R.id.videobtn);
        videobtn.setOnClickListener(this);
        duanzibtn = findViewById(R.id.duanzibtn);
        duanzibtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clean:
                finish();
                break;
            case R.id.videobtn:
                Intent intent = new Intent(CompileActivity.this,VideoActivity.class);
                startActivity(intent);
                break;
            case R.id.duanzibtn:
                break;
        }
    }
}
