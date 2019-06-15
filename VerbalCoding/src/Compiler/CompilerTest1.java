package Compiler;

import java.util.ArrayList;
import java.util.Scanner;

public class CompilerTest1 {

	public static void main(String[] args) throws Exception {
		ArrayList<Integers> intArrayList = new ArrayList<Integers>();
		ArrayList<Decimals> decimalArrayList = new ArrayList<Decimals>();
		ArrayList<Characters> charactersArrayList = new ArrayList<Characters>();
		ArrayList<Buuleans> buuleansArrayList = new ArrayList<Buuleans>();
		ArrayList<Strings> stringArrayList = new ArrayList<Strings>();
		int numOfForLoops = 65;
		int numOfScanners = 65;
		//intArrayList.add(new Integers("beta","4",true)); //0
		//intArrayList.add(new Integers("joe",null,false)); //1
		//intArrayList.add(new Integers("yeet","69",true)); //2
		intArrayList.add(new Integers("job","84",true)); //3
		stringArrayList.add(new Strings("ammu",null,false));
		charactersArrayList.add(new Characters("yeet","n",true));
		decimalArrayList.add(new Decimals("nig",null,false));
		buuleansArrayList.add(new Buuleans("beta",null,false));
		//Compiler test = new Compiler ("declare variable boolean rohith equal to true",intArrayList,decimalArrayList,charactersArrayList,buuleansArrayList,stringArrayList,numOfForLoops);
		Compiler test = new Compiler ("input user integer to variable alpha",numOfScanners,intArrayList,decimalArrayList,charactersArrayList,buuleansArrayList,stringArrayList,numOfForLoops);
		if (test.main().contains("for (")) {
			numOfForLoops++;
		}
		if (test.main().contains("Scanner(System.in);")) {
			numOfScanners++;
		}
		//Compiler test1 = new Compiler ("declare for loop set incrementor 25 until greater than or equal to 10 incrementor minusminus",intArrayList,decimalArrayList,charactersArrayList,buuleansArrayList,stringArrayList,numOfForLoops);
		System.out.println(test.main());
		//System.out.println(decimalArrayList.get(1));
		//System.out.println(test1.main());	
		//System.out.println(numOfForLoops);//Find out how to incement 
		//System.out.println(stringArrayList.get(0));
		//System.out.println(stringArrayList.get(1));
		/*
		 * System.out.println(intArrayList.get(2)); 
		 * System.out.println(intArrayList.get(3));
		 * System.out.println(intArrayList.get(4)); 
		 */
		//System.out.println(intArrayList.get(5));
		//declare existing variable integer beta equal to 7 WORKS
		//declare variable integer beta WORKS
		//declare variable integer beta equal to 6 WORKS
		//declare variable integer beta equal to 16 plus 14 minus 2 modulus 6 WORKS
		//declare for loop set incrementor 0 until greater than or equal to 10 incrementor plusplus
	}
}

