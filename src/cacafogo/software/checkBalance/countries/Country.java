package cacafogo.software.checkBalance.countries;

import cacafogo.software.checkBalance.DIYActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public abstract class Country extends Activity {
	
	protected String operatorName;
	protected String networkCountry;
	
	//Country variables
	protected String smsNumber;
	protected String smsText;
	protected String encodedHash = Uri.encode("#");
    protected String code = "";
    protected String url = "";
    protected Context context;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        //get the operator name
        operatorName = telephonyManager.getNetworkOperatorName(); 
        // Getting connected network iso country code
        networkCountry = telephonyManager.getNetworkCountryIso();

        
        Log.d("ON", "Operator name = " + operatorName);
        Log.d("NC", "Operator country = " + networkCountry);
	}

	
	public Country(){

	}
	
	
	//METHODS TO CONTACT THE NETWORK PROVIDER
	public void callUSSD(String code) {
		 //make the call
        String url = "tel:" + code;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        startActivity(intent);
        finish();
	}

	public void sendText(String smsNumber, String smsText) {
		// code to send the text
		 Uri uri = Uri.parse("smsto:" + smsNumber);
         Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
         intent.putExtra("sms_body", smsText);  
         startActivity(intent);
         finish();
	}
	
	public void openURL(String url){
		//code to open browser with the given url
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(intent);
		finish();
	}
	
	public void diyUssd(){
		//code to open browser with the given url
		Intent intent = new Intent(this, DIYActivity.class);
		startActivity(intent);
		finish();
	}

}
