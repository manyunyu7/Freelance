package com.litziy.kawalcovid.content_provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;

import com.litziy.kawalcovid.db.MedicineDatabaseHelper;
import com.litziy.kawalcovid.db.MedicineDatabaseManager;

import static com.litziy.kawalcovid.db.MedicineDatabaseHelper.AUTHORITY;
import static com.litziy.kawalcovid.db.MedicineDatabaseHelper.SCHEME;
import static com.litziy.kawalcovid.db.MedicineDatabaseHelper.TABLE_MEDICINE;

public class MyContentProvider extends ContentProvider {

    private MedicineDatabaseManager medicineDatabaseManager;

    private static final int MEDICINE = 1;
    private static final int MEDICINE_ID = 2;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static SQLiteDatabase sqlite;


    Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
            .authority(AUTHORITY)
            .appendPath(TABLE_MEDICINE)
            .build();


    public MyContentProvider() {
        medicineDatabaseManager = new MedicineDatabaseManager(getContext());
        sUriMatcher.addURI(AUTHORITY, TABLE_MEDICINE, MEDICINE);
        sUriMatcher.addURI(AUTHORITY, TABLE_MEDICINE + "/#", MEDICINE_ID);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long added;
        if (sUriMatcher.match(uri) == MEDICINE) {
            added = medicineDatabaseManager.insert(values);
        } else {
            added = 0;
        }
        getContext().getContentResolver().notifyChange(CONTENT_URI, null);
        return Uri.parse(CONTENT_URI + "/" + added);
    }

    @Override
    public boolean onCreate() {
        sqlite = medicineDatabaseManager.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor;
        switch (sUriMatcher.match(uri)) {
            case MEDICINE:
                cursor = medicineDatabaseManager.queryAll();
                break;
            case MEDICINE_ID:
                cursor = medicineDatabaseManager.queryById(uri.getLastPathSegment());
                break;
            default:
                cursor = null;
                break;
        }

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int updated;
        if (sUriMatcher.match(uri) == MEDICINE_ID) {
            updated = medicineDatabaseManager.update(uri.getLastPathSegment(), values);
        } else {
            updated = 0;
        }

        getContext().getContentResolver().notifyChange(CONTENT_URI, null);

        return updated;
    }
}