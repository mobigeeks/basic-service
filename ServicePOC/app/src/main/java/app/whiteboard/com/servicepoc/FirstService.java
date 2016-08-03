package app.whiteboard.com.servicepoc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class FirstService extends Service {

    private static String TAG = "SampleServiceApp";

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
        Log.d(TAG, "FirstService started");
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG,"Service is running");
        }
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d(TAG, "FirstService destroyed");
    }

}
