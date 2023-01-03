package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewBook4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book4);

        PDFView pdfView = findViewById(R.id.bookpdf4);
        pdfView.fromAsset("Book4.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}