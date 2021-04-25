package com.builddream.admin_svmit_college;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.addNotice);

        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (cardView.getId()){
            case R.id.addNotice:
                Intent intent=new Intent(MainActivity.this,UploadNotice.class);
                startActivity(intent);
                break;
        }
    }
}