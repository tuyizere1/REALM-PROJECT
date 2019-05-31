package com.paccy.realmloginvideoplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class SignUpActivity extends AppCompatActivity {

    private EditText etName,etEmail,etUname,etPass;
    private Button btnReg;
    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUname = (EditText) findViewById(R.id.etUname);
        etPass = (EditText) findViewById(R.id.etPass);
        btnReg = (Button) findViewById(R.id.btnReg);

         realm = Realm.getDefaultInstance();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(etName.length()>0 && etEmail.length()>0 && etUname.length()>0 && etPass.length()>0)
               {
                   realm.beginTransaction();
                   Users user = realm.createObject(Users.class);
                   user.setName(etName.getText().toString());
                   user.setEmail(etEmail.getText().toString());
                   user.setUsername(etUname.getText().toString());
                   user.setPassword(etPass.getText().toString());
                   realm.commitTransaction();
                   Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(intent);
               }

               else
               {
                   Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_SHORT).show();
               }

            }
        });
    }
}
