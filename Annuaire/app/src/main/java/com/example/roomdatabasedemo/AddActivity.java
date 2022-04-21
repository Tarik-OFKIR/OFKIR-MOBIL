package com.example.roomdatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AddActivity extends AppCompatActivity {

//    private EditText nome,prenom,email,phone,job;
//    RoomDB roomDB;
//    private Button btt_add;
//
//    RoomDB database;
    private EditText nome,prenom,email,phone,job;
    private Button btt_add;
    RoomDB roomDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        roomDB=RoomDB.getInstance(this);

        nome= findViewById( R.id.editTextFistName );
        prenom = findViewById( R.id.editTextLastName );
        job = findViewById( R.id.editTextJob);
        phone = findViewById( R.id.editTextPhone );
        email = findViewById( R.id.editTextEmail );

        btt_add = findViewById( R.id.btnAdd );


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get string from edit text
                String sFirstName = firstName.getText().toString().trim();
                String sLastName = lastName.getText().toString().trim();
                String sJob = job.getText().toString().trim();
                 String sPhone = phone.getText().toString().trim();
                String sEmail = email.getText().toString().trim();

                // check condition
                if((!sFirstName.equals("") || !sLastName.equals("")) && !phone.equals("") )
                 {
                    // when text is not empty
                    // initialize main data
                    MainData data=new MainData();

                    //Set text on main data
                     data.setFirst_name( sFirstName );
                     data.setLast_name( sLastName );
                     data.setJob( sJob );
                     data.setPhone( sPhone );
                     data.setEmail( sEmail );


                    //Insert text in database
                    database.mainDao().insert(data);

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName.getText().clear();
                lastName.getText().clear();
                job.getText().clear();
                phone.getText().clear();
                email.getText().clear();
            }
        });

    }
}
