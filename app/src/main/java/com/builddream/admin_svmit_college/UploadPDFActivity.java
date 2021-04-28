package com.builddream.admin_svmit_college;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class UploadPDFActivity extends AppCompatActivity {
    private CardView addPDF;
    private final int REQ = 1;
    private EditText pdfTitle;
    private Uri pdfData;
    private Button btnUploadPDF;

    private DatabaseReference reference;
    private StorageReference storageReference;
    String DownloadUrl = "";
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_p_d_f);

        reference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        pd = new ProgressDialog(this);

        addPDF = findViewById(R.id.addPDF);
        pdfTitle= findViewById(R.id.pdfTitle);

        btnUploadPDF = findViewById(R.id.btnUploadPDF);
        addPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }
    private void openGallery() {
       Intent intent=new Intent();
       intent.setType("pdf/docs/ppt");
       intent.setAction(intent.ACTION_GET_CONTENT);
       startActivityForResult(Intent.createChooser(intent,"Select PDF File"),REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ && resultCode == RESULT_OK) {
            pdfData = data.getData();
            Toast.makeText(this, ""+pdfData, Toast.LENGTH_SHORT).show();
        }
    }
}