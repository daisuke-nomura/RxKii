package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.KiiListResult;
import com.kii.cloud.storage.KiiThing;
import com.kii.cloud.storage.KiiThingOwner;
import com.kii.cloud.storage.KiiTopic;
import com.kii.cloud.storage.ThingFields;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiThings {

    @CheckResult
    @NonNull
    public static Completable registerOwnerWithThingIDAsCompletable(@NonNull final String thingID, @NonNull final KiiThingOwner owner) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        KiiThing.registerOwnerWithThingID(thingID, owner);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable registerOwnerWithVenderThingIDAsCompletable(@NonNull final String vendorThingID, @NonNull final KiiThingOwner owner) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        KiiThing.registerOwnerWithVenderThingID(vendorThingID, owner);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiThing> registerAsSingle(@NonNull final String vendorThingID, @NonNull final String password, @Nullable final String thingType, @Nullable final ThingFields thingFields) {
        return Single
                .fromCallable(() -> KiiThing.register(vendorThingID, password, thingType, thingFields));
    }

    @CheckResult
    @NonNull
    public static Single<KiiThing> refreshAsSingle(@NonNull final KiiThing kiiThing) {
        return Single
                .fromCallable(() -> {
                    kiiThing.refresh();
                    return kiiThing;
                });
    }

    @CheckResult
    @NonNull
    public static Completable updateAsCompletable(@NonNull final KiiThing kiiThing) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiThing.update();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable deleteAsCompletable(@NonNull final KiiThing kiiThing) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiThing.delete();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<Boolean> isOwnerAsSingle(@NonNull final KiiThing kiiThing, @NonNull final KiiThingOwner owner) {
        return Single
                .fromCallable(() -> kiiThing.isOwner(owner));
    }

    @CheckResult
    @NonNull
    public static Completable registerOwnerAsCompletable(@NonNull final KiiThing kiiThing, @NonNull final KiiThingOwner owner) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiThing.registerOwner(owner);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable unregisterOwnerAsCompletable(@NonNull final KiiThing kiiThing, @NonNull final KiiThingOwner owner) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiThing.unregisterOwner(owner);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable disableAsCompletable(@NonNull final KiiThing kiiThing) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiThing.disable();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable enableAsCompletable(@NonNull final KiiThing kiiThing) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiThing.enable();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiThing> enableAsSingle(@NonNull final String thingId) {
        return Single
                .fromCallable(() -> KiiThing.loadWithThingID(thingId));
    }

    @CheckResult
    @NonNull
    public static Single<KiiThing> loadWithVendorThingIDAsSingle(@NonNull final String vendorThingID) {
        return Single
                .fromCallable(() -> KiiThing.loadWithVendorThingID(vendorThingID));
    }

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle(@NonNull final KiiThing kiiThing) {
        return Single
                .fromCallable(() -> kiiThing.listTopics());
    }

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle(@NonNull final KiiThing kiiThing, @Nullable final String paginationKey) {
        return Single
                .fromCallable(() -> kiiThing.listTopics(paginationKey));
    }
}
