package org.opencv.samples.facedetect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Menu extends Activity {

	
	String count = "0";
	TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Faces counted: " + count);
        Log.w("MENU", "ON CREATE");
        
       
    }
    
    
    public void button1_OnClick(View v)
    {
    	Intent mainIntent = new Intent(Menu.this, FdActivity.class);
        Menu.this.startActivityForResult(mainIntent, 1);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	//super.onActivityResult(requestCode, resultCode, data);
    	
    	Log.w("MENU", String.valueOf(resultCode));
    	
        if (requestCode == 1) {
             if(resultCode == RESULT_OK){
              count = data.getStringExtra("count");
              Log.w("MENU", "ACTIVITY RESULT count = " + count);
              textView.setText("Faces counted: " + count);
             }
             else textView.setText("Faces counted: " + "failure retrieving data");
        }
   }
    
    @Override
    public void onResume(){
    	super.onResume();
    	
    	//textView.setText("Faces counted: " + count);
    	Log.w("MENU", "ON RESUME");
    	Log.w("MENU", "ON RESUME count = " + count);
    }
    
    
}