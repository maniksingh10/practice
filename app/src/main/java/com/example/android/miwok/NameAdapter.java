package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by manik on 20-12-2017.
 */

public class NameAdapter extends ArrayAdapter<ObjectL> {

    private int mColor;
    private int mLayColor;

    public NameAdapter(Context context, ArrayList<ObjectL> androidFlavors, int color, int laycolor) {

        super(context, 0, androidFlavors);
        mColor = color;
        mLayColor=laycolor;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.view_layout, parent, false);
        }



        // Get the {@link AndroidFlavor} object located at this position in the list
        ObjectL currentAndroidFlavor = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.tv1);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentAndroidFlavor.getEng());


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.tv2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentAndroidFlavor.getTrans());


        ImageView imgView = (ImageView) listItemView.findViewById(R.id. jpg);

        if(currentAndroidFlavor.hasImg()) {
            imgView.setImageResource(currentAndroidFlavor.getImg());
            imgView.setVisibility(View.VISIBLE);
        }else {
            imgView.setVisibility(View.GONE);
        }

        View colorContain = listItemView.findViewById(R.id. text_container);
        int color = ContextCompat.getColor(getContext(),mColor);

        colorContain.setBackgroundColor(color);


        View backcolorContain = listItemView.findViewById(R.id. laycolor);
        int lcolor = ContextCompat.getColor(getContext(),mLayColor);

        backcolorContain.setBackgroundColor(lcolor);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

