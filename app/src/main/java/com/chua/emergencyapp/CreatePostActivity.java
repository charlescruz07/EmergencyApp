package com.chua.emergencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CreatePostActivity extends AppCompatActivity {

    private EditText postTitle,postDesc;
    private Button postBtn;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        postTitle = (EditText) findViewById(R.id.titleTxt);
        postDesc = (EditText) findViewById(R.id.descriptionTxt);
        postBtn = (Button) findViewById(R.id.postBtn);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        firebaseDatabase = FirebaseDatabase.getInstance();
        mRef = firebaseDatabase.getReference();

        //GETTING THE DATE
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        final String formattedDate = df.format(c.getTime());
        //END OF GETTING DATE

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posts posts = new Posts(postTitle.getText().toString(),postDesc.getText().toString(),formattedDate);
                mRef.child("Posts").child(mUser.getUid()).push().setValue(posts);
                finish();
                startActivity(new Intent(CreatePostActivity.this,AdminActivity.class));
            }
        });
    }
}
