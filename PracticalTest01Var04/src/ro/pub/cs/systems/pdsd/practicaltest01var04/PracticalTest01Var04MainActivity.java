package ro.pub.cs.systems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;


public class PracticalTest01Var04MainActivity extends Activity {

	private EditText field;
	private ButtonClickListener bcl = new ButtonClickListener(); 
	private int tries = 0, correct = 0, incorrect = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        
        field = (EditText)findViewById(R.id.editText1);
        
        Button bt1 = (Button)findViewById(R.id.button_digit_1);
        bt1.setOnClickListener(bcl);
        Button bt2 = (Button)findViewById(R.id.button_digit_2);
        bt2.setOnClickListener(bcl);
        Button bt3 = (Button)findViewById(R.id.button_digit_3);
        bt3.setOnClickListener(bcl);
        Button bt4 = (Button)findViewById(R.id.button_digit_4);
        bt4.setOnClickListener(bcl);
        Button bt5 = (Button)findViewById(R.id.button1);
        bt5.setOnClickListener(bcl);
        
        if (savedInstanceState != null) {
			int leftCount = savedInstanceState.getInt("tries_done");
			if (leftCount != 0) {
				tries = leftCount;
			} else {
				tries = 0;
			}
			int rightCount = savedInstanceState.getInt("correct_done");
			if (rightCount != 0) {
				correct = rightCount;
			} else {
				correct = 0;
			}
			
			int okCount = savedInstanceState.getInt("incorrect_done");
			if (okCount != 0) {
				incorrect = okCount;
			} else {
				incorrect = 0;
			}
		} 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var04_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    protected class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			
			switch (view.getId()) {

			case R.id.button_digit_1:
				if (field.getText().toString().isEmpty() == false)
					field.setText(field.getText().toString() + ", "
							+ ((Button) view).getText().toString());
				else
					field.setText(field.getText().toString()
							+ ((Button) view).getText().toString());
				break;

			case R.id.button_digit_2:
				if (field.getText().toString().isEmpty() == false)
					field.setText(field.getText().toString() + ", "
							+ ((Button) view).getText().toString());
				else
					field.setText(field.getText().toString()
							+ ((Button) view).getText().toString());
				break;

			case R.id.button_digit_3:
				if (field.getText().toString().isEmpty() == false)
					field.setText(field.getText().toString() + ", " + ((Button) view).getText().toString());
				else
					field.setText(field.getText().toString()
							+ ((Button) view).getText().toString());
				break;

			case R.id.button_digit_4:
				if (field.getText().toString().isEmpty() == false)
					field.setText(field.getText().toString() + ", " + ((Button) view).getText().toString());
				else
					field.setText(field.getText().toString() + ((Button) view).getText().toString());
				break;
				
			case R.id.button1:
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var04SecondaryActivity");
				intent.putExtra("verify", field.getText().toString());
				startActivityForResult(intent, 1);
				break;

			}
		}
		
    }
    
    @Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
    	
    	savedInstanceState.putString("tries_done", String.valueOf(tries));
    	savedInstanceState.putString("correct_done", String.valueOf(correct));
    	savedInstanceState.putString("incorrect_done", String.valueOf(incorrect));
    	
    	//Log.d(Constants.TAG, "onSaveInstanceState method was invoked");
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      
      super.onRestoreInstanceState(savedInstanceState);
      //Log.d(Constants.TAG, "onSaveInstanceState method was invoked");
    }
    
}
