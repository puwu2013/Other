import java.util.ArrayList;
import java.util.List;

/**
  * @author qin_kangkang
**/
public class FillNum2 extends Thread{
	
	private static int m;
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		m = 111;
		int a[][] = new int [m][m];
		List<String> nextRightTopList = new ArrayList<String>();
		int centerColumn = m/2;
		String firstTip = "0"+",".concat(String.valueOf(centerColumn));
		String nextTip = "";
		String currentTip = firstTip;
		nextRightTopList.add(firstTip);
		int rightColumn = centerColumn;
		int topRow = 0;
		for (int i = 2; i <= m*m; i++) {
			topRow = topRow - 1;
			if (topRow < 0) {
				topRow = topRow + m;
			}
			nextTip = String.valueOf(topRow).concat(",");
			rightColumn = rightColumn + 1;
			if (rightColumn >= m) {
				rightColumn = m - rightColumn;
			}
			nextTip = nextTip.concat(String.valueOf(rightColumn));
			if (nextRightTopList.contains(nextTip)) {
				String [] array = null;
				array = currentTip.split(",");
				nextTip = String.valueOf(Integer.valueOf(array[0]) + 1) + ",";
				nextTip = nextTip + array[1];
			}
			nextRightTopList.add(nextTip);
			currentTip = nextTip;
			topRow = Integer.valueOf(currentTip.split(",")[0]);
			rightColumn = Integer.valueOf(currentTip.split(",")[1]);
			a[topRow][rightColumn] = i;
			nextTip = "";
		}
//		for (int i = 1; i <= nextRightTopList.size(); i++) {
//			String tip[] = nextRightTopList.get(i-1).split(",");
//			int row = Integer.valueOf(tip[0]);
//			int column = Integer.valueOf(tip[1]);
//			a[row][column] = i;
//		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + "	");
			}
			System.out.println();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
