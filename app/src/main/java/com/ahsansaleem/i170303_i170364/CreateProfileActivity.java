package com.ahsansaleem.i170303_i170364;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import com.squareup.picasso.Picasso;
public class CreateProfileActivity extends AppCompatActivity {

    Uri imageUri;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    ImageView selectImagebtn;
    EditText firstName;
    EditText lastName;
    RadioButton male;
    RadioButton female;
    Button continueBtn;
    ActivityResultLauncher<String> mGetContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);
        selectImagebtn =findViewById(R.id.photo_input);
        firstName = findViewById(R.id.fname_input);
        lastName = findViewById(R.id.lname_input);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        firstName.getText().toString();
        continueBtn=findViewById(R.id.continue_btn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(CreateProfileActivity.this,MainActivity.class);
            }
        });


        mGetContent=registerForActivityResult(
                new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        selectImagebtn.setImageURI(result);
                        imageUri=result;
                        uploadImage();
//                        Intent intent = new Intent(CreateProfileActivity.this, MainActivity.class);
//                        startActivity(intent);

                    }
                }
        );

        selectImagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });



    }

    public void uploadImage() {
        String fileName = FirebaseAuth.getInstance().getCurrentUser().getUid();

        storageReference = FirebaseStorage.getInstance().getReference("images/"+fileName);
        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //selectImagebtn.setImageURI(imageUri);
                        Toast.makeText(CreateProfileActivity.this,"Successfully Uploaded",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CreateProfileActivity.this,"Failed to Upload",Toast.LENGTH_SHORT).show();
            }
        });
    }

}