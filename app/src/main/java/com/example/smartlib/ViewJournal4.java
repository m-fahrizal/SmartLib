package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewJournal4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_journal4);
        PDFView pdfView = findViewById(R.id.journalpdf4);

        pdfView.fromAsset("Journal4.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}