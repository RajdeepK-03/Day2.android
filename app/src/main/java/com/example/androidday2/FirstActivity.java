package com.example.androidday2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtName;
    private Button btnGoNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edtName = findViewById(R.id.edtPersonName);
        btnGoNext = findViewById(R.id.btnNext);

        btnGoNext.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (edtName.getText().toString().trim().length()!=0)
        {
            Intent mIntent = new Intent(FirstActivity.this, SecondActivity.class);
            mIntent.putExtra("name", edtName.getText().toString());
            startActivity(mIntent);
        }
        else
            {
            edtName.setError("please Enter Name");
        }
    }
    private void showAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.ic_action_name);
        alertDialogBuilder.setTitle("Login error");
        alertDialogBuilder.setMessage("Enter your Name");
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //alertDialogBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_action_name));

        AlertDialog mAlertDialog = alertDialogBuilder.create();
        mAlertDialog.show();
    }

}
