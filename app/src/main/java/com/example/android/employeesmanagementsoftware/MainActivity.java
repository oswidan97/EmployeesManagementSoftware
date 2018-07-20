package com.example.android.employeesmanagementsoftware;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//         TasksFragment fragment = new TasksFragment();
//         getSupportFragmentManager()
//                 .beginTransaction()
//                 .replace(R.id.frame, fragment)
//                 .commit();
        Button emp = (Button)findViewById(R.id.emp);
        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent employeeActivity = new Intent(MainActivity.this,EmployeeActivity.class);
                startActivity(employeeActivity);
            }
        });

        Button dep = (Button)findViewById(R.id.dep);
        dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departementActivity = new Intent(MainActivity.this,DepartmentActivity.class);
                startActivity(departementActivity);
            }
        });
    }
}