package fox.test.openmap;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TrailList extends ArrayAdapter<String>{
	private final Context myContext;
	String[] listOfNames;
	String[] listOfDifficulty;
	
	public TrailList(Context context, String[] listOfNames, String[] listOfDifficulty) {
		super(context, R.layout.oetraillist, listOfNames);
		this.listOfNames = listOfNames;
		this.listOfDifficulty = listOfDifficulty;
		this.myContext = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflator = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflator.inflate(R.layout.oetraillist, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		Log.d("Value of ImageView: " + imageView, "errrrror");
		textView.setText(listOfNames[position]);
		String s = listOfDifficulty[position];
		Log.d("Value of ImageView: " + imageView, "errrrror");
		if(s.startsWith("easiest")) {
			imageView.setImageResource(R.drawable.easy);
		}
		else if(s.startsWith("moderate")) {
			imageView.setImageResource(R.drawable.moderate);
		}
		else if(s.startsWith("difficult")) {
			imageView.setImageResource(R.drawable.difficult);
		}
		else {
			imageView.setImageResource(R.drawable.expert);
		}
		return rowView;
	}
}
