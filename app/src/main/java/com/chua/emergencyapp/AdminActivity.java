package com.chua.emergencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdminActivity extends AppCompatActivity {

    private ImageView displayPic;
    private TextView displayName, userRole;
    private Button logoutBtn;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mRef = firebaseDatabase.getReference();

        displayPic = (ImageView) findViewById(R.id.displayPic);
        displayName = (TextView) findViewById(R.id.displayName);
        userRole = (TextView) findViewById(R.id.userRole);
        logoutBtn = (Button) findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(AdminActivity.this,LoginActivity.class));
            }
        });

//        Glide.with(this).load(mUser.getPhotoUrl()).into(displayPic);
//        displayName.setText();

        mRef = firebaseDatabase.getReference().child("Users").child(mUser.getUid());
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users user = dataSnapshot.getValue(Users.class);
                Log.d("bernard", user.getName());
                Glide.with(AdminActivity.this).load(user.getDisplayPicture()).into(displayPic);
                displayName.setText(user.getName());
                userRole.setText(user.getRole());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
