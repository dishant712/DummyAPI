package com.example.apicart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> productArrayList = new ArrayList();
    RecyclerView recyclerView;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyle);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://dummyjson.com/carts";
        dialog= ProgressDialog.show(this,"Please Wait","Data Loading");

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        try {

                            JSONObject jsonObject= new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("carts");

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                //jsonarray to ArrayList<JsonObject>

                                ArrayList listdata = new ArrayList();
                                JSONObject ob = jsonArray.getJSONObject(i);
                                JSONArray jArray = ob.getJSONArray("products");
                                System.out.println("array="+jArray);

                                    for (int j=0;j<jArray.length();j++){
                                        try {
                                            listdata.add(jArray.get(j));
                                        } catch (JSONException e) {
                                            throw new RuntimeException(e);
                                        }

                                }
                                Product product= new Product(
                                  ob.getInt("id"),
                                  ob.getInt("total"),
                                  ob.getInt("discountedTotal"),
                                  ob.getInt("userId"),
                                  ob.getInt("totalProducts"),
                                  ob.getInt("totalQuantity"),listdata
                                );
                                productArrayList.add(product);
                            }


                            myadapter m = new myadapter(MainActivity.this,productArrayList);
                            recyclerView.setAdapter(m);

                            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(null,LinearLayoutManager.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}