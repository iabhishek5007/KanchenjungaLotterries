package com.rckdeveloper.kanchenjungalotterries;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class PdfiewerActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfiewer);
        pdfView = (PDFView) findViewById(R.id.pdfView);

//        String url = getIntent().getStringExtra("url");
//        URL myUri = "http://kanchenjungalotterries.com/images/KJ%20MOR%2030.01.2021%20SATURDAY.pdf?dateTime=11dbf";
//
//
//        pdfView.fromUri(myUri).load();


    }

//    private void downloadFile() {
//        progressBar.setVisibility(View.VISIBLE);
//        DownloadFileTask task = new DownloadFileTask(
//                WebViewActivity.this,
//                mURL,
//                "/download/pdf_file.pdf");
//        task.startTask();
//    }
//
//    @Override
//    public void onFileDownloaded() {
//        progressBar.setVisibility(View.GONE);
//        File file = new File(Environment.getExternalStorageDirectory()
//                .getAbsolutePath()
//                + "/download/pdf_file.pdf");
//        if (file.exists()) {
//            pdfView.fromFile(file)
//                    //.pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
//                    .enableSwipe(true)
//                    .swipeHorizontal(true)
//                    .enableDoubletap(true)
//                    .defaultPage(0)
//                    .enableAnnotationRendering(true)
//                    .password(null)
//                    .scrollHandle(null)
//                    .onLoad(new OnLoadCompleteListener() {
//                        @Override
//                        public void loadComplete(int nbPages) {
//                            pdfView.setMinZoom(1f);
//                            pdfView.setMidZoom(5f);
//                            pdfView.setMaxZoom(10f);
//                            pdfView.zoomTo(2f);
//                            pdfView.scrollTo(100, 0);
//                            pdfView.moveTo(0f, 0f);
//                        }
//                    })
//                    .load();
//
//        }
//    }
//
//    public class DownloadFileTask {
//        public static final String TAG = "DownloadFileTask";
//
//        private AppCompatActivity context;
//        private GetTask contentTask;
//        private String url;
//        private String fileName;
//
//        public DownloadFileTask(AppCompatActivity context, String url, String fileName) {
//            this.context = context;
//            this.url = url;
//            this.fileName = fileName;
//        }
//
//        public void startTask() {
//            doRequest();
//        }
//
//        private void doRequest() {
//            contentTask = new GetTask();
//            contentTask.execute();
//        }
//
//        private class GetTask extends AsyncTask<String, Integer, String> {
//
//            @Override
//            protected String doInBackground(String... arg0) {
//                int count;
//                try {
//                    Log.d(TAG, "url = " + url);
//                    URL _url = new URL(url);
//                    URLConnection conection = _url.openConnection();
//                    conection.connect();
//                    InputStream input = new BufferedInputStream(_url.openStream(),
//                            8192);
//                    OutputStream output = new FileOutputStream(
//                            Environment.getExternalStorageDirectory() + fileName);
//                    byte data[] = new byte[1024];
//                    while ((count = input.read(data)) != -1) {
//                        output.write(data, 0, count);
//                    }
//                    output.flush();
//                    output.close();
//                    input.close();
//                } catch (Exception e) {
//                    Log.e("Error: ", e.getMessage());
//                }
//                return null;
//            }
//
//            protected void onPostExecute(String data) {
//                context.onFileDownloaded();
//            }
//        }
//    }
}