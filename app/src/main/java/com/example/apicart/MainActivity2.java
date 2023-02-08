package com.example.apicart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<Product> productArrayList = new ArrayList();
    ArrayList<JSONObject>  listdata = new ArrayList();
    ArrayList<singleproduct> sl= new ArrayList();
    int pos;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=findViewById(R.id.list);

        ArrayList<JSONObject> receivingArr=new ArrayList<>();

        ArrayList<String> list = getIntent().getExtras().getStringArrayList("listdata");

        //ArrayList<String> to ArrayList<JSINOBJECT>
        for (int i = 0; i < list.size(); i++) {

            try {
                receivingArr.add(new JSONObject(list.get(i)));
                System.out.println(list.get(i));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }


        for (int k=0;k<receivingArr.size();k++) {
            try {
                JSONObject object = receivingArr.get(k);
                System.out.println("==>"+object);
                singleproduct single = new singleproduct(
                        object.getInt("id"),
                        object.getInt("price"),
                        object.getInt("quantity"),
                        object.getInt("total"),
                        object.getInt("discountPercentage"),
                        object.getInt("discountedPrice"),
                        object.getString("title")
                );
                sl.add(single);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            myadapter2 m2 = new myadapter2(this, sl);
            listView.setAdapter(m2);
        }
    }
}