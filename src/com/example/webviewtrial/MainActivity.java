package com.example.webviewtrial;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

   private WebView browser;

   @Override		
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      browser = (WebView)findViewById(R.id.webView1);
      browser.getSettings().setLoadsImagesAutomatically(true);
      browser.getSettings().setJavaScriptEnabled(true);
      browser.setWebViewClient(new MyBrowser());
      browser.loadUrl("file:///android_asset/try.html");
   
      browser.setOnTouchListener(new View.OnTouchListener() {


			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return (event.getAction() == MotionEvent.ACTION_MOVE);
				}
    	  });
   }



   private class MyBrowser extends WebViewClient {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
         view.loadUrl(url);
         return true;
      }
   }
}

