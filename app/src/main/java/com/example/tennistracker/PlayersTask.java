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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayersTask extends AsyncTask<String, Integer, Void> {
    protected Void doInBackground(String... jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Player[] players = mapper.readValue(jsonString[0], Player[].class);
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

    public void fetchPlayers() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql://10.0.2.2:5234/TennisTracker", "root", "root");

                    String sql = "SELECT * FROM Players";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Player p = new Player(
                                resultSet.getString("id"),
                                resultSet.getString("first"),
                                resultSet.getString("last"),
                                resultSet.getString("hand"),
                                resultSet.getString("dob"),
                                resultSet.getString("ioc"),
                                resultSet.getString("height"),
                                resultSet.getString("wikidata")
                        );
                    }
                    // players.Add(p);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }}).start();
    }

}

