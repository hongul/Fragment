package edu.temple.lab4adapterandactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteFragment extends Fragment {

    PaletteInterface parent;
    ColorAdapter myAdapter;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.activity_palette, container, false);

        // grid for colors
        GridView myGridview = (GridView) layout.findViewById(R.id.gridview);
        // string to be use for parsing when current language is not english
        final String[] actualColors = {"White", "Cyan", "Blue", "Grey", "Purple"};
        // use resource string when language is not english
        Resources res = getResources();
        String[] myColors = res.getStringArray(R.array.colors_array);

        // get context
        Context myContext;
        myContext = getActivity();
        // give content to adapter
        myAdapter = new ColorAdapter(myContext, myColors);
        myGridview.setAdapter(myAdapter);

        // on click listener for color selection
        myGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String message = actualColors[i];


                    parent.sendMessage(message);


            }
        });

        return layout;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof  PaletteInterface){
            parent = (PaletteInterface) activity;
        } else {
            throw new RuntimeException("Not Implemented");
        }

    }

    public interface PaletteInterface {
        void sendMessage(String message);
    }


}
