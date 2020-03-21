package org.resulam.www.clafricamobile.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.resulam.www.clafricamobile.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView helpText = findViewById(R.id.about_text);
        helpText.setText(Html.fromHtml(getString(R.string.signature)));
    }
}
