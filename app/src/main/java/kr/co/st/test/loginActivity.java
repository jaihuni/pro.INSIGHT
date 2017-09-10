package kr.co.st.test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 이상원 on 2016-11-02.
 */
public class loginActivity extends Activity {

    public static final String PREF_ID = "Pref01";
    public static final int actMode = Activity.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView edit01 = (TextView) findViewById(R.id.edit01);

        final Button IDbtn =  (Button) findViewById(R.id.IDbtn);
        IDbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String myID = edit01.getText().toString();

                SharedPreferences myPrefs = getSharedPreferences(PREF_ID, actMode);
                SharedPreferences.Editor myEditer = myPrefs.edit();
                myEditer.putString("ID", myID);
                myEditer.commit();

                finish();
            }
        });
    }
}
