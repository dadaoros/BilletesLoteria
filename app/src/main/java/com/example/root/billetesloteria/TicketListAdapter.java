package com.example.root.billetesloteria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Models.Ticket;

/**
 * Created by root on 6/10/14.
 */
public class TicketListAdapter extends BaseAdapter {
    ArrayList<Ticket> tickets;
    LayoutInflater lInflater;
    public TicketListAdapter(ArrayList<Ticket> tickets, LayoutInflater inflater) {
        this.lInflater=inflater;
        this.tickets=tickets;
    }

    @Override
    public int getCount() {
        return tickets.size();
    }

    @Override
    public Object getItem(int position) {
        return tickets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view=lInflater.inflate(R.layout.listview_item,null);
        TextView nombreLoteria= (TextView) view.findViewById(R.id.title);
        TextView numeroLoteria= (TextView) view.findViewById(R.id.l_number);
        TextView numeroSerie= (TextView) view.findViewById(R.id.l_series);

        Ticket ticket=tickets.get(position);
        nombreLoteria.setText(ticket.getLoteria());
        numeroLoteria.setText(ticket.getNumero());
        numeroSerie.setText(ticket.getSerie());
        return view;
    }
}
