package ǰ׺��;

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
 * leetcode 724. Ѱ���������������
 * 
	����һ���������͵����� nums�����дһ���ܹ��������� ������������ �ķ�����
	������������������ �������� �ģ����������������������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
	������鲻����������������ô����Ӧ�÷��� -1����������ж��������������ô����Ӧ�÷��������ߵ���һ����
	
	���룺
	nums = [1, 7, 3, 6, 5, 6]
	�����3

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
 * 	leetcode 560. ��ΪK��������
	��Ŀ����
	
	����һ�����������һ������ k������Ҫ�ҵ��������к�Ϊ k ��������������ĸ�����
	
	ʾ�� 1 :
	
	����:nums = [1,1,1], k = 2
	���: 2 , [1,1] �� [1,1] Ϊ���ֲ�ͬ�������

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
//ǰ׺���㷨
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





