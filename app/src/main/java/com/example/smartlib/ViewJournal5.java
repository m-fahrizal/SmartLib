package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewJournal5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_journal5);

        PDFView pdfView = findViewById(R.id.journalpdf5);
        pdfView.fromAsset("Journal5.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}