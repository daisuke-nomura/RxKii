package com.kyaracter.rxkii;


import android.support.annotation.NonNull;

import com.kii.cloud.abtesting.KiiExperiment;

import io.reactivex.Single;

public class RxKiiExperiment {

    public static Single<KiiExperiment> getByIDAsSingle(@NonNull final String experimentID) {
        return Single
                .fromCallable(() -> KiiExperiment.getByID(experimentID));
    }
}
