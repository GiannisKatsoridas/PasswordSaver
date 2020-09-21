package com.ikats.passwordsaver.listviewhelpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ikats.passwordsaver.R;

import java.util.ArrayList;

public class PasswordAdapter extends ArrayAdapter<Password> {

    Context mContext;
    int mLayoutResourceId;
    ArrayList<Password> mData;

    public PasswordAdapter(Context context, int resource, ArrayList<Password> data) {
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Override
    public Password getItem(int position) {
        return mData.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View row;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(mLayoutResourceId, parent, false);

        final TextView description = row.findViewById(R.id.row_password_description);

        description.setText(mData.get(position).Description);

        return row;
    }

}
