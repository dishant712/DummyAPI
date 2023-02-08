package com.example.apicart;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myclass> {

    MainActivity mainActivity;
    ArrayList<Product> al;

    public myadapter(MainActivity mainActivity, ArrayList<Product> al) {
        this.mainActivity=mainActivity;
        this.al=al;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        myclass m = new myclass(view);
        return m;
    }

    class myclass extends RecyclerView.ViewHolder{
            TextView id,total,disper,totalpro,quan,userid,product;
        public myclass(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.item_id);
            total=itemView.findViewById(R.id.item_total);
            disper=itemView.findViewById(R.id.item_disper);
            totalpro=itemView.findViewById(R.id.item_totalpro);
            quan=itemView.findViewById(R.id.item_quan);
            userid=itemView.findViewById(R.id.item_userid);
            product=itemView.findViewById(R.id.item_product);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {

        holder.id.setText("Id = "+al.get(position).getId());
        holder.total.setText("Total = "+al.get(position).getTotal());
        holder.disper.setText("Discount Percentage = "+al.get(position).distotal);
        holder.totalpro.setText("Total Product = "+al.get(position).getTotalpro());
        holder.quan.setText("Total Quantity = "+al.get(position).getTotalquan());
        holder.userid.setText("User Id = "+al.get(position).getUserid());
//        holder.product.setText("Products = "+al.get(position).getProduct());
        holder.product.setText("Products = Click Here to See the Products)");


        System.out.println(al.get(position).getProduct());

        //ArrayList<JsonObject> to ArrayList<String>

        ArrayList<JSONObject> list=al.get(holder.getAdapterPosition()).getProduct();

        ArrayList<String> sendingListOfStrings = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++) {
            sendingListOfStrings.add( list.get(i).toString() );
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(mainActivity,MainActivity2.class);
                    intent.putStringArrayListExtra("listdata", (ArrayList<String>) sendingListOfStrings);
                    mainActivity.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }
}
