package com.aware.utils;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import com.aware.Aware;

/**
 * Created by denzil on 03/03/2017.
 * This is just a light sync adapter. We use it to trigger the already existing mechanism to sync data to the server.
 */

public class Aware_SyncAdapter extends AbstractThreadedSyncAdapter {

    private Context mContext;

    public Aware_SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        mContext = context;
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        Log.d(Aware.TAG, "AWARE SyncAdapter onPerformSync");

        Intent syncBroadcast = new Intent(Aware.ACTION_AWARE_SYNC_DATA);
        mContext.sendBroadcast(syncBroadcast);

//        Intent aware = new Intent(mContext, Aware.class);
//        mContext.startService(aware);
//
//        Aware.startScheduler(mContext);
//        Aware.toggleSensors(mContext);
    }
}
