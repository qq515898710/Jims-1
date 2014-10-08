package org.mo.open.common.barcode;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

/**
 * 本代码由http://www.sharejs.com/codes/java/1327提供 <br>
 * 支持EAN13, EAN8, UPCA, UPCE, Code 3 of 9, Codabar, Code 11, Code 93, Code 128,
 * MSI/Plessey, Interleaved 2 of PostNet等 <br>
 * 利用jbarcode生成各种条形码！测试成功！分享给大家！
 * 
 * @author moziqi
 *
 */
public class BarcodeUtil {
	public static void main(String[] paramArrayOfString) {
		try {
			JBarcode localJBarcode = new JBarcode(EAN8Encoder.getInstance(),
					WidthCodedPainter.getInstance(),
					EAN8TextPainter.getInstance());
			String str = "4554754";
			BufferedImage localBufferedImage = localJBarcode.createBarcode(str);
			// TODO
			// saveToGIF(localBufferedImage, "EAN8.jpg");
			saveToJPEG(localBufferedImage, "moziq2i.jpeg");
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	static void saveToJPEG(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "jpeg");
	}

	static void saveToFile(BufferedImage paramBufferedImage,
			String paramString1, String paramString2) {
		try {
			FileOutputStream localFileOutputStream = new FileOutputStream(
					"F:/file/" + paramString1);
			ImageUtil.encodeAndWrite(paramBufferedImage, paramString2,
					localFileOutputStream, 96, 96);
			localFileOutputStream.close();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}
}
