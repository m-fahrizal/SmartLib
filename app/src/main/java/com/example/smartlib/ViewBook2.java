package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewBook2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book2);

        PDFView pdfView = findViewById(R.id.bookpdf2);
        pdfView.fromAsset("Book2.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}