package com.example.sharetodropbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
 
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.exception.DropboxException;
 
public class UploadFileToDropbox extends AsyncTask<Void, Void, Boolean> {
 
    private DropboxAPI<?> dropbox;
    private String path = "/storage/sdcard/";
    private Context context;
 
    public UploadFileToDropbox(Context context, DropboxAPI<?> dropbox,
            String path) {
        this.context = context.getApplicationContext();
        this.dropbox = dropbox;
        this.path = path;
    }
 
    @Override
    protected Boolean doInBackground(Void... params) {
        final File tempDir = context.getCacheDir();
        File tempFile;
        FileWriter fr;
        try {
            tempFile = File.createTempFile("file", ".txt", tempDir);
            fr = new FileWriter(tempFile);
            fr.write("Sample");
            fr.close();
 
            FileInputStream fileInputStream = new FileInputStream(tempFile);
            dropbox.putFile(path + "HaxLogs.txt", fileInputStream,
                    tempFile.length(), null, null);
            tempFile.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DropboxException e) {
            e.printStackTrace();
        }
 
        return false;
    }
 
    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            Toast.makeText(context, "File Uploaded Sucesfully!",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Failed to upload file", Toast.LENGTH_LONG)
                    .show();
        }
    }
}