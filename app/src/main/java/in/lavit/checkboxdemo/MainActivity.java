package in.lavit.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    private CheckBox checkBoxPri,checkBoxGra,checkBoxPG,checkBoxOther;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,radioButtonFemale;
    private ToggleButton toggleButtonONOFF;
    private Spinner spinnerPerson;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.persons));


        checkBoxPri = findViewById(R.id.checkBoxPrimary);
        checkBoxGra = findViewById(R.id.checkBoxGraduation);
        checkBoxPG = findViewById(R.id.checkBoxPost);
        checkBoxOther = findViewById(R.id.checkBoxOther);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);

        toggleButtonONOFF = findViewById(R.id.toggleButtonOnOFF);

        spinnerPerson = findViewById(R.id.spinnerPerson);
        spinnerPerson.setAdapter(adapter);


        checkBoxPri.setOnCheckedChangeListener(this);
        checkBoxGra.setOnCheckedChangeListener(this);
        checkBoxPG.setOnCheckedChangeListener(this);
        checkBoxOther.setOnCheckedChangeListener(this);

        radioGroupGender.setOnCheckedChangeListener(this);


        toggleButtonONOFF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Toggling to "+isChecked, Toast.LENGTH_SHORT).show();
            }
        });


        spinnerPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String name =  parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id){
            case R.id.checkBoxPrimary:
                Toast.makeText(this, "Primary is "+isChecked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxGraduation:
                Toast.makeText(this, "Graduation is "+isChecked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxPost:
                Toast.makeText(this, "PG is "+isChecked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxOther:
                Toast.makeText(this, "Other is "+isChecked, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id = group.getId();
            switch (checkedId){
                case R.id.radioButtonMale:
                    Toast.makeText(this, "Male is "+radioButtonMale.isChecked(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioButtonFemale:
                    Toast.makeText(this, "Female is "+radioButtonFemale.isChecked(), Toast.LENGTH_SHORT).show();
                    break;
            }
    }
}
