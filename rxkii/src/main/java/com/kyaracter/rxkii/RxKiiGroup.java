package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.KiiGroup;
import com.kii.cloud.storage.KiiListResult;
import com.kii.cloud.storage.KiiTopic;
import com.kii.cloud.storage.KiiUser;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiGroup {

    @CheckResult
    @NonNull
    public static Completable saveAsCompletable(@NonNull final KiiGroup kiiGroup) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiGroup.save();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiGroup> refreshAsSingle(@NonNull final KiiGroup kiiGroup) {
        return Single
                .fromCallable(() -> {
                    kiiGroup.refresh();
                    return kiiGroup;
                });
    }

    @CheckResult
    @NonNull
    public static Completable deleteAsCompletable(@NonNull final KiiGroup kiiGroup) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiGroup.delete();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiGroup> registerGroupWithIDAsSingle(@NonNull final String id, @NonNull final String name, @Nullable final List<KiiUser> members) {
        return Single
                .fromCallable(() -> KiiGroup.registerGroupWithID(id, name, members));
    }

    @CheckResult
    @NonNull
    public static Completable changeNameAsCompletable(@NonNull final KiiGroup kiiGroup, @NonNull final String name) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiGroup.changeName(name);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> getOwnerAsSingle(@NonNull final KiiGroup kiiGroup) {
        return Single
                .fromCallable(() -> kiiGroup.getOwner());
    }

    @CheckResult
    @NonNull
    public static Single<List<KiiUser>> listMembersAsSingle(@NonNull final KiiGroup kiiGroup) {
        return Single
                .fromCallable(() -> kiiGroup.listMembers());
    }

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle(@NonNull final KiiGroup kiiGroup) {
        return Single
                .fromCallable(() -> kiiGroup.listTopics());
    }

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle(@NonNull final KiiGroup kiiGroup, @Nullable final String paginationKey) {
        return Single
                .fromCallable(() -> kiiGroup.listTopics(paginationKey));
    }
}
