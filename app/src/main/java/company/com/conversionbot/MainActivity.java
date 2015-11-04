package company.com.conversionbot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {

    Spinner selectMeasurement;
    Spinner selectUnit1;
    Spinner selectUnit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectMeasurement = (Spinner) findViewById(R.id.spinner);
        selectUnit1 = (Spinner) findViewById(R.id.spinner2);
        selectUnit2 = (Spinner) findViewById(R.id.spinner3);

        final ArrayAdapter<String> Volume = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Volume));
        final ArrayAdapter<String> Distance = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Distance));
        final ArrayAdapter<String> Weight = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Weight));
        final ArrayAdapter<String> Temp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Temperature));

        selectMeasurement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3) {
                selectUnit1.setSelection(position);
                final String selection = (String) arg0.getItemAtPosition(position);
                    if(selection.equals("Distance")){
                        selectUnit1.setAdapter(Distance);
                        selectUnit2.setAdapter(Distance);
                    }
                    else if(selection.equals("Weight")){
                        selectUnit1.setAdapter(Weight);
                        selectUnit2.setAdapter(Weight);
                    }
                    else if(selection.equals("Temperature")){
                        selectUnit1.setAdapter(Temp);
                        selectUnit2.setAdapter(Temp);
                    }
                    else if(selection.equals("Volume")){
                        selectUnit1.setAdapter(Volume);
                        selectUnit2.setAdapter(Volume);
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });


        selectUnit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        selectUnit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
