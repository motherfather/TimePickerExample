package com.estsoft.timepickerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker)findViewById( R.id.datePicker );
        datePicker.init( 2016, 5-1, 24, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                ((TextView)findViewById( R.id.dateText )).setText( year + "-" + ( monthOfYear + 1 ) + "-"+ dayOfMonth );
            }
        });

        findViewById( R.id.button ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth() + 1;
                int day = datePicker.getDayOfMonth();

                Toast.makeText(MainActivity.this, year + "년 " + month + "월 " + day + "일", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
