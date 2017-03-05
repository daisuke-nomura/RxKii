package com.kyaracter.rxkii;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.KiiUser;
import com.kii.cloud.storage.callback.KiiSocialCallBack;
import com.kii.cloud.storage.social.KiiSocialConnect;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiSocialConnect {

    @CheckResult
    @NonNull
    public static Single<KiiUser> logInAsSingle(@NonNull final KiiSocialConnect kiiSocialConnect, @Nullable final Activity var1, @Nullable final Bundle var2) {
        return Single
                .create(e -> kiiSocialConnect.logIn(var1, var2, new KiiSocialCallBack() {
                    @Override
                    public void onLoginCompleted(@NonNull KiiSocialConnect.SocialNetwork network, @Nullable KiiUser user, @Nullable Exception exception) {
                        if (exception != null) {
                            e.onError(exception);
                            return;
                        }

                        e.onSuccess(user);
                    }
                }));
    }

    @CheckResult
    @NonNull
    public static Completable linkAsCompletable(@NonNull final KiiSocialConnect kiiSocialConnect, @Nullable final Activity var1, @Nullable final Bundle var2) {
        return Completable
                .create(e -> kiiSocialConnect.link(var1, var2, new KiiSocialCallBack() {
                    @Override
                    public void onLinkCompleted(@NonNull KiiSocialConnect.SocialNetwork network, @Nullable KiiUser user, @Nullable Exception exception) {
                        if (exception != null) {
                            e.onError(exception);
                            return;
                        }

                        e.onComplete();
                    }
                }));
    }

    @CheckResult
    @NonNull
    public static Completable unlinkAsCompletable(@NonNull final KiiSocialConnect kiiSocialConnect, @Nullable final Activity var1, @Nullable final Bundle var2) {
        return Completable
                .create(e -> kiiSocialConnect.unlink(var1, var2, new KiiSocialCallBack() {
                    @Override
                    public void onUnLinkCompleted(@NonNull KiiSocialConnect.SocialNetwork network, @Nullable KiiUser user, @Nullable Exception exception) {
                        if (exception != null) {
                            e.onError(exception);
                            return;
                        }

                        e.onComplete();
                    }
                }));
    }
}
