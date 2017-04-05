package edu.temple.lab4adapterandactivity;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends Fragment {

    View myView;
    private String color;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.activity_canvas, container, false);

        myView = layout.findViewById(R.id.activity_canvas);

        Bundle args = getArguments();
        if( args != null) {
            color = args.getString("color");
            myView.setBackgroundColor(Color.parseColor(color));
        }


        return layout;
    }

    public void changeBGcolor(String message){
        myView.setBackgroundColor(Color.parseColor(message));
    }
}
