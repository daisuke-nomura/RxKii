package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.Kii;
import com.kii.cloud.storage.KiiListResult;
import com.kii.cloud.storage.KiiTopic;

import io.reactivex.Single;

public class RxKii {

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle() {
        return Single
                .fromCallable(() -> Kii.listTopics());
    }

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle(@Nullable final String paginationKey) {
        return Single
                .fromCallable(() -> Kii.listTopics(paginationKey));
    }
}