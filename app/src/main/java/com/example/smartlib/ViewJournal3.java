package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewJournal3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_journal3);

        PDFView pdfView = findViewById(R.id.journalpdf3);
        pdfView.fromAsset("Journal3.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
    }
}