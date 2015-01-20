package com.project.convene2k13;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Show_on_map extends FragmentActivity implements LocationListener {
	
	

	GoogleMap googleMap;
	 public static final LatLng SKNCOE_loc = new LatLng(18.46614,73.83620);
	public double lat;
	public double lng;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_on_map);
		
		// Getting reference to the SupportMapFragment of activity_main.xml
		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		
		
	

		// Getting GoogleMap object from the fragment
		googleMap = fm.getMap();
		

		// Enabling MyLocation Layer of Google Map
		googleMap.setMyLocationEnabled(true);				
				

        MarkerOptions markerskncoe = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.mark_red));
        markerskncoe.position(SKNCOE_loc);
        markerskncoe.title("SKNCOE-Convene 2K13");
        googleMap.addMarker(markerskncoe);
        
		 // Getting LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = locationManager.getLastKnownLocation(provider);

         LatLng my_loc = new LatLng(location.getLatitude(),location.getLongitude());
        lat=my_loc.latitude;
        lng=my_loc.longitude;
        // Creating a marker
        MarkerOptions MyCurrentLocMarker = new MarkerOptions();

        // Setting the position for the marker
        MyCurrentLocMarker.position(my_loc);
        // Setting the title for the marker.

        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
		List<Address> addresses = null;
		  // Call the synchronous getFromLocation() method by passing in the lat/long values.
       
		try {
			addresses = geocoder.getFromLocation(my_loc.latitude, my_loc.longitude, 1);
		} 
       catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
		if (addresses != null && addresses.size() > 0) {
           Address address = addresses.get(0);
           // Format the first line of address (if available), city, and country name.

           String addressText = String.format("%s, %s, %s",
                   address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                   address.getLocality(),
                   address.getCountryName());
    		  // Setting the title for the marker.
           // This will be displayed on taping the marker
           MyCurrentLocMarker.title("Your Location-"+addressText);
         
        
        
        // Clears the previously touched position
        //googleMap.clear();

        // Animating to the touched position
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(my_loc));

        // Placing a marker on the touched position
       
		}
		
		googleMap.addMarker(MyCurrentLocMarker);
        if(location!=null){
                onLocationChanged(location);
        }        
        locationManager.requestLocationUpdates(provider, 1000, 0, this);
 
     // Zoom in the Google Map
     		googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        
        
        
        
        
        
     // Setting a click event handler for the map
        googleMap.setOnMapClickListener(new OnMapClickListener() {
 
            @Override
            public void onMapClick(LatLng latLng) {
 
               
               
                
            }
         });
        
		
	}
	

	@Override
	public void onLocationChanged(Location location) {
		
		
	//	googleMap.clear();
		
		  MarkerOptions markerskncoe = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.mark_red));
	        markerskncoe.position(SKNCOE_loc);
	        markerskncoe.title("SKNCOE-Convene 2K13");
	        googleMap.addMarker(markerskncoe);
	        
		// Creating a LatLng object for the current location
		 LatLng mychangedloc = new LatLng(location.getLatitude(), location.getLongitude());
		  lat=mychangedloc.latitude;
	        lng=mychangedloc.longitude;
		
		 // Creating a marker
        MarkerOptions MyCurrentLocMarker = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.mark_red));

        // Setting the position for the marker
        MyCurrentLocMarker.position(mychangedloc);
        // Setting the title for the marker.

        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
		List<Address> addresses = null;
		  // Call the synchronous getFromLocation() method by passing in the lat/long values.
       
		try {
			addresses = geocoder.getFromLocation(mychangedloc.latitude, mychangedloc.longitude, 1);
		} 
       catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
		if (addresses != null && addresses.size() > 0) {
           Address address = addresses.get(0);
           // Format the first line of address (if available), city, and country name.

           String addressText = String.format("%s, %s, %s",
                   address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                   address.getLocality(),
                   address.getCountryName());
    		  // Setting the title for the marker.
           // This will be displayed on taping the marker
           MyCurrentLocMarker.title("Your Location-"+addressText);
         
        
        
        // Clears the previously touched position
        //googleMap.clear();


        // Placing a marker on the touched position
        googleMap.addMarker(MyCurrentLocMarker);
		}
		
		// Showing the current location in Google Map
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(mychangedloc));
		
	
	
				
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub		
	}
	

	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.show_on_map, menu);
	    return true;
	  }
	  
	  public void get_walking_direction(View view){
		  
		  Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr="+lat +","+lng+"&daddr="+SKNCOE_loc.latitude+","+SKNCOE_loc.longitude));

          startActivity(intent);

		}
	  
	}