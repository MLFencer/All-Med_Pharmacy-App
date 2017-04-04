package com.bigmacdev.pharmacy_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPerscription extends AppCompatActivity {

    private EditText pFirst, pLast, dFirst, dLast, drug, quantity, scriptId, scriptDt;
    private Button submit;
    private Spinner menu;
    private ArrayList<Perscription> perscriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_perscription);

        //Todo: make it so that the pharmasist can choose when a walk-in is due.

        Bundle bundle = this.getIntent().getExtras();
        perscriptions = (ArrayList<Perscription>) bundle.getSerializable("perscriptions");

        submit = (Button)findViewById(R.id.submitAdd);
        menu = (Spinner)findViewById(R.id.menuAdd);
        pFirst = (EditText)findViewById(R.id.patientFirstNameAdd);
        pLast = (EditText)findViewById(R.id.patientLastNameAdd);
        dFirst = (EditText)findViewById(R.id.perscriberFirstNameAdd);
        dLast = (EditText)findViewById(R.id.perscriberLastNameAdd);
        drug = (EditText)findViewById(R.id.drugNameAdd);
        quantity = (EditText)findViewById(R.id.quantityAdd);
        scriptId = (EditText)findViewById(R.id.scriptIdAdd);
        scriptDt = (EditText)findViewById(R.id.scriptDateAdd);

        submit.setOnClickListener(submitClick);

        final ArrayAdapter<CharSequence> menuItems = ArrayAdapter.createFromResource(this, R.array.menu_items,android.R.layout.simple_spinner_item);
        menuItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        menu.setAdapter(menuItems);
        menu.setOnItemSelectedListener(menuItemSelected);


    }

    private View.OnClickListener submitClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (allReady()){
                String first, last, docF, docL, drugT, quan, scriptIdT, scriptDtT;
                first = pFirst.getText().toString();
                last = pLast.getText().toString();
                docF = dFirst.getText().toString();
                docL = dLast.getText().toString();
                drugT = drug.getText().toString();
                quan =  quantity.getText().toString();
                scriptIdT = scriptId.getText().toString();
                scriptDtT = scriptDt.getText().toString();
                perscriptions.add(new Perscription(first,last,docF+" "+docL, drugT,quan, scriptIdT, scriptDtT, 15));
                pFirst.setText("");
                pLast.setText("");
                dFirst.setText("");
                dLast.setText("");
                drug.setText("");
                quantity.setText("");
                scriptId.setText("");
                scriptDt.setText("");
            }
        }
    };

    private boolean allReady(){
        boolean pF = !pFirst.getText().toString().equals("");
        boolean pL = !pLast.getText().toString().equals("");
        boolean dF = !dFirst.getText().toString().equals("");
        boolean dL = !dLast.getText().toString().equals("");
        boolean d = !drug.getText().toString().equals("");
        boolean q = !quantity.getText().toString().equals("");
        boolean sI = !scriptId.getText().toString().equals("");
        boolean sD = !scriptDt.getText().toString().equals("");
        return pF && pL && dF && dL && d && q && sI && sD;
    }


    private AdapterView.OnItemSelectedListener menuItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position!=0){
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                switch (position){
                    case 1:
                        intent.setClass(AddPerscription.this, Menu.class);
                        bundle.putSerializable("perscriptions",perscriptions);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    case 2:
                        intent.setClass(AddPerscription.this, Stock.class);
                        bundle.putSerializable("perscriptions",perscriptions);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case 3:
                        Toast.makeText(AddPerscription.this, "Already in Add Perscription", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };
}
