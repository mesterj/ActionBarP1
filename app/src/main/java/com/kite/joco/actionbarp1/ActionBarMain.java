package com.kite.joco.actionbarp1;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class ActionBarMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_action_bar_main);
        try {
            ActionBar actionBar = getActionBar();
            // Ez a home gomb ha lecserélem az ikonját akkor visszarak az alk. főoldalra (eggyel visszább)
            actionBar.setDisplayShowHomeEnabled(true);
            // Engedélyezi a feliratot ha saját layoutból fújom fel akkor kikapcs
            actionBar.setDisplayShowTitleEnabled(false);
            // Ez ad olyan vissza jelet amivel vissza lehet menni egy képernyőt. IOS-hez szokott userek hálásak lesznek érte
            //actionBar.setDisplayHomeAsUpEnabled(true);
            // Itt fújom fel a saját xml
            LayoutInflater inflater = LayoutInflater.from(this);
            View myactionbar = inflater.inflate(R.layout.actbarlayout, null);

            // itt állítom be a custom layoutot az actionbarhoz
            actionBar.setCustomView(myactionbar);
            // itt történik a costum actionbar megjelenítése
            actionBar.setDisplayShowCustomEnabled(true);
        } catch (Exception nex) {
            Log.d("ACTIONBARLOG", " A jó édes anyjáért nincs actionbar: " + nex.getLocalizedMessage());
        }

        // actionBar.setCustomView(R.layout.actbarlayout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_bar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case (R.id.action_settings):
                break;
            case (R.id.home):
                finish();
                break;
            case (R.id.about):
                Toast.makeText(this, "Ezt a programot Józsi csinálta", Toast.LENGTH_LONG).show();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case (R.id.btnMenu):
                Intent i = new Intent(v.getContext(), Menu1Activity.class);
                startActivity(i);
                break;

            case (R.id.btnMenu2):
                Intent partnerInfo = new Intent(v.getContext(),PartnerInfoActivity.class);
                startActivity(partnerInfo);
                break;
        }
    }
}
