package com.example.lifecycle05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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

    TextView createTV2;
    TextView startTV2;
    TextView resumeTV2;
    TextView pauseTV2;
    TextView stopTV2;
    TextView restartTV2;
    TextView destroyTV2;
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
        ////////////////////////////////////////
        createTV2 = findViewById(R.id.create2);
        startTV2 = findViewById(R.id.start2);
        resumeTV2 = findViewById(R.id.resume2);
        pauseTV2 = findViewById(R.id.pause2);
        stopTV2 = findViewById(R.id.stop2);
        restartTV2 = findViewById(R.id.restart2);
        destroyTV2 = findViewById(R.id.destroy2);

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        counter = new LCCounter(0, 0, 0, 0, 0, 0 , 0);

        counter.setCreate((counter.getCreate())+1);
        editor = sharedPrefs.edit();
        int current = sharedPrefs.getInt("create", 0);
        Log.i("create current", String.valueOf(current));
        editor.putInt("create", current+1);
        editor.apply();
        createTV2.setText("Create -- " + (current+1));
        //----------------------------------------------------------

        counter.setDestroy(counter.getDestroy()+1);
        editor = sharedPrefs.edit();
        //int destroyCount = counter.getDestroy();
        int destroyCurrent = sharedPrefs.getInt("destroy", 0);
        editor.putInt("destroy", 1+current);
        editor.apply();
        destroyTV2.setText("Destroy -- " + (1+destroyCurrent));

        pauseTV2.setText("Pause -- " + sharedPrefs.getInt("pause", 0));
        stopTV2.setText("Stop -- " + sharedPrefs.getInt("stop", 0));
        restartTV2.setText("Restart -- " + sharedPrefs.getInt("restart", 0));
    }
    @Override
    protected void onStart() {
        super.onStart();
        counter.setStart(counter.getStart()+1);

        editor = sharedPrefs.edit();
        int count = counter.getStart();
        int current = sharedPrefs.getInt("start", 0);
        editor.putInt("start", current+1);
        editor.apply();
        startTV2.setText("Start -- " + (current+1));

    }
    @Override
    protected void onResume() {
        super.onResume();
        counter.setResume(counter.getResume()+1);

        editor = sharedPrefs.edit();
        int count = counter.getResume();
        Log.i("resume count", String.valueOf(count));
        int current = sharedPrefs.getInt("resume", 0);
        editor.putInt("resume", 1+current);
        editor.apply();
        resumeTV2.setText("Resume -- " + (current+1));
    }
    @Override
    protected void onPause() {
        super.onPause();
        counter.setPause(counter.getPause()+1);

        editor = sharedPrefs.edit();
        int count = counter.getPause();
        Log.i("pause count", String.valueOf(count));
        int current = sharedPrefs.getInt("pause", 0);
        editor.putInt("pause", 1+current);
        editor.apply();
        pauseTV2.setText("Pause -- " + (current+1));
    }
    @Override
    protected void onStop() {
        super.onStop();
        counter.setStop(counter.getStop()+1);

        editor = sharedPrefs.edit();
        int count = counter.getStop();
        int current = sharedPrefs.getInt("stop", 0);
        editor.putInt("stop", 1+current);
        editor.apply();
        stopTV2.setText("Stop -- " + (current+1));
    }
    @Override
    protected void onRestart() {
        super.onRestart();

        counter.setRestart(counter.getRestart()+1);

        editor = sharedPrefs.edit();
        int count = counter.getRestart();
        int current = sharedPrefs.getInt("restart", 0);
        editor.putInt("restart", 1+current);
        editor.apply();
        restartTV2.setText("Restart -- " + (current+1));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
class LCCounter{
    private int create;
    private int start;
    private int resume;
    private int pause;
    private int stop;
    private int restart;
    private int destroy;

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