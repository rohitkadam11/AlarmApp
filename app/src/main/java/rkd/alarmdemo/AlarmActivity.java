package rkd.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlarmActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(AlarmActivity.this,AlarmActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(AlarmActivity.this,123,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        prepare();

        alarmManager.cancel(pendingIntent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        play();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stop();
    }

    public  void  prepare(){
        mediaPlayer=MediaPlayer.create(AlarmActivity.this,R.raw.alarm);
    }
    public  void play(){
        if(mediaPlayer != null){
            prepare();
            mediaPlayer.start();
        }
    }
    public  void  stop(){
        mediaPlayer.stop();
    }
}
