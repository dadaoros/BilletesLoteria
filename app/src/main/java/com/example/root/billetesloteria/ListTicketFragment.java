package com.example.root.billetesloteria;



import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Models.Ticket;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListTicketFragment extends Fragment {

    ArrayAdapter<Ticket> listAdapter;
    ListView ticketList;

    public ListTicketFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view =inflater.inflate(R.layout.fragment_list_ticket, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View v) {
        ticketList = (ListView)v.findViewById(R.id.list_view);
        listAdapter=new TicketListAdapter(new ArrayList<Ticket>(),getActivity());
    }


}
