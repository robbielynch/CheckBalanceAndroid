package cacafogo.software.checkBalance.countries;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class Ireland extends Country {
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //vodafone
	        if(operatorName.contains("odafone")){
	        	code = "*174" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        	
	        	//url = "http://www.cacafogo.tk";
	        	//openURL(url);
	        }
	        //o2
	        else if(operatorName.contains("2")){
	        	code = "*100" + encodedHash;
	        	callUSSD(code);
	        }
	        //Meteor
	        else if(operatorName.contains("eteor")){
	        	code = "*" + encodedHash + "100" + encodedHash;
	        	callUSSD(code);
	        }
	        //Three
	        else if(operatorName.contains("hree") || operatorName.contains("3") 
	        		|| operatorName.contains("THREE")){

	        	//get wifi network info from the connectivity manager
	        	ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
	        	NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

	        	//if wifi is connected...
	        	if (mWifi.isConnected()) {
	        		//connect to website
	        		url = "https://my3.three.ie";
		        	openURL(url);
	        	}else{
	        		//connect to my 3
	        		url = "http://mobile.3ireland.ie/hb/singleurl";
	        		openURL(url);
	        	}
	        }
	        //Postfone
	        else if(operatorName.contains("ostfone")){
	        	code = "*" + "200" + encodedHash;
	        	callUSSD(code);
	        }
	        //Tesco
	        else if(operatorName.contains("esco")){
	        	code = "*" + "100" + encodedHash;
	        	callUSSD(code);
	        }
	        //emobile
	        else if(operatorName.contains("eMobile") || operatorName.contains("emobile") || operatorName.contains("Emobile")
	        		|| operatorName.contains("EMOB") || operatorName.contains("e-m") || operatorName.contains("E-M")
	        		|| operatorName.contains("e-M") || operatorName.contains("E-m")){
	        	code = "*" + encodedHash + "100" + encodedHash;
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
	  
}
