package edu.temple.lab4adapterandactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle("Canvas Activity");

        Intent myIntent = getIntent();

        String message = myIntent.getStringExtra("message");

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        View myView = findViewById(R.id.activity_canvas);
        myView.setBackgroundColor(Color.parseColor(message));
    }
}
