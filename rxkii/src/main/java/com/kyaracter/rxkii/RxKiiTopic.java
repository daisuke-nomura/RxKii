package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.kii.cloud.storage.KiiPushMessage;
import com.kii.cloud.storage.KiiTopic;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiTopic {

    @CheckResult
    @NonNull
    public static Completable saveAsCompletable(@NonNull final KiiTopic kiiTopic) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiTopic.save();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable deleteAsCompletable(@NonNull final KiiTopic kiiTopic) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiTopic.delete();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<Boolean> existsAsSingle(@NonNull final KiiTopic kiiTopic) {
        return Single
                .fromCallable(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return kiiTopic.exists();
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable sendMessageAsCompletable(@NonNull final KiiTopic kiiTopic, @NonNull final KiiPushMessage message) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiTopic.sendMessage(message);
                        return null;
                    }
                });
    }
}
