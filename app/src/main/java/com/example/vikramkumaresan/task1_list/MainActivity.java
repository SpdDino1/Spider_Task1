package com.example.vikramkumaresan.task1_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button inputbutton;
    Button deletebutton;

    EditText inputelement;
    EditText deleteelement;

    ArrayAdapter adapt;

    ArrayList<String> stuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To auto pan when the keyboard pops up and hides things
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        inputbutton=(Button)findViewById(R.id.appendbutton);
        deletebutton=(Button)findViewById(R.id.deletebutton);
        inputelement=(EditText)findViewById(R.id.append);
        deleteelement=(EditText)findViewById(R.id.delete);

        stuff = new ArrayList<String>();

        ListView list = (ListView) findViewById(R.id.list);
        adapt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stuff);
        list.setAdapter(adapt);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(getBaseContext(),Main2Activity.class);
                        i.putExtra("Data",parent.getItemAtPosition(position).toString());
                        startActivity(i);
                    }
                }
        );
    }

    void enqueue(View view){
        stuff.add(inputelement.getText().toString());
        inputelement.setText("");
        adapt.notifyDataSetChanged();
    }

    void dequeue(View view){
        int flag=0;

        try {
            int pos = Integer.parseInt(deleteelement.getText().toString());
        }
        catch (Exception e){
            flag=1;
            if(deleteelement.getText().toString().equals("")){
                Toast.makeText(getBaseContext(),"Enter Position",Toast.LENGTH_SHORT).show();
            }
            else {
            Toast.makeText(getBaseContext(),"Invalid Position",Toast.LENGTH_SHORT).show();
            }
            deleteelement.setText("");
        }

        if(flag==0){    //If type cast completed
            try {
                stuff.remove(Integer.parseInt(deleteelement.getText().toString()));
                adapt.notifyDataSetChanged();
            }catch (Exception e){
                Toast.makeText(getBaseContext(),"Position Vacant",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
