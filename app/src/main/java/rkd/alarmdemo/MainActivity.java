package rkd.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonSetAlarm;
    Button buttonRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetAlarm=findViewById(R.id.buttonsetAlarm);
        buttonRepeat=findViewById(R.id.buttonRepeat);

        buttonSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarm();
            }
        });

        buttonRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatAlarm();
            }
        });
    }


    public  void setAlarm(){
       AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(MainActivity.this,AlarmActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,123,intent,PendingIntent.FLAG_UPDATE_CURRENT);
       alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+1000,pendingIntent);

    }

    public  void repeatAlarm(){
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(MainActivity.this,AlarmActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,123,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+1000,500,pendingIntent);
    }
}
