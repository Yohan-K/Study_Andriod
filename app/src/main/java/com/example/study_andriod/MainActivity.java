package com.example.study_andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;
    private Button btn_move;
    private EditText et_test;
    private String str;
    ImageView img_test;
    private ListView list;
    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        btn_test = findViewById(R.id.btn_test);
        btn_move = findViewById(R.id.btn_move);
        et_test = findViewById(R.id.et_test);
        list = (ListView)findViewById(R.id.list);
        et_save = (EditText)findViewById(R.id.et_save);

        // Button
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

        // Image
        img_test = (ImageView)findViewById(R.id.img_test);
        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getApplicationContext() == MainActivity
                Toast.makeText(getApplicationContext(), "이미지 클릭!", Toast.LENGTH_SHORT).show();
            }
        });

        // List
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        data.add("요한킴");
        data.add("맥북");
        data.add("사자");
        adapter.notifyDataSetChanged(); // 저장

        // SharedPreference
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("Kim", "");
        et_save.setText(value);
    }

    // Activity를 벗어났을 때(뒤로 가기나 앱 종료 시 실행)
    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        
        // (EditText)et_save에 입력한 값
        String value = et_save.getText().toString();
        editor.putString("Kim", value);
        editor.commit();
    }
}