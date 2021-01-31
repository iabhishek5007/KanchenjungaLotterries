package com.rckdeveloper.kanchenjungalotterries;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import im.delight.android.webview.AdvancedWebView;

public class HomeActivity extends AppCompatActivity implements AdvancedWebView.Listener {

    private static final String TEST_PAGE_URL = "http://kanchenjungalotterries.com/";
    private AdvancedWebView mWebView;
    boolean doubleBackToExitPressedOnce = false;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        // progressDialog.show();

        mWebView = (AdvancedWebView) findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.setGeolocationEnabled(true);
        mWebView.setMixedContentAllowed(true);
        mWebView.setCookiesEnabled(true);
        mWebView.setThirdPartyCookiesEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {


        });
        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                //   Toast.makeText(HomePage.this, title, Toast.LENGTH_SHORT).show();
            }

        });
        mWebView.addHttpHeader("X-Requested-With", "");
        mWebView.loadUrl(TEST_PAGE_URL);


    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) {
            return;
        }
        // ...

        if (doubleBackToExitPressedOnce) {
            // Log.i(TAG, "double click");
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.kanchenjungalotterries)
                    .setTitle("Press Exit To Close App:")
                    .setMessage("Are you sure to exit?")
                    .setPositiveButton("Exit",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    finish();
                                }

                            }).setNegativeButton("No", null).show();
            return;
        } else {
            //   Log.i(TAG, "single click");
            if (mWebView.canGoBack()) {
                //   Log.i(TAG, "canGoBack");
                mWebView.goBack();
            } else {
                //   Log.i(TAG, "nothing to canGoBack");
            }
        }

        this.doubleBackToExitPressedOnce = true;
        if (getApplicationContext() == null) {
            return;
        } else {
            //    Toast.makeText(this, "Please click BACK again to exit",
            //     Toast.LENGTH_SHORT).show();
        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
//        super.onBackPressed();
    }


    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        mWebView.setVisibility(View.INVISIBLE);
        progressDialog.show();
    }

    @Override
    public void onPageFinished(String url) {
        mWebView.setVisibility(View.VISIBLE);
        progressDialog.dismiss();
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
        Toast.makeText(HomeActivity.this, "onPageError(errorCode = " + errorCode + ",  description = " + description + ",  failingUrl = " + failingUrl + ")", Toast.LENGTH_SHORT).show();


    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
//        Intent intent = new Intent(HomeActivity.this, PdfiewerActivity.class);
//        intent.putExtra("url", url);
//        startActivity(intent);

    }

    @Override
    public void onExternalPageRequest(String url) {
        Toast.makeText(HomeActivity.this, "onExternalPageRequest(url = " + url + ")", Toast.LENGTH_SHORT).show();
    }
}