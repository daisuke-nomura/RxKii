package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.KiiBucket;
import com.kii.cloud.storage.KiiObject;
import com.kii.cloud.storage.query.KiiQuery;
import com.kii.cloud.storage.query.KiiQueryResult;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiBucket {

    @CheckResult
    @NonNull
    public static Single<KiiQueryResult<KiiObject>> queryAsSingle(@NonNull final KiiBucket kiiBucket, @Nullable final KiiQuery query) {
        return Single
                .fromCallable(new Callable<KiiQueryResult<KiiObject>>() {
                    @Override
                    public KiiQueryResult<KiiObject> call() throws Exception {
                        return kiiBucket.query(query);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<Integer> countAsSingle(@NonNull final KiiBucket kiiBucket) {
        return Single
                .fromCallable(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return kiiBucket.count();
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<Integer> countAsSingle(@NonNull final KiiBucket kiiBucket, @Nullable final KiiQuery query) {
        return Single
                .fromCallable(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return kiiBucket.count(query);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable deleteAsCompletable(@NonNull final KiiBucket kiiBucket) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiBucket.delete();
                        return null;
                    }
                });
    }
}