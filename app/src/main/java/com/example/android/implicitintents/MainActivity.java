package com.example.android.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_editText);
        mLocationEditText = findViewById(R.id.location_editText);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        Uri website = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, website);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.i("Implicit intents", "Can't handle this intent.");
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri location = Uri.parse("geo:0,0?=" + loc);

        Intent intent = new Intent(Intent.ACTION_VIEW, location);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.i("Implicit intents", "Can't handle this intent.");
        }
    }
}