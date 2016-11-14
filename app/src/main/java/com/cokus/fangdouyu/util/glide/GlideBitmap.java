package com.cokus.fangdouyu.util.glide;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.util.BitmapUtil;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author coku
 */
public class GlideBitmap {

    private static ConcurrentHashMap<String, SoftReference<GlideBitmap>> withs;
    private static ConcurrentHashMap<String, SoftReference> contexts;
    private  static final int DEFAULT_IMAGE_UNLOAD = R.drawable.image_loading_5_3;
    private  static final int DEFAULT_IMAGE_ERROR = R.color.colorwhite;

    private RequestManager with;
    private Context context;

    static {
        contexts = new ConcurrentHashMap<>();
        withs = new ConcurrentHashMap<>();
    }

    private GlideBitmap(Context context) {
        if (context != null)
            Glide.get(context).clearMemory();
        with = Glide.with(context);
        contexts.put(context.getClass().getName(), new SoftReference(context));
        this.context =context;
    }


    private GlideBitmap(Application context) {
        if (context != null)
            Glide.get(context).clearMemory();
        with = Glide.with(context);
        contexts.put(context.getClass().getName(), new SoftReference(context));
        this.context =context;
    }

    private GlideBitmap(Fragment context) {
        if (context.getActivity() != null)
            Glide.get(context.getActivity()).clearMemory();
        with = Glide.with(context);
        contexts.put(context.getClass().getName(), new SoftReference(context));
        this.context =context.getActivity();
    }

    public GlideBitmap(Activity context) {
        if (context != null)
            Glide.get(context).clearMemory();
        with = Glide.with(context);
        contexts.put(context.getClass().getName(), new SoftReference(context));
        this.context =context;
    }

    public void clearMemory(){
        Glide.get(context).clearMemory();
    }

    public void clearDiskCache(){
        Glide.get(context).clearDiskCache();
    }


    /**
     *
     * @param ctx
     * @return
     */
    public static synchronized GlideBitmap create(Context ctx) {
        Map<String, SoftReference> tempContexts;
        if (contexts != null && !contexts.isEmpty()) {
            tempContexts = new ConcurrentHashMap<>(contexts);
            if (contexts.containsKey(ctx.getClass().getName())) {
                contexts.remove(ctx.getClass().getName());
                withs.remove(ctx.getClass().getName());
            }
            for (Map.Entry<String, SoftReference> entry : tempContexts.entrySet()) {
                if (entry.getValue().get() == null) {
                    contexts.remove(entry.getKey());
                    withs.remove(entry.getKey());
                }
            }
            tempContexts.clear();
        }
        GlideBitmap mFinalBitmap;
        if (ctx == null)
            return null;
        if (withs.containsKey(ctx.getClass().getName())) {
            mFinalBitmap = withs.get(ctx.getClass().getName()).get();
        } else {
            mFinalBitmap = new GlideBitmap(ctx);
            withs.put(ctx.getClass().getName(), new SoftReference<GlideBitmap>(mFinalBitmap));
        }

        return mFinalBitmap;
    }

    public static synchronized GlideBitmap create(Activity ctx) {
        Map<String, SoftReference> tempContexts;
        if (contexts != null && !contexts.isEmpty()) {
            if (contexts.containsKey(ctx.getClass().getName())) {
                contexts.remove(ctx.getClass().getName());
                withs.remove(ctx.getClass().getName());
            }
            tempContexts = new ConcurrentHashMap<>(contexts);
            for (Map.Entry<String, SoftReference> entry : tempContexts.entrySet()) {
                if (entry.getValue().get() == null) {
                    contexts.remove(entry.getKey());
                    withs.remove(entry.getKey());
                }
            }
            tempContexts.clear();
        }
        GlideBitmap mFinalBitmap = null;
        if (withs.containsKey(ctx.getClass().getName())) {
            mFinalBitmap = withs.get(ctx.getClass().getName()).get();
        } else {
            mFinalBitmap = new GlideBitmap(ctx);
            withs.put(ctx.getClass().getName(), new SoftReference<GlideBitmap>(mFinalBitmap));
        }
        return mFinalBitmap;
    }

    public static synchronized GlideBitmap create(Fragment ctx) {
        Map<String, SoftReference> tempContexts;
        if (contexts != null && !contexts.isEmpty()) {
            if (contexts.containsKey(ctx.getClass().getName())) {
                contexts.remove(ctx.getClass().getName());
                withs.remove(ctx.getClass().getName());
            }
            tempContexts = new ConcurrentHashMap<>(contexts);
            for (Map.Entry<String, SoftReference> entry : tempContexts.entrySet()) {
                if (entry.getValue().get() == null) {
                    contexts.remove(entry.getKey());
                    withs.remove(entry.getKey());
                }
            }
            tempContexts.clear();
        }
        GlideBitmap mFinalBitmap = null;
        if (withs.containsKey(ctx.getClass().getName())) {
            mFinalBitmap = withs.get(ctx.getClass().getName()).get();
        } else {
            mFinalBitmap = new GlideBitmap(ctx);
            withs.put(ctx.getClass().getName(), new SoftReference<GlideBitmap>(mFinalBitmap));
        }
        return mFinalBitmap;
    }

