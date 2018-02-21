package practice.carpet.red.redpractice.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import practice.carpet.red.redpractice.R;

public class ImageFullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full_screen);

        Bundle extras = getIntent().getExtras();
        ImageView image = findViewById(R.id.image_full);
        Picasso.with(this).load(extras.getString("IMAGE_URL")).into(image);
    }
}
