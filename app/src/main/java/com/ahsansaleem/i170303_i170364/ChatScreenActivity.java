package com.ahsansaleem.i170303_i170364;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChatScreenActivity extends AppCompatActivity {

    ImageView back_button;
    ImageView call_friend_btn;
    RecyclerView recyclerView;
    EditText messageText;
    MessageDBHandler dbHandler;
    FloatingActionButton send_btn, mic_btn, camera_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);


        call_friend_btn = findViewById(R.id.call_friend_btn);
        call_friend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatScreenActivity.this, CallActivity.class));
            }
        });

        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatScreenActivity.this, MainActivity.class));
            }
        });

        ArrayList<MessageModel> messageList = new ArrayList<>();


        messageText = findViewById(R.id.message_text);
        send_btn = findViewById(R.id.send_button);
        mic_btn = findViewById(R.id.mic_button);
        camera_btn = findViewById(R.id.camera_button);

        dbHandler = new MessageDBHandler(ChatScreenActivity.this); // instantiation of DBHandler and the message table will be created

        messageList = dbHandler.readMessages(); // reading the previous stores messages from the db
//        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_INCOMING, MessageAdapter.MESSAGE_TYPE_IMG, R.drawable.receiver_image, "Han heaklsdjalsdllo", R.drawable.receiver_image, "10:75"));
//
        //        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_OUTGOING, MessageAdapter.MESSAGE_TYPE_TEXT, R.drawable.receiver_image, "Han heaklaslidijasldjalsdkjassdjalsdllo", R.drawable.receiver_image, "10:75"));
//        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_INCOMING, MessageAdapter.MESSAGE_TYPE_TEXT, R.drawable.receiver_image, "Han heaklsdasldjasjalsdllo", R.drawable.receiver_image, "10:75"));
//        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_OUTGOING, MessageAdapter.MESSAGE_TYPE_TEXT, R.drawable.receiver_image, "Han heaskldjalsjdlajdlakssdlaksksjdlasjdslkkaklsdjalsdllo", R.drawable.receiver_image, "10:75"));
//        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_INCOMING, MessageAdapter.MESSAGE_TYPE_TEXT, R.drawable.receiver_image, "Han heaalksjdlkakjsdlaksjdlkalsdjklsdjalsdllo", R.drawable.receiver_image, "10:75"));

//        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_OUTGOING, MessageAdapter.MESSAGE_TYPE_IMG, R.drawable.receiver_image, "Han hello", R.drawable.receiver_image, "10:75"));
//        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_INCOMING, MessageAdapter.MESSAGE_TYPE_IMG, R.drawable.receiver_image, "Han hello", R.drawable.receiver_image, "10:75"));
//        messageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_OUTGOING, MessageAdapter.MESSAGE_TYPE_TEXT, R.drawable.receiver_image, "Han hellasdhasdkajshdkhsadjkahsdkhaskjo", R.drawable.receiver_image, "10:75"));


        messageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(messageText.getText().toString().isEmpty()) {
                    send_btn.setVisibility(View.GONE);
                    mic_btn.setVisibility(View.VISIBLE);
                    camera_btn.setVisibility(View.VISIBLE);
                }
                else {
                    mic_btn.setVisibility(View.GONE);
                    camera_btn.setVisibility(View.GONE);
                    send_btn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ArrayList<MessageModel> finalMessageList = messageList;

        finalMessageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_OUTGOING, MessageAdapter.MESSAGE_TYPE_IMG, R.drawable.receiver_image, "Han hello", R.drawable.receiver_image, "10:75"));
        MessageAdapter messageAdapter = new MessageAdapter(this, finalMessageList);

        recyclerView = findViewById(R.id.message_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!messageText.getText().toString().isEmpty()) {

                    dbHandler.addNewMessage(MessageAdapter.MESSENGER_TYPE_OUTGOING, MessageAdapter.MESSAGE_TYPE_TEXT, R.drawable.receiver_image, messageText.getText().toString(),R.drawable.receiver_image,"10:75");

                    finalMessageList.add(new MessageModel(MessageAdapter.MESSENGER_TYPE_OUTGOING, MessageAdapter.MESSAGE_TYPE_TEXT, R.drawable.receiver_image, messageText.getText().toString(), R.drawable.receiver_image, "10:75"));
                    recyclerView.scrollToPosition(finalMessageList.size() - 1);
                    messageText.setText("");
                }
            }
        });
    }
}