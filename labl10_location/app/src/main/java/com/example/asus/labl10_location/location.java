//lab 10 written by Dimiter DInkov
//Student Number :C15334276


package com.example.asus.labl10_location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class location extends Activity implements LocationListener {


    //Variables
    private static final int MY_PERMISSION_GPS = 1;

    //Text View called location Text
    private TextView locationText;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        locationText = (TextView) findViewById(R.id.LocationView);//Assigning a text view to location Text
        setUpLocation();
    }

    //When ever location changes update the coordinates on the screen
    @Override
    public void onLocationChanged(Location location) {
        String latestLocation ="";

        if(location != null)
        {
            latestLocation =String.format("CurrentLocation \n Longitude: %1$s \n Latitude : %2$s",
                    location.getLongitude(),location.getLatitude());
        }
        Toast.makeText(location.this,latestLocation, Toast.LENGTH_LONG).show();
        locationText.setText(latestLocation);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    //Set up initial location
    private void setUpLocation() {
        // Assume thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSION_GPS);
        }

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                60000,
                5,
                this
        );
    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                60000,
                5,
                this
        );

    }

    protected void onPause()
    {
        super.onPause();
        locationManager.removeUpdates(this);
    }
}
