package ca.ualberta.cs.comput301.currentlocation;

import java.sql.Date;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class CurrentLocationActivity extends Activity {
	TextView tv;
	private static final String GPS_MOCK_PROVIDER = "GpsMockProvider";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// Obtain LocationManager service and set up location update request.
		// To Do
		tv = (TextView) findViewById(R.id.myLocationText);
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
	}

	
	// Retrieve location updates through LocationListener interface
	private final LocationListener locationListener = new LocationListener(){
	// To Do: override the four methods.
		public void onLocationChanged (Location location){
			if (location != null){
				double lat = location.getLatitude();
				double lng = location.getLongitude();
				Date date = new Date(location.getTime());
				tv.setText("Your location: "+lat+lng+date);
				
			}else{
				tv.setText("???");
			}
			
		}
		public void onProviderDisabled (String provider){
			
			
		}
		public void onProviderEnabled (String provider){
			
			
		}
		public void onStatusChanged (String provider){
			
		}
		
		public void onStatusChanged (String provider, int status, Bundle extras){
			
			
		}
		
		
	};

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
