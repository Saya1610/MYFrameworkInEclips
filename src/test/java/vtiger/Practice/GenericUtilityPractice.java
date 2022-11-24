package vtiger.Practice;

public class GenericUtilityPractice {

	public static void main(String[] args) {//caller/calling function
		int sum=GenericUtilityPractice.add(10,30);
		System.out.println(sum);
	}
	public static int add(int a,int b)//called fuc
	{
		int c=a+b;
		return c;
		
	}

}
