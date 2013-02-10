package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class NewZealand extends Country {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

    	checkNetworks();
    }

    
    
    public void checkNetworks(){
    	//vodafone nz
    	if(operatorName.contains("odafone")){
    		smsNumber = "777";
            smsText = "bal";
            
            sendText(smsNumber, smsText);
    	}
    	//telecom nz
    	else if(operatorName.contains("elecom")){
    		smsNumber = "333";
            smsText = "Bal";
            
            sendText(smsNumber,smsText);
    	}
    	else{
    		//if network is not found
    		diyUssd();
    	}
    }
  
}
