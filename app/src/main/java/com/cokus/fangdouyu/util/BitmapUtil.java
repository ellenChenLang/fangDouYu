package com.cokus.fangdouyu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/**
 * @author coku
 */
public class BitmapUtil {
	/**
	*
	* @param path
	* @return
	*/
	public static Bitmap getBitmapFromSDCard(String path) {
		FileInputStream fis  =null;
		try {
			fis =  new FileInputStream(path);
			if(fis!=null){
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 2;
				return BitmapFactory.decodeStream(fis, null, options);
				}
		} catch (Exception e) {
			
		}
		return null;
	}


		public static Bitmap temp;
		public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
			int w = bitmap.getWidth();
			int h = bitmap.getHeight();
			Matrix matrix = new Matrix();
			float scaleWidth = ((float) width / w);
			float scaleHeight = ((float) height / h);
			matrix.postScale(scaleWidth, scaleHeight);


			Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
			return newbmp;
		}

	public static void saveBitmapToSDCard(Bitmap bitmap,String path)  {
		File file=new File(path);
		if (file.exists()){
			file.delete();
		}
		FileOutputStream outputStream=null;
		try{
			outputStream=new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
			outputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	System.out.println("----------save success-------------------");
	}
	/**
	 * 按照高度的百分比压缩
	 * @param srcBitmap
	 * @param newHeight
	 * @return
	 */
	public static Bitmap bitmapZoomByHeight(Bitmap srcBitmap,float newHeight)
	{
		int srcWidth = srcBitmap.getWidth();
		int srcHeight = srcBitmap.getHeight();

		float scaleHeight = ((float) newHeight) / srcHeight;
		float scaleWidth = scaleHeight;

		return bitmapZoomByScale(srcBitmap, scaleWidth, scaleHeight);

	}
	/**
	 * 按照高度的百分比压缩
	 * @param drawable
	 * @param newHeight
	 * @return
	 */
	public static Bitmap bitmapZoomByHeight(Drawable drawable,float newHeight)
	{
		Bitmap srcBitmap=drawableToBitmap(drawable);
		int srcWidth = srcBitmap.getWidth();
		int srcHeight = srcBitmap.getHeight();

		float scaleHeight = ((float) newHeight) / srcHeight;
		float scaleWidth = scaleHeight;

		return bitmapZoomByScale(srcBitmap, scaleWidth, scaleHeight);

	}
	/**
	 * 使用长宽缩放比缩放
	 * @param srcBitmap
	 * @param scaleWidth
	 * @param scaleHeight
	 * @return
	 */
	public static Bitmap bitmapZoomByScale(Bitmap srcBitmap,float scaleWidth,float scaleHeight)
	{
		int srcWidth = srcBitmap.getWidth();
		int srcHeight = srcBitmap.getHeight();
		Matrix matrix = new Matrix();

		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizedBitmap = Bitmap.createBitmap(srcBitmap, 0, 0, srcWidth,
				srcHeight, matrix, true);
		if(resizedBitmap != null)
		{
			srcBitmap=null;
			return resizedBitmap;
		}
		else
		{
			return srcBitmap;
		}
	}
	/**
	 * Drawable转化为Bitmap
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		return bitmap;

	}

}
