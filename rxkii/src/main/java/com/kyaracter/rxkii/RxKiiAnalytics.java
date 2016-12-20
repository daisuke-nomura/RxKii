package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.analytics.KiiAnalytics;
import com.kii.cloud.analytics.aggregationresult.GroupedResult;
import com.kii.cloud.analytics.aggregationresult.ResultQuery;

import java.util.concurrent.Callable;

import io.reactivex.Single;

public class RxKiiAnalytics {

    @CheckResult
    @NonNull
    public static Single<GroupedResult> getResultAsSingle(@NonNull final String ruleId, @Nullable final ResultQuery query) {
        return Single
                .fromCallable(new Callable<GroupedResult>() {
                    @Override
                    public GroupedResult call() throws Exception {
                        return KiiAnalytics.getResult(ruleId, query);
                    }
                });
    }
}
