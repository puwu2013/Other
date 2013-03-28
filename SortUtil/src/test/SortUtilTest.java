package test;

import org.junit.Test;

import sort.SortUtil;

public class SortUtilTest {

	SortUtil sortUtil = new SortUtil();
	Integer[] array = {9,10,15,6,5,3,2,1,4};
	
	@Test
	public void testBubbleSort() {
		sortUtil.BubbleSort(array);
	}

	@Test
	public void testSelectSort() {
		sortUtil.SelectSort(array);
	}
	
}
