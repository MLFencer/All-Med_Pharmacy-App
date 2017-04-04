package com.bigmacdev.pharmacy_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements PerscriptionFragment.OnListFragmentInteractionListener{

    private Button history, completed, logout;
    private Spinner menu;
    private TextView patientName, perscriberName, drugName, drugQuantity, scriptDate, scriptNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu = (Spinner)findViewById(R.id.menuMain);
        history=(Button)findViewById(R.id.historyMain);
        completed=(Button)findViewById(R.id.completedMain);
        logout=(Button)findViewById(R.id.logoutMain);
        patientName=(TextView)findViewById(R.id.patientNameMain);
        perscriberName=(TextView)findViewById(R.id.perscriberNameMain);
        drugName=(TextView)findViewById(R.id.drugNameMain);
        drugQuantity=(TextView)findViewById(R.id.quantityMain);
        scriptDate=(TextView)findViewById(R.id.scriptWrittenDateMain);
        scriptNumber=(TextView)findViewById(R.id.scriptNumberMain);

        logout.setOnClickListener(logoutClick);
        history.setOnClickListener(historyClick);
        completed.setOnClickListener(completedClick);

        final ArrayAdapter<CharSequence> menuItems = ArrayAdapter.createFromResource(this, R.array.menu_items,android.R.layout.simple_spinner_item);
        menuItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        menu.setAdapter(menuItems);
        menu.setOnItemSelectedListener(menuItemSelected);
    }

    AdapterView.OnItemSelectedListener menuItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position!=0){
                switch (position){
                    case 1:
                        Toast.makeText(Menu.this, "Already on the Menu", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Intent intent = new Intent();
                        intent.setClass(Menu.this, Stock.class);
                        startActivity(intent);
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    @Override
    public void onListFragmentInteraction(Perscription item) {
        Toast.makeText(this, "Selected script: "+item.getPatientLastName(), Toast.LENGTH_SHORT).show();
        patientName.setText(item.getPatientFirstName()+" "+item.getPatientLastName());
        perscriberName.setText("Dr. "+item.getPerscriberName());
        drugName.setText(item.getDrugId());
        scriptDate.setText(item.getScriptWrittenDate());
        drugQuantity.setText(item.getQuantity());
        scriptNumber.setText(item.getScriptNumber());

    }

    View.OnClickListener completedClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Menu.this, "This script has been filled.", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener historyClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Menu.this, "This will take you to history of scripts filled.", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener logoutClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Menu.this, MainActivity.class);
            startActivity(intent);
        }
    };
}
