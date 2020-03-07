package org.resulam.www.clafricamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.gc.materialdesign.views.ButtonRectangle;

public class OpenSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_settings);
    }

    public void openLanguageSettings(View view){
        Intent intent=new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS);
        startActivity(intent);
    }

    public void showAllKeyboards(View view){
        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        imeManager.showInputMethodPicker();
    }
}
