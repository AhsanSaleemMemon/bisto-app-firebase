package com.ahsansaleem.i170303_i170364;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MessageDBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "bisto";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "messagestable";

    private static final String ID_COL = "id";

    private static final String MESSENGER_TYPE_COL = "messengertype";

    private static final String MESSAGE_TYPE_COL = "messagetype";

    private static final String FRIEND_PROFILE_IMAGE_COL = "friendprofileimage";

    private static final String IMAGE_MESSAGE_COL = "imagemessage";

    private static final String TEXT_MESSAGE_COL = "textmessage";

    private static final String MESSAGE_DATE_COL = "messagedate";

    public MessageDBHandler (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MESSENGER_TYPE_COL + " INTEGER,"
                + MESSAGE_TYPE_COL + " INTEGER,"
                + FRIEND_PROFILE_IMAGE_COL + " INTEGER,"
                + TEXT_MESSAGE_COL + " TEXT,"
                + IMAGE_MESSAGE_COL + " INTEGER,"
                + MESSAGE_DATE_COL + " TEXT)";

        sqLiteDatabase.execSQL(createQuery);





    }

    public void addNewMessage (int messengerType, int messageType, int friendProfileImage, String textMessage,int imageMessage, String messageDate) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MESSENGER_TYPE_COL, messengerType);
        values.put(MESSAGE_TYPE_COL, messageType);
        values.put(FRIEND_PROFILE_IMAGE_COL, friendProfileImage);
        values.put(TEXT_MESSAGE_COL, textMessage);
        values.put(IMAGE_MESSAGE_COL, imageMessage);
        values.put(MESSAGE_DATE_COL, messageDate);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<MessageModel> readMessages() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorMessages = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<MessageModel> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorMessages.moveToFirst()) {
            do {


                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new MessageModel(cursorMessages.getInt(1),
                        cursorMessages.getInt(2),
                        cursorMessages.getInt(3),
                        cursorMessages.getString(4),
                        cursorMessages.getInt(5),
                        cursorMessages.getString(6)));
            } while (cursorMessages.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorMessages.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
