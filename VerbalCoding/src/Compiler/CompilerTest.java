package Compiler;
import java.io.FileOutputStream;  
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/*
 * THIS TESTER IS OBSOLETE USE CompilerTest1 INSTEAD
 */
public class CompilerTest {

	public static void main(String[] args) throws IOException {
		//Compiler test = new Compiler ("declare variable boolean raj equal to true");
		//Compiler test1 = new Compiler ("declare variable integer sagay equal to 45");
		//Compiler test2 = new Compiler ("declare if condition sagay greater than 14 or raj equal to false");
		//Compiler test3 = new Compiler ("concatenated output with variable sagay and text is the value of sagay ENDtext");
		//Compiler test4 = new Compiler ("end if condition");
		//Compiler test5 = new Compiler ("insert comment Hello this is my first program");
		/*^^^STORE EVERY LINE IN AS AN ELEMENT IN AN ARRAY LIST SO THAT WHEN THE USER SAYS GO BACK TO THIS LINE AND CHANGE IT
			 OR SOMETHING WE CAN REMOVE AND/OR ADD STUFF
			 AND THEN COMPILE EVERYTHING AS SHOWN IN THE LINE BELOW*/
		//String fileContent = test.main() + "\n" + test1.main() + "\n" + test2.main() + "\n" + test3.main() + "\n" + test4.main() + "\n" + test5.main();
		try{    
	       FileOutputStream fout = new FileOutputStream("///Users/3001896/Desktop/testcode.java"); 
	      //byte b[]=fileContent.getBytes();
	      //fout.write(b);    
	       fout.close();    
	       System.out.println("success...");    
	     } catch(Exception e1){System.out.println(e1);}   
	}

}