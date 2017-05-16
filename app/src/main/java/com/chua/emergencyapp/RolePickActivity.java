package com.chua.emergencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RolePickActivity extends AppCompatActivity{

    private LinearLayout adminBtn,memberBtn;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_pick);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mRef = firebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        adminBtn = (LinearLayout) findViewById(R.id.adminBtn);
        memberBtn = (LinearLayout) findViewById(R.id.memberBtn);

        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("bernard","na click ang admin");
                mRef.child("Users").child(user.getUid()).child("role").setValue("Community Administrator");
                finish();
                startActivity(new Intent(RolePickActivity.this,AdminActivity.class));
            }
        });

        memberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.child("Users").child(user.getUid()).child("role").setValue("Community Member");
                finish();
                startActivity(new Intent(RolePickActivity.this,MemberActivity.class));
                //start member activity
            }
        });
    }
}
