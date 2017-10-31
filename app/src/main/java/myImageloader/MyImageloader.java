package myImageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 加载图片
 */

public class MyImageloader {
    private ImageCache mImageCache = new ImageCache();
    //初始化线程池 为cpu数量
    private ExecutorService mService = Executors.newFixedThreadPool(Runtime.getRuntime()
            .availableProcessors());

    public void displayImage(final String url, final ImageView imageView) {
        Bitmap bitmap = mImageCache.getBitmapFroMemCache(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(url);
        mService.submit(new Runnable() {
            @Override
            public void run() {
                 final Bitmap bitmap1 = loadImage(url);
                if (bitmap1 == null) {
                    Log.e("加载失败！", url);
                    return;
                }
                if (imageView.getTag().equals(url)) {
                   imageView.post(new Runnable() {
                       @Override
                       public void run() {
                           imageView.setImageBitmap(bitmap1);
                       }
                   });
                }
                mImageCache.putBitmapToMemCache(url, bitmap1);
            }
        });
    }

    private Bitmap loadImage(String url) {
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        try {
            URL u = new URL(url);
            conn = (HttpURLConnection) u.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (Exception e) {
            Log.e("loadImage-Exception", e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        return bitmap;
    }
}
