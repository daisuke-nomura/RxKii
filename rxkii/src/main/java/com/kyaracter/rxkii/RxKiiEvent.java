package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.kii.cloud.analytics.KiiEvent;

import java.util.concurrent.Callable;

import io.reactivex.Completable;

public class RxKiiEvent {

    @CheckResult
    @NonNull
    public static Completable pushAsCompletable(@NonNull final KiiEvent kiiEvent) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        kiiEvent.push();
                        return null;
                    }
                });
    }
}
