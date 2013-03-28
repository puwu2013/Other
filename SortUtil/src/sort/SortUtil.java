package sort;

/**
 * 排序方法实现
 * 
 * @author puwu 2013-3-28 20:35:41
 */
public class SortUtil {
	/**
	 * 冒泡排序:将待排序的元素看作是竖着排列的“气泡”，较小的元素比较轻，从而要往上浮。在冒泡排序算法中我们要对
	 * 这个“气泡”序列处理若干遍。所谓一遍处理，就是自底向上检查一遍这个序列，并时刻注意两个相邻的元素的顺序是否
	 * 正确。如果发现两个相邻元素的顺序不对，即“轻”的元素在下面，就交换它们的位置。显然，处理一遍之后，“最轻”
	 * 的元素就浮到了最高位置；处理二遍之后，“次轻”的元素就浮到了次高位置。在作第二遍处理时，由于最高位置上的元
	 * 素已是“最轻”元素，所以不必检查。一般地，第i遍处理时，不必检查第i高位置以上的元素，因为经过前面i-1遍的 处理，它们已正确地排好序。
	 * 
	 * @param array
	 */
	public void BubbleSort(Integer[] array) {
		int length = array.length;
		int temp;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (array[i] > array[j])// 比较交换相邻元素
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
	 * 选择排序：对待排序的记录序列进行n-1遍的处理，第1遍处理是将L[1..n]中最小者与L[1]交换位置，第2遍处理是将
	 * L[2..n]中最小者与L[2]交换位置，......，第i遍处理是将L[i..n]中最小者与L[i]交换位置。这样，经过i遍处理之后，
	 * 前i个记录的位置就已经按从小到大的顺序排列好了。
	 * 
	 * @param array
	 */
	public void SelectSort(Integer[] array) {
		int length = array.length;
		int minLocation = 0;
		int tempMin;
		for (int i = 0; i < length; i++) {
			tempMin = array[i];
			minLocation = i;
			for (int j = i + 1; j < length; j++) {
				if (tempMin > array[j]) {
					// 每次发现有比临时最小值还小的就把temp重新赋值
					tempMin = array[j];
					// 每次发现有比临时最小值还小的就把minLocation重新赋值
					minLocation = j;
				}
			}
			array[minLocation] = array[i];
			array[i] = tempMin;
		}
		printAfterSorted(array);
	}
	
	public void printAfterSorted(Integer[] array){
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
