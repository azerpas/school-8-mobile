import android.widget.ArrayAdapter;

public class MatchsAdapter extends ArrayAdapter<Match> {
    ArrayList<Match> matchs = new ArrayList<Match>(); 

    public MatchsAdapter(Context context, int resource, int textViewResourceId, ArrayList<Match> objects) {
        super(context, resource, textViewResourceId, objects);
        matchs = objects;

        // Launch the Task to retrieve the Players from the DB/JSON
        // this.plyrs = ...
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_view_items, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(matchs.get(position).getId());
        return v;

    }

}