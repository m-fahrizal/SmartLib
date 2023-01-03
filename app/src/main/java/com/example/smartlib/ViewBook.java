package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        PDFView pdfView = findViewById(R.id.bookpdf1);
        pdfView.fromAsset("book1.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}