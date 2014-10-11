package com.example.root.billetesloteria;



import android.annotation.TargetApi;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import Models.Ticket;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListTicketFragment extends Fragment {

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
        Log.w("Estado", "Working");
        try {
            Log.w("Frag.elementos:", "" + listAdapter.getCount());
        }catch(Exception e){

        }
        updateList();

    }

    private void updateList() {
        if(listAdapter!=null) {
            listAdapter.notifyDataSetChanged();
            listAdapter.setNotifyOnChange(true);
            ticketListView.setAdapter(listAdapter);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w("Estado","Suspendido");
    }
    public void setListAdapter(ArrayAdapter<Ticket> listAdapter) {
        this.listAdapter = listAdapter;
    }
    private void initComponents(View v) {
        ticketListView = (ListView)v.findViewById(R.id.list_view);

    }

}