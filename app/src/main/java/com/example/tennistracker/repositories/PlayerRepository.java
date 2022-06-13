package com.example.tennistracker.repositories;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class PlayerRepository {
    public PlayerRepository() throws JSONException {
        String jsonString = "{}";
        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            jsonString = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject(jsonString);
        // String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        // JSONArray arr = obj.getJSONArray("posts");
    }
}