package com.puwu.java;

/**
  * @author wang_zexin
��������
**/
public class FillNum1 extends Thread{
	private static int n = 111;
	private static int a[][] = new int[n][n];
	private static int count = 0;
	private static int cc=n*n;

	public void run() {
		super.run();
	}

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("aaaaaaS");
		Thread.sleep(10000);
		System.out.println("bbbbbb");
		Long start = System.currentTimeMillis();
		if (n % 2 == 1) {
			dan();
		}
		pirnt(a);
		Long end = System.currentTimeMillis();
		System.out.print(end - start);
	}

	public static void dan() {

		for (int i = 0; i < cc; i++) {
			if (i != 0 && i % n == 0) {
				count++;
			}
			if (a[(0 - i + cc + count * 2) % n][((n - 1) / 2 + i - count)
					% n] == 0) {
				a[(0 - i + cc + count * 2) % n][((n - 1) / 2 + i - count)
						% n] = i + 1;
			} else {
				a[(0 - i + cc + count * 2) % n][((n - 1) / 2 + i - count)
						% n] = i + 1;
			}
		}
	}

	public static void pirnt(int a[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + "	");
			}
			System.out.println();
		}
	}
}
