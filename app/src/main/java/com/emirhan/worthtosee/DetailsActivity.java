package com.emirhan.worthtosee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView country;
    TextView landMark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.imageView);
        country = findViewById(R.id.country);
        landMark = findViewById(R.id.landMark);
        Intent intent = getIntent();
        String a = intent.getStringExtra("landmark");
        String b = intent.getStringExtra("country");
        landMark.setText(a);
        country.setText(b);
        //MainActivity de selectedImage i static olarak tanimladigimiz icin
        //Tum activity lerde buna ulasabiliriz
        //Cok buyuk cok kisinin ugrastigi projelerded tercih edilmez
        //Nedeni herkes tarafindan ulasilabilir ve degistirilebilir olmasi
       // imageView.setImageBitmap(selectedImage);
        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());


    }
}