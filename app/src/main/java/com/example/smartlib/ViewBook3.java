package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewBook3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book3);

        PDFView pdfView = findViewById(R.id.bookpdf3);
        pdfView.fromAsset("Book3.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}