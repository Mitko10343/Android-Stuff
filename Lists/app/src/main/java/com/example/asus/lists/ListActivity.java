import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListActivity extends ListActivity
{

    // better to put this external in resources but ok for now..!
    String[] countries = {"South Africa", "France", "Spain", "Germany", "Finland", "Ireland", "England"};

    // custom adapter class, declared as an inner class
    public class MyCustomAdapter extends ArrayAdapter<String>
    {
        // constructor
        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects)
        {
            super(context, textViewResourceId, objects);
        }

        // This getview method is called each time a row needs to be formatted for the list
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row, parent, false);

            // row formatting...

            TextView label = (TextView)row.findViewById(R.id.country);
            label.setText(countries[position]);

            ImageView myImage = (ImageView)row.findViewById(R.id.myicon);
            if (countries[position] == "Ireland")
            {
                myImage.setImageResource(R.drawable.icongray);
            }
            else
            {
                myImage.setImageResource(R.drawable.icon);
            }

            //
            return row;
        } // get View

        public LayoutInflater getLayoutInflater() {
            return layoutInflater;
        }
    } // closes the custom adapter class


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new MyCustomAdapter(
                MainActivityCase3.this,
                R.layout.row,
                countries));
    }

    /* this event handler will execute when the list is clicked.  You can only use this particular event
	handler method if you are extending ListActivity. Otherwise, if you are extending AppCompActivity, you need to implement an adapter listener using
	an anonymous class. etc.

	*/
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        String selection = l.getItemAtPosition(position).toString();
        Toast.makeText(this, selection, Toast.LENGTH_LONG).show();
    }

}
