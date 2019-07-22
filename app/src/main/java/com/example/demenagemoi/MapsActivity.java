package com.example.demenagemoi;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.demenagemoi.Helpers.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utils.isAuthenticated())
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings();
        mMap.setMinZoomPreference(10);
        // Add a marker in Sydney and move the camera
        LatLng esgi = new LatLng(48.849378, 2.389630); //REQUEST GET LAT LONG
        mMap.addMarker(new MarkerOptions().position(esgi)
                .title("ESGI : 242 Rue du Faubourg Saint-Antoine, 75012 Paris") //REQUEST GET ADRESS AND NAME
                .snippet("Cartons : 6 - Large : 2  Moyen : 1  Petit : 3")); //REQUEST GET CARBOARD AND SIZE
        mMap.moveCamera(CameraUpdateFactory.newLatLng(esgi));

        LatLng second = new LatLng(48.854399, 2.393400);
        mMap.addMarker(new MarkerOptions().position(second)
                .title("Conforama : 73 Avenue Philippe-Auguste, 75011 Paris")
                .snippet("Cartons : 23 - Large : 4  Moyen : 16  Petit : 3"));

        LatLng third = new LatLng(48.854406, 2.385806);
        mMap.addMarker(new MarkerOptions().position(third)
                .title("OFFICE DEPOT : 190 Boulevard Voltaire, 75011 Paris")
                .snippet("Cartons : 17 - Large : 4  Moyen : 10  Petit : 3"));
        }

}
