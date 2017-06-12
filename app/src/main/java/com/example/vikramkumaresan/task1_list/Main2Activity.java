package com.example.vikramkumaresan.task1_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView out = (TextView)findViewById(R.id.txt);

        Bundle data = getIntent().getExtras();

        out.setText(data.getString("Data"));

    }
}
