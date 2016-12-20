package com.kyaracter.rxkii;


import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.kii.cloud.storage.KiiUser;
import com.kii.cloud.storage.resumabletransfer.KiiDownloader;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferManager;
import com.kii.cloud.storage.resumabletransfer.KiiUploader;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Single;

public class RxKiiRTransferManager {

    @CheckResult
    @NonNull
    public static Single<List<KiiUploader>> listUploadEntriesAsSingle(@NonNull final KiiRTransferManager kiiRTransferManager, @NonNull final Context context) {
        return Single
                .fromCallable(new Callable<List<KiiUploader>>() {
                    @Override
                    public List<KiiUploader> call() throws Exception {
                        return kiiRTransferManager.listUploadEntries(context);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<List<KiiUploader>> listUploadEntriesAsSingle(@NonNull final KiiRTransferManager kiiRTransferManager, @NonNull final Context context, @NonNull final KiiUser kiiUser) {
        return Single
                .fromCallable(new Callable<List<KiiUploader>>() {
                    @Override
                    public List<KiiUploader> call() throws Exception {
                        return kiiRTransferManager.listUploadEntries(context, kiiUser);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<List<KiiDownloader>> listDownloadEntriesAsSingle(@NonNull final KiiRTransferManager kiiRTransferManager, @NonNull final Context context) {
        return Single
                .fromCallable(new Callable<List<KiiDownloader>>() {
                    @Override
                    public List<KiiDownloader> call() throws Exception {
                        return kiiRTransferManager.listDownloadEntries(context);
                    }
                });
    }

    @CheckResult
    @NonNull
    public static Single<List<KiiDownloader>> listDownloadEntriesAsSingle(@NonNull final KiiRTransferManager kiiRTransferManager, @NonNull final Context context, @NonNull final KiiUser kiiUser) {
        return Single
                .fromCallable(new Callable<List<KiiDownloader>>() {
                    @Override
                    public List<KiiDownloader> call() throws Exception {
                        return kiiRTransferManager.listDownloadEntries(context, kiiUser);
                    }
                });
    }
}
