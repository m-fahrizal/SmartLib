package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewJournal2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_journal2);

        PDFView pdfView = findViewById(R.id.journalpdf2);
        pdfView.fromAsset("Journal2.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}