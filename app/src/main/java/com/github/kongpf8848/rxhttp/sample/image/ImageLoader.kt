package com.jsy.tk.library.image

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.github.kongpf8848.rxhttp.sample.R
import com.github.kongpf8848.rxhttp.sample.image.transfrom.RoundCornerTransform

/**
 * 图片加载库
 */
class ImageLoader private constructor() {

    private object ImageLoader {
        val holder = ImageLoader()
    }

    private fun getRequestOptions(requestOptions: RequestOptions?): RequestOptions {
        return if (requestOptions == null) {
            OPTIONS_DEFAULT
        } else {
            var placeholderId = R.mipmap.cover_default
            var errorId = R.mipmap.cover_default
            if (requestOptions.placeholderId > 0) {
                placeholderId = requestOptions.placeholderId
            }
            if (requestOptions.errorId > 0) {
                errorId = requestOptions.errorId
            }
            requestOptions.placeholder(placeholderId).error(errorId)
        }
    }

    /**
     * 加载本地图片
     * @param context
     * @param resourceId
     * @param requestOptions
     * @param imageView
     */
    fun load(
        context: Context,
        resourceId: Int,
        imageView: ImageView,
        requestOptions: RequestOptions? = null
    ) {
        Glide.with(context)
            .load(resourceId)
            .apply(getRequestOptions(requestOptions))
            .into(imageView)
    }

    fun load(
        activity: Activity,
        resourceId: Int,
        imageView: ImageView,
        requestOptions: RequestOptions? = null
    ) {
        Glide.with(activity)
            .load(resourceId)
            .apply(getRequestOptions(requestOptions))
            .into(imageView)
    }

    fun load(
        fragment: Fragment,
        resourceId: Int,
        imageView: ImageView,
        requestOptions: RequestOptions? = null
    ) {
        Glide.with(fragment)
            .load(resourceId)
            .apply(getRequestOptions(requestOptions))
            .into(imageView)
    }
    /*=================================================分割线================================================*/
    /**
     * 加载远程图片
     * @param context
     * @param url
     * @param requestOptions
     * @param imageView
     */
    fun load(
        context: Context,
        url: String?,
        imageView: ImageView,
        requestOptions: RequestOptions? = null,
        listener:RequestListener<Drawable>?=null
    ) {
        Glide.with(context)
            .load(url)
            .apply(getRequestOptions(requestOptions))
            .listener(listener)
            .into(imageView)
    }

    fun load(
        activity: Activity,
        url: String?,
        imageView: ImageView,
        requestOptions: RequestOptions? = null
    ) {
        Glide.with(activity)
            .load(url)
            .apply(getRequestOptions(requestOptions))
            .into(imageView)
    }

    fun load(
        fragment: Fragment,
        url: String?,
        imageView: ImageView,
        requestOptions: RequestOptions? = null
    ) {
        Glide.with(fragment)
            .load(url)
            .apply(getRequestOptions(requestOptions))
            .into(imageView)
    }

    /*=================================================分割线================================================*/
    /**
     * 加载圆形图片
     * @param context
     * @param resourceId
     * @param imageView
     */
    fun circleCrop(
        context: Context,
        resourceId: Int,
        imageView: ImageView
    ) {
        load(context, resourceId, imageView, OPTIONS_CIRCLE)
    }

    fun circleCrop(
        context: Context,
        url: String?,
        imageView: ImageView
    ) {
        load(context, url, imageView, OPTIONS_CIRCLE)
    }

    fun circleCrop(
        activity: Activity,
        resourceId: Int,
        imageView: ImageView
    ) {
        load(activity, resourceId, imageView, OPTIONS_CIRCLE)
    }

    fun circleCrop(
        activity: Activity,
        url: String?,
        imageView: ImageView
    ) {
        load(activity, url, imageView, OPTIONS_CIRCLE)
    }

    fun circleCrop(
        fragment: Fragment,
        resourceId: Int,
        imageView: ImageView
    ) {
        load(fragment, resourceId, imageView, OPTIONS_CIRCLE)
    }

