package com.puwu.java;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuessNum {
	private static String answer;
	private static int countA = 0;
	private static int countB = 0;
	private static int countGuess = 0;
	private static String input = "";
	private static String output = "";
	private static byte[] buff = new byte[20];
	private static OutputStream out = null;
	
	public static void main(String[] args) throws IOException {
		String targetDir = "E:/";
		String fileName = "answer.txt";
		String rankFile = "rank.txt";
		System.out.println("/**  0：查看游戏规则	1：开始游戏	2：结束游戏  **/");
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		int order = 0;
		boolean flag = true;
		while(flag){
			String temp = buffReader.readLine();
			order = Integer.valueOf((temp == null || "".equals(temp)) ? "2" : temp);
			switch (order) {
			case 0:
				Runtime.getRuntime().exec("notepad.exe " + targetDir + File.separator + "rules.txt");
				break;
			case 1:
				File targetFile = makeFilePath(targetDir,fileName);
				out = new BufferedOutputStream(new FileOutputStream(targetFile));
				answer = getAnswer();
				try {
					buff = answer.getBytes();
					out.write(buff);
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				startGuess(buffReader,targetDir, rankFile);
				break;
			case 2:
				flag = false;
				break;
			default :
				flag = false;
				break;
			}
		}
	}
	
	public static void startGuess(BufferedReader buffReader,String targetDir,String rankFile){
		System.out.println("请输入猜测的数字(按回车结束输入)：");
		long start = System.currentTimeMillis();
		long end = 0l;
		while (true) {
			try {
				input = buffReader.readLine();
				if (null == input || "".equals(input)) {
					System.out.println("输入不能为空，请重新输入(按回车结束输入)：");
					continue;
				} else if (!checkNum(input)) {
					System.out.println("输入的数字格式不对，请重新输入(按回车结束输入)：");
					continue;
				} else if (input.length() != 4) {
					System.out.println("输入数字的个数不对，请重新输入(按回车结束输入)：");
					continue;
				}
				char[] cc = input.toCharArray();
				char[] an = answer.substring(answer.length()-4).toCharArray();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (cc[i] == an[j]) {
							if (i == j) {
								countA++;
							} else {
								countB++;
							}
						}
					}
				}
				countGuess = countGuess + 1;
				if (countA == 4) {
					countA = 0;
					countB = 0;
					end = System.currentTimeMillis();
					DecimalFormat decimalFormat = new DecimalFormat("#.#");
					double takeTime = ((end - start)*1.0) / 1000;
					String takeTimeString = decimalFormat.format(takeTime);
					output = "\n" + "此次猜数花费" + countGuess + "次，" + "耗时 " + takeTimeString + "秒。";
					buff = output.getBytes();
					out.write(buff);
					out.flush();
					out.close();
					makeRandFile(targetDir,rankFile,String.valueOf(countGuess),takeTimeString);
					System.out.println("恭喜你，猜对了，" + answer);
					countGuess = 0;
					break;
				}
				output = "\n" + "第" + countGuess + "次猜数：" + input + "    " + countA + "A" + countB + "B";
				buff = output.getBytes();
				out.write(buff);
				out.flush();
				System.out.println(countA + "A" + countB + "B");
				countA = 0;
				countB = 0;
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

	public static boolean checkNum(String strValue) {
		String regEx = "^[0-9]+$";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(strValue);
		boolean rs = mat.find();
		return rs;
	}
	
	public static String getAnswer(){
		String answer = "";
		Random random = new Random();
		ArrayList<String> list = new ArrayList<String>();
		int nextRandom;
		String nextRandomStr = "";
		while (true) {
			if (answer.length() == 4) {
				break;
			}
			nextRandom = random.nextInt(10);
			nextRandomStr = String.valueOf(nextRandom);
			if (list.contains(nextRandomStr)) {
				continue;
			}
			list.add(nextRandomStr);
			answer = answer + nextRandomStr;
		}
		answer = "正确答案为:" + answer;
		return answer;
	}
	
	public static File makeFilePath(String targetDir,String fileName){
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		return targetFile;
	}
	
	public static File makeRandFile(String targetDir, String fileName,
			String count, String takeTime) throws IOException {
		File filePath = new File(targetDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File targetFile = new File(filePath + File.separator + fileName);
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(targetFile,"rw");
			raf.seek(raf.length());
			String temp = "\n" + count + "\t" + takeTime;
			raf.write(temp.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return targetFile;
	}
}