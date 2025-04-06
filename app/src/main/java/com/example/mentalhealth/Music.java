package com.example.mentalhealth;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mentalhealth.databinding.ActivityMusicBinding;

public class Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        TextView m1 = findViewById(R.id.m1);
        TextView m2 = findViewById(R.id.m2);
        TextView m3 = findViewById(R.id.m3);
        TextView m4 = findViewById(R.id.m4);

        m1.setText(Html.fromHtml(getString(R.string.m1), Html.FROM_HTML_MODE_LEGACY));
        m2.setText(Html.fromHtml(getString(R.string.m2), Html.FROM_HTML_MODE_LEGACY));
        m3.setText(Html.fromHtml(getString(R.string.m3), Html.FROM_HTML_MODE_LEGACY));
        m4.setText(Html.fromHtml(getString(R.string.m4), Html.FROM_HTML_MODE_LEGACY));

        m1.setMovementMethod(LinkMovementMethod.getInstance());
        m2.setMovementMethod(LinkMovementMethod.getInstance());
        m3.setMovementMethod(LinkMovementMethod.getInstance());
        m4.setMovementMethod(LinkMovementMethod.getInstance());

    }


}