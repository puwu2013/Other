package com.puwu.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * when use these two methods copy file,
 * the project encode and the file encode in the same is better
 * CPU:Pentium Dual 3.2Ghz
 * Memory:4G
 * @author qin_kangkang
 */
public class CopyFile {

	public static void main(String[] args) throws IOException {
		String sourceFile = "D:/backup/hotel.sql";
		String targetDir = "E:/backup";
		String fileName1 = "hotel_1.sql";
		String fileName2 = "hotel_2.sql";
		String fileName3 = "hotel_3.sql";
		String fileName4 = "hotel_4.sql";
		String fileName5 = "hotel_5.sql";
		String fileName6 = "hotel_6.sql";

		CopyFile_BufferedIOStream(sourceFile, targetDir,fileName1);

		CopyFile_FileIOS(sourceFile, targetDir, fileName2);
		
		CopyFile_FileChannel(sourceFile, targetDir, fileName3);
		
		CopyFile_FileChannel2(sourceFile, targetDir, fileName4);
		
		CopyFile_FileChannel3(sourceFile, targetDir, fileName5);
		
		CopyFile_BufferedRW(sourceFile, targetDir,fileName6);
	}

	/**
	 * use the BufferedInputStream,BufferedOutputStream copy the sourceFile to the targetFile
	 * use this method,to set the project encode is not necessary and the efficiency is high.
	 * the read file is 161M,this method takes about 450 milliseconds
	 * @param sourceFile
	 * @param targetDir
	 * @param fileName
	 * @throws IOException
	 */
	public static void CopyFile_BufferedIOStream(String sourceFile,
			String targetDir, String fileName) throws IOException {
		// if the targetFile exists,delete the file.
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		long start = System.currentTimeMillis();
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(sourceFile));
			out = new BufferedOutputStream(new FileOutputStream(targetFile));
			byte[] buff = new byte[1024];
			while (in.read(buff) > 0) {
				out.write(buff);
			}
			out.flush();
		} finally {
			if (in != null) {
				in.close();
			}
			if (in != null) {
				out.close();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("BufferedInputStream,BufferedOutputStream : " + (end - start));
	}
	
	/**
	 * use the FileInputStream,FileOutputStream copy the sourceFile to the targetFile
	 * the read file is 161M,this method takes about 1100 milliseconds
	 * @param sourceFile
	 * @param targetDir
	 * @param fileName
	 * @throws IOException
	 */
	public static void CopyFile_FileIOS(String sourceFile, String targetDir,
			String fileName) throws IOException {
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		
		FileInputStream fin = new FileInputStream(sourceFile);
		FileOutputStream fout = new FileOutputStream(targetFile);
		
		long start = System.currentTimeMillis();
		
		byte[] buff = new byte[1024];
		
		while (fin.read(buff) > 0) {
			fout.write(buff);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("FileInputStream,FileOutputStream : " + (end - start));
	}
	
	/**
	 * use the FileInputStream,FileOutputStream,FileChannel copy the sourceFile to the targetFile
	 * the read file is 161M,this method takes about 1320 milliseconds
	 * @param sourceFile
	 * @param targetDir
	 * @param fileName
	 * @throws IOException
	 */
	public static void CopyFile_FileChannel(String sourceFile, String targetDir,
			String fileName) throws IOException {
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		
		FileInputStream fin = new FileInputStream(sourceFile);
		FileOutputStream fout = new FileOutputStream(targetFile);
		FileChannel inChanl = fin.getChannel();
		FileChannel outChanl = fout.getChannel();
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		long start = System.currentTimeMillis();
		
		while (true) {
			byteBuffer.clear();
			int readBytes = inChanl.read(byteBuffer);
			if (readBytes < 0) {
				break;
			}
			byteBuffer.flip();
			outChanl.write(byteBuffer);
		}
		fout.close();
		fin.close();
		long end = System.currentTimeMillis();
		System.out.println("FileInputStream,FileOutputStream,FileChannel,ByteBuffer.allocate(1024) : " + (end - start));
	}
	
	/**
	 * use the FileInputStream,FileOutputStream,FileChannel copy the sourceFile to the targetFile
	 * the read file is 161M,this method takes about 1050 milliseconds
	 * @param sourceFile
	 * @param targetDir
	 * @param fileName
	 * @throws IOException
	 */
	public static void CopyFile_FileChannel2(String sourceFile, String targetDir,
			String fileName) throws IOException {
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		
		FileInputStream fin = new FileInputStream(sourceFile);
		FileOutputStream fout = new FileOutputStream(targetFile);
		FileChannel inChanl = fin.getChannel();
		FileChannel outChanl = fout.getChannel();
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
		
		long start = System.currentTimeMillis();
		
		while (true) {
			byteBuffer.clear();
			int readBytes = inChanl.read(byteBuffer);
			if (readBytes < 0) {
				break;
			}
			byteBuffer.flip();
			outChanl.write(byteBuffer);
		}
		fout.close();
		fin.close();
		long end = System.currentTimeMillis();
		System.out.println("FileInputStream,FileOutputStream,FileChannel,ByteBuffer.allocateDirect(1024) : " + (end - start));
	}
	
	/**
	 * use the FileInputStream,FileOutputStream,FileChannel, copy the sourceFile to the targetFile
	 * the read file is 161M,this method takes about 1050 milliseconds
	 * @param sourceFile
	 * @param targetDir
	 * @param fileName
	 * @throws IOException
	 */
	public static void CopyFile_FileChannel3(String sourceFile, String targetDir,
			String fileName) throws IOException {
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		
		File tempFile = new File(sourceFile);
		
		FileInputStream fin = new FileInputStream(sourceFile);
		FileOutputStream fout = new FileOutputStream(targetFile);
		FileChannel inChanl = fin.getChannel();
		FileChannel outChanl = fout.getChannel();
		
		long start = System.currentTimeMillis();
		
		outChanl.transferFrom(inChanl, 0, tempFile.length());
		
		fout.close();
		fin.close();
		long end = System.currentTimeMillis();
		System.out.println("FileInputStream,FileOutputStream,FileChannel.transferFrom() : " + (end - start));
	}
	
	/**
	 * use the BufferedInputStream,BufferedOutputStream copy the sourceFile to the targetFile
	 * use this method,you must set the project's encode and the efficiency is low.
	 * the read file is 161M,this method takes about 2600 milliseconds
	 * @param sourceFile
	 * @param targetDir
	 * @param fileName
	 * @throws IOException
	 */
	public static void CopyFile_BufferedRW(String sourceFile,
			String targetDir, String fileName)
			throws IOException {
		// if the targetFile exists,delete the file.
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		long start1 = System.currentTimeMillis();
		BufferedReader buffReader = new BufferedReader(new FileReader(
				sourceFile));
		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(
				targetFile));
		String temp = "";
		try {
			boolean flag = true;
			while (flag) {
				temp = buffReader.readLine();
				if (temp == null) {
					break;
				}
				buffWriter.write(temp);
				buffWriter.newLine();
				buffWriter.flush();
			}
		} finally {
			if (buffReader != null) {
				buffReader.close();
			}
			if (buffWriter != null) {
				buffWriter.close();
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println("BufferedReader,BufferedWriter : " + (end1 - start1));
	}
}
