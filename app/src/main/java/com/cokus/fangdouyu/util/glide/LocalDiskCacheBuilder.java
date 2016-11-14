package com.cokus.fangdouyu.util.glide;

import android.content.Context;
import android.os.Environment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;
import com.cokus.fangdouyu.global.Constants;

import java.io.File;


public class LocalDiskCacheBuilder implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        File file = new File(Environment.getExternalStorageDirectory()
                .getAbsoluteFile()
                + File.separator
                + Constants.CACHE_DIR_UIMAGE);
        if (!file.exists()) {
            file.mkdirs();
        }
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
        builder.setMemoryCache(new LruResourceCache(defaultMemoryCacheSize / 3));
        builder.setDiskCache(new DiskLruCacheFactory(file.getAbsolutePath(),
                1000 * 1024 * 1024));
        builder.setDecodeFormat(DecodeFormat.DEFAULT);
//        builder.setDiskCacheService(ThreadManager.getDownloadPool().getPool());
        builder.setBitmapPool(new LruBitmapPool(defaultBitmapPoolSize / 3));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
//        glide.register(GlideUrl.class, InputStream.class,
//                new OkHttpUrlLoader.Factory(new OkHttpClient()));
    }

}
