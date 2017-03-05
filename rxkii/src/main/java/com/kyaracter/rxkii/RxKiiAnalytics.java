package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.analytics.KiiAnalytics;
import com.kii.cloud.analytics.aggregationresult.GroupedResult;
import com.kii.cloud.analytics.aggregationresult.ResultQuery;

import io.reactivex.Single;

public class RxKiiAnalytics {

    @CheckResult
    @NonNull
    public static Single<GroupedResult> getResultAsSingle(@NonNull final String ruleId, @Nullable final ResultQuery query) {
        return Single
                .fromCallable(() -> KiiAnalytics.getResult(ruleId, query));
    }
}
