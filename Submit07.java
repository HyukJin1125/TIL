package hyukjin.submit07;

import java.util.Arrays;

public class Submit07 {

	public static void main(String[] args) {
	
	// Q.02	
	int[] intArray = {23, 456, 213, 32, 464, 1, 2, 4};
	
	for (int i = 0; i < intArray.length; i++) {
		int maxInt = intArray[0];
		for (int j = 0; j < intArray.length -i; j++) {
			if(intArray[j] > maxInt) {
				maxInt = intArray[j];
			}
		}
	int maxIntIndex = getIndex(intArray, maxInt);
	int swapIntIndex = intArray.length -i -1;
	int tmpInt = intArray[maxIntIndex];
	intArray[maxIntIndex] = intArray[swapIntIndex];
	intArray[swapIntIndex] = tmpInt;
	}
	printArray(intArray);	
		
	// Q.02 내림차순	
	int[] intArray2 = {23, 456, 213, 32, 464, 1, 2, 4};
	
	for (int i = 0; i < intArray2.length; i++) {
		int maxInt = intArray2[0];
		for (int j = 0; j < intArray2.length -i; j++) {
			if(intArray2[j] > maxInt) {
				maxInt = intArray2[j];
			}
		}
	int maxIntIndex = getIndex(intArray2, maxInt);
	int swapIntIndex = intArray2.length -i -1;
	int tmpInt = intArray2[maxIntIndex];
	intArray[maxIntIndex] = intArray2[swapIntIndex];
	intArray[swapIntIndex] = tmpInt;
	}
	printArray(intArray2);	
			
	
	} // main 끝
	
	// 로또 번호 생성기
			// Array 에 랜덤 숫자(1 ~ 45)를 6개 넣어주는데 중복을 허용하지 않아야 한다.
			// 배열 안에 랜덤 숫자 넣기
			// 로또 번호 넣어주기
			// 1 ~ 45 사이의 랜덤 정수
	static int[] makeLotto() {
		int[] lottoArray = new int[6];
		for (int i = 0; i < lottoArray.length;) {
			preventDuplicate: while (true) {
				int randInt = (int) (Math.random() * 45) + 1;
				for(int j = 0; j < lottoArray.length; j++){
					if (lottoArray[i] == randInt) {
						continue preventDuplicate;
					}
				}
				lottoArray[i] = randInt;
				i++;
				break;
			}
		}
		Arrays.parallelSort(lottoArray);
		return lottoArray;
	}
	
	static void printArray(int[] intArray) {
			System.out.print("{");
		for (int i = 0; i < intArray.length; i++) {
			if(i == intArray.length -1) {
				System.out.print(intArray[i] + "}\n");
			}else {
				System.out.print(intArray[i] + ", ");
			}
	 	}
	}
	
	static int max(int... intArray) {
		int result = intArray[0];
		for(int i = 0; i < intArray.length; i++) {
			if(intArray[i] > result) {
				result = intArray[i];
			}
		}
	return result;
	}
	
	static int min(int... intArray){
		int result = intArray[0];
		for (int i = 0; i < intArray.length; i++) {
			if(intArray[i] > result) {
			result = intArray[i];
		}
	}
		return result;
}
	
	static int getIndex(int[] intArray, int intVar){
		for(int i = 0; i < intArray.length; i++) {
			if (intArray[i] == intVar) {
			return i;
			}
		}
	return -1;
	}
	
	
	
	
}
