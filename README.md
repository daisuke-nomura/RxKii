# RxKii: RxJava 2 wrapper for Kii Cloud

[![Release](https://jitpack.io/v/daisuke-nomura/rxkii.svg)](https://jitpack.io/#daisuke-nomura/rxkii)

RxKii is a [RxJava 2][rxjava2] wrapper library for [Kii Cloud][kii].  
This library returns Single or Completable or Observable of RxJava 2.  

NOTE: NOT compatible with RxJava 1.

## Sample usage

    RxKiiUser.logInAsSingle("aaa@example.com", "bbbb")
        .flatMapCompletable(new Function<KiiUser, CompletableSource>() {
            @Override
            public CompletableSource apply(KiiUser kiiUser) throws Exception {
                KiiBucket appBucket = Kii.bucket("my_user");
                KiiObject kiiObject = appBucket.object();
                kiiObject.set("cccc", "dddd");
                return RxKiiObject.saveAsCompletable(kiiObject);
            }
        })
        .toSingleDefault(new Object())
        .flatMap(new Function<Object, SingleSource<Integer>>() {
            @Override
            public SingleSource<Integer> apply(Object o) throws Exception {
                return RxKiiBucket.countAsSingle(Kii.bucket("my_user"));
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Integer value) {
                Log.d("onSuccess", String.valueOf(value));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("onError", e.toString());
            }
        }); 

## Binaries

    allprojects {
        repositories {
            maven { url "https://jitpack.io" }
        }
    }

and

    dependencies {
        compile 'com.github.daisuke-nomura:RxKii:1.0.3'
    }

## Bugs and Feedback

Please use [GitHub Issues][issues].

## License

    MIT License

    Copyright (c) 2016 Daisuke Nomura

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.


[kii]: https://jp.kii.com/
[rxjava2]: https://github.com/ReactiveX/RxJava/tree/2.x
[issues]: https://github.com/daisuke-nomura/RxKii/issues