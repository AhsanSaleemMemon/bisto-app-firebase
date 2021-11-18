package com.ahsansaleem.i170303_i170364;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class ContactFragment extends Fragment {
    public static final int PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    private RecyclerView recyclerView;
    private List<ContactProfile> list;
    private ContactAdapter contactAdapter;
    TextView addContact;
    ArrayList<ContactProfile> contactsInfoList = new ArrayList<>();

    private static final String[] PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contactFragment =  inflater.inflate(R.layout.fragment_contact, container, false);

        recyclerView = contactFragment.findViewById(R.id.contacts_recycler_view);
        list = new ArrayList<>();

//
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
//        list.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
        requestContactPermission();
        getContacts();

        contactAdapter = new ContactAdapter(contactsInfoList, getContext());
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(contactFragment.getContext()));

        addContact= contactFragment.findViewById(R.id.new_contact);

        contactAdapter = new ContactAdapter(contactsInfoList, getContext());
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(contactFragment.getContext()));
        addContact= contactFragment.findViewById(R.id.new_contact);

        return contactFragment;
    }

    private void getContacts(){
        ContentResolver contentResolver = getActivity().getContentResolver();
        String contactId = null;
        String displayName = null;

        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {

                    ContactProfile contactsInfo = new ContactProfile();
                    contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    contactsInfo.setContactId(contactId);
                    contactsInfo.setContactName(displayName);
                    contactsInfo.setContactPhoto(R.drawable.man);

                    Cursor phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{contactId},
                            null);

                    if (phoneCursor.moveToNext()) {
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        contactsInfo.setContactPhone(phoneNumber);
                    }

                    phoneCursor.close();
                   contactsInfoList.add(new ContactProfile("Ahsan", "03453785686", R.drawable.man));
                    contactsInfoList.add(contactsInfo);
                }
            }
        }
        cursor.close();

    }


    public void requestContactPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        android.Manifest.permission.READ_CONTACTS)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Read contacts access needed");
                    builder.setPositiveButton(android.R.string.ok, null);
                    builder.setMessage("Please enable access to contacts.");
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            requestPermissions(
                                    new String[]
                                            {android.Manifest.permission.READ_CONTACTS}
                                    , PERMISSIONS_REQUEST_READ_CONTACTS);
                        }
                    });
                    builder.show();
                } else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{android.Manifest.permission.READ_CONTACTS},
                            PERMISSIONS_REQUEST_READ_CONTACTS);
                }
            } else {
                getContacts();
            }
        } else {
            getContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getContacts();
                } else {
                    Toast.makeText(getContext(), "You have disabled a contacts permission", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }

    }




}