package jp.sample.foo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class ShowTouchEvent extends Activity {
	private String touchInfo = "";
	private TextView tv;
	private int touchCount = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView)findViewById(R.id.tv);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
    	touchCount++;
    	if(touchCount >= 100)
    	{
    		touchCount = 0;
    		touchInfo = "";
    	}
    	switch(event.getAction())
    	{
    	case MotionEvent.ACTION_CANCEL:
    		touchInfo =  "CANCEL:" + touchInfo;
    		break;
    	case MotionEvent.ACTION_DOWN:
    		touchInfo =  "DOWN:" + touchInfo;
    		break;
    	case MotionEvent.ACTION_UP:
    		touchInfo =  "UP:" + touchInfo;
    		break;
    	case MotionEvent.ACTION_MOVE:
    		touchInfo =  "MOVE:" + touchInfo;
    		break;
    	}
    	touchInfo = "(X=" + event.getX() + ", Y=" + event.getY() + ")\n" + touchInfo;
    	tv.setText(touchInfo);
    	return super.onTouchEvent(event);
    }
}