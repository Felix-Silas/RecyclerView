package com.example.jsonrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Browser;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<RowObject> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("homeworkData");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject homeworkData = jsonArray.getJSONObject(i);
                RowObject rowObject = new RowObject(
                  homeworkData.getString("title"),
                  homeworkData.getString("description"),
                  homeworkData.getString("image")
                );
                arrayList.add(rowObject);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HelperAdapter helperAdapter = new HelperAdapter(arrayList,MainActivity.this);
        recyclerView.setAdapter(helperAdapter);
    }

    private String JsonDataFromAsset() {
        String json=null;
        try {
            InputStream inputStream = getAssets().open("homeworkData.json");
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}