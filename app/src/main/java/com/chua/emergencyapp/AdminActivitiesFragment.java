package com.chua.emergencyapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Acer on 14/05/2017.
 */

public class AdminActivitiesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_layout,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mRef = firebaseDatabase.getReference();

        ArrayList<String> test = new ArrayList<>();
        final ArrayList<Posts> postArray = new ArrayList<>();

        Query query = mRef.child("Posts")
                .child(mUser.getUid());

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Posts posts = dataSnapshot.getValue(Posts.class);
                postArray.add(posts);
                adapter = new AdminActivitiesAdapter(getActivity(),postArray);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


//        Posts post = new Posts("yolanda","please press the safe button if you receive this broadcast", "123",test);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        postArray.add(post);
//        adapter = new AdminActivitiesAdapter(getActivity(),postArray);
//        recyclerView.setAdapter(adapter);
        //END OF TEST
        return rootView;
    }
}
