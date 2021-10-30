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


public class ChatFragment extends Fragment {

   private RecyclerView chatRecyclerView;
   private List<ChatProfile> list;
   private ChatAdapter chatAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View chatFragment =  inflater.inflate(R.layout.fragment_chat, container, false);

        list = new ArrayList<>();
        chatRecyclerView = chatFragment.findViewById(R.id.chat_recycler_view);

        list.add(new ChatProfile("Ahsan Memon", "I'm in Karachi", "now", "text", true /* sent by a friend */ , true, true,R.drawable.man));
        list.add(new ChatProfile("Ahsan Memon", "I'm in Karachi", "now", "text", true /* sent by a friend */ , true, true,R.drawable.man));
        list.add(new ChatProfile("Ahsan Memon", "I'm in Karachi", "now", "text", true /* sent by a friend */ , true, true,R.drawable.man));
        list.add(new ChatProfile("Ahsan Memon", "I'm in Karachi", "now", "text", true /* sent by a friend */ , true, true,R.drawable.man));
        list.add(new ChatProfile("Ahsan Memon", "I'm in Karachi", "now", "text", true /* sent by a friend */ , true, true,R.drawable.man));
        list.add(new ChatProfile("Ahsan Memon", "I'm in Karachi", "now", "text", true /* sent by a friend */ , true, true,R.drawable.man));
        list.add(new ChatProfile("Ahsan Memon", "I'm in Karachi", "now", "text", true /* sent by a friend */ , true, true,R.drawable.man));


        chatAdapter = new ChatAdapter(list, getActivity());

        chatRecyclerView.setAdapter(chatAdapter);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(chatFragment.getContext()));

        return chatFragment;



    }
}