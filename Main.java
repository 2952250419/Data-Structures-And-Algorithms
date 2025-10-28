package 前缀和;

public class Main {
	public static void main(String []args) {
		Solution solution = new Solution();
		int [] nums = new int [] {1, 7, 3, 6, 5, 6} ;
		int res = solution.pivotIndex(nums);
		System.out.println(res);
		
		Solution2 s2 = new Solution2();
		int [] n2 = new int [] {1,1,1};
		int r2 = s2.subarraySum(n2,2);
		System.out.println(r2);
		
		Solution3 s3 = new Solution3();
		int [] n3 = new int [] {1,1,1};
		int r3 = s2.subarraySum(n3,2);
		System.out.println(r3);
	}
}
/*
 * leetcode 724. 寻找数组的中心索引
 * 
	给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
	我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
	如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
	
	输入：
	nums = [1, 7, 3, 6, 5, 6]
	输出：3

 */
class Solution {
    public int pivotIndex(int[] nums) {
    	int nums_sum = 0;
    	int res = -1;
    	for(int i : nums) {
    		nums_sum += i;
    	}
    	
    	for(int leftsum = 0,i = 0;i<nums.length;i++) {
    		if(leftsum == nums_sum - leftsum - nums[i]) {
    			res  = i;
    		}
    		leftsum += nums[i];
		}
    	return res;
    }
}
/*
 * 	leetcode 560. 和为K的子数组
	题目描述
	
	给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
	
	示例 1 :
	
	输入:nums = [1,1,1], k = 2
	输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

 */
class Solution2 {
    public int subarraySum(int[] nums, int k) {
    	int res = 0;
    	for(int l = 0;l<nums.length;l++) {
    		int sum  = 0;
    		for(int r = l ;r<nums.length;r++) {
    			sum += nums[r];
    			if(sum == k) res++;
    		}	
    	}
    	return res;
    }
}
//前缀表算法
class Solution3 {
    public int subarraySum(int[] nums, int k) {
    	int[] presum = new int[nums.length+1];
    	int res = 0;
    	for(int i = 0;i<nums.length;i++) {
    		presum[i+1] = nums[i] + presum[i]; 
    	}
    	for(int i =0;i<nums.length;i++) {
    		for(int j = i;j<nums.length;j++) {
    			if(k == presum[j] - presum[i]) res+=1;
    		}
    	}
    	return res;
    }
}





