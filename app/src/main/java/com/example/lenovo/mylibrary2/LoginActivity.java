package com.example.lenovo.mylibrary2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText et_email, et_pass;
    Button bt_login;
    TextView tv_gagal;
    CheckBox ck_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = (EditText) findViewById(R.id.et_email);
        et_pass = (EditText) findViewById(R.id.et_pass);
        tv_gagal = (TextView) findViewById(R.id.tv_gagal);
        bt_login = (Button) findViewById( R.id.bt_login);


        final EditText ed = (EditText) findViewById(R.id.et_pass);
        CheckBox c = (CheckBox)findViewById(R.id.ck_show);

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked){
                    ed.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else {
                    ed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member = new Member(et_email.getText().toString());
                if (member.getId_member() !=null && member.getPassword().equals(et_pass.getText().toString())){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("members", member);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    et_email.setText(" ");
                    et_pass.setText(" ");
                    et_email.requestFocus();
                }
            }
        });

        et_email.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v , int keyCode, KeyEvent event) {
                tv_gagal.setVisibility(View.INVISIBLE);
                return false;
            }
        });

    }
}
