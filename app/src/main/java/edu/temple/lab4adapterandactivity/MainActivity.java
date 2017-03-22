package edu.temple.lab4adapterandactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity implements PaletteFragment.PaletteInterface{

    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasFragment = new CanvasFragment();

        addFragment(new PaletteFragment(), R.id.frag1);
        addFragment(canvasFragment, R.id.frag2);

    }


    private void addFragment (Fragment fragment, int containerId){
        getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    @Override
    public void sendMessage(String message) {
        canvasFragment.changeBGcolor(message);
    }


}
