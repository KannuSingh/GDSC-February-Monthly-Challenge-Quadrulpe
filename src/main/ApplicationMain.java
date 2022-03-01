package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationMain {

	public static void main(String[] args) {

		int[] nums = { -1, 0, -5, -2, -2, -4, 0, 1, -2 };

		System.out.println(findQuadruple(nums, -9));

	}

	public static List<List<Integer>> findQuadruple(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0)
			return result;

		int size = nums.length;
		
		//Sort the array
		Arrays.sort(nums);
		
		
		for (int i = 0; i <= size - 1; i++) {
			for (int j = i + 1; j <= size - 1; j++) {
				int left = j + 1;
				int right = size - 1;
				int diff = target - (nums[i] + nums[j]);
				while (left < right) {

					if (nums[left] + nums[right] < diff)
						left++;

					else if ((nums[left] + nums[right] > diff))
						right--;

					else {
						List<Integer> quadruple = new ArrayList<Integer>();
						quadruple.add(nums[i]);
						quadruple.add(nums[j]);
						quadruple.add(nums[left]);
						quadruple.add(nums[right]);
						result.add(quadruple);
						
						//handling duplicates
						while (left < right && nums[left] == quadruple.get(2))
							++left;
						
						//handling duplicates
						while (left < right && nums[right] == quadruple.get(3))
							--right;
					}
					
					//handling duplicates
					while (j + 1 < size - 1 && nums[j + 1] == nums[j])
						++j;
				}
				
				//handling duplicates
				while (i + 1 < size - 1 && nums[i + 1] == nums[i])
					++i;
			}

		}

		return result;
	}
}
