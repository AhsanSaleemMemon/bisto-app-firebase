package com.ahsansaleem.i170303_i170364;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CallHistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<CallHistoryProfile> list;
    private CallHistoryAdapter callHistoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View CallHistoryView =  inflater.inflate(R.layout.fragment_callhistory, container, false);

        recyclerView = CallHistoryView.findViewById(R.id.rcv);
        list = new ArrayList<>();


        list.add(new CallHistoryProfile("Ahsan Memon", "inbound - ", "4:35 pm", false, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Aqeel Ejaz", "lost - ", "Monday", true, R.drawable.man, R.drawable.outgoing));
        list.add(new CallHistoryProfile("Zaid Ali", "inbound - ", "Sunday", false, R.drawable.man, R.drawable.outgoing));
        list.add(new CallHistoryProfile("Usama Rasheed", "outbound - ", "October 07", true, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Aqib Ajmal", "inbound - ", "October 07", false, R.drawable.man, R.drawable.outgoing));
        list.add(new CallHistoryProfile("Jeremy san", "inbound - ", "October 06", false, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Jeremy san", "inbound - ", "October 06", false, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Jeremy san", "inbound - ", "October 06", false, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Jeremy san", "inbound - ", "October 06", false, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Jeremy san", "inbound - ", "October 06", false, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Jeremy san", "inbound - ", "October 06", false, R.drawable.man, R.drawable.ingoing));
        list.add(new CallHistoryProfile("Jeremy san", "inbound - ", "October 06", false, R.drawable.man, R.drawable.ingoing));


        callHistoryAdapter = new CallHistoryAdapter(list, getActivity());

        recyclerView.setAdapter(callHistoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CallHistoryView.getContext()));

        return CallHistoryView;

    }
}