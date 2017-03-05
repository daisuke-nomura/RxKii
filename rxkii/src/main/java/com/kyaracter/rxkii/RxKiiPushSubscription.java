package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.kii.cloud.storage.KiiBucket;
import com.kii.cloud.storage.KiiPushSubscription;
import com.kii.cloud.storage.KiiSubscribable;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiPushSubscription {

    @CheckResult
    @NonNull
    public static Completable subscribeAsCompletable(@NonNull final KiiPushSubscription kiiPushSubscription, @NonNull final KiiSubscribable target) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiPushSubscription.subscribe(target);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable subscribeBucketAsCompletable(@NonNull final KiiPushSubscription kiiPushSubscription, @NonNull final KiiBucket bucket) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiPushSubscription.subscribeBucket(bucket);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<Boolean> isSubscribedAsSingle(@NonNull final KiiPushSubscription kiiPushSubscription, @NonNull final KiiSubscribable target) {
        return Single
                .fromCallable(() -> kiiPushSubscription.isSubscribed(target));
    }

    @CheckResult
    @NonNull
    public static Completable unsubscribeAsCompletable(@NonNull final KiiPushSubscription kiiPushSubscription, @NonNull final KiiSubscribable target) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiPushSubscription.unsubscribe(target);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable unsubscribeBucketAsCompletable(@NonNull final KiiPushSubscription kiiPushSubscription, @NonNull final KiiBucket bucket) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiPushSubscription.unsubscribeBucket(bucket);
                        return null;
                    }
                });
    }
}
