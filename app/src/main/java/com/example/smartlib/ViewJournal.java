package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewJournal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_journal);

        PDFView pdfView = findViewById(R.id.journalpdf1);
        pdfView.fromAsset("Journal1.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}