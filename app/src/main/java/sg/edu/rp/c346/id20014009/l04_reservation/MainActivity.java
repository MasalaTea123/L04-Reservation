package sg.edu.rp.c346.id20014009.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    EditText editTextFullName;
    EditText editMobileNum;
    EditText editTextGroupSize;
    Button btnReservation;
    Button btnReset;
    CheckBox checkBoxSmkArea;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);

        editTextFullName=findViewById(R.id.editTextFullName);
        editMobileNum=findViewById(R.id.editTextPhoneNumber);
        editTextGroupSize=findViewById(R.id.editSizeNumber);
        checkBoxSmkArea=findViewById(R.id.checkBoxSmkArea);
        btnReservation=findViewById(R.id.reserve);
        btnReset=findViewById(R.id.reset);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2020,06,1);

        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName=editTextFullName.getText().toString();
                String phoneNum=editMobileNum.getText().toString();
                String groupSize=editTextGroupSize.getText().toString();
                String isSmoke="";
                if(checkBoxSmkArea.isChecked()){
                    isSmoke=("smoking.");
                }
                else{
                    isSmoke=("non-smoking");
                }
                String date=dp.getYear()+"/"+(dp.getMonth()+1)+"/"+dp.getDayOfMonth();
                String time=tp.getCurrentHour()+":"+String.format("%02d",tp.getCurrentMinute());

                String msg="Hi, "+fullName+", you have booked a "+groupSize+" personn(s) "+ isSmoke+ " table on "+date+ " at "+time+". Your phone number is "+phoneNum+".";
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            editTextFullName.setText("");
            editMobileNum.setText("");
            editTextGroupSize.setText("");
            checkBoxSmkArea.setText("false");
            dp.updateDate(2020,6,1);
            tp.setCurrentHour(19);
            tp.setCurrentMinute(30);


            }
        });

    }
}