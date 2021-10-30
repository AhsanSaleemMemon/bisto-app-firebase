package com.ahsansaleem.i170303_i170364;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ContactFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ContactProfile> list;
    private ContactAdapter contactAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contactFragment =  inflater.inflate(R.layout.fragment_contact, container, false);

        recyclerView = contactFragment.findViewById(R.id.contacts_recycler_view);
        list = new ArrayList<>();


        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));

        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));

        contactAdapter = new ContactAdapter(list, getContext());
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(contactFragment.getContext()));


        return contactFragment;
    }
}