package com.example.tennistracker;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayersAdapter extends ArrayAdapter<Player> {

    Player[] players;
    ArrayList<String> plyrs = new ArrayList<String>(); 

    public PlayersAdapter(Context context, int textViewResourceId, Player[] objects) {
        super(context, textViewResourceId, objects);
        players = objects;
        PlayersTask playersTask = new PlayersTask();
        //playersTask.fetchPlayers();
        // Launch the Task to retrieve the Players from the DB/JSON
        // this.plyrs = ...
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Player getItem(int position){
       return players[position];
    }

    @Override
    public long getItemId(int position){
       return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(players[position].getFirst() + " " + players[position].getLast());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(players[position].getFirst() + " " + players[position].getLast());

        return label;
    }

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
                    ArrayList<Player> plyrs = new ArrayList<Player>();
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://10.0.2.2:5432/tracker", "azerpas", "123456");

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
                            plyrs.add(p);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!plyrs.isEmpty())
                        players = (Player[]) plyrs.toArray();
                }}).start();
        }

    }
}