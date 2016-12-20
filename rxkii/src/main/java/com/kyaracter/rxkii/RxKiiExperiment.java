package com.kyaracter.rxkii;


import android.support.annotation.NonNull;

import com.kii.cloud.abtesting.KiiExperiment;

import java.util.concurrent.Callable;

import io.reactivex.Single;

public class RxKiiExperiment {

    public static Single<KiiExperiment> getByIDAsSingle(@NonNull final String experimentID) {
        return Single
                .fromCallable(new Callable<KiiExperiment>() {
                    @Override
                    public KiiExperiment call() throws Exception {
                        return KiiExperiment.getByID(experimentID);
                    }
                });
    }
}
