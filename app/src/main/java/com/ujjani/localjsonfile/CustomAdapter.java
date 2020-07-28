package com.ujjani.localjsonfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<CountryList> arrayList;

    public CustomAdapter(Context context, ArrayList<CountryList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        }
        TextView name, email;
        name = (TextView) convertView.findViewById(R.id.txtName);
        email = (TextView) convertView.findViewById(R.id.txtCountryCode);
        name.setText(arrayList.get(position).getName());
        email.setText(arrayList.get(position).getCountryCode());

        return convertView;
    }

}
