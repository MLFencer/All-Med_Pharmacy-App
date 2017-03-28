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

import com.bigmacdev.pharmacy_app.dummy.DummyContent2;

public class Stock extends AppCompatActivity implements DrugFragment.OnListFragmentInteractionListener{

    private Button add;
    private Spinner menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        add= (Button)findViewById(R.id.addStock);
        menu= (Spinner)findViewById(R.id.menuStock);

        final ArrayAdapter<CharSequence> menuItems = ArrayAdapter.createFromResource(this, R.array.menu_items, android.R.layout.simple_spinner_item);
        menuItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        menu.setAdapter(menuItems);
        menu.setOnItemSelectedListener(menuItemSelected);

        add.setOnClickListener(addClick);
    }

    AdapterView.OnItemSelectedListener menuItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position!=0){
                switch (position){
                    case 1:
                        Intent intent = new Intent();
                        intent.setClass(Stock.this, Menu.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(Stock.this, "Already on Stock Menu.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    View.OnClickListener addClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Stock.this, "Added New Drug to List", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onListFragmentInteraction(DummyContent2.DummyItem item) {
        Toast.makeText(this, "Selected "+item.id, Toast.LENGTH_SHORT).show();
    }
}
