package com.edureka.sorting;

public class Ascending {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] array = {3,5,7,1,4};
		//System.out.println(array.length);
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-i-1;j++)
			{
				
				if(array[j]>array[j+1])
				{
					int temp=array[j];
					System.out.println("Temp value is" +temp);
					array[j]=array[j+1];
					System.out.println("array["+j+"]"+"="+array[j]);
					array[j+1]=temp;
					
				
			}
		}
		}
	
	for(int x=0;x<array.length;x++)
	{
		System.out.println(array[x]);
	}
	}
	
	
}
