package algorithm;

public class Solution_마방진 {
	
	//마방진을 만드는게 아니라 마방진임들 체크하는 메소드를 만드는게 목표
	static boolean checkMaBangJin(int[][] target) {
		int len = target.length;
		int sumInitRow =0;
		int sumInitCol =0;
		
		//행의 합, 열의 합
		for (int i = 0; i < len; i++) {
			int sumCurRow =0;
			int sumCurCol =0;
			for (int j = 0; j < len; j++) {
				sumCurRow += target[i][j];
				sumCurCol += target[j][i];
				if(i==0) {
					sumInitRow += target[i][j];
					sumInitCol += target[j][i];
				}
			}
			if(sumInitRow != sumCurRow || sumInitCol != sumCurCol) {
				return false;
			}
		}
		
		//대각선 검사
		for (int i = 0; i < len; i++) {
			int sumCro =0;
			for (int j = len-1; j >= 0; j--) {
				sumCro += target[i][j];
			}
			if(sumInitRow != sumCro) {
				return false;
			}
		}
		
		return true;
	}//end of checkMaBangJin()
	
	static int oneRowSum(int[][] target) {
		int rand = (int) (Math.random()*target.length);	//임의의 한 행  
		int sum =0;
		for (int i = 0; i < target.length; i++) {
			sum += target[rand][i];
		}
		return sum;
	}//end of oneRowSum()
	
	static int totalSum(int[][] target) {
		int sum=0;
		for (int i = 0; i < target.length; i++) {
			sum += target[0][i];
		}
		return (2*(target.length+1))*sum;
	}//end of tatalSum()
	
	public static void main(String[] args) {
		int[][] arrOdd1 ={	{4,9,2},
							{3,5,7},
							{8,1,6}
		};
		
		int[][] arrOdd2 ={	{4,8,2},
							{3,5,7},
							{9,1,6}
		};
		
		System.out.println("arrOdd1은 마방진 ? :"+ checkMaBangJin(arrOdd1));
		System.out.println("arrOdd2은 마방진 ? :"+ checkMaBangJin(arrOdd2));
		
		System.out.println("arrOdd1의 임의의 한 행의 값은? :"+oneRowSum(arrOdd1));
		System.out.println("arrOdd1의 마방진의 총합은? :"+totalSum(arrOdd1));
	
		
		System.out.println("################################");
		int[][] arrEven1 = {{1,15,14,4},
							{12,6,7,9},
							{8,10,11,5},
							{13,3,2,16}
		};
		int[][] arrEven2 = {{1,15,4,14},
							{12,6,7,9},
							{8,10,11,5},
							{13,3,2,16}
		};
		
		System.out.println("arrEven1은 마방진 ? :"+ checkMaBangJin(arrEven1));
		System.out.println("arrEven2은 마방진 ? :"+ checkMaBangJin(arrEven2));
		
		System.out.println("arrEven1의 임의의 한 행의 값은? :"+oneRowSum(arrEven1));
		System.out.println("arrEven1의 마방진의 총합은? :"+totalSum(arrEven1));
	
	}//end of main
}//end of class














