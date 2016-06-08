package com.puwu.java.SortUtil;

/**
 * ���򷽷�ʵ��
 * 
 * @author puwu 2013-3-28 20:35:41
 */
public class SortUtil {
	/**
	 * ð������:���������Ԫ�ؿ������������еġ����ݡ�����С��Ԫ�رȽ��ᣬ�Ӷ�Ҫ���ϸ�����ð�������㷨������Ҫ��
	 * ��������ݡ����д������ɱ顣��νһ�鴦�������Ե����ϼ��һ��������У���ʱ��ע���������ڵ�Ԫ�ص�˳���Ƿ�
	 * ��ȷ�����������������Ԫ�ص�˳�򲻶ԣ������ᡱ��Ԫ�������棬�ͽ������ǵ�λ�á���Ȼ������һ��֮�󣬡����ᡱ
	 * ��Ԫ�ؾ͸��������λ�ã��������֮�󣬡����ᡱ��Ԫ�ؾ͸����˴θ�λ�á������ڶ��鴦��ʱ���������λ���ϵ�Ԫ
	 * �����ǡ����ᡱԪ�أ����Բ��ؼ�顣һ��أ���i�鴦��ʱ�����ؼ���i��λ�����ϵ�Ԫ�أ���Ϊ����ǰ��i-1��� ������������ȷ���ź���
	 * 
	 * @param array
	 */
	public void bubbleSort(Integer[] array) {
		int length = array.length;
		int temp;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (array[i] > array[j])// �ȽϽ�������Ԫ��
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		printAfterSorted(array);
	}

	/**
	 * ѡ�����򣺶Դ�����ļ�¼���н���n-1��Ĵ�����1�鴦���ǽ�L[1..n]����С����L[1]����λ�ã���2�鴦���ǽ�
	 * L[2..n]����С����L[2]����λ�ã�......����i�鴦���ǽ�L[i..n]����С����L[i]����λ�á�����������i�鴦��֮��
	 * ǰi����¼��λ�þ��Ѿ�����С�����˳�����к��ˡ�
	 * 
	 * @param array
	 */
	public void selectSort(Integer[] array) {
		int length = array.length;
		int minLocation = 0;
		int tempMin;
		for (int i = 0; i < length; i++) {
			tempMin = array[i];
			minLocation = i;
			for (int j = i + 1; j < length; j++) {
				if (tempMin > array[j]) {
					// ÿ�η����б���ʱ��Сֵ��С�ľͰ�temp���¸�ֵ
					tempMin = array[j];
					// ÿ�η����б���ʱ��Сֵ��С�ľͰ�minLocation���¸�ֵ
					minLocation = j;
				}
			}
			array[minLocation] = array[i];
			array[i] = tempMin;
		}
		int a = 5;
		int b = a++ + 6;
		System.out.println(a+" " + b);
		int c = a++ + 6;
		System.out.println(a+" " + b + " " + c);
		printAfterSorted(array);
	}
	
	public void stringSort(String str){
		for(int i=0;i<str.length();i++){
			String maxStr = String.valueOf(str.charAt(i));
			int index = i;
			for(int j=i+1;j<str.length();j++){
				String temp = String.valueOf(str.charAt(j));
				if(maxStr.compareTo(temp) < 0){
					maxStr = temp;
					index = j;
				}
			}
		}
	}
	
	public void printAfterSorted(Integer[] array){
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
