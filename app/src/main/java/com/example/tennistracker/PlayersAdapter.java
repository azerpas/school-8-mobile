import android.widget.ArrayAdapter;

public class PlayersAdapter extends ArrayAdapter<Player> {

    ArrayList<Player> players = new ArrayList<Player>(); 
    ArrayList<String> plyrs = new ArrayList<String>(); 

    public PlayersAdapter(Context context, int resource, int textViewResourceId, ArrayList<Player> objects) {
        super(context, resource, textViewResourceId, objects);
        players = objects;

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
}