    fun circleCrop(
        fragment: Fragment,
        url: String,
        imageView: ImageView
    ) {
        load(fragment, url, imageView, OPTIONS_CIRCLE)
    }
    /*=================================================分割线================================================*/
    /**
     * 加载头像
     */

    fun circleAvatar(
        context: Context,
        url: String?,
        imageView: ImageView
    ) {
        load(
            context,
            url,
            imageView,
            OPTIONS_AVATAR
        )
    }


    fun circleAvatar(
        activity: Activity,
        url: String?,
        imageView: ImageView
    ) {
        load(
            activity,
            url,
            imageView,
            OPTIONS_AVATAR
        )
    }

    fun circleAvatar(
        fragment: Fragment,
        url: String,
        imageView: ImageView
    ) {
        load(
            fragment,
            url,
            imageView,
            OPTIONS_AVATAR
        )
    }
    /*=================================================分割线================================================*/
    /**
     * 加载圆角图片
     * @param context
     * @param url
     * @param radius
     * @param imageView
     */
    fun roundCorner(
        context: Context,
        url: String,
        radius: Int,
        imageView: ImageView
    ) {
        load(context, url, imageView, roundedCorners(radius))
    }

    fun roundCorner(
        activity: Activity,
        url: String?,
        radius: Int,
        imageView: ImageView
    ) {
        load(activity, url, imageView, roundedCorners(radius))
    }

    fun roundCorner(
        fragment: Fragment,
        url: String,
        radius: Int,
        imageView: ImageView
    ) {
        load(fragment, url, imageView, roundedCorners(radius))
    }
    /*=================================================分割线================================================*/
    /**
     * 加载指定四个圆角值的图片
     * @param context
     * @param leftTop
     * @param rightTop
     * @param rightBottom
     * @param leftBottom
     * @param imageView
     */
    fun roundCorner(
        context: Context,
        url: String,
        imageView: ImageView,
        leftTop: Int = 0,
        rightTop: Int = 0,
        rightBottom: Int = 0,
        leftBottom: Int = 0

    ) {

        load(
            context,
            url,
            imageView,
            roundedCorners(imageView, leftTop, rightTop, rightBottom, leftBottom)
        )
    }

    fun roundCorner(
        activity: Activity,
        url: String?,
        imageView: ImageView,
        leftTop: Int = 0,
        rightTop: Int = 0,
        rightBottom: Int = 0,
        leftBottom: Int = 0
    ) {
        load(
            activity,
            url,
            imageView,
            roundedCorners(imageView, leftTop, rightTop, rightBottom, leftBottom)
        )
    }

    fun roundCorner(
        fragment: Fragment,
        url: String,
        imageView: ImageView,
        leftTop: Int = 0,
        rightTop: Int = 0,
        rightBottom: Int = 0,
        leftBottom: Int = 0
    ) {
        load(
            fragment,
            url,
            imageView,
            roundedCorners(imageView, leftTop, rightTop, rightBottom, leftBottom)
        )
    }

    companion object {

        val OPTIONS_DEFAULT = RequestOptions().placeholder(R.mipmap.cover_default).error(R.mipmap.cover_default)
        val OPTIONS_CIRCLE = RequestOptions.circleCropTransform()
        val OPTIONS_AVATAR = RequestOptions.circleCropTransform().placeholder(R.mipmap.avatar_default).error(R.mipmap.avatar_default)

        fun getInstance() = ImageLoader.holder

        fun roundedCorners(radius: Int) = RequestOptions.bitmapTransform(RoundedCorners(radius))
        fun roundedCorners(
            imageView: ImageView,
            leftTop: Int,
            rightTop: Int,
            rightBottom: Int,
            leftBottom: Int
        ) = RequestOptions.bitmapTransform(
            RoundCornerTransform(
                imageView.scaleType,
                leftTop,
                rightTop,
                rightBottom,
                leftBottom
            )
        )
    }


}
