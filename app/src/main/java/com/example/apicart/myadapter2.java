package com.example.apicart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter2 extends BaseAdapter {

    MainActivity2 mainActivity2;
    ArrayList<singleproduct> sl;

    public myadapter2(MainActivity2 mainActivity2, ArrayList<singleproduct> sl) {

        this.mainActivity2=mainActivity2;
        this.sl=sl;

    }

    @Override
    public int getCount() {
        return sl.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(mainActivity2).inflate(R.layout.item2,parent,false);
        TextView id = convertView.findViewById(R.id.id);
        TextView price = convertView.findViewById(R.id.price);
        TextView quantity = convertView.findViewById(R.id.quantity);
        TextView total = convertView.findViewById(R.id.total);
        TextView discountPercentage = convertView.findViewById(R.id.discountPercentage);
        TextView discountedPrice = convertView.findViewById(R.id.discountedPrice);
        TextView title = convertView.findViewById(R.id.title);

        id.setText("Id = " + sl.get(position).getId());
        price.setText("Price = " + sl.get(position).getPrice());
        quantity.setText("Quantity = " + sl.get(position).getQuantity());
        total.setText("Total = " + sl.get(position).getTotal());
        discountPercentage.setText("Discount Percentage = " + sl.get(position).getDiscountper());
        discountedPrice.setText("Discount Price = " + sl.get(position).getPrice());
        title.setText("Title = " + sl.get(position).getTitle());

        return convertView;
    }
}
