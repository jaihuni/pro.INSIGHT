package kr.co.st.test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by 이상원 on 2016-10-26.
 */
public class StartActivity extends Activity {

    public static final String PREF_ID = "Pref01";
    public static final int actMode = Activity.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button scanBtn = (Button) findViewById(R.id.scanBtn);
        scanBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });

        Button syncBtn = (Button) findViewById(R.id.syncBtn);
        syncBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                ConnectThread thread = new ConnectThread("112.165.79.178");
                thread.start();

                Toast.makeText(getApplicationContext(), "동기화를 완료했습니다.", Toast.LENGTH_LONG).show();

                restoreFromSavedState();

            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        restoreFromSavedState();
    }

    protected  void  restoreFromSavedState(){
        SharedPreferences myPrefs = getSharedPreferences(PREF_ID, actMode);
        if ((myPrefs == null) || (!myPrefs.contains("ID"))) {
            Intent myIntent = new Intent(getApplicationContext(), loginActivity.class);
            startActivity(myIntent);
        }
        else {
            String myID = myPrefs.getString("ID", "");

            TextView ID = (TextView)findViewById(R.id.IDView);

            ID.setText(myID);

            int myScore = myPrefs.getInt("Score", 0);
            int useScore = myPrefs.getInt("Use", 0);

            String strScore = Integer.toString(myScore);

            TextView score = (TextView)findViewById(R.id.scoreView);

            score.setText(strScore);

            strScore = Integer.toString(myScore-useScore);

            TextView cscore = (TextView)findViewById(R.id.cscoreView);

            cscore.setText(strScore);
        }

    }

    class ConnectThread extends Thread {
        String hostname;

        public ConnectThread(String addr) {
            hostname = addr;
        }

        public void run(){
            try {
                int portNumber = 7000;
                SharedPreferences myPrefs = getSharedPreferences(PREF_ID, actMode);

                Socket sock = new Socket(hostname, portNumber);

                ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
                outstream.writeObject(myPrefs.getString("ID", ""));
                outstream.flush();

                outstream.writeObject(Integer.toString(myPrefs.getInt("Score", 0)));
                outstream.flush();

                ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());

                Object obj = instream.readObject();
                String str = obj.toString();

                int use = Integer.parseInt(str);

                SharedPreferences.Editor myEditor = myPrefs.edit();

                myEditor.putInt("Use", use);
                myEditor.commit();

                sock.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
