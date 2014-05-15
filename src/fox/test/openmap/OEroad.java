//OEroad is used to display information about 18 Road's trails, such as Trail Difficulty, Trail Length, and Trail Style.
package fox.test.openmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OEroad extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.openmapgrid);
	}
	
	public void onClick(View v) {
    	switch (v.getId()){
    	case R.id.OEtraillist:
    		//And intent is used to change between the map view and the OEroad view
    		Intent intent = new Intent(this, TrailListActivity.class);
    		startActivity(intent);
    		break;
    	}
    }
}
