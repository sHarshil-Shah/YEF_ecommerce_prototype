package com.example.sum.e_commerce;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity {

    String[] desc = {"description1","description2","description3","description4"};
    String[] longDesc = {"Long description 1","Long description 2","Long Description 3","Long Description 4"};
    String[] itemPrice = {"1000","2000","3000","4000"};
    private int[] itemImages = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        int intValue = intent.getIntExtra("i", 0);

        TextView text = findViewById(R.id.txtheading);
        TextView description = findViewById(R.id.txtDescriptionDetails);
        TextView longDescription = findViewById(R.id.txtLongDescription);
        TextView price = findViewById(R.id.txtPrice);
        ImageView images = findViewById(R.id.itemImage);

        description.setText(desc[intValue]);
        longDescription.setText(longDesc[intValue]);
        text.setText("Item "+(intValue+1));
        price.setText("₹ "+itemPrice[intValue]);
        images.setImageResource(itemImages[intValue]);

        findViewById(R.id.btncontect).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                //Inform the user the button has been clicked
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:123456789"));
                startActivity(callIntent);
            }
        });
    }
}
