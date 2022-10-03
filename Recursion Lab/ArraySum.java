package Lab3;

public class ArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sumOfArray (Integer[] a,int index) {
		int sum;
		if(index<0) {
			return 0;
		}else {
			sum=a[index]+sumOfArray(a,--index);
		}
		return sum;
		
	}
}
