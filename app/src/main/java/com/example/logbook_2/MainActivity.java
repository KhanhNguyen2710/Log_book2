package com.example.logbook_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
   // String[] imageList;
    Button Next_button, Prev_button,Add_button;
    EditText URL_input;
    List<String> urlList = new ArrayList<>(); // List img


    int i  ;

    private static final String CHECK_IMG_URL = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpeg|jpg|gif|png)";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            imageView = findViewById(R.id.imgView);
            URL_input = findViewById(R.id.URL_input);

    /*        urlList.add("https://i.pinimg.com/564x/8b/6e/ce/8b6ece9d979f9a3e721e32954c72fd74.jpg");

            Picasso.get().load(urlList.get(i)).into(imageView);*/

            Add_button = findViewById(R.id.Add_button);
            Add_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = URL_input.getText().toString();
                    if(!(url.length() == 0)) {
                        urlList.add(url);
                        i = urlList.size() - 1;
                        Picasso.get()
                                .load(urlList.get(i))
                                .into(imageView);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid url", Toast.LENGTH_SHORT).show();

                    }
                }

            });

            Next_button = findViewById(R.id.Next_button);
            Next_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i ++ ;
                    if(i == urlList.size()){
                        i = urlList.size() -1 ;
                       // lập:  i = 0 ;
                        Picasso.get().load(urlList.get(i)).into(imageView);
                    }else{
                        Picasso.get().load(urlList.get(i)).into(imageView);
                    }
                }
            });

            Prev_button = findViewById(R.id.Prev_button);
            Prev_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i --; // -1
                    if (i < 0){
                        i = 0;
                        Picasso.get().load(urlList.get(i)).into(imageView);
                    }else{
                        Picasso.get().load(urlList.get(i)).into(imageView);
                    }
                }
            });
        }


    }