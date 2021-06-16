package com.example.sm;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText mEmailEt, mPasswordEt;
    TextView notHaveAccntTv;
    Button mLoginBtn;
    private FirebaseAuth mAuth;
    //ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        mEmailEt = findViewById(R.id.emailEt);
        mPasswordEt = findViewById(R.id.passwordEt);
        notHaveAccntTv = findViewById(R.id.notHaveAccntTv);
        mLoginBtn = findViewById(R.id.login_btn);


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void loginUser(String email, String passw) {
        //pd.show();
        mAuth.signInWithEmailAndPassword(email, passw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //pd.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                            finish();
                        } else {
                            //pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }

                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //pd.dismiss();
                Toast.makeText(LoginActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void onLoginButton(View view) {
        String email = mEmailEt.getText().toString();
        String passw = mPasswordEt.getText().toString();
       // if(email.contains("@") && passw.length()>5)
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            loginUser(email, passw);
        }
        else{
            Toast.makeText(this,  "Email or password wrong!", Toast.LENGTH_SHORT).show();
        }
    }




    public void onNotHaveText(View view) {
        startActivity(new Intent( LoginActivity.this, RegisterActivity.class));

    }
}