package com.example.sdiointernslimited;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sdiointernslimited.Models.Students;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecordActivity extends AppCompatActivity {
    EditText etName, etClass, etSection, etRollNo, etSchool, etGender, etAge;
    Button bt1, bt2;
    DatabaseReference studentDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        etName = findViewById(R.id.stuname);
        etClass = findViewById(R.id.stuclass);
        etSection = findViewById(R.id.stusection);
        etRollNo = findViewById(R.id.sturoll);
        etSchool = findViewById(R.id.stuschool);
        etGender = findViewById(R.id.stugen);
        etAge = findViewById(R.id.stuage);
        bt1 = findViewById(R.id.addrec);



        studentDbRef = FirebaseDatabase.getInstance().getReference().child("Students");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertStudentData();
            }
        });
    }

    private void insertStudentData(){
        String etname = etName.getText().toString();
        String etclass = etClass.getText().toString();
        String etsection = etSection.getText().toString();
        String etrollno = etRollNo.getText().toString();
        String etschool = etSchool.getText().toString();

        Students students = new Students(etname, etclass, etsection, etrollno, etschool);

        studentDbRef.push().setValue(students);
        Toast.makeText(RecordActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
    }

}