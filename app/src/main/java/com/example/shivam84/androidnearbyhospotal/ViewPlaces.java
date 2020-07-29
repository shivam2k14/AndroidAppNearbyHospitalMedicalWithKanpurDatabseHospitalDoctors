package com.example.shivam84.androidnearbyhospotal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shivam84.androidnearbyhospotal.Model.Photos;
import com.example.shivam84.androidnearbyhospotal.Model.PlaceDetails;
import com.example.shivam84.androidnearbyhospotal.Remote.IGoogleApiService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPlaces extends AppCompatActivity {

    IGoogleApiService mServices;
    PlaceDetails mPlaces;

    ImageView photo_on_map;
    RatingBar ratingBar;
    TextView place_name,place_address,open_hours_of_place;
    //TextView place_phoneNum;
    Button btn_sbmt_on_Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_places);

        mServices=Common.getGoogleApiService();

        photo_on_map = (ImageView) findViewById(R.id.photo_from_map);
        ratingBar=(RatingBar)findViewById(R.id.ratingBar_From_Map);

        place_address=(TextView)findViewById(R.id.placeAdd_from_Map);
        place_name=(TextView)findViewById(R.id.placeName_from_Map);
      // place_phoneNum=(TextView)findViewById(R.id.placePhone_from_Map);
        open_hours_of_place=(TextView)findViewById(R.id.placeHour_from_Map);
        btn_sbmt_on_Map=(Button)findViewById(R.id.btn_show_map);

        //empty all view
        place_name.setText("");
        place_address.setText("");
        open_hours_of_place.setText("");
      // place_phoneNum.setText("");

        btn_sbmt_on_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(mPlaces.getResult().getUrl()));
                startActivity(mapIntent);
            }
        });



        //photos

        if (Common.currentResult.getPhotos() != null && Common.currentResult.getPhotos().length > 0) {
            Picasso.with(this)
                    .load(getPhotoOfPlace(Common.currentResult.getPhotos()[0].getPhoto_reference(),1000)) //get photos is array
                    .placeholder(R.drawable.ic_image_black_24dp)
                    .error(R.drawable.ic_error_black_24dp)

                    .into(photo_on_map);


        }

     //ratingbar
        if(Common.currentResult.getRating()!= null && !TextUtils.isEmpty(Common.currentResult.getRating()))
        {
            ratingBar.setRating(Float.parseFloat(Common.currentResult.getRating()));
        }
        else {
            ratingBar.setVisibility(View.GONE);
        }
          //phone num

        //opening_hours


        if(Common.currentResult.getOpening_hours()!= null )
        {
           open_hours_of_place.setText("Open Now :"+Common.currentResult.getOpening_hours().getOpen_now());
        }
        else {
            open_hours_of_place.setVisibility(View.GONE);
        }


        //use service to fetch add and name
        mServices.getDetailsPlaces(getPlaceDetailUrl(Common.currentResult.getPlace_id()))
                .enqueue(new Callback<PlaceDetails>() {
                    @Override
                    public void onResponse(Call<PlaceDetails> call, Response<PlaceDetails> response) {
                        mPlaces=response.body();
                        place_address.setText(mPlaces.getResult().getFormatted_address());
                        place_name.setText(mPlaces.getResult().getName());
                      // place_phoneNum.setText(mPlaces.getResult().getFormatted_phone_number());

                    }

                    @Override
                    public void onFailure(Call<PlaceDetails> call, Throwable t) {

                    }
                });
    }

    private String getPlaceDetailUrl(String place_id) {
        StringBuilder url= new StringBuilder("https://maps.googleapis.com/maps/api/place/details/json");
        url.append("?placeid="+place_id);
        url.append("&key="+getResources().getString(R.string.browser_key));
        return url.toString();
    }

    private String getPhotoOfPlace(String photo_reference,int maxwidth) {
        StringBuilder url =new StringBuilder("https://maps.googleapis.com/maps/api/place/photo");
        url.append("?maxwidth="+maxwidth);
        url.append("&photoreference="+photo_reference);
        url.append("&key="+getResources().getString(R.string.browser_key));
        return url.toString();

    }
}
