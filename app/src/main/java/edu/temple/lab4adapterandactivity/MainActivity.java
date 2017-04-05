package edu.temple.lab4adapterandactivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements PaletteFragment.PaletteInterface{

    CanvasFragment canvasFragment;
    private int orientation;
    private boolean isTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check device type
        isTablet = getResources().getBoolean(R.bool.isTablet);
        if (isTablet) {
            setContentView(R.layout.tablet_layout);

            canvasFragment = new CanvasFragment();

            addFragment(new PaletteFragment(), R.id.frag1);
            addFragment(canvasFragment, R.id.frag2);
        } else {
            //check orientation; 1 == portrait, 2 == landscape
            orientation = getResources().getConfiguration().orientation;
            if (orientation == 1) { // portrait
                setContentView(R.layout.small_portrait);

                addFragment(new PaletteFragment(), R.id.frag);
            } else { // landscape
                setContentView(R.layout.small_landscape);

                canvasFragment = new CanvasFragment();

                addFragment(new PaletteFragment(), R.id.frag1);
                addFragment(canvasFragment, R.id.frag2);
            }
        }



//        canvasFragment = new CanvasFragment();
//
//        addFragment(new PaletteFragment(), R.id.frag1);
//        addFragment(canvasFragment, R.id.frag2);

    }


    private void addFragment (Fragment fragment, int containerId){
        getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    @Override
    public void sendMessage(String message) {


        if(orientation == 1 && !isTablet) {
            canvasFragment = new CanvasFragment();
            Bundle args = new Bundle();
            args.putString("color", message);
            canvasFragment.setArguments(args);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag, canvasFragment)
                    .addToBackStack(null)
                    .commit();
        } else {

            canvasFragment.changeBGcolor(message);
        }
    }



}
