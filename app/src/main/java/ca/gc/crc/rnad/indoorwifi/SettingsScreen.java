package ca.gc.crc.rnad.indoorwifi;

import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceFragment;
import android.support.annotation.RequiresApi;
import android.util.Log;

import ca.gc.crc.rnad.indoorwifi.Constants;

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public  abstract class  SettingsScreen extends PreferenceFragment {
    public static String ServerName = "tcp://iot.eclipse.org:1883";
    public static String topicName = "anchorId";
    EditTextPreference ServerEditText;
    static EditTextPreference Subscribe;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // addPreferencesFromResource(R.xml.pref_general);
         ServerEditText = (EditTextPreference) findPreference("example_text");
         ServerEditText.setText(ServerName);
         Subscribe= (EditTextPreference) findPreference("example_text2");
         Subscribe.setText(topicName);
        try {
            ServerName = ServerEditText.getText();
            topicName = Subscribe.getText();

        } catch (NullPointerException iot) {
            ServerName = "tcp://iot.eclipse.org:1883";
            topicName = "anchorId";

        }

    }


    public String getServerName(){
        return  ServerEditText.getText().trim();

    }

    public static String getTopicName(){
        Log.d("455",Subscribe.getText().trim().toString());
        return Subscribe.getText().trim();
    }

}

