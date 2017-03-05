package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.kii.cloud.storage.KiiACL;
import com.kii.cloud.storage.KiiACLEntry;

import java.util.Set;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiACL {

    @CheckResult
    @NonNull
    public static Completable saveAsCompletable(@NonNull final KiiACL kiiACL) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiACL.save();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<Set<KiiACLEntry>> listACLEntriesAsSingle(@NonNull final KiiACL kiiACL) {
        return Single
                .fromCallable(() -> kiiACL.listACLEntries());
    }
}
