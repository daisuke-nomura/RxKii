package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.resumabletransfer.KiiRTransfer;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferCallback;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferInfo;
import com.kii.cloud.storage.resumabletransfer.KiiUploader;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;

public class RxKiiUploader {

    @CheckResult
    @NonNull
    public static Single<KiiRTransferInfo> infoAsSingle(@NonNull final KiiUploader kiiUploader) {
        return Single
                .fromCallable(new Callable<KiiRTransferInfo>() {
                    @Override
                    public KiiRTransferInfo call() throws Exception {
                        return kiiUploader.info();
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable suspendAsCompletable(@NonNull final KiiUploader kiiUploader) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        kiiUploader.suspend();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable terminateAsCompletable(@NonNull final KiiUploader kiiUploader) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        kiiUploader.terminate();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Observable<Float> transferAsObservable(@NonNull final KiiUploader kiiUploader) {
        return Observable
                .create(new ObservableOnSubscribe<Float>() {
                    @Override
                    public void subscribe(final ObservableEmitter<Float> emitter) throws Exception {
                        kiiUploader.transferAsync(new KiiRTransferCallback() {
                            @Override
                            public void onProgress(@NonNull KiiRTransfer operator, long completedInBytes, long totalSizeinBytes) {
                                emitter.onNext((float) completedInBytes / totalSizeinBytes);
                            }

                            @Override
                            public void onTransferCompleted(@NonNull KiiRTransfer operator, @Nullable Exception e) {
                                if (e != null) {
                                    emitter.onError(e);
                                    return;
                                }

                                emitter.onComplete();
                            }
                        });
                    }
                });
    }
}
