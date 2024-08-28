package Test.Test_script;

import java.util.ArrayList;

public class prac {
	public static void main(String[] args) {
		prac obj=new prac();
//		obj.intarrayp();
//		obj.stringarrayp();
	//	obj.newforloop();
	//	obj.even();
//		obj.arraylists();
		obj.reversestring();
	}
	public void intarrayp() {
		//single dimentional array
		int array[]=new int[5];
		array[1]=20;
		array[0]=40;
		array[2]=60;
		//System.out.println(array[0]+""+array[1]);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		
	}

	public void stringarrayp() {
		//single dimentional array
		String []array= {"f","e","dsfdf"};
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	public void newforloop() {
		String []array= {"f","e","dsfdf"};
		for(String s:array)// it will print each value present in array
		{
			System.out.println(s);
		}
	}
	//print even number from list
	public void even() {
		int []array= {1,5,7,3,7,7,2,9,6,8};
		for(int s:array)// it will print each value present in array
		{
			if(s%2==0) {
			System.out.println("even number:-"+s);
			}
		}
	}
	
	public void arraylists() {
		ArrayList objs=new ArrayList();
		objs.add("text");
		objs.get(0).equals("text");
	}
	 //reverse string
	public void reversestring() {
     String s="test text";
     for(int i=s.length()-1;i>=0;i--) {
    	 System.out.println(s.charAt(i));
     }
	}


}
