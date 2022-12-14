package com.example.crudoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonViewAll, buttonDelete, buttonUpdate;
    EditText editName, editRollNumber;
    Switch switchIsActive;
    ListView listViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout22);

        buttonUpdate = findViewById(R.id.button4);
        buttonDelete= findViewById(R.id.button3);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.editTextName);
        editRollNumber = findViewById(R.id.editTextRollNumber);
        switchIsActive = findViewById(R.id.switchStudent);
        listViewStudent = findViewById(R.id.listViewStudent);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            Student studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper dbHelper  = new dbHelper(MainActivity.this);
                dbHelper.addStudent(studentModel);

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener()
        {
            Student studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper dbHelper  = new dbHelper(MainActivity.this);

                dbHelper.deleteStudent(studentModel);
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            Student studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper dbHelper  = new dbHelper(MainActivity.this);

                dbHelper.updateStudent(studentModel);
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(MainActivity.this);
                List<Student> list = dbHelper.getAllStudents();
                ArrayAdapter arrayAdapter = new ArrayAdapter<Student>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listViewStudent.setAdapter(arrayAdapter);

            }
        });

    }

}
