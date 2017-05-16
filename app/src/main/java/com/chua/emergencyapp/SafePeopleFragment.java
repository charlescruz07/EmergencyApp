package com.chua.emergencyapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Acer on 16/05/2017.
 */

public class SafePeopleFragment extends Fragment {

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
        layoutManager = new GridLayoutManager(rootView.getContext(),1,GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mRef = firebaseDatabase.getReference();

        ArrayList<SafePeople> safePeopleList = new ArrayList<>();
        SafePeople sp = new SafePeople("asd","charles");
        safePeopleList.add(sp);
        safePeopleList.add(sp);
        safePeopleList.add(sp);
        safePeopleList.add(sp);
        safePeopleList.add(sp);
        safePeopleList.add(sp);
        safePeopleList.add(sp);
        safePeopleList.add(sp);

        adapter = new SafePeopleAdapter(getActivity(),safePeopleList);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
