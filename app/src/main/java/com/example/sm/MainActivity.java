package com.example.sm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

    public class MainActivity extends AppCompatActivity {

        Button mRegisterBtn,mLoginBtn;
        //1.merrne NOX emulator se qeky jau kill laptopin , edhe te xml kto dizajni provone me bo me relativelayout se qashtu osht ma response
        //u be a je tu e provu a met prit a jo, jo del soeke j besoj qe bon haha qokay, se ili u hi mu pastru e spo di qysh ja ka lon ajo emoakial edhe pass
        // okay pra qe ka najsen tregomni flm shume <3 hahah nihem

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mRegisterBtn= findViewById(R.id.register_btn);
            mLoginBtn= findViewById(R.id.login_btn);


            mRegisterBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                }

            });

            mLoginBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent( MainActivity.this, LoginActivity.class));
                }
            });

        }
    }
