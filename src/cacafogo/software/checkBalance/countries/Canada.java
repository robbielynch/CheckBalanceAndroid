package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Canada extends Country {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

    	
    	checkNetworks();
    }

    
    
    public void checkNetworks(){
    	//Rogers Wireless
    	if(operatorName.contains("ogers") || operatorName.contains("ROGERS")){
    		code = "*225";
    		callUSSD(code);
    	}
    	//Bell Mobility
    	else if(operatorName.contains("ell") || operatorName.contains("BELL") || operatorName.contains("Bell")){
    		code = encodedHash + "321";
    		callUSSD(code);
    	}
    	//telus Mobility
    	else if(operatorName.contains("elus") || operatorName.contains("TELUS")){
    		code = encodedHash + "123";
    		callUSSD(code);
    	}
    	else{
    		//if network is not found
    		diyUssd();
    	}
    }
  
}
