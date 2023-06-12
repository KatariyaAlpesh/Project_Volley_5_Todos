package com.example.project_volley_5_todos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class MainActivity extends AppCompatActivity
{

    RecyclerView recyclerView;
    String url;
    ArrayList<DataModel> ArrayListDataModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);

        url = "https://jsonplaceholder.typicode.com/todos";

        call_API();
    }

    private void call_API()
    {
        RequestQueue queue = Volley.newRequestQueue(this);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0 ; i < jsonArray.length() ; i++)
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                Integer userId = jsonObject.getInt("userId");
                                Integer id = jsonObject.getInt("id");
                                String title = jsonObject.getString("title");
                                boolean completed = jsonObject.getBoolean("completed");

                                DataModel dataModel = new DataModel(userId , id , title , completed);

                                ArrayListDataModel.add(dataModel);

                            }

                        }
                        catch (JSONException e)
                        {
                            throw new RuntimeException(e);
                        }

                        RecyclerView_Adapter recyclerView_adapter = new RecyclerView_Adapter(MainActivity.this
                                                                                                     , ArrayListDataModel);
                        recyclerView.setAdapter(recyclerView_adapter);

                        LinearLayoutManager LM = new LinearLayoutManager(MainActivity.this
                                                                                , LinearLayoutManager.VERTICAL
                                                                                , false);
                        recyclerView.setLayoutManager(LM);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

              //  textView.setText("That didn't work!");

            }
        });
        queue.add(stringRequest);

    }
}