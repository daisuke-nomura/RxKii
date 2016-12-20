package com.kyaracter.rxkii;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.KiiServerCodeEntry;
import com.kii.cloud.storage.KiiServerCodeEntryArgument;
import com.kii.cloud.storage.KiiServerCodeExecResult;

import java.util.concurrent.Callable;

import io.reactivex.Single;

public class RxKiiServerCodeEntry {

    public static Single<KiiServerCodeExecResult> executeAsSingle(@NonNull final KiiServerCodeEntry kiiServerCodeEntry, @Nullable final KiiServerCodeEntryArgument argument) {
        return Single
                .fromCallable(new Callable<KiiServerCodeExecResult>() {
                    @Override
                    public KiiServerCodeExecResult call() throws Exception {
                        return kiiServerCodeEntry.execute(argument);
                    }
                });
    }
}
