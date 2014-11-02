package test;

import java.util.TreeMap;

/*
 The median of a set of numbers is the number in the middle when the items are arranged in sorted order, when the number of items is odd, or the average of the two numbers in the middle, when the number of items is even; for instance, the median of {3 7 4 1 2 6 5} is 4 and the median of {4 2 1 3} is 2.5. The normal algorithm for computing the median considers the entire set of numbers at once; the streaming median algorithm recalculates the median of each successive prefix of the set of numbers, and can be applied to a prefix of an infinite sequence. For instance, the streaming medians of the original sequence of numbers are 3, 5, 4, 3.5, 3, 3.5, and 4.

 The streaming median is computed using two heaps. All the numbers less than or equal to the current median are in the left heap, which is arranged so that the maximum number is at the root of the heap. All the numbers greater than or equal to the current median are in the right heap, which is arranged so that the minimum number is at the root of the heap. Note that numbers equal to the current median can be in either heap. The count of numbers in the two heaps never differs by more than 1.

 When the process begins the two heaps are initially empty. The first number in the input sequence is added to one of the heaps, it doesn’t matter which, and returned as the first streaming median. The second number in the input sequence is then added to the other heap, if the root of the right heap is less than the root of the left heap the two heaps are swapped, and the average of the two numbers is returned as the second streaming median.

 Then the main algorithm begins. Each subsequent number in the input sequence is compared to the current median, and added to the left heap if it is less than the current median or to the right heap if it is greater than the current median; if the input number is equal to the current median, it is added to whichever heap has the smaller count, or to either heap arbitrarily if they have the same count. If that causes the counts of the two heaps to differ by more than 1, the root of the larger heap is removed and inserted in the smaller heap. Then the current median is computed as the root of the larger heap, if they differ in count, or the average of the roots of the two heaps, if they are the same size.
 */
public class StreamingMedian {

	private static TreeMap<Integer, Integer> leftHeap = new TreeMap<Integer, Integer>();
	private static TreeMap<Integer, Integer> rightHeap = new TreeMap<Integer, Integer>();
	private static TreeMap<Integer, Integer> swapHeap = new TreeMap<Integer, Integer>();
	private static Integer index = 0;
	private static Integer median = 0;

	public static Integer getMedian(Character s) {
		int value = Integer.parseInt(String.valueOf(s));
		int leftSize = leftHeap.size();
		int rightSize = rightHeap.size();
		/* handle first element */
		if (index == 0) {
			leftHeap.put(value, 0);
			index++;
			median = Integer.parseInt(String.valueOf(s));
			return median;
		}
		/* handle second element */
		if (index == 1) {
			rightHeap.put(value, 0);
			index++;
			if (rightHeap.firstKey() < leftHeap.lastKey()) {
				swapHeap = rightHeap;
				rightHeap = leftHeap;
				leftHeap = swapHeap;
			}
			median = Integer
					.valueOf((leftHeap.lastKey() + rightHeap.firstKey()) / 2);
			return median;
		}
		/* handle subsequent elements */
		if (value < median) {/* if value < median put it in leftHeap */
			leftHeap.put(value, 0);
			index++;
		} else if (value > median) {/* if value > median put it in rightHeap */
			rightHeap.put(value, 0);
			index++;
		} else {/* if value = median put it in smaller heap */
			if (leftSize < rightSize) {
				leftHeap.put(value, 0);
				index++;
			} else if (rightSize < leftSize) {
				rightHeap.put(value, 0);
				index++;
			} else {/* else put it arbitrarily */
				leftHeap.put(value, 0);
				index++;
			}
		}
		/* Recalculate Sizes */
		leftSize = leftHeap.size();
		rightSize = rightHeap.size();
		/*
		 * If count differ by more than 1 remove root of rightHeap and insert
		 * into leftHeap
		 */
		if (Math.abs(rightSize - leftSize) > 1) {
			if (leftSize < rightSize) {
				leftHeap.put(rightHeap.firstKey(), 0);
				rightHeap.remove(rightHeap.firstKey());
			} else {
				rightHeap.put(leftHeap.lastKey(), 0);
				leftHeap.remove(leftHeap.lastKey());
			}
			/* Recalculate Sizes */
			leftSize = leftHeap.size();
			rightSize = rightHeap.size();
		}

		/* If counts differ the median is the root of large heap */
		if (Math.abs(rightSize - leftSize) > 0) {
			if (leftSize < rightSize) {
				median = rightHeap.firstKey();
				return median;
			} else {
				median = leftHeap.lastKey();
				return median;
			}
		} else {/* else the median is the average of both roots */
			median = Integer
					.valueOf((leftHeap.lastKey() + rightHeap.firstKey()) / 2);
			return median;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stream = "274915836274915836";
		for (int i = 0; i < stream.length(); i++) {
			System.out.println(stream.charAt(i) + " | "
					+ getMedian(stream.charAt(i)));
		}
	}

}
