package br.eng.mosaic.pigeon.client.gui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import br.eng.mosaic.pigeon.client.R;
import br.eng.mosaic.pigeon.client.gameplay.SelectPerson;
import br.eng.mosaic.pigeon.client.gameplay.Stage;
import br.eng.mosaic.pigeon.client.infra.SendMessage;
import br.eng.mosaic.pigeon.client.infra.facebook.LoginFacebook;

public class MainActivity extends Activity {
	static final private int GET_CODE = 0;
	protected Drawable getDrawable(int id) {
    	return this.getResources().getDrawable( id );
    }
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.start_game).setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        startGame();
                    }
                });

       
		//showTopFive();
		
        
        /*findViewById(R.id.high_score).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showHighScore();
            }
        });
        */
		findViewById(R.id.facebook).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				loginFacebook();
			}
		});
		
		findViewById(R.id.twitter_button).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				enviaMensagem();
			}
		});
		
		
	}
	
	private void startGame() {
		// call the dialog to set a message
		try {

			this.showDialog(Stage.DIALOG_CHOOSE_MESSAGE);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}		
		//Intent i = new Intent(this, Stage1.class);
		//Intent i = new Intent(this, Stage2.class);
		//Intent i = new Intent(this, Stage3.class);
		Intent i = new Intent(this, SelectPerson.class);
		startActivity(i);
	}

	private void showTopFive() {

		Intent i = new Intent(this, TopFiveActivity.class);
		startActivity(i);
	}

	private void showHighScore() {

		Intent i = new Intent(this, HighScoreActivity.class);
		startActivity(i);
	}

	private void loginFacebook() {
		if (haveInternet(getBaseContext()))
    	{
			Intent i = new Intent(this, LoginFacebook.class);
			startActivity(i);
    	}else
    	{
    		Toast.makeText(MainActivity.this, "No internet connection", Toast.LENGTH_SHORT).show();
    	}
	}
	
	public void enviaMensagem() {
		startActivity(new Intent(this, SendMessage.class));
	}
	
	public static boolean haveInternet(Context ctx) {
 	   NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
 	   if (info == null || !info.isConnected()) {
 	       return false;
 	   }
 	   if (info.isRoaming()) {
 	       return false;
 	   }
 	  
 	   return true;
 	}
	
	@Override
	protected void onPause() {
		super.onPause();
		setResult(RESULT_CANCELED);
		finish(); // Close the screen
	}
}