/*
*    Check Balance - The one click solution to checking your remaining balance on your mobile phone.
*    Copyright (C) 2012  Author: Robbie Lynch
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package cacafogo.software.checkBalance;

import cacafogo.software.checkBalance.countries.Armenia;
import cacafogo.software.checkBalance.countries.Australia;
import cacafogo.software.checkBalance.countries.Belgium;
import cacafogo.software.checkBalance.countries.Brazil;
import cacafogo.software.checkBalance.countries.Canada;
import cacafogo.software.checkBalance.countries.China;
import cacafogo.software.checkBalance.countries.France;
import cacafogo.software.checkBalance.countries.Germany;
import cacafogo.software.checkBalance.countries.India;
import cacafogo.software.checkBalance.countries.Ireland;
import cacafogo.software.checkBalance.countries.Italy;
import cacafogo.software.checkBalance.countries.Kazakhstan;
import cacafogo.software.checkBalance.countries.Mexico;
import cacafogo.software.checkBalance.countries.Netherlands;
import cacafogo.software.checkBalance.countries.NewZealand;
import cacafogo.software.checkBalance.countries.Poland;
import cacafogo.software.checkBalance.countries.Portugal;
import cacafogo.software.checkBalance.countries.Romania;
import cacafogo.software.checkBalance.countries.Russia;
import cacafogo.software.checkBalance.countries.Spain;
import cacafogo.software.checkBalance.countries.Sweden;
import cacafogo.software.checkBalance.countries.Thailand;
import cacafogo.software.checkBalance.countries.UK;
import cacafogo.software.checkBalance.countries.USA;
import cacafogo.software.checkBalance.countries.Ukraine;
import cacafogo.software.checkBalance.countries.Uzbekistan;
import cacafogo.software.touchBalance.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CheckBalance extends Activity {
   
    private Intent intent;
    private String encodedHash = Uri.encode("#");

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        
        /*
         * 	GET NETWORK DETAILS
         */
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        //get the operator name
        String operatorName = telephonyManager.getNetworkOperatorName(); 
        // Getting connected network iso country code
        String networkCountry = telephonyManager.getNetworkCountryIso();
        
        Log.d("ON", "Operator name = " + operatorName);
        Log.d("NC", "Operator country = " + networkCountry);
        
        
        /*
         * 	CHECK SHARED PREFERENCES
         */
        SharedPreferences myPrefs = this.getSharedPreferences("checkBalance", MODE_WORLD_READABLE);
        String prefUssd = myPrefs.getString("ussd", "nothing");
        
        
        Log.d("SP", "Myprefs = " + prefUssd);
        
        
        /*
         *      UPDATE LAUNCH COUNT
         */
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        
     // Increment launch counter
        long launch_count = myPrefs.getLong("launch_count", 0) + 1;
        prefsEditor.putLong("launch_count", launch_count);
        prefsEditor.commit();
        Log.d("SP", "launchCount = " + launch_count);
        
        
        
        /*
         * 	CREATE NOTIFICATION ADVERTISING THE DONATE VERSION
         */
        createNotification(launch_count);
       
        
        //IF SHARED PREFERENCES CONTAINS A USSD CODE
        if(!prefUssd.equals("nothing")) {
        	Log.d("SP", "prefUssd ! = nothing        prefUssd = " + prefUssd);
        	
        	//replace each # symbol with %23
        	prefUssd = prefUssd.replaceAll("#", encodedHash);
        	Log.d("SP", "prefUssd after replace # = " + prefUssd);
        	
        	//make the call
        	String url = "tel:" + prefUssd;
            intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
            startActivity(intent);
            finish();
            //CODE TO CLEAR PREFERENCES
        	//myPrefs.edit().remove("checkBalance").commit();
        	//myPrefs.edit().clear().commit();
        }
        
        
        
        //If there are no Shared Preferences saved, then the following code will be executed
        //to find out what country the user is in and call the appropriate class.
        //-----------------------------------------------------------------------------------------
        //IRELAND--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("ie")){
	        	
	            intent = new Intent(CheckBalance.this, Ireland.class);
	           	startActivity(intent);
	           	finish();
	            
        }
        //-----------------------------------------------------------------------------------------
        //ARMENIA--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("am")){
        	
        	intent = new Intent(CheckBalance.this, Armenia.class);
        	startActivity(intent);
        	finish();
        	
        }
        //-----------------------------------------------------------------------------------------
        //AUSTRALIA--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("au")){
        	intent = new Intent(CheckBalance.this, Australia.class);
           	startActivity(intent);
           	finish();
        }
        //-----------------------------------------------------------------------------------------
        //BELGIUM-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("be")){
        	intent = new Intent(CheckBalance.this, Belgium.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //BRAZIL-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("br")){
        	intent = new Intent(CheckBalance.this, Brazil.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //CANADA-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("ca")){
        	intent = new Intent(CheckBalance.this, Canada.class);
           	startActivity(intent);
           	finish();
        }
        //-----------------------------------------------------------------------------------------
        //CHINA-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("cn")){
        	intent = new Intent(CheckBalance.this, China.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //FRANCE-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("fr")){
        	intent = new Intent(CheckBalance.this, France.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //GERMANY-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("de")){
        	intent = new Intent(CheckBalance.this, Germany.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //INDIA-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("in")){
        	intent = new Intent(CheckBalance.this, India.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //ITALY-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("it")){
        	intent = new Intent(CheckBalance.this, Italy.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //KAZAKHSTAN-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("kz")){
        	intent = new Intent(CheckBalance.this, Kazakhstan.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //MEXICO-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("mx")){
        	intent = new Intent(CheckBalance.this, Mexico.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //NETHERLANDS-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("nl")){
        	intent = new Intent(CheckBalance.this, Netherlands.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //NEW ZEALAND--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("nz")){
        	intent = new Intent(CheckBalance.this, NewZealand.class);
           	startActivity(intent);
           	finish();
        }
        //-----------------------------------------------------------------------------------------
        //POLAND-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("pl")){
        	intent = new Intent(CheckBalance.this, Poland.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //PORTUGAL-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("pt")){
        	intent = new Intent(CheckBalance.this, Portugal.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //ROMANIA-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("ro")){
        	intent = new Intent(CheckBalance.this, Romania.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //RUSSIA-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("ru")){
        	intent = new Intent(CheckBalance.this, Russia.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //SPAIN-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("es")){
        	intent = new Intent(CheckBalance.this, Spain.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //SWEDEN-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("se")){
        	intent = new Intent(CheckBalance.this, Sweden.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //THAILAND-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("th")){
        	intent = new Intent(CheckBalance.this, Thailand.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //UNITED KINGDOM/GREAT BRITAIN--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("uk") || networkCountry.contains("gb")|| networkCountry.contains("UK")
        		|| networkCountry.contains("GB")){
        	intent = new Intent(CheckBalance.this, UK.class);
           	startActivity(intent);
           	finish();
        }
        //-----------------------------------------------------------------------------------------
        //UKRAINE--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("ua") || networkCountry.contains("UA")){
        	intent = new Intent(CheckBalance.this, Ukraine.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //USA--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("us")){
        	intent = new Intent(CheckBalance.this, USA.class);
           	startActivity(intent);
           	finish();
        }
        //-----------------------------------------------------------------------------------------
        //UZBEKISTAN--------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        else if(networkCountry.contains("uz")){
        	intent = new Intent(CheckBalance.this, Uzbekistan.class);
        	startActivity(intent);
        	finish();
        }
        //-----------------------------------------------------------------------------------------
        //COUNTRY NOT FOUND-----------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------
        
        else{
        	//if country is not found
  	      	//Toast.makeText(getApplicationContext(), "Your Country Is Currently Not Supported - Send us an email and we'll add it for you!",
  	        //Toast.LENGTH_LONG).show();
  	      	
  	      	intent = new Intent(this, DIYActivity.class);
  	      	startActivity(intent);
  	      	finish();
        }
       
    }

	private void createNotification(long launch_count) {
		
		//if launchcount is dividable by 20
		if(launch_count % 10 == 0){
			//Get a reference to the NotificationManager:
	    	String ns = Context.NOTIFICATION_SERVICE;
	    	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
	    	
	    	//Instantiate the Notification:
	    	int icon = R.drawable.ic_launcher;
	    	CharSequence tickerText = getString(R.string.hi);
	    	long when = System.currentTimeMillis();

	    	Notification notification = new Notification(icon, tickerText, when);
	    	
	    	//Define the notification's message and PendingIntent:
	    	Context context = getApplicationContext();
	    	CharSequence contentTitle = getString(R.string.app_name);
	    	CharSequence contentText = getString(R.string.tap_to_get_the_donate_version);
	    	//intent to open page on android market
	    	Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
			notificationIntent.setData(Uri.parse("market://details?id=cacafogo.software.touchBalanceDonate"));
			//startActivity(notificationIntent);
	    	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

	    	notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
	    	//Pass the Notification to the NotificationManager:
	    	final int HELLO_ID = 1;

	    	mNotificationManager.notify(HELLO_ID, notification);
		}
		
	}

}