package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewBook5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book5);

        PDFView pdfView = findViewById(R.id.bookpdf5);
        pdfView.fromAsset("Book5.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}