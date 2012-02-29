package org.example.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
public class CongratScreen extends Activity implements OnClickListener
{
	private static final String TAG = "Sudoku";
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.congratscreen);
        View menuButton = findViewById(R.id.menu_button);
        menuButton.setOnClickListener(this);
        View replayButton = findViewById(R.id.replay_button);
        replayButton.setOnClickListener(this);
	}
	
	public void onClick(View v) 
    {
    	switch (v.getId())
    	{
    		case R.id.menu_button:
    			finish();
    			break;
	    	case R.id.replay_button:
	    		openNewGameDialog();
	    		break;
	    	// More buttons go here (if any) ...
    	}
    }
    
    private void openNewGameDialog()
    {
    	new AlertDialog.Builder(this)
    			.setTitle(R.string.new_game_title)
    			.setItems(R.array.difficulty,
    					new DialogInterface.OnClickListener()
    						{
    							public void onClick(DialogInterface dialoginterface, int i)
    							{
    								startGame(i);
    							}
    						})
    			.show();
    }
    
    private void startGame(int i)
    {
    	Log.d(TAG, "clicked on " + i);
    	//Start game here...
    	Intent intent = new Intent(this,Game.class);
    	intent.putExtra(Game.KEY_DIFFICULTY, i);
    	startActivity(intent);
    	finish();
    }

	public void onClick(DialogInterface dialog, int which) 
	{
		// TODO Auto-generated method stub
		
	}
	
	protected void onResume()
    {
    	super.onResume();
    	Music.play(this, R.raw.congrat);
    }
    
    protected void onPause()
    {
    	super.onPause();
    	Music.stop(this);
    }
}
