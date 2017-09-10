package kr.co.st.test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;

import org.w3c.dom.Text;


public class MainActivity extends FragmentActivity {

    public static final String PREF_ID = "Pref01";
    public static final int actMode = Activity.MODE_PRIVATE;

    private WebView mWebView;    // 웹뷰 선언
    public final int CALL_ZXING_RESULT = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "ALL");
        startActivityForResult(intent, CALL_ZXING_RESULT);


        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                finish();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == CALL_ZXING_RESULT) {

            if(resultCode == Activity.RESULT_OK)
            {
                SharedPreferences myPrefs = getSharedPreferences(PREF_ID, actMode);
                String contents = data.getStringExtra("SCAN_RESULT");

                TextView tv = (TextView)findViewById(R.id.textView);

                if(myPrefs.contains(contents)) {
                    tv.setText("이미 스캔한 코드입니다.");
                }
                else {
                    int codenum = Integer.parseInt(contents);
                    int add = 0;
                    if(codenum < 50) {
                        add = 10;
                    }
                    else if(codenum < 100) {
                        add = 10;
                    }
                    else if(codenum < 150) {
                        add = 10;

                    }
                    else if(codenum < 200) {

                        add = 10;
                    }
                    else if(codenum < 250) {

                        add = 10;
                    }
                    else if(codenum < 300) {

                        add = 10;
                    }
                    else if(codenum < 350) {

                        add = 10;
                    }
                    else if(codenum < 400) {

                        add = 10;
                    }
                    SharedPreferences.Editor myEditor = myPrefs.edit();
                    tv.setText(Integer.toString(add)+"점 획득!");
                    int score = myPrefs.getInt("Score", 0) + add;
                    myEditor.putInt("Score", score);
                    myEditor.putInt(contents, 0);
                    myEditor.commit();
                }




            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
