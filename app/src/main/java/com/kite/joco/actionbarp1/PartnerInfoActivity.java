package com.kite.joco.actionbarp1;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class PartnerInfoActivity extends CrmLevelActivity {

    TextView tvSearchString;
    public static final String LOGTAG = "CRMParnerInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_info);
        tvSearchString = (TextView) findViewById(R.id.tvSearchString);

        Log.d(LOGTAG,"onCreate");

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d(LOGTAG," Search fired with : " + query );
            showsearchString(query);
        }
    }

    private void showsearchString(String text) {
        tvSearchString.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }
}
