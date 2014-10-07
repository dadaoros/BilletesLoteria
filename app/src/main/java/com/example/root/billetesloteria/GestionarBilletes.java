package com.example.root.billetesloteria;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import java.util.ArrayList;

import Models.Ticket;

import static com.example.root.billetesloteria.R.color.light_style;


public class GestionarBilletes extends ActionBarActivity implements View.OnTouchListener{
    private ActionBar actionBar;
    private ImageButton btnAddTicket, btnDelTicket, btnListTickets;
    private AddTicketFragment addTicketF;
    private ListTicketFragment listTicketF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_billetes);
        initComponents();
        initActionBar();
    }

    private void initComponents(){
        btnAddTicket= (ImageButton)findViewById(R.id.add_ticket);
        btnAddTicket.setOnTouchListener(this);
        btnDelTicket= (ImageButton)findViewById(R.id.delete_ticket);
        btnDelTicket.setOnTouchListener(this);
        btnListTickets= (ImageButton)findViewById(R.id.ticket_list);
        btnListTickets.setOnTouchListener(this);

        loadFragment(getListTicketF());
    }

    //creamos un metodo generico para cargar los fragmentos
    private void loadFragment(Fragment f) {
        FragmentManager fManager= getFragmentManager();
        android.app.FragmentTransaction transaction = fManager.beginTransaction();
        transaction.replace(R.id.container,f);
        transaction.commit();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void initActionBar() {
        actionBar=getActionBar();
        actionBar.setHomeButtonEnabled(false);
    }
    //Empleamos una inicializacion por demanda
    public AddTicketFragment getAddTicketF() {
        if(addTicketF==null)addTicketF=new AddTicketFragment();
        return addTicketF;
    }
    public ListTicketFragment getListTicketF() {
        if(listTicketF==null)listTicketF= new ListTicketFragment();
        return listTicketF;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gestionar_billetes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

     @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageButton btn=(ImageButton)view;
        int actionMasket = motionEvent.getActionMasked();
        switch(actionMasket){
            case MotionEvent.ACTION_DOWN:
                btn.setColorFilter(light_style);
                btn.invalidate();
                changeFragment(view);
                break;
            case MotionEvent.ACTION_UP:
                btn.clearColorFilter();
                btn.invalidate();
                break;
        }
        return true;
    }

    private void changeFragment(View view) {
        switch (view.getId()){
            case R.id.add_ticket:loadFragment(getAddTicketF());break;
            case R.id.ticket_list:loadFragment(getListTicketF());break;
            //TODO: Terminar de Implementar switch case
        }
    }
}
