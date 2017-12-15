package com.example.asus.lab6;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

/**
 * Created by Asus on 18/10/2017.
 */

public class CustomAdapter extends BaseAdapter {

    public CustomAdapter(Context context,int rowLayoutId,String[] myArrayData) {

        super(context, rowLayoutId,myArrayData);

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row;
        LayoutInflater inflater = getLayoutInflater();
        row = inflater.inflate(R.layout.row,parent,false);
    }


  public int getViewTypeCount()
  {
      return 2;
  }

  public int getViewType(int position)
  {
      return(contactList.get(position).getContactType() ==  ContactType)
  }


}
