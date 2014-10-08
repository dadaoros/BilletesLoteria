package com.example.root.billetesloteria;

/**
 * Created by root on 7/10/14.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import Models.Ticket;

/**
 * Created by alejandro on 5/2/14.
 */
public class TicketReceiver extends BroadcastReceiver {

    public static final String FILTER_NAME = "listacontactos";
    public static final int CONTACTO_AGREGADO = 1;
    public static final int CONTACTO_ELIMINADO = 2;
    public static final int CONTACTO_ACTUALIZADO = 3;

    private final ArrayAdapter<Ticket> adapter;
    public TicketReceiver(ArrayAdapter<Ticket> adapter) {
        this.adapter = adapter;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        int operacion = intent.getIntExtra("operacion", -1);
        switch (operacion) {
            case CONTACTO_AGREGADO:
                agregarTicket(intent);
                Log.d("Debbugin", "onCreate() Restoring previous state");
                break;
            case CONTACTO_ELIMINADO:
                //TODO: eliminar contacto
                break;
            case CONTACTO_ACTUALIZADO:
                actualizarContacto(intent);
                break;
        }
    }

    private void agregarTicket(Intent intent) {
        Ticket ticket = (Ticket) intent.getSerializableExtra("datos");
        adapter.add(ticket);

    }



    private void actualizarContacto(Intent intent) {
        Ticket contacto = (Ticket) intent.getSerializableExtra("datos");
        int posicion = adapter.getPosition(contacto);
        adapter.insert(contacto, posicion);
    }
}
