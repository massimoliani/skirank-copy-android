package com.skirank.plugins.copyandroid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.OpenableColumns;
import android.util.Log;
//import com.getcapacitor.FileUtils;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@CapacitorPlugin(name = "CopyAndroid")
public class CopyAndroidPlugin extends Plugin {

    private CopyAndroid implementation = new CopyAndroid();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    public File getDirectory(String directory, Context context) {
        Context c = context;
        switch (directory) {
            case "DOCUMENTS":
                return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            case "DATA":
            case "LIBRARY":
                return c.getFilesDir();
            case "CACHE":
                return c.getCacheDir();
            case "EXTERNAL":
                return c.getExternalFilesDir(null);
            case "EXTERNAL_STORAGE":
                return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    private Uri getCopyFilePath(Uri uri, String directory, String filename, Context context) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            return null;
        }
        int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
        if (!cursor.moveToFirst()) {
            return null;
        }
        String name = cursor.getString(nameIndex);
        Log.v("COPY-ANDROID", "original filename" + name);

        File file, dir;
        if (directory != null) {
            dir = this.getDirectory(directory, context);
        } else {
            dir = context.getCacheDir();
        }
        if (filename == null) {
            filename = name;
        }
        file = new File(dir, filename);

        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            FileOutputStream outputStream = new FileOutputStream(file);
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                Log.v("COPY-ANDROID", "os file system copy");
                FileUtils.copy(inputStream, outputStream);
            } else {
                int read;
                int maxBufferSize = 1024 * 1024;
                int bufferSize = Math.min(inputStream.available(), maxBufferSize);
                final byte[] buffers = new byte[bufferSize];
                Log.v("COPY-ANDROID", "while loop stream copy");
                while ((read = inputStream.read(buffers)) != -1) {
                    outputStream.write(buffers, 0, read);
                }
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            return null;
        } finally {
            cursor.close();
        }

        Uri fileUri = Uri.fromFile(file);
        Log.v("COPY-ANDROID", "final fileuri" + fileUri.toString());
        return fileUri;
    }

    @PluginMethod
    public void copy(PluginCall call) {
        Uri uri = Uri.parse(call.getString("path"));
        String filename = call.getString("filename");
        String directory = call.getString("directory");

        Context context = getBridge().getActivity().getApplicationContext();
        uri = getCopyFilePath(uri, directory, filename, context);

        JSObject ret = new JSObject();
        ret.put("path", uri.toString());
        call.resolve(ret);
    }
}
