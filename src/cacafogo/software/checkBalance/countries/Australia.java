package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Australia extends Country {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

    	checkNetworks();
    }

    
    
    public void checkNetworks(){
    	//vodafone au
        if(operatorName.contains("odafone")){
        	smsNumber = "1512";
            smsText = " ";
            
            sendText(smsNumber,smsText);
        }
        //optus au
        else if(operatorName.contains("ptus")){
        	smsNumber = "9999";
            smsText = "Balance";
            
            sendText(smsNumber,smsText);
        }
        //telstra au
        else if(operatorName.contains("elstra")){
        	code = encodedHash + "100" + encodedHash;
        	callUSSD(code);
        }
        else{
        	//if network is not found
  	      	diyUssd();
        }
    }
  
}
