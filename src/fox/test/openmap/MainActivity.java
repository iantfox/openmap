//This file is the main page for 18 Road
package fox.test.openmap;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;

//To be able to have a clickable object in the view, I had to use "implements View.OnClickListener"
public class MainActivity extends FragmentActivity implements View.OnClickListener{
	private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Because we are telling the method to implement the onClickListener, we can reference an onClick to "this" object
        TextView bopenOEroad = (TextView)findViewById(R.id.openOEroad);
        bopenOEroad.setOnClickListener(this);
        
        myMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        //LatLng oneEight = new LatLng(39.307074, -108.707342);
        float zoom = 12;
        CameraUpdate myLocation = CameraUpdateFactory.newLatLng(new LatLng(39.307074, -108.707342));
        CameraUpdate mapZoom = CameraUpdateFactory.zoomTo(zoom);
        myMap.moveCamera(myLocation);
        myMap.animateCamera(mapZoom);
    }
    
    public void onClick(View v) {
    	switch (v.getId()){
    	case R.id.openOEroad:
    		//And intent is used to change between the map view and the OEroad view
    		Intent intent = new Intent(this, OEroad.class);
    		startActivity(intent);
    		break;
    	}
    }
}