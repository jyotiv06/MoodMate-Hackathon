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

import com.example.mentalhealth.databinding.ActivityBooksBinding;

public class Books extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        TextView book1 = findViewById(R.id.book1);
        TextView book2 = findViewById(R.id.book2);
        TextView book3 = findViewById(R.id.book3);
        TextView book4 = findViewById(R.id.book4);

        book1.setText(Html.fromHtml(getString(R.string.messageWithLink), Html.FROM_HTML_MODE_LEGACY));
        book2.setText(Html.fromHtml(getString(R.string.msg2), Html.FROM_HTML_MODE_LEGACY));
        book3.setText(Html.fromHtml(getString(R.string.msg3), Html.FROM_HTML_MODE_LEGACY));
        book4.setText(Html.fromHtml(getString(R.string.msg4), Html.FROM_HTML_MODE_LEGACY));

        book1.setMovementMethod(LinkMovementMethod.getInstance());
        book2.setMovementMethod(LinkMovementMethod.getInstance());
        book3.setMovementMethod(LinkMovementMethod.getInstance());
        book4.setMovementMethod(LinkMovementMethod.getInstance());


    }
}