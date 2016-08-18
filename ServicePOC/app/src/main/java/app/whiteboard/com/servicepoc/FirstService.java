package app.whiteboard.com.servicepoc;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FirstService extends Service {

    private static String TAG = "SampleServiceApp";
    private File targetDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    File outFile;
    FileWriter fileWriter;
    BufferedWriter writer;


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
        outFile = new File(targetDir, "servicePOC.txt");
        try {
            fileWriter =new FileWriter(outFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer = new BufferedWriter(fileWriter);

        save("Hey this is a service POC ");
    }

    public void save(String textContent){
        try{
           writer.write(textContent);
        }
        catch (Exception ex){
            Log.e("Exception occurred!!!", ex.getMessage());
        }
        simulateDelay();

    }
    private void simulateDelay(){
        try{
            //Thread.sleep(3000);
            save("this again");
        }catch(Exception ex)
        {
            // Only likely exception is an InterruptedException which we can ignore
        }
    }

   @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d(TAG, "ServicePOC service was terminated");
    }

}
