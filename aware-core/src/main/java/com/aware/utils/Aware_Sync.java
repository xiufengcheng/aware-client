package com.aware.utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by denzil on 03/03/2017.
 */

public class Aware_Sync extends Service {

    public static final String ACCOUNT_TYPE = "awareframework.com";
    public static final String ACCOUNT = "AWARE Framework";

    private Aware_SyncAdapter sAwareSyncAdapter = null;
    private static final Object sSyncAdapterLock = new Object();

    @Override
    public void onCreate() {
        super.onCreate();

        synchronized(sSyncAdapterLock) {
            if (sAwareSyncAdapter == null) sAwareSyncAdapter = new Aware_SyncAdapter(getApplicationContext(), true);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sAwareSyncAdapter.getSyncAdapterBinder();
    }
}
