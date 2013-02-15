package cacafogo.software.checkBalance;

import cacafogo.software.touchBalance.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DIYActivity extends Activity {
	
     //
     String tempUssd = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diy);
	     
	     Button saveBtn = (Button)findViewById(R.id.save_btn);
	     final EditText ussdEt = (EditText)findViewById(R.id.ussd_et);
	     
	     //get the ussd code from the edit text box
	     tempUssd = ussdEt.getText().toString();
	     
	     
	     
	     //when the save button is pressed
	     saveBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("SP", "Save Clicked");
				// set ussd code
				tempUssd = ussdEt.getText().toString();
				createSharedPrefs();
				finish();
			}
		});
	}

	
	//CREATE SHARED PREFERENCES
	protected void createSharedPrefs() {
		// TODO Auto-generated method stub
		SharedPreferences myPrefs = this.getSharedPreferences("checkBalance", MODE_WORLD_READABLE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString("ussd", tempUssd);
        prefsEditor.commit();
        Log.d("SP", "tempussd = " + tempUssd);
	}

}
