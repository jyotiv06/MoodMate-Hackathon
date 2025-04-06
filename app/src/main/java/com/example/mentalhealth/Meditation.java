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

import com.example.mentalhealth.databinding.ActivityMeditationBinding;

public class Meditation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        TextView m11 = findViewById(R.id.m11);
        TextView m12 = findViewById(R.id.m12);
        TextView m13 = findViewById(R.id.m13);
        TextView m14 = findViewById(R.id.m14);

        m11.setText(Html.fromHtml(getString(R.string.m11), Html.FROM_HTML_MODE_LEGACY));
        m12.setText(Html.fromHtml(getString(R.string.m12), Html.FROM_HTML_MODE_LEGACY));
        m13.setText(Html.fromHtml(getString(R.string.m13), Html.FROM_HTML_MODE_LEGACY));
        m14.setText(Html.fromHtml(getString(R.string.m14), Html.FROM_HTML_MODE_LEGACY));

        m11.setMovementMethod(LinkMovementMethod.getInstance());
        m12.setMovementMethod(LinkMovementMethod.getInstance());
        m13.setMovementMethod(LinkMovementMethod.getInstance());
        m14.setMovementMethod(LinkMovementMethod.getInstance());

    }
}