    public static synchronized GlideBitmap create(Application ctx) {
        Map<String, SoftReference> tempContexts;
        if (contexts != null && !contexts.isEmpty()) {
            if (contexts.containsKey(ctx.getClass().getName())) {
                contexts.remove(ctx.getClass().getName());
                withs.remove(ctx.getClass().getName());
            }
            tempContexts = new ConcurrentHashMap<>(contexts);
            for (Map.Entry<String, SoftReference> entry : tempContexts.entrySet()) {
                if (entry.getValue().get() == null) {
                    contexts.remove(entry.getKey());
                    withs.remove(entry.getKey());
                }
            }
            tempContexts.clear();
        }
        GlideBitmap mFinalBitmap = null;
        if (withs.containsKey(ctx.getClass().getName())) {
            mFinalBitmap = withs.get(ctx.getClass().getName()).get();
        } else {
            mFinalBitmap = new GlideBitmap(ctx);
            withs.put(ctx.getClass().getName(), new SoftReference<GlideBitmap>(mFinalBitmap));
        }
        return mFinalBitmap;
    }

    /**
     *
     * @param imageView
     * @param uri
     * @return 此函数可以自定设置你需要glide的配置
     */
    public RequestManager display(ImageView imageView, String uri) {
        try {
            if (imageView != null) {
                with.load(uri)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .placeholder(DEFAULT_IMAGE_UNLOAD)
                        .error(DEFAULT_IMAGE_ERROR)
                        .crossFade()
                        .into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return with;
    }
    public RequestManager display(ImageView imageView, int uri) {
        try {
            if (imageView != null) {
                with.load(uri).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  with;
    }

    public static void display(RequestManager with, ImageView imageView, String uri) {
        with.load(uri).diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(DEFAULT_IMAGE_UNLOAD)
                .error(DEFAULT_IMAGE_ERROR)
                .into(imageView);
    }


    /**
     * @param imageView
     * @param uri
     */
    public void displayNoCache(ImageView imageView, String uri) {
        try {
            if (imageView != null) {
                with.load(uri).diskCacheStrategy(DiskCacheStrategy.NONE)
                        .placeholder(DEFAULT_IMAGE_UNLOAD)
                        .error(DEFAULT_IMAGE_ERROR)
                        .crossFade().into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载圆形图片
     * @param imageView
     * @param uri
     */
    public void displayCircle(ImageView imageView, String uri) {
        try {
            if (imageView != null) {
                with.load(uri).diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.usercenter_default_avatar)
                        .error(R.drawable.usercenter_default_avatar)
                        .transform(new GlideCircleTransform(context))
                        .dontAnimate().into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载圆角矩形图片
     * @param imageView
     * @param uri
     */
    public void displayRound(ImageView imageView, String uri) {
        try {
            if (imageView != null) {
                with.load(uri).diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(DEFAULT_IMAGE_UNLOAD)
                        .error(DEFAULT_IMAGE_UNLOAD)
                        .transform(new GlideRoundTransform(context))
                        .dontAnimate().into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载圆角矩形图片
     * @param imageView
     * @param uri
     * @param radius 圆角半径
     */
    public void displayRound(ImageView imageView, String uri,int radius) {
        try {
            if (imageView != null) {
                with.load(uri).diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(DEFAULT_IMAGE_UNLOAD)
                        .error(DEFAULT_IMAGE_ERROR)
                        .transform(new GlideRoundTransform(context,radius))
                        .dontAnimate().into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display(ImageView imageView, String uri, boolean hasReplaceError) {
        try {
            if (imageView != null) {
                with.load(uri).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 广告界面获取到bitmap按高比例缩放，然后剪裁显示中间
     *
     * @param imageView
     * @param url
     * @param height
     */
    public void displayAdImage(final ImageView imageView, String url, final float height) {
        try {
            if (imageView != null) {
                with.load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).format(DecodeFormat.PREFER_ARGB_8888)
                        .placeholder(Color.TRANSPARENT)
                        .error(Color.TRANSPARENT)
                        .dontAnimate()
                        .into(new BitmapImageViewTarget(imageView) {
                            @Override
                            protected void setResource(Bitmap resource) {
                                imageView.setScaleType(ImageView.ScaleType.CENTER);
                                imageView.setImageBitmap(BitmapUtil.bitmapZoomByHeight(resource, height));
                    }
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public File downloadImageviewFile(String url)  {
        File file = null;
        try {
          file = with.load(url)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        }catch (Exception e){
        }
        return file;
    }
}
