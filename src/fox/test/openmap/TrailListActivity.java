package fox.test.openmap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;
import fox.test.openmap.DataBaseHelper;

public class TrailListActivity extends ListActivity {
	String trailName = "oeRoad";
    ArrayList<String> localListOfNames = new ArrayList<String>();
    ArrayList<String> localListOfDifficulty = new ArrayList<String>();
    DataBaseHelper myDbHelper = new DataBaseHelper(this);
	//myDbHelper = new DataBaseHelper(this);
    public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
	    try {
			maker();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
	    Map<String, String> map;
	    int count = localListOfNames.size();
	    for(int i = 0; i < count; i++) {
	    	map = new HashMap<String, String>();
	    	map.put("name", localListOfNames.get(i));
	    	map.put("difficulty", localListOfDifficulty.get(i));
	    	Log.d("errrrror", localListOfDifficulty.get(i));
	    	list.add(map);
	    }
	    
	    //String[] filledListOfNames = localListOfNames.toArray(new String[0]);
	    
	    //TrailList NamesAdapter = new TrailList(this, filledListOfNames);
	    SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.oetraillist, new String[] {"name", "difficulty"}, new int[] {R.id.label, R.id.icon});
	    setListAdapter(adapter);
	    
	}
	
	public void maker() throws IOException {
		
		Log.d("errrrror", "Able to get inside of maker");
		myDbHelper.createDataBase();
		myDbHelper.openDataBase();
		Cursor name = myDbHelper.trailTable(trailName);
		Cursor difficulty = myDbHelper.trailDifficulty(trailName);
		name.moveToFirst();
		difficulty.moveToFirst();
		
		int numberofTrails = name.getCount();
		Log.d("Value of numberofTrails: " + numberofTrails, "errrrror");
		while(!name.isLast() && !difficulty.isLast()) {
			String n = name.getString(name.getColumnIndex("name"));
			Log.d("Value of n: " + n, "errrrror");
			String d = difficulty.getString(difficulty.getColumnIndex("difficulty"));
			Log.d("Value of d: " + d, "errrrror");
			localListOfNames.add(n);
			localListOfDifficulty.add(d);
			name.moveToNext();
			difficulty.moveToNext();
		}
	}
}