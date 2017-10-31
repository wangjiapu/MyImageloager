package myImageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 处理图片缓存逻辑
 */

public class ImageCache {
    //默认使用内存的1/8为内存缓存空间
    private static final int cache=(int) (Runtime.getRuntime().maxMemory()/1024)/8;

    private LruCache <String,Bitmap> mImagecache;

    public ImageCache(){
        initImageCache();
    }

    private void initImageCache() {
        mImagecache=new LruCache<String,Bitmap>(cache){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }
    public void putBitmapToMemCache(String key,Bitmap bitmap){
        if (getBitmapFroMemCache(key)==null){
            mImagecache.put(key,bitmap);
        }

    }
    public Bitmap getBitmapFroMemCache(String key){
        return  mImagecache.get(key);
    }
}
