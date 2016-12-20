package com.kyaracter.rxkii;


import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.kii.cloud.storage.resumabletransfer.KiiDownloader;
import com.kii.cloud.storage.resumabletransfer.KiiRTransfer;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferCallback;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferInfo;

import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;

public class RxKiiDownloader {

    @CheckResult
    @NonNull
    public static Single<KiiRTransferInfo> infoAsSingle(@NonNull final KiiDownloader kiiDownloader) {
        return Single
                .fromCallable(new Callable<KiiRTransferInfo>() {
                    @Override
                    public KiiRTransferInfo call() throws Exception {
                        return kiiDownloader.info();
                    }
                });
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
                .create(new ObservableOnSubscribe<Float>() {
                    @Override
                    public void subscribe(final ObservableEmitter<Float> emitter) throws Exception {
                        kiiDownloader.transferAsync(new KiiRTransferCallback() {
                            @Override
                            public void onProgress(@NonNull KiiRTransfer operator, long completedInBytes, long totalSizeinBytes) {
                                super.onProgress(operator, completedInBytes, totalSizeinBytes);
                                emitter.onNext((float) completedInBytes / totalSizeinBytes);
                            }

                            @Override
                            public void onTransferCompleted(@NonNull KiiRTransfer operator, @NonNull Exception e) {
                                super.onTransferCompleted(operator, e);
                                emitter.onComplete();
                            }
                        });
                    }
                });
    }
}
