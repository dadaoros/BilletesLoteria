package com.example.root.billetesloteria;



import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import Models.Ticket;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AddTicketFragment extends Fragment implements View.OnClickListener {

    TextView tNumber, tSeries,tLotery;
    Button bSave,bCancel;
    public AddTicketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_ticket, container, false);
        inicializarComponentes(v);
        // Inflate the layout for this fragment
        return v;
    }
    //final???
    private void inicializarComponentes(final View view) {
        tNumber= (EditText)view.findViewById(R.id.tNumber);
        tSeries= (EditText) view.findViewById(R.id.tSeries);
        tLotery= (EditText) view.findViewById(R.id.tLotery);
        bSave= (Button) view.findViewById(R.id.btn_save);
        bCancel=(Button) view.findViewById(R.id.btn_cancel);
        bSave.setOnClickListener(this);
        bCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save: break;
            case R.id.btn_cancel:cleanFields(); break;
        }

    }

    private void cleanFields() {

        tLotery.setText("");
        tNumber.setText("");
        tSeries.setText("");
    }

    private void saveTicket(String sLotery, String sNumber, String sSeries) {
        // TODO: Modificar la fecha
        Date date=new Date();
        Ticket ticket = new Ticket(sLotery,sNumber,sSeries, date);

    }
}
