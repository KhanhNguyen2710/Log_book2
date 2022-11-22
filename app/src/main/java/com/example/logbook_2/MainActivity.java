package com.example.logbook_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    // String[] imageList;
    Button Forward_button, Backward_button,Add_button;
    EditText URL_input;
    List<String> urlList = new ArrayList<>(); // List img
    int i  ;

    public static boolean IsValidUrl(String urlString) {
        try {
            new URL(urlString);
            return URLUtil.isValidUrl(urlString) && Patterns.WEB_URL.matcher(urlString).matches();
        } catch (MalformedURLException ignored) {
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imgView);
        URL_input = findViewById(R.id.URL_input);
        Add_button = findViewById(R.id.Add_button);
        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = URL_input.getText().toString();

                if(!(url.length() ==0)){
                    if (IsValidUrl(url)){
                        urlList.add(url);
                        i = urlList.size() - 1;
                        Picasso.get()
                                .load(urlList.get(i))
                                .into(imageView);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid link", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Url can not be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Forward_button = findViewById(R.id.Forward_button);
        Forward_button.setOnClickListener(new View.OnClickListener() {
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

        Backward_button = findViewById(R.id.Backward_button);
        Backward_button.setOnClickListener(new View.OnClickListener() {
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