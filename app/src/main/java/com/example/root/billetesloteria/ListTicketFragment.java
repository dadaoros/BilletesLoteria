package com.example.root.billetesloteria;



import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import Models.Ticket;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListTicketFragment extends Fragment  {

    //TODO: remover implement Onclick
    private ArrayAdapter<Ticket> listAdapter;
    private ListView ticketListView;
    public ListTicketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view =inflater.inflate(R.layout.fragment_list_ticket, container, false);
        initComponents(view);
        return view;
    }
    @Override
    public void onResume(){
        super.onResume();
        listAdapter.setNotifyOnChange(true);
        ticketListView.setAdapter(listAdapter);
        Ticket t=null;
        try {
            t = (Ticket) ticketListView.getAdapter().getItem(0);
            Log.w("elemento 0",t.getLoteria());
        }catch(Exception e){

        }

    }
    @Override
    public void onPause() {
        super.onPause();
    }
    public void setListAdapter(ArrayAdapter<Ticket> listAdapter) {
        this.listAdapter = listAdapter;
        listAdapter.setNotifyOnChange(true);
        ticketListView.setAdapter(listAdapter);
    }
    private void initComponents(View v) {
        ticketListView = (ListView)v.findViewById(R.id.list_view);
        listAdapter=new TicketListAdapter(new ArrayList<Ticket>(),getActivity());
        listAdapter.setNotifyOnChange(true);
        ticketListView.setAdapter(listAdapter);
    }

}