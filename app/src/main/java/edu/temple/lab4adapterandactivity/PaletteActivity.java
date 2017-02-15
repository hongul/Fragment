package edu.temple.lab4adapterandactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        setTitle("Palette Activity");

        GridView myGridview = (GridView) findViewById(R.id.gridview);

        final String[] myColors = {"White", "Cyan", "Blue", "Grey", "Purple"};

        ColorAdapter myAdapter = new ColorAdapter(this, myColors);

        myGridview.setAdapter(myAdapter);

        myGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(PaletteActivity.this, CanvasActivity.class);

                String message = ((TextView) view).getText().toString();
                //Toast.makeText(PaletteActivity.this, message, Toast.LENGTH_SHORT).show();

                myIntent.putExtra("message", message);

                startActivity(myIntent);
            }
        });

    }
}
