package com.estsoft.timepickerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker)findViewById( R.id.timePicker );

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay + ":" + minute;
                ((TextView)findViewById(R.id.timeText)).setText(time);
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String timeSelected = hour + "시" + minute + "분";
                Toast.makeText(MainActivity.this, timeSelected, Toast.LENGTH_LONG).show();
            }
        });
    }
}
