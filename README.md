# RxHttp

基于Retrofit和RxJava2封装的Http类库，实现了get,post,post表单请求,文件下载及进度监听,文件上传及进度监听功能。

# 功能特点
```
支持上传及进度监听，支持上传多个文件，支持文本和文件混合上传

支持下载及进度监听，支持大文件下载

支持自定义OkHttpClient

链式调用，支持每一个请求动态添加Header

支持网络请求和Activity,Fragment生命周期绑定，界面销毁时自动取消订阅

```
# 添加依赖
```
implementation 'com.github.kongpf8848:RxHttp:1.0.1'
```
# get请求
```
       RxHttp.getInstance()
                .get(this)
                .url(Constants.URL_GET)
                .enqueue(new HttpCallback<Feed>() {
                    @Override
                    public void onStart() {
                        Log.d(TAG, "onStart");
                    }

                    @Override
                    public void onResponse(Feed response) {
                        Toast.makeText(MainActivity.this, response.getDate(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError:" + e.getMessage());
                        Toast.makeText(MainActivity.this, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
```
# post请求
```
        String content = "this is post content";
        RxHttp.getInstance()
                .post(this)
                .content(content)
                .url(Constants.URL_POST)
                .enqueue(new HttpCallback<String>() {

                    @Override
                    public void onStart() {
                        Log.d(TAG, "onStart");
                    }

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "response:" + response, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError:" + e.getMessage());
                        Toast.makeText(MainActivity.this, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
```
# post表单请求
```
 Map<String, Object> map = new HashMap<>();
        map.put("model", Build.MODEL);
        map.put("manufacturer", Build.MANUFACTURER);
        map.put("os", Build.VERSION.SDK_INT);
        RxHttp.getInstance().postForm(this).url(Constants.URL_POST_FORM).params(map).enqueue(new HttpCallback<String>() {

            @Override
            public void onStart() {
                Log.d(TAG, "onStart");
            }

            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "response:" + response, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError:" + e.getMessage());
                Toast.makeText(MainActivity.this, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });
```
# 下载请求
```
  RxHttp.getInstance().download(this).dir(PATH)
                .url(Constants.URL_DOWNLOAD)
                .enqueue(new DownloadCallback() {

                    @Override
                    public void onStart() {
                        showProgressDialog("正在下载新版本,请稍等...");
                    }

                    @Override
                    public void onProgress(DownloadInfo downloadInfo) {
                        if (downloadInfo != null) {
                            updateProgress(downloadInfo.getTotal(),downloadInfo.getProgress());
                        }
                    }

                    @Override
                    public void onResponse(DownloadInfo downloadInfo) {
                        Log.d(TAG, "onResponse");
                        closeProgressDialog();
                        MainActivity.this.downloadInfo = downloadInfo;
                        install();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError:"+e.getMessage());
                        closeProgressDialog();

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete:");
                    }

                });

```
# 上传请求
```
 Map<String, Object> map = new HashMap<>();
        map.put("model", Build.MODEL);
        map.put("manufacturer", Build.MANUFACTURER);
        map.put("os", Build.VERSION.SDK_INT);
        map.put("image", new File(path));

        RxHttp.getInstance().upload(this).url(Constants.URL_UPLOAD).params(map).enqueue(new UploadCallback<String>() {
            @Override
            public void onStart() {
                showProgressDialog("正在上传,请稍等...");
            }

            @Override
            public void onProgress(final long totalBytes, final long readBytes) {
                updateProgress(totalBytes,readBytes);
            }

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "response:" + response);
                Toast.makeText(MainActivity.this, "response:" + response, Toast.LENGTH_SHORT).show();
                closeProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError:" + e.getMessage());
                Toast.makeText(MainActivity.this, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                closeProgressDialog();

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
                closeProgressDialog();
            }
        });
```
具体使用可参考Demo

# License
```
Copyright (C) 2019 kongpf8848

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
