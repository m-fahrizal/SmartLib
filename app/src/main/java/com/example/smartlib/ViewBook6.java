package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewBook6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book6);

        PDFView pdfView = findViewById(R.id.bookpdf6);
        pdfView.fromAsset("Book6.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}