package Compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FinalCompiler {

	public static void main(String[] args) throws Exception {
		File temp;
		String fileName = "";
		ArrayList<Integers> intArrayList = new ArrayList<Integers>();
		ArrayList<Decimals> decimalArrayList = new ArrayList<Decimals>();
		ArrayList<Characters> charactersArrayList = new ArrayList<Characters>();
		ArrayList<Buuleans> buuleansArrayList = new ArrayList<Buuleans>();
		ArrayList<Strings> stringsArrayList = new ArrayList<Strings>();
		int numOfForLoops = 65;
		int numOfScanners = 65;
		ArrayList<String> linesOfCode = new ArrayList<String>();
		//intArrayList.add();
		boolean stillCoding = true;
		String fileContent = "";
		while (stillCoding) {
			/*
			 * Get string from Arvind
			 * 
			 */
			String stringFromArvind = ""; //Replace with code that gets string
			linesOfCode.add(new Compiler(stringFromArvind,numOfScanners,intArrayList,decimalArrayList,charactersArrayList,buuleansArrayList,stringsArrayList,numOfForLoops).main());
			int prevLine = linesOfCode.size()-1;
			if (linesOfCode.get(prevLine).contains("for (")) {
				numOfForLoops++;
			}
			if (linesOfCode.get(prevLine).contains("SavE FILE As: ")) {
				fileName = linesOfCode.get(prevLine).replace("SavE FILE As: ","");
				linesOfCode.remove(prevLine);
				stillCoding = false;
			}
			
		}
		/*
		 * After the while loop is false (the user has stopped coding) it will combine all the elements in ArrayList linesOfCode and will write it to a file
		 */
		for (int i = 0; i < linesOfCode.size(); i++) {
			fileContent = fileContent + "\n" + linesOfCode.get(i) + "\n";
		}
		try{    
			   temp = File.createTempFile(fileName, ".java");
		       FileOutputStream fout = new FileOutputStream("///Users/3001896/Desktop/"+fileName+".java"); //Change the file directory to where ever it ends up being saved in the AWS server
		       byte b[]=fileContent.getBytes();
		       fout.write(b);    
		       fout.close();    
		       System.out.println("success...");    
		     } catch(Exception e1) {System.out.println(e1);} 
		  
	}

}

//SWITCH STATEMENTS
