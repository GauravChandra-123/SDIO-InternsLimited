package com.example.sdiointernslimited;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sdiointernslimited.Models.Users;
import com.example.sdiointernslimited.databinding.ActivitySignUpPageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpPage extends AppCompatActivity {

    ActivitySignUpPageBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(SignUpPage.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are creating your account");
        txt1 = findViewById(R.id.alreadyhaveaccount);


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.emailaddress.getText().toString(), binding.password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressDialog.dismiss();

                                if (task.isSuccessful()){

                                    Intent intent = new Intent(SignUpPage.this, LoginActivity.class);
                                    startActivity(intent);


                                    Users users = new Users(binding.username.getText().toString(), binding.emailaddress.getText().toString(), binding.password.getText().toString(), binding.city.getText().toString(), binding.mobno.getText().toString());

                                    String id = task.getResult().getUser().getUid();
                                    database.getReference().child("Users").child(id).setValue(users);

                                    Toast.makeText(SignUpPage.this, "User Created Successfully", Toast.LENGTH_LONG).show();
                                }
                                else {

                                    Toast.makeText(SignUpPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }


                            }
                        });
            }
        });
    }
}