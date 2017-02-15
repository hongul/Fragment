package edu.temple.lab4adapterandactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by hongear on 2/15/17.
 */

public class ColorAdapter extends BaseAdapter {

    Context myContext;
    String[] myColors;

    public ColorAdapter(Context context, String[] colors) {
        this.myContext = context;
        this.myColors = colors;
    }

    @Override
    public int getCount() {
        return myColors.length;
    }

    @Override
    public Object getItem(int i) {
        return myColors[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(myContext);
        textView.setText(myColors[i]);
        textView.setBackgroundColor(Color.parseColor(myColors[i].toString()));
        return textView;
    }
}
