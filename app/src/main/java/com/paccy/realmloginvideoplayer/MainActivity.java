package com.paccy.realmloginvideoplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private EditText etuName,etPass;
    private Button btnLogin,btnSignup;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);

        etuName = (EditText) findViewById(R.id.etUname);
        etPass = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);

        realm = Realm.getDefaultInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = etuName.getText().toString();
                String pass = etPass.getText().toString();
                realm.beginTransaction();
                RealmQuery<Users> query = realm.where(Users.class);
                RealmResults<Users> usr = query.findAll();
                realm.commitTransaction();
                int flag=0;
                for(Users x:usr)
                {
                    if(x.getUsername().equals(uname) && x.getPassword().equals(pass))
                    {
                        flag=1;
                        break;
                    }

                }
                if(flag==1)
                {
                    Intent intent = new Intent(getApplicationContext(), VideoPlayer.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
