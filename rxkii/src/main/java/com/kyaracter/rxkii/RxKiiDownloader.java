package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kii.cloud.storage.resumabletransfer.KiiDownloader;
import com.kii.cloud.storage.resumabletransfer.KiiRTransfer;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferCallback;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferInfo;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class RxKiiDownloader {

    @CheckResult
    @NonNull
    public static Single<KiiRTransferInfo> infoAsSingle(@NonNull final KiiDownloader kiiDownloader) {
        return Single
                .fromCallable(() -> kiiDownloader.info());
    }

    @CheckResult
    @NonNull
    public static Completable suspendAsCompletable(@NonNull final KiiDownloader kiiDownloader) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        kiiDownloader.suspend();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Completable terminateAsCompletable(@NonNull final KiiDownloader kiiDownloader) {
        return Completable
                .fromCallable(new Callable<Completable>() {
                    @Override
                    public Completable call() throws Exception {
                        kiiDownloader.terminate();
                        return null;
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Observable<Float> transferAsObservable(@NonNull final KiiDownloader kiiDownloader) {
        return Observable
                .create(emitter -> kiiDownloader.transferAsync(new KiiRTransferCallback() {
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
                }));
    }
}
