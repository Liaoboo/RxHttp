package com.github.kongpf8848.rxhttp.request

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.github.kongpf8848.rxhttp.bean.DownloadInfo
import okhttp3.RequestBody

class DownloadRequest : AbsRequest<DownloadInfo> {
    var dir: String? = null
        private set
    var filename: String? = null
        private set
    var md5: String? = null
        private set
    var isBreakpoint = false
        private set

    constructor(context: Context) : super(context) {}
    constructor(activity: Activity) : super(activity) {}
    constructor(fragment: Fragment) : super(fragment) {}

    fun dir(dir: String?): DownloadRequest {
        this.dir = dir
        return this
    }

    fun filename(filename: String?): DownloadRequest {
        this.filename = filename
        return this
    }

    fun breakpoint(breakpoint: Boolean): DownloadRequest {
        isBreakpoint = breakpoint
        return this
    }

    fun md5(md5: String?): DownloadRequest {
        this.md5 = md5
        return this
    }

    override fun buildRequestBody(): RequestBody? {
        return null
    }
}