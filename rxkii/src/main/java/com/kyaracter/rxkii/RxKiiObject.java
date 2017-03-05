package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.KiiObject;

import java.io.File;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiObject {

    @CheckResult
    @NonNull
    public static Single<KiiObject> refreshAsSingle(@NonNull final KiiObject kiiObject) {
        return Single
                .fromCallable(() -> {
                    kiiObject.refresh();
                    return kiiObject;
                });
    }

    @CheckResult
    @NonNull
    public static Completable saveAsCompletable(@NonNull final KiiObject kiiObject) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiObject.save();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable saveAsCompletable(@NonNull final KiiObject kiiObject, final boolean overWrite) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiObject.save(overWrite);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable saveAllFieldsAsCompletable(@NonNull final KiiObject kiiObject, final boolean overWrite) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiObject.saveAllFields(overWrite);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable deleteAsCompletable(@NonNull final KiiObject kiiObject) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiObject.delete();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<String> publishBodyAsSingle(@NonNull final KiiObject kiiObject) {
        return Single
                .fromCallable(() -> kiiObject.publishBody());
    }

    @CheckResult
    @NonNull
    public static Single<String> publishBodyExpiresAtAsSingle(@NonNull final KiiObject kiiObject, final long expiresAt) {
        return Single
                .fromCallable(() -> kiiObject.publishBodyExpiresAt(expiresAt));
    }

    @CheckResult
    @NonNull
    public static Single<String> publishBodyExpiresInAsSingle(@NonNull final KiiObject kiiObject, final int expiresIn) {
        return Single
                .fromCallable(() -> kiiObject.publishBodyExpiresIn(expiresIn));
    }

    @CheckResult
    @NonNull
    public static Completable uploadBodyAsCompletable(@NonNull final KiiObject kiiObject, @NonNull final File sourceFile, @Nullable final String contentType) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiObject.uploadBody(sourceFile, contentType);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable downloadBodyAsCompletable(@NonNull final KiiObject kiiObject, @NonNull final File destFile) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiObject.downloadBody(destFile);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable deleteBodyAsCompletable(@NonNull final KiiObject kiiObject) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiObject.deleteBody();
                        return null;
                    }
                });
    }
}
