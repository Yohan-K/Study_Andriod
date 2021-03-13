package com.example.study_andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;
    private Button btn_move;
    private EditText et_test;
    private String str;
    ImageView img_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        btn_test = findViewById(R.id.btn_test);
        btn_move = findViewById(R.id.btn_move);
        et_test = findViewById(R.id.et_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("요한K");
            }
        });

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_test.getText().toString();
                // 페이지 이동
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", str);
                startActivity(intent); // 액티비티 이동
            }
        });

        img_test = (ImageView)findViewById(R.id.img_test);
        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getApplicationContext() == MainActivity
                Toast.makeText(getApplicationContext(), "이미지 클릭!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}