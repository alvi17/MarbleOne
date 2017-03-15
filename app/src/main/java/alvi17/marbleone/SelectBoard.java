package alvi17.marbleone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import static android.os.Build.VERSION_CODES.M;

public class SelectBoard extends Activity implements OnClickListener {

	int NO_BOARDS =21;
	int BOARD = 0;
	ImageView imgBoards[] = new ImageView[NO_BOARDS];
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_board);

		
		imgBoards[0] = (ImageView)findViewById(R.id.idImgBoard0);
		imgBoards[1] = (ImageView)findViewById(R.id.idImgBoard1);
		imgBoards[2] = (ImageView)findViewById(R.id.idImgBoard2);
		imgBoards[3] = (ImageView)findViewById(R.id.idImgBoard3);
		imgBoards[4] = (ImageView)findViewById(R.id.idImgBoard4);
		imgBoards[5] = (ImageView)findViewById(R.id.idImgBoard5);
		imgBoards[6] = (ImageView)findViewById(R.id.idImgBoard6);
		imgBoards[7] = (ImageView)findViewById(R.id.idImgBoard7);

		imgBoards[8] = (ImageView)findViewById(R.id.idImgBoard8);
		imgBoards[9] = (ImageView)findViewById(R.id.idImgBoard9);
		imgBoards[10] = (ImageView)findViewById(R.id.idImgBoard10);
		imgBoards[11] = (ImageView)findViewById(R.id.idImgBoard11);
		imgBoards[12] = (ImageView)findViewById(R.id.idImgBoard12);
		imgBoards[13] = (ImageView)findViewById(R.id.idImgBoard13);
		imgBoards[14] = (ImageView)findViewById(R.id.idImgBoard14);
		imgBoards[15] = (ImageView)findViewById(R.id.idImgBoard15);

		imgBoards[16] = (ImageView)findViewById(R.id.idImgBoard16);
		imgBoards[17] = (ImageView)findViewById(R.id.idImgBoard17);
		imgBoards[18] = (ImageView)findViewById(R.id.idImgBoard18);
		imgBoards[19] = (ImageView)findViewById(R.id.idImgBoard19);
		imgBoards[20] = (ImageView)findViewById(R.id.idImgBoard20);


		
		for(int i=0;i<NO_BOARDS;i++){
			imgBoards[i].setOnClickListener(this);
		}
		

		SharedPreferences masPref = this.getSharedPreferences("alvi17.marbleone", MODE_PRIVATE);
		int index = masPref.getInt("board", BOARD);
		
		for(int i=0;i<NO_BOARDS;i++){
			if(masPref.getBoolean("game"+i+"_finished", false)){
				imgBoards[i].setImageDrawable(getResources().getDrawable(R.drawable.ic_tick));
			}
		}
		
		if(masPref.getBoolean("game"+index+"_finished", false)){
			imgBoards[index].setImageResource(R.drawable.ic_select_frame_finished);
		}else{
			imgBoards[index].setImageResource(R.drawable.ic_select_frame);
		}
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		SharedPreferences masPref = this.getSharedPreferences("alvi17.marbleone", MODE_PRIVATE);
		SharedPreferences.Editor prefEditor = masPref.edit();
		for(int i=0;i<NO_BOARDS;i++){
			if(v == imgBoards[i]){
				changeBoard(i);
			}
		}
		
		prefEditor.commit();
		
	}
	
	private void changeBoard(int index) {
		// TODO Auto-generated method stub
		SharedPreferences masPref = this.getSharedPreferences("alvi17.marbleone", MODE_PRIVATE);
		SharedPreferences.Editor prefEditor = masPref.edit();
		
		int currentIndex = masPref.getInt("board", BOARD);
		if(masPref.getBoolean("game"+currentIndex+"_finished", false)){
			imgBoards[currentIndex].setImageResource(R.drawable.ic_tick);
		}else{
			imgBoards[currentIndex].setImageResource(R.drawable.ic_empty_pebble);
		}
		prefEditor.putInt("board", index);
		if(masPref.getBoolean("game"+index+"_finished", false)){
			imgBoards[index].setImageResource(R.drawable.ic_select_frame_finished);
		}else{
			imgBoards[index].setImageResource(R.drawable.ic_select_frame);

		}
		imgBoards[index].invalidate();
		prefEditor.commit();
		
	}

	public void finish(View view){
		Intent databackIntent = new Intent(SelectBoard.this,MASPebbleActivity.class);
		startActivity(databackIntent);
		finish();
	}
	
	

}
