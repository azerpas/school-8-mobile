package com.example.tennistracker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayersTask extends AsyncTask<String, Integer, Void> {
    protected Void doInBackground(String... jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Player lib = mapper.readValue(jsonString[0], Player.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onProgressUpdate(Integer... p) {
        // Update the progress bar every progress
    }
    protected void onPostExecute(Long result) {
        // Call the result handler at the end
    }
}

