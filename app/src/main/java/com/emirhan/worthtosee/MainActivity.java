package com.emirhan.worthtosee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> landmarkNames;
    ArrayList<String> countryList;
    ArrayList<Bitmap> imagesList;
    //static Bitmap selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        //Data
        landmarkNames = new ArrayList<>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Reichstag");
        landmarkNames.add("Galata");

        countryList = new ArrayList<>();
        countryList.add("Italy");
        countryList.add("France");
        countryList.add("Germany");
        countryList.add("Turkey");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap reichstag = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.reichstag);
        Bitmap galata = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.galata);
        imagesList = new ArrayList<>();
        imagesList.add(pisa);
        imagesList.add(eiffel);
        imagesList.add(reichstag);
        imagesList.add(galata);


        //ListView
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_activated_1,landmarkNames);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("country",countryList.get(position));
                intent.putExtra("landmark",landmarkNames.get(position));
                // image bitmap putExtra ile gonderilemez
               // intent.putExtra("image",imagesList.get(position));


                //Bu da bir yontemdi ancak singleton ile calismak daha guvenli
                //static ler buyuk projelerde karisikliga ve aciga sebep olur (herkes tarafindan duzenlenebilir)
                //selectedImage = imagesList.get(position);

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(imagesList.get(position));

                startActivity(intent);

            }
        });
    }
}