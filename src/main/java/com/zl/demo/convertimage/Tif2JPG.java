package com.zl.demo.convertimage;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;

public class Tif2JPG {

	public void tif2Jpg(String fileAbsolutePath) {
        if (fileAbsolutePath == null || "".equals(fileAbsolutePath.trim())){
            return ;    
        }
        if (!new File(fileAbsolutePath).exists()){
            //logger.info("系统找不到指定文件【"+fileAbsolutePath+"】");
            return ;
        }
        FileSeekableStream fileSeekStream = null;
        try {
            fileSeekStream = new FileSeekableStream(fileAbsolutePath);
            TIFFEncodeParam tiffEncodeParam = new TIFFEncodeParam();
            JPEGEncodeParam jpegEncodeParam = new JPEGEncodeParam();
            ImageDecoder dec = ImageCodec.createImageDecoder("tiff", fileSeekStream, null);
            int count = dec.getNumPages();
            tiffEncodeParam.setCompression(TIFFEncodeParam.COMPRESSION_GROUP4);
            tiffEncodeParam.setLittleEndian(false);
            System.out.println("该tif文件共有【" + count + "】页");
            String filePathPrefix = fileAbsolutePath.substring(0, fileAbsolutePath.lastIndexOf("."));
            for (int i = 0; i < count; i++) {
                RenderedImage renderedImage = dec.decodeAsRenderedImage(i);
                File imgFile = new File(filePathPrefix + "_" + i + ".jpg");
                //logger.info("每页分别保存至： " + imgFile.getCanonicalPath());
                ParameterBlock pb = new ParameterBlock();
                pb.addSource(renderedImage);
                pb.add(imgFile.toString());
                pb.add("JPEG");
                pb.add(jpegEncodeParam);
                RenderedOp renderedOp = JAI.create("filestore",pb);
                renderedOp.dispose();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fileSeekStream != null){
                try {
                    fileSeekStream.close();
                } catch (IOException e) {
                }
                fileSeekStream = null;
            }
        }
    }
    
    public void jpg2Tif(String fileAbsolutePath) {
        OutputStream outputStream = null;
        try {
            RenderedOp renderOp = JAI.create("fileload", fileAbsolutePath);
            String tifFilePath = fileAbsolutePath.substring(0, fileAbsolutePath.lastIndexOf("."))+".tif";
            outputStream = new FileOutputStream(tifFilePath);
            TIFFEncodeParam tiffParam = new TIFFEncodeParam();
            ImageEncoder imageEncoder = ImageCodec.createImageEncoder("TIFF", outputStream, tiffParam);
            imageEncoder.encode(renderOp);
            //logger.info("jpg2Tif 保存至： " + tifFilePath);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
                outputStream = null;
            }
        }
    }
    
    /**
	 *  tiff 图片 转  JPG 图片
	 * @param filePath   tiff文件路径
	 */
	public static void tiffTurnJpg(String filePath, String des){
		 RenderedOp file = JAI.create("fileload", filePath);//读取tiff图片文件
		     OutputStream ops = null;
			try {
				ops = new FileOutputStream(des);
				//文件存储输出流
			     JPEGEncodeParam param = new JPEGEncodeParam();
			     ImageEncoder image = ImageCodec.createImageEncoder("JPEG", ops, param); //指定输出格式
			     //解析输出流进行输出
			     image.encode(file);
			     //关闭流
			     ops.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		     System.out.println("tiff转换jpg成功");
		}

    public static void main(String args[]) throws Exception{
    	Tif2JPG imageConvert = new Tif2JPG();
        /* tif 转 jpg 格式*/
        //imageConvert.tif2Jpg("/home/zl/Documents/Share/qm.tif");
    	imageConvert.tiffTurnJpg("/home/zl/Documents/Share/北宋 张择端《清明上河图》.tif", "/home/zl/Documents/Share/qm.jpg");
        /* jpg 转 tif 格式*/
    	//imageConvert.jpg2Tif("/home/zl/Documents/Share/123.jpg");
        //Tif2JPG.tiffTurnJpg("/home/zl/Documents/Share/qm.tif", "/home/zl/Documents/Share/qm.jpg");
    }

}
