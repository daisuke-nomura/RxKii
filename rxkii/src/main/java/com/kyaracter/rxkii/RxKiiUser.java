package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.IdentityData;
import com.kii.cloud.storage.KiiGroup;
import com.kii.cloud.storage.KiiListResult;
import com.kii.cloud.storage.KiiTopic;
import com.kii.cloud.storage.KiiUser;
import com.kii.cloud.storage.UserFields;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RxKiiUser {

    @CheckResult
    @NonNull
    public static Completable registerAsCompletable(@NonNull final KiiUser kiiUser, @NonNull final String password) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        kiiUser.register(password);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable requestResendEmailVerificationAsCompletable() {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        KiiUser.requestResendEmailVerification();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable verifyPhoneAsCompletable(@NonNull final KiiUser kiiUser, @NonNull final String code) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        kiiUser.verifyPhone(code);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable changePhoneAsCompletable(@NonNull final String phoneNumber) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        KiiUser.changePhone(phoneNumber);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable requestResendPhoneVerificationCodeAsCompletable() {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        KiiUser.requestResendPhoneVerificationCode();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> logInAsSingle(@NonNull final String userIdentifier, @NonNull final String password) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.logIn(userIdentifier, password);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> logInWithLocalPhoneAsSingle(@NonNull final String localPhoneNumber, @NonNull final String password, @NonNull final String country) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.logInWithLocalPhone(localPhoneNumber, password, country);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> loginWithTokenAsSingle(@NonNull final String token) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.loginWithToken(token);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> loginWithTokenAsSingle(@NonNull final String token, final long expiresAt) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.loginWithToken(token, expiresAt);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> loginWithTokenAsSingle(@NonNull final String token, final long expiresAt, @NonNull final String refreshToken) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.loginWithToken(token, expiresAt, refreshToken);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> loginWithStoredCredentialsAsSingle() {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.loginWithStoredCredentials();
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> refreshAsSingle(@NonNull final KiiUser kiiUser) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        kiiUser.refresh();
                        return kiiUser;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable changePasswordAsCompletable(@NonNull final KiiUser kiiUser, @NonNull final String newPassword, @NonNull final String oldPassword) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiUser.changePassword(newPassword, oldPassword);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable changeEmailAsCompletable(@NonNull final String email) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        KiiUser.changeEmail(email);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable resetPasswordAsCompletable(@NonNull final String identifier) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        KiiUser.resetPassword(identifier);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable resetPasswordAsCompletable(@NonNull final String identifier, @NonNull final KiiUser.NotificationMethod notificationMethod) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        KiiUser.resetPassword(identifier, notificationMethod);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable completeResetPasswordAsCompletable(@NonNull final String identifier, @NonNull final String pinCode, @Nullable final String newPassword) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        KiiUser.completeResetPassword(identifier, pinCode, newPassword);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable updateAsCompletable(@NonNull final KiiUser kiiUser, @Nullable final IdentityData identityData, @Nullable final UserFields userFields) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiUser.update(identityData, userFields);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable updateAsCompletable(@NonNull final KiiUser kiiUser, @NonNull final UserFields userFields) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiUser.update(userFields);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable deleteAsCompletable(@NonNull final KiiUser kiiUser) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiUser.delete();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> findUserByUserNameAsSingle(@NonNull final String username) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.findUserByUserName(username);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> findUserByEmailAsSingle(@NonNull final String email) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.findUserByEmail(email);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> findUserByPhoneAsSingle(@NonNull final String phone) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.findUserByPhone(phone);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiUser> registerAsPseudoUserAsSingle(@Nullable final UserFields userFields) {
        return Single
                .fromCallable(new Callable<KiiUser>() {
                    @Override
                    public KiiUser call() throws Exception {
                        return KiiUser.registerAsPseudoUser(userFields);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable putIdentityAsCompletable(@NonNull final KiiUser kiiUser, @NonNull final IdentityData identityData, @Nullable final UserFields userFields, @NonNull final String password) {
        return Completable
                .fromCallable(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        kiiUser.putIdentity(identityData, userFields, password);
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<List<KiiGroup>> memberOfGroupsAsSingle(@NonNull final KiiUser kiiUser) {
        return Single
                .fromCallable(new Callable<List<KiiGroup>>() {
                    @Override
                    public List<KiiGroup> call() throws Exception {
                        return kiiUser.memberOfGroups();
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<List<KiiGroup>> ownerOfGroupsAsSingle(@NonNull final KiiUser kiiUser) {
        return Single
                .fromCallable(new Callable<List<KiiGroup>>() {
                    @Override
                    public List<KiiGroup> call() throws Exception {
                        return kiiUser.ownerOfGroups();
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle(@NonNull final KiiUser kiiUser) {
        return Single
                .fromCallable(new Callable<KiiListResult<KiiTopic>>() {
                    @Override
                    public KiiListResult<KiiTopic> call() throws Exception {
                        return kiiUser.listTopics();
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<KiiListResult<KiiTopic>> listTopicsAsSingle(@NonNull final KiiUser kiiUser, @Nullable final String paginationKey) {
        return Single
                .fromCallable(new Callable<KiiListResult<KiiTopic>>() {
                    @Override
                    public KiiListResult<KiiTopic> call() throws Exception {
                        return kiiUser.listTopics(paginationKey);
                    }
                });
    }
}
