package com.example.lifecycle05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPrefs; //this is for set 2, as long as the app has been installed on phone
    SharedPreferences.Editor editor;
    LCCounter counter;
    TextView createTV1;
    TextView startTV1;
    TextView resumeTV1;
    TextView pauseTV1;
    TextView stopTV1;
    TextView restartTV1;
    TextView destroyTV1;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createTV1 = findViewById(R.id.create);
        startTV1 = findViewById(R.id.start);
        resumeTV1 = findViewById(R.id.resume);
        pauseTV1 = findViewById(R.id.pause);
        stopTV1 = findViewById(R.id.stop);
        restartTV1 = findViewById(R.id.restart);
        destroyTV1 = findViewById(R.id.destroy);

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        counter = new LCCounter(0, 0, 0, 0, 0, 0 , 0);

        counter.setCreate(counter.getCreate()+1);
        editor = sharedPrefs.edit();
        int count = counter.getCreate();
        int current = sharedPrefs.getInt("create", 0);
        editor.putInt("start", count+current);
        editor.apply();
        createTV1.setText("Create -- " + (count+current));
    }
    @Override
    protected void onStart() {
        super.onStart();
        counter.setStart(counter.getStart()+1);

        editor = sharedPrefs.edit();
        int count = counter.getStart();
        int current = sharedPrefs.getInt("start", 0);
        editor.putInt("start", count+current);
        editor.apply();
        startTV1.setText("Start -- " + (count+current));
    }
    @Override
    protected void onResume() {
        super.onResume();
        counter.setResume(counter.getResume()+1);

        editor = sharedPrefs.edit();
        int count = counter.getResume();
        int current = sharedPrefs.getInt("resume", 0);
        editor.putInt("resume", count+current);
        editor.apply();
        resumeTV1.setText("Resume -- " + (count+current));
    }
    @Override
    protected void onPause() {
        super.onPause();
        counter.setPause(counter.getPause()+1);

        editor = sharedPrefs.edit();
        int count = counter.getPause();
        int current = sharedPrefs.getInt("pause", 0);
        editor.putInt("pause", count+current);
        editor.apply();
        pauseTV1.setText("Pause -- " + (count+current));
    }
    @Override
    protected void onStop() {
        super.onStop();
        counter.setStop(counter.getStop()+1);

        editor = sharedPrefs.edit();
        int count = counter.getStop();
        int current = sharedPrefs.getInt("stop", 0);
        editor.putInt("stop", count+current);
        editor.apply();
        stopTV1.setText("Stop -- " + (count+current));
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        counter.setRestart(counter.getRestart()+1);

        editor = sharedPrefs.edit();
        int count = counter.getRestart();
        int current = sharedPrefs.getInt("restart", 0);
        editor.putInt("restart", count+current);
        editor.apply();
        restartTV1.setText("Restart -- " + (count+current));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        counter.setDestroy(counter.getDestroy()+1);

        editor = sharedPrefs.edit();
        int count = counter.getDestroy();
        int current = sharedPrefs.getInt("destroy", 0);
        editor.putInt("destroy", count+current);
        editor.apply();
        destroyTV1.setText("Stop -- " + (count+current));
    }

    public class LCCounter{
        int create;
        int start;
        int resume;
        int pause;
        int stop;
        int restart;
        int destroy;

        LCCounter(int create, int start, int resume, int pause, int stop, int restart, int destroy) {
            this.create= create;
            this.start = start;
            this.resume = resume;
            this.pause = pause;
            this.stop = stop;
            this.restart = restart;
            this.destroy = destroy;
        }
    int getCreate(){
            return create;
    }
    int getStart() {

        return start;
    }

    int getDestroy() {

        return destroy;
    }

    int getRestart() {

        return restart;
    }

    int getStop() {

        return stop;
    }

    int getPause() {

        return pause;
    }

    int getResume() {

        return resume;
    }

    void setStart(int start) {
        this.start = start;
    }

    void setResume(int resume) {
        this.resume = resume;
    }

    void setPause(int pause) {
        this.pause = pause;
    }

    void setStop(int stop) {
        this.stop = stop;
    }

    void setRestart(int restart) {
        this.restart = restart;
    }

    void setDestroy(int destroy) {
        this.destroy = destroy;
    }
    void setCreate(int create){
            this.create = create;
    }
    }
}
