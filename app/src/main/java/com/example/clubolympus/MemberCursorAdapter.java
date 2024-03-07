package com.example.clubolympus;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.clubolympus.data.ClubOlympusContract;

import org.w3c.dom.Text;

import java.lang.reflect.Member;

public class MemberCursorAdapter extends CursorAdapter {

    public MemberCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.member_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView firstNameTextView = view.findViewById(R.id.firstNameTextView);
        TextView lasstNameTextView = view.findViewById(R.id.lastNameTextView);
        TextView sportNameTextView = view.findViewById(R.id.sportNameTextView);

        String firstName = cursor.getString(cursor.getColumnIndexOrThrow(ClubOlympusContract.MemberEntry.COLUMN_FIRST_NAME));
        String lastName = cursor.getString(cursor.getColumnIndexOrThrow(ClubOlympusContract.MemberEntry.COLUMN_LAST_NAME));
        String sportName = cursor.getString(cursor.getColumnIndexOrThrow(ClubOlympusContract.MemberEntry.COLUMN_SPORT));

        firstNameTextView.setText(firstName);
        lasstNameTextView.setText(lastName);
        sportNameTextView.setText(sportName);
    }
}
