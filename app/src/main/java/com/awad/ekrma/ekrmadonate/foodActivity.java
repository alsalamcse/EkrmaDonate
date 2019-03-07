package com.awad.ekrma.ekrmadonate;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class foodActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
  //  String[] paths = { "India", "USA", "China", "Japan", "Other"};
    private static final String[] paths = {"item 1", "item 2", "item 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        spinner = (Spinner)findViewById(R.id.spningre);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(foodActivity.this,
                android.R.layout.simple_spinner_item,paths);

        spinner.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);










    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

         //   Toast.makeText(getApplicationContext(),foodActivity[position] , Toast.LENGTH_LONG).show();

            switch (position) {
            case 0:

                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


}