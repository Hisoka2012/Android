package com.example.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends Activity {
	
	
	private DialogFragment dialogframgment; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		final View one = findViewById(R.id.one);
		final View two = findViewById(R.id.two);
		final View three = findViewById(R.id.three);
		final View four = findViewById(R.id.four);
		final View five = findViewById(R.id.five);
		
		one.setBackgroundColor(Color.GRAY);
		two.setBackgroundColor(Color.rgb(0, 255, 0));
		three.setBackgroundColor(Color.rgb(255, 0, 255));
		four.setBackgroundColor(Color.WHITE);
		five.setBackgroundColor(Color.rgb(0, 0, 255));

		final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
		
		
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener (){
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				int times = 3 * progress;
				int middle =  progress+15;
				two.setBackgroundColor(Color.rgb(progress, middle, times)); 
				three.setBackgroundColor(Color.rgb(middle, times, progress)); 
				five.setBackgroundColor(Color.rgb(times, progress, middle)); 
			}
			
		});
		
			
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	
	



	public static class AlertDialogFragment extends DialogFragment {

		public static AlertDialogFragment newInstance() {
			return new AlertDialogFragment();
		}
	
	
		@Override  
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the Builder class for convenient dialog construction     
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
						.setMessage(R.string.dialog_message).setCancelable(false); 
			
			builder.setNegativeButton(R.string.action_visit_moma,new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.moma.org"));
							startActivity(intent);
						}
						});
					
			builder.setPositiveButton(R.string.action_not_now, new DialogInterface.OnClickListener(){ 
						public void onClick(DialogInterface dialog, int id) {
								// User cancelled the dialog
						}
						});
			
			// Create the AlertDialog object and return it
			 return builder.create();
		}

	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_more_information) {
			dialogframgment = AlertDialogFragment.newInstance();
			dialogframgment.show(getFragmentManager(), "More Information");
			
		}
		return super.onOptionsItemSelected(item);
	}
}
