package company.com.conversionbot;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

    //Declare
    Spinner selectMeasurement;
    Spinner selectUnit1;
    Spinner selectUnit2;
    EditText enterMeasurement;
    EditText result;
    String unitFrom;
    String unitTo;
    String userIn;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set spinners according to ids from xml
        selectMeasurement = (Spinner) findViewById(R.id.spinner);
        selectUnit1 = (Spinner) findViewById(R.id.spinner2);
        selectUnit2 = (Spinner) findViewById(R.id.spinner3);

        //Set arrays for spinners according to ids from xml
        final ArrayAdapter<String> Volume = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Volume));
        final ArrayAdapter<String> Distance = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Distance));
        final ArrayAdapter<String> Weight = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Weight));
        final ArrayAdapter<String> Temp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Temperature));

        //Listener for first spinner (Select measurment)
        selectMeasurement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3) {
                selectUnit1.setSelection(position);
                //Create a string from the spinner position
                final String selection = (String) arg0.getItemAtPosition(position);
                    //Switch statement to set spinner 2 and 3 according to spinner 1
                    switch(selection){
                        case "Distance":
                            selectUnit1.setAdapter(Distance);
                            selectUnit2.setAdapter(Distance);
                            break;
                        case "Weight":
                            selectUnit1.setAdapter(Weight);
                            selectUnit2.setAdapter(Weight);
                            break;
                        case "Temperature":
                            selectUnit1.setAdapter(Temp);
                            selectUnit2.setAdapter(Temp);
                            break;
                        case "Volume":
                            selectUnit1.setAdapter(Volume);
                            selectUnit2.setAdapter(Volume);
                            break;
                        default:
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        //Listener for spinner 2 (what unit is being converted)
        selectUnit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3) {
                final String selection = (String) arg0.getItemAtPosition(position);
                unitFrom = selection;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        //Listener for spinner 3 (what the units are being converted to)
        selectUnit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                final String selection = (String) arg0.getItemAtPosition(position);
                unitTo = selection;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        //Set the variable to be data from text input
        enterMeasurement = (EditText)findViewById(R.id.editText);
        userIn = enterMeasurement.getText().toString();

        //Set the variable for output text
        result = (EditText)findViewById(R.id.editText2);
        output = result.getText().toString();

        //Listener for the text input
        enterMeasurement.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                
            }
        });

    }

   @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save spinner states
        outState.putInt("savedSpinner1", selectMeasurement.getSelectedItemPosition());
        outState.putInt("savedSpinner2", selectUnit1.getSelectedItemPosition());
        outState.putInt("savedSpinner3", selectUnit2.getSelectedItemPosition());
        outState.putString("userInput", userIn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null) {
            selectMeasurement.setSelection(savedInstanceState.getInt("savedSpinner1"));
            selectUnit1.setSelection(savedInstanceState.getInt("savedSpinner2"));
            selectUnit2.setSelection(savedInstanceState.getInt("savedSpinner3"));
            userIn = savedInstanceState.getString("userInput");
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
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
