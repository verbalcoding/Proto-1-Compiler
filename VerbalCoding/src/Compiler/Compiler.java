package Compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Compiler {
private String stringInput;
//Syntax------------------------------------------------------------
private final String DECLARE = "declare";
private final String EXISTING = "existing";
private final String IFCONDITION = "declare if condition";
private final String FORCONDITION = "declare for loop";
private final String NESTEDFORCONDITION = "declare nested for loop";
private final String INTEGER = "variable integer";
private final String DECIMAL = "variable decimal";
private final String CHARACTER = "variable character";
private final String BOOLEAN = "variable boolean";
private final String VALUEDECLARED = "equal to";
private final String GREATERTHAN = "greater than";
private final String LESSTHAN = "less than";
private final String EQUALTO = "equal to";
private final String NOTEQUALTO = "not equal to";
private final String GREATERTHANOREQUALTO = "greater than or equal to";
private final String LESSTHANOREQUALTO = "less than or equal to";
private final String ANDRELATIONSHIP = "and";
private final String ORRELATIONSHIP = "or";
private final String ENDIF = "end if condition";
private final String ENDFOR = "end for loop";
private final String ADDITION = "plus";
private final String SUBTRACTION = "minus";
private final String MULTIPLICATION = "times";
private final String DIVISION = "divided by";
private final String MODULUS = "modulus";
private final String POWER = "to the power of";
private final String ROOT = "root";
private final String OUTPUT = "output";
private final String CONCATENATEDOUTPUT = "concatenated output";
private final String INPUT = "input";
private final String ARRAY = "array";
private final String COMMENT = "insert comment";
private final String STRING = "string";
//private final String QUIT = "quit";
//------------------------------------------------------------------
private final String FILENAME = "NAME file: ";
//------------------------------------------------------------------
private boolean isDeclareStatement = false;
private boolean isIfCondition = false;
private boolean isForCondition = false;
private boolean endIf = false;
private boolean endFor = false;
private boolean isIntValue = false;
private boolean isDecimalValue = false;
private boolean isCharacterValue = false;
private boolean isBuuleanValue = false;
private boolean specificValueDeclared = false;
private boolean isNestedForLoop = false;
private boolean isArithmetic = false;
private boolean isOutputting = false;
private boolean isConcatenatedOutput = false;
private boolean isInputting = false;
private boolean isArray = false;
private boolean isComment = false;
private boolean isString = false;
private boolean isPower = false;
private boolean isRooting = false;
//------------------------------------------------------------------
private String descriptionOfLine;
private String finalReturn;
private String nameOfFile;
private String tempStringInput;//Used to instantiate variable objects
private boolean isValDeclared; //^^^^^^
private char semicolon = ';';
//------------------------------------------------------------------
ArrayList<Integers> intArrayList = new ArrayList<Integers>();
ArrayList<Decimals> doubleArrayList = new ArrayList<Decimals>();
ArrayList<Characters> charArrayList = new ArrayList<Characters>();
ArrayList<Buuleans> booleanArrayList = new ArrayList<Buuleans>();
ArrayList<Strings> stringArrayList = new ArrayList<Strings>();
public int numOfForLoops;
public int numScanners;
//------------------------------------------------------------------
public Compiler (String userString, int numOfScanners, ArrayList Int, ArrayList Decimals, ArrayList Characters, ArrayList Buuleans, ArrayList Strings, int numOfFors/*,String fileName*/) {
	intArrayList = Int;
	doubleArrayList = Decimals;
	charArrayList = Characters;
	booleanArrayList = Buuleans;
	stringArrayList = Strings;
	stringInput = userString;
	descriptionOfLine = userString;
	numOfForLoops = numOfFors;
	numScanners = numOfScanners;
	//nameOfFile = fileName;
}
//------------------------------------------------------------------

public String main () throws Exception {
	if (stringInput.contains(INPUT)) {
		isInputting = true;
		if (stringInput.contains("integer")) {
			isIntValue = true;
		} 
		if (stringInput.contains("decimal")) {
			isDecimalValue = true;
		}
		if (stringInput.contains("character")) {
			isCharacterValue = true;
		}
		if (stringInput.contains("boolean")) {
			isBuuleanValue = true;
		}
		if (stringInput.contains("string")) {
			isString = true;
		}
	}
	if (stringInput == FILENAME)
		getFileName(stringInput);
	if (stringInput.contains(ARRAY))
		isArray = true;
	if (stringInput.contains(STRING))
		isString = true;
	if (stringInput.contains(CONCATENATEDOUTPUT))
		isConcatenatedOutput = true;
	if (stringInput.contains(COMMENT))
		isComment = true;
	if (stringInput.contains(ROOT)||stringInput.contains(POWER)||stringInput.contains(ADDITION)||stringInput.contains(SUBTRACTION)||stringInput.contains(MULTIPLICATION)||stringInput.contains(DIVISION)||stringInput.contains(MODULUS))
		isArithmetic = true;
	if (stringInput.contains(OUTPUT))
		isOutputting = true;
	if (stringInput.contains(INPUT))
		isInputting = true;
	if (stringInput.contains(IFCONDITION)) 
		isIfCondition = true;
	if (stringInput.contains(ARRAY))
		isArray = true;
	if (stringInput.contains(FORCONDITION)) 
		isForCondition = true;
	if (stringInput.contains(NESTEDFORCONDITION))
		isNestedForLoop = true;
	if (stringInput.contains(ENDIF)) 
		endIf = true;
	if (stringInput.contains(ENDFOR))
		endFor = true;
	if (stringInput.contains(DECLARE)) {
		isDeclareStatement = true;
		if (stringInput.contains(INTEGER)) {
			isIntValue = true;
		} 
		if (stringInput.contains(DECIMAL)) {
			isDecimalValue = true;
		}
		if (stringInput.contains(CHARACTER)) {
			isCharacterValue = true;
		}
		if (stringInput.contains(BOOLEAN)) {
			isBuuleanValue = true;
		}
		if (stringInput.contains(VALUEDECLARED)) {
			specificValueDeclared = true;
		}
	}
	if (isInputting == true && isIntValue == true)
		inputtingInt(stringInput);
	if (isInputting == true && isDecimalValue == true)
		inputtingDecimal(stringInput);
	if (isInputting == true && isCharacterValue == true) 
		inputtingCharacter(stringInput);
	if (isInputting == true && isString == true)
		inputtingString(stringInput);
	if (isInputting == true && isBuuleanValue == true) {
		inputtingBoolean(stringInput);	
	}
		
	if (isInputting == true && isString == true)
		inputtingString(stringInput);
		
	if (isArray == true)
		array(stringInput);
	if (isOutputting == true)
		output(stringInput);
	if (isConcatenatedOutput == true)
		concatenatedOutput(stringInput);
	if (isDeclareStatement == true && isIntValue == true && isArithmetic == true) 
		declaringIntWithArithmetic(stringInput);
	if (isDeclareStatement == true && isDecimalValue == true && isArithmetic == true)
		declaringDecimalWithArithmetic(stringInput);
	if (isDeclareStatement == true && isCharacterValue == true && isArithmetic == true)
		finalReturn = "This line contains an error: " + stringInput;
	if (isDeclareStatement == true && isBuuleanValue == true && isArithmetic == true)
		finalReturn = "This line contains an error: " + stringInput;
	if (isDeclareStatement == true && isString == true && specificValueDeclared == true) 
		declaringStringWithValue(stringInput);
	if (isDeclareStatement == true && isString == true && specificValueDeclared == false)
		declaringString(stringInput);
	if (isDeclareStatement == true && isIntValue == true && specificValueDeclared == true && isArithmetic == false)
		declaringIntWithValue(stringInput);
	if (isDeclareStatement == true && isIntValue == true && specificValueDeclared == false)
		declaringInt(stringInput);
	if (isDeclareStatement == true && isDecimalValue == true && specificValueDeclared == true && isArithmetic == false)
		declaringDoubleWithValue(stringInput);
	if (isDeclareStatement == true && isDecimalValue == true && specificValueDeclared == false)
		declaringDouble(stringInput);
	if (isDeclareStatement == true && isCharacterValue == true && specificValueDeclared == true)
		declaringCharWithValue(stringInput);
	if (isDeclareStatement == true && isCharacterValue == true && specificValueDeclared == false)
		declaringChar(stringInput);
	if (isDeclareStatement == true && isBuuleanValue == true && specificValueDeclared == true)
		declaringBoolWithValue(stringInput);
	if (isDeclareStatement == true && isBuuleanValue == true && specificValueDeclared == false)
		declaringBool(stringInput);
		
	if (isIfCondition == true)
		ifCondition(stringInput);
	if (isForCondition == true || isNestedForLoop == true) {
		forCondition(stringInput/*,numOfForLoops*/);
	}
	if (endIf == true) {
		stringInput = "}";
		descriptionOfLine = "Ending the previous condition";
		finalReturn = stringInput + " // " + descriptionOfLine;
		return finalReturn; 
	}
	if (endFor == true) {
		stringInput = "}";
		descriptionOfLine = "Ending the previous loop";
		finalReturn = stringInput + " // " + descriptionOfLine;
		return finalReturn; 
	}
	if (isComment == true) {
		stringInput = stringInput.replace("insert comment","Coder's comment: ");
		stringInput = "//" + stringInput; 
		finalReturn = stringInput;
	}
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}
public String getFileName (String stringInput) {
	stringInput = stringInput.replace("NAME file: ","SavE FILE As: ");
	return stringInput;
}
private String inputtingInt (String stringInput) throws Exception { //works (MODEL FOR INPUTS)
	//input user integer to variable alpha <- (or any other variable name)
	boolean preExisitingVariable = false;
	boolean preExistingInt = false;
	String intName = "";
	char scanName = (char) numScanners;
	stringInput = stringInput.replace("input user integer","Scanner "+scanName); // Scanner a to variable alpha
	stringInput = stringInput.replace("to var","= new Scanner(System.in);\n"); //Scanner a = new Scanner(System.in); iable alpha
	stringInput = stringInput.replace("iable","int"); //Scanner a = new Scanner(System.in); int alpha
	stringInput = stringInput + " = "; //Scanner a = new Scanner(System.in); int alpha = 
	stringInput = stringInput + scanName + ".nextInt();"; //Scanner a = new Scanner(System.in); int alpha = a.nextInt();
	String[] parts = stringInput.split(";\nint ");
	intName = parts[1].replace(" = "+scanName+".nextInt();","");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(intName)) {
			boolean exisitingBool = true;
	 		if (exisitingBool) 
	 		stringInput = stringInput.replace("int ","");	
		}
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < intArrayList.size(); i++) {
		if ((intArrayList.get(i).returnName()).equals(intName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + intName + " is " + intArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				intArrayList.get(i).changeVal("User Input");
			i = intArrayList.size();
			preExistingInt = true;
		}
	}
	if (preExistingInt == false)
		intArrayList.add(new Integers(intName,"User Input",true));
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String inputtingDecimal (String stringInput) throws Exception { //works (Done)
	//input user decimal num to variable alpha , num <- (or any other variable name)
	//Scanner a = new Scanner(System.in);
	//alpha = a.nextDouble();
	//Scanner a = new Scanner(System.in);\ndouble alpha = a.nextDouble();
	char scanName = (char) numScanners;
	String doubleName = "";
	boolean preExisitingVariable = false;
	boolean preExistingDouble = false;
	stringInput = stringInput.replace("input user decimal","Scanner "+scanName);
	stringInput = stringInput.replace("to var","= new Scanner(System.in);\n ");
	stringInput = stringInput.replace("iable","double");
	stringInput = stringInput + " = ";
	stringInput = stringInput + scanName + ".nextDouble();";
	String[] parts = stringInput.split(";\ndouble ");
	doubleName = parts[1].replace(" = "+scanName+".nextDouble();","");
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(doubleName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(doubleName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(doubleName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(doubleName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(doubleName)) {
			boolean exisitingBool = true;
	 		if (exisitingBool) 
	 		stringInput = stringInput.replace("double ","");	
		}
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if ((doubleArrayList.get(i).returnName()).equals(doubleName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + doubleName + " is " + doubleArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				doubleArrayList.get(i).changeVal("User Input");
			i = doubleArrayList.size();
			preExistingDouble = true;
		}
	}
	if (preExistingDouble == false)
		doubleArrayList.add(new Decimals(doubleName,"User Input",true));
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String inputtingCharacter (String stringInput) throws Exception { //works (Done)
	//input user character to variable alpha
	char scanName = (char) numScanners;
	String charName = "";
	boolean preExisitingVariable = false;
	boolean preExistingChar = false;
	stringInput = stringInput.replace("input user character","Scanner "+scanName);
	stringInput = stringInput.replace("to var","= new Scanner(System.in);\n ");
	stringInput = stringInput.replace("iable","char");
	stringInput = stringInput + " = ";
	stringInput = stringInput + scanName + ".next().charAt(0);";
	String[] parts = stringInput.split(";\nchar ");
	charName = parts[1].replace(" = "+scanName+".next().charAt(0);","");
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(charName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(charName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(charName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(charName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(charName)) {
			boolean exisitingBool = true;
	 		if (exisitingBool) 
	 		stringInput = stringInput.replace("character ","");	
		}
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < charArrayList.size(); i++) {
		if ((charArrayList.get(i).returnName()).equals(charName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + charName + " is " + charArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				charArrayList.get(i).changeVal("User Input");
			i = charArrayList.size();
			preExistingChar = true;
		}
	}
	if (preExistingChar == false)
		doubleArrayList.add(new Decimals(charName,"User Input",true));
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String inputtingBoolean (String stringInput) throws Exception { //works (Done)
	//input user character num to variable alpha , num <- (or any other variable name)
	char scanName = (char) numScanners;
	String boolName = "";
	boolean preExisitingVariable = false;
	boolean preExistingBool = false;
	stringInput = stringInput.replace("input user boolean","Scanner "+scanName);
	stringInput = stringInput.replace("to var","= new Scanner(System.in);\n ");
	stringInput = stringInput.replace("iable","boolean");
	stringInput = stringInput + " = ";
	stringInput = stringInput + scanName + ".nextBoolean();";
	String[] parts = stringInput.split(";\nboolean ");
	boolName = parts[1].replace(" = "+scanName+".nextBoolean();","");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(boolName)) {
			boolean exisitingBool = true;
	 		if (exisitingBool) 
	 		stringInput = stringInput.replace("boolean ","");	
		}
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if ((booleanArrayList.get(i).returnName()).equals(boolName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + boolName + " is " + booleanArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				booleanArrayList.get(i).changeVal("User Input");
			i = booleanArrayList.size();
			preExistingBool = true;
		}
	}
	if (preExistingBool == false)
		booleanArrayList.add(new Buuleans(boolName,"User Input",true));
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String inputtingString (String stringInput) throws Exception { //works (Done)
	//input user string num to variable alpha , num <- (or any other variable name)
	boolean preExisitingVariable = false;
	boolean preExistingString = false;
	String stringName = "";
	char scanName = (char) numScanners;
	stringInput = stringInput.replace("input user string","Scanner "+scanName);
	stringInput = stringInput.replace("to var","= new Scanner(System.in);\n ");
	stringInput = stringInput.replace("iable","String");
	stringInput = stringInput + " = "; //Scanner a = new Scanner(System.in); String alpha = a.nextInt();
	stringInput = stringInput + scanName + ".nextString();";
	String[] parts = stringInput.split(";\nString");
	stringName = parts[1].replace(" = "+scanName+".nextString();","");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
	
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(stringName)) {
			boolean exisitingBool = true;
	 		if (exisitingBool) 
	 		stringInput = stringInput.replace("string ","");	
		}
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < stringArrayList.size(); i++) {
		if ((stringArrayList.get(i).returnName()).equals(stringName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + stringName + " is " + stringArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				stringArrayList.get(i).changeVal("User Input");
			i = stringArrayList.size();
			preExistingString = true;
		}
	}
	if (preExistingString == false)
		stringArrayList.add(new Strings(stringName,"User Input",true));
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String array (String stringInput) throws Exception { //work in progress
	//declare (data type) array (name of array) with 10 elements
	//declare (data type) array (name of array) with 10 elements populate (randomly/manually/...)
	if(stringInput.contains("integer")) {
		stringInput = stringInput.replace("declare integer array","int[]");
		stringInput = stringInput.replace("with ","= new int[");
		stringInput = stringInput.replace(" elements","];");
	}
	if(stringInput.contains("decimal")) {
		stringInput = stringInput.replace("declare decimal array","double[]");
	stringInput = stringInput.replace("with ","= new double[");
	stringInput = stringInput.replace(" elements","];");
	}
	if(stringInput.contains("character")) {
		stringInput = stringInput.replace("declare character array","char[]");
		stringInput = stringInput.replace("with ","= new char[");
		stringInput = stringInput.replace(" elements","];");
	}
	if (stringInput.contains("boolean")) {
		stringInput = stringInput.replace("declare boolean array","boolean[]");
		stringInput = stringInput.replace("with ","= new boolean[");
		stringInput = stringInput.replace(" elements","];");
	}
	if (stringInput.contains("string")) {
		stringInput = stringInput.replaceAll("declare string array","String[]");
		stringInput = stringInput.replace("with ","= new String[");
		stringInput = stringInput.replace(" elements","];");
	}
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String concatenatedOutput (String stringInput) throws Exception { //works (Done)
	//concatenated output with text Hello my name is ENDtext and variable name and number 14
	//System.out.println("Hello my name is" + name + 14);
	stringInput = stringInput.replace(CONCATENATEDOUTPUT, "System.out.println(");
	if (stringInput.contains("and variable")) {
		stringInput = stringInput.replace("and variable","+");
	}
	if (stringInput.contains("and text")) {
		stringInput = stringInput.replace("and text","+\"");
		stringInput = stringInput.replace("ENDtext","\"");
	}
	if (stringInput.contains("and number")) {
		stringInput = stringInput.replace("and number","+");
	}
	if (stringInput.contains("with variable")) {
		stringInput = stringInput.replace("with variable","");

	}
	if (stringInput.contains("with text")) {
		stringInput = stringInput.replace("with text","\"");
		stringInput = stringInput.replace("ENDtext","\"");

	}
	if (stringInput.contains("with number")) {
		stringInput = stringInput.replace("with number","");

	}
	if (stringInput.contains("+ +") || stringInput.contains("++")) {
		stringInput = stringInput.replaceAll("\\+ +","\\+");
		stringInput = stringInput.replaceAll("\\++","\\+");
	}
	stringInput = stringInput + ")" + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String output (String stringInput) throws Exception { //works
	//output (variable+variablename) or (text+text) or (number+numbervalue)
	//output variable boat
	stringInput = stringInput.replace(OUTPUT, "System.out.println(");
	if (stringInput.contains("variable")) {
		stringInput = stringInput.replace("variable","");
		stringInput = stringInput + ")" + semicolon;
	}
	if (stringInput.contains("text")) {
		stringInput = stringInput.replace("text","\"");
		stringInput = stringInput + "\")" + semicolon;
	}
	if (stringInput.contains("number")) {
		stringInput = stringInput.replace("number","");
		stringInput = stringInput + ")" + semicolon;
	}

	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringString (String stringInput) throws Exception { //works
	String stringName,stringVal = "";
	boolean isDeclared = false;
	boolean preExisitingVariable = false;
	//declare variable string rohith 
	stringInput = stringInput.replace("declare variable string", "String");
	stringName = stringInput.replace("string ","");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(stringName)) {
			boolean exisitingBool = true;
	 		if (exisitingBool) 
	 		stringInput = stringInput.replace("boolean","");	
		}
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	stringArrayList.add(new Strings(stringName,stringVal,isDeclared));
	stringInput = stringInput + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringStringWithValue (String stringInput) throws Exception { //works (may containt errors)
	//declare variable string ammu equal to (some string)
	String stringName, stringVal;
	boolean isDeclared = true;
	boolean preExistingString = false;
	boolean preExisitingVariable = false;
	if (stringInput.contains(EXISTING)) {
		stringInput = stringInput.replace("declare existing variable string ",""); //ammu equal to (some string)
	}else {
		stringInput = stringInput.replace("declare variable string", "String"); //String ammu equal to (some string)
	}
	stringInput = stringInput.replace(" equal to "," = \""); //ammu = " 
	String[] parts = stringInput.split(" = ");
	stringName = parts[0].replace("String ","");
	stringVal = parts[1].replaceAll("\"","");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(stringName)) 
			preExisitingVariable = true;
		
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < stringArrayList.size(); i++) {
		if ((stringArrayList.get(i).returnName()).equals(stringName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + stringName + " is " + stringArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				stringArrayList.get(i).changeVal(stringVal);
			i = stringArrayList.size();
			preExistingString = true;
		}
	}
	if(preExistingString == false) {
		stringArrayList.add(new Strings(stringName,stringVal,isDeclared));
	}
	stringInput = stringInput + "\"" + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringIntWithValue (String stringInput) throws Exception { //works
	//declare variable integer alpha equal to 14 
	String intName, intValue;
	boolean isDeclared = true;
	boolean preExistingInt = false;
	boolean preExisitingVariable = false;
	if (stringInput.contains(EXISTING)) {
		stringInput = stringInput.replace("declare existing variable integer","");
	}else {
		stringInput = stringInput.replace("declare variable integer", "int");
	}
	stringInput = stringInput.replace(EQUALTO, "="); 
	descriptionOfLine = "The line is declaring an integer with a value";	
	 //int alpha = 14
	String[] parts = stringInput.split(" = ");
	intName = parts[0].replace("int ","");
	intValue = parts[1];
	if (intValue.matches(".*\\d.*") == false)
		throw new Exception ("An Integer variable must be declared with a number");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < intArrayList.size(); i++) {
		if ((intArrayList.get(i).returnName()).equals(intName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + intName + " is " + intArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				intArrayList.get(i).changeVal(intValue);
			i = intArrayList.size();
			preExistingInt = true;
		}
	}
	if (preExistingInt == false)
		intArrayList.add(new Integers(intName,intValue,isDeclared));
	stringInput = stringInput + semicolon; 
	finalReturn = stringInput + " // " + descriptionOfLine;
	//intArrayList.add(intArrayList.get(0));
	return finalReturn;
}
private String declaringInt (String stringInput) throws Exception { //works (MODEL)
	String intName,intValue = "";
	boolean isDeclared = false;
	boolean preExisitingVariable = false;
	//boolean preExistingInt = false;
	/*
	 *if (stringInput.contains(EXISTING)) {
	 *	stringInput = stringInput.replace("declare existing variable integer","");
	 *}else {
	 *	stringInput = stringInput.replace("declare variable integer", "int");
	 *}
	 */
	stringInput = stringInput.replace("declare variable integer", "int");
	descriptionOfLine = "The line is a declaring an integer";	
	intName = stringInput.replace("int ","");
	/*
	 *for (int i = 0; i < stringArrayList.size(); i++) {
	 *	if (stringArrayList.get(i).returnName() == intName) {
	 *		stringArrayList.get(i).changeVal(intValue);
	 *		i = stringArrayList.size();
	 *		preExistingInt = true;
	 *	}
	 *}
	 *if (preExistingInt == false)
	 */
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	intArrayList.add(new Integers(intName,intValue,isDeclared));
	stringInput = stringInput + "" + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringDoubleWithValue (String stringInput) throws Exception { // works
	if (stringInput.contains(EXISTING)) {
		stringInput = stringInput.replace("declare existing variable decimal","");
	}else {
		stringInput = stringInput.replace("declare variable decimal", "double");
	}
	stringInput = stringInput.replace(EQUALTO, "=");
	descriptionOfLine = "The line is declaring a double with a value";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringDouble (String stringInput) throws Exception { //works
	stringInput = stringInput.replace("declare variable decimal", "double");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a double";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringCharWithValue (String stringInput) throws Exception { //works
	stringInput = stringInput.replace("declare variable character", "char");
	stringInput = stringInput.replace("equal to ", "= '");
	stringInput = stringInput + "'" + semicolon;
	descriptionOfLine = "The line is declaring a character with a value";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringChar (String stringInput) throws Exception { //works
	stringInput = stringInput.replace("declare variable character", "char");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a character";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringBoolWithValue (String stringInput) throws Exception { //works (MODEL)
	String boolName, boolValue;  //declare variable boolean beta equal to true
	boolean isDeclared = true;
	boolean preExistingBool = false;
	boolean preExisitingVariable = false;
	boolean wrongDeclaration = true;
	boolean a = false;
	stringInput = stringInput.replace("declare variable boolean", "boolean");
 //boolean rohith = true
	stringInput = stringInput.replace(EQUALTO, "=");
	//declare variable boolean beta equal to true // boolean beta = true
	String[] parts = stringInput.split(" = ");
	boolName = parts[0].replace("boolean ",""); //rohith
	boolValue = parts[1]; //true
	if (boolValue.equals("true") || boolValue.equals("false"))
		wrongDeclaration = false;
	if (wrongDeclaration) 
		throw new Exception ("A boolean variable must be declared true or false");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
	}
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(boolName)) 
			preExisitingVariable = true;
	}
	
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(boolName)) {
			boolean exisitingBool = true;
	 		if (exisitingBool) 
	 		stringInput = stringInput.replace("boolean","");	
		}
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if ((booleanArrayList.get(i).returnName()).equals(boolName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + boolName + " is " + booleanArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				booleanArrayList.get(i).changeVal(boolValue);
			i = booleanArrayList.size();
			preExistingBool = true;
		}
	}
	if (preExistingBool == false)
		booleanArrayList.add(new Buuleans(boolName,boolValue,isDeclared));
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a boolean with a value";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringBool (String stringInput) throws Exception { //works
	stringInput = stringInput.replace("declare variable boolean", "boolean");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a boolean";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String ifCondition (String stringInput) throws Exception { //works
	//Expected input example: declare if condition alpha greater than 7 and alpha equal to beta 
	stringInput = stringInput.replace(IFCONDITION, "if (");
	if (stringInput.contains(GREATERTHANOREQUALTO))
		stringInput = stringInput.replaceAll(GREATERTHANOREQUALTO, ">=");
	if (stringInput.contains(LESSTHANOREQUALTO))
		stringInput = stringInput.replaceAll(LESSTHANOREQUALTO, "<=");
	if (stringInput.contains(GREATERTHAN))
		stringInput = stringInput.replaceAll(GREATERTHAN, ">");
	if (stringInput.contains(LESSTHAN))
		stringInput = stringInput.replaceAll(LESSTHAN, "<");
	if (stringInput.contains(EQUALTO))
		stringInput = stringInput.replaceAll(EQUALTO, "==");
	if (stringInput.contains(NOTEQUALTO))
		stringInput = stringInput.replaceAll(NOTEQUALTO, "!=");
	if (stringInput.contains(ANDRELATIONSHIP))
		stringInput = stringInput.replaceAll(ANDRELATIONSHIP, "&&");
	if (stringInput.contains(ORRELATIONSHIP))
		stringInput = stringInput.replaceAll(ORRELATIONSHIP, "||");
	stringInput = stringInput + "" + ") {";
	//Example output: if ( alpha > 7 && alpha == beta ) {
	descriptionOfLine = "This line is the heading of a if condition, it reads " + descriptionOfLine;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String forCondition (String stringInput/*, int numOfFors*/) throws Exception { //works (detect infinite loops)
	//Expected input example: declare for loop set incrementor 0 until greater than or equal to 10 incrementor plusplus
	//numOfForLoops++; **FIND OUT HOW TO INCREMENT AND RETURN VALUE
	stringInput = stringInput.replace(FORCONDITION, "for (");
	char temp = (char) numOfForLoops;
	
	stringInput = stringInput.replace("set incrementor", "int " + temp + " =");
	stringInput = stringInput.replace("until", "; " + temp);
	
	if (stringInput.contains(GREATERTHANOREQUALTO)) 
		stringInput = stringInput.replaceAll(GREATERTHANOREQUALTO, ">=");
	if (stringInput.contains(LESSTHANOREQUALTO)) 
		stringInput = stringInput.replaceAll(LESSTHANOREQUALTO, "<=");
	if (stringInput.contains(GREATERTHAN)) 
		stringInput = stringInput.replaceAll(GREATERTHAN, ">");
	if (stringInput.contains(LESSTHAN)) 
		stringInput = stringInput.replaceAll(LESSTHAN, "<");
	if (stringInput.contains(EQUALTO)) 
		stringInput = stringInput.replaceAll(EQUALTO, "<=");
	
	if (stringInput.contains("plusplus")) 
		stringInput = stringInput.replace("incrementor plusplus", "; " + temp + "++");
	if (stringInput.contains("minusminus")) 
		stringInput = stringInput.replace("incrementor minusminus", "; " + temp + "--");
	stringInput = stringInput + "" + ") {";
	/*
	 * if (stringInput.contains(NESTEDFORCONDITION)) {
		isNestedForLoop = true;
		stringInput = stringInput.replace(NESTEDFORCONDITION, "for (");
	}else {
		isNestedForLoop = false;
		stringInput = stringInput.replace(FORCONDITION, "for (");
	}
	if (isNestedForLoop == false) {
		stringInput = stringInput.replace("set incrementor", "int i =");
		stringInput = stringInput.replace("until", "; i");
	}
	if (isNestedForLoop == true) {
		stringInput = stringInput.replace("set incrementor", "int k =");
		stringInput = stringInput.replace("until", "; k");
	}
	if (stringInput.contains(GREATERTHANOREQUALTO)) 
		stringInput = stringInput.replaceAll(GREATERTHANOREQUALTO, ">=");
	if (stringInput.contains(LESSTHANOREQUALTO)) 
		stringInput = stringInput.replaceAll(LESSTHANOREQUALTO, "<=");
	if (stringInput.contains(GREATERTHAN)) 
		stringInput = stringInput.replaceAll(GREATERTHAN, ">");
	if (stringInput.contains(LESSTHAN)) 
		stringInput = stringInput.replaceAll(LESSTHAN, "<");
	if (stringInput.contains(EQUALTO)) 
		stringInput = stringInput.replaceAll(EQUALTO, "<=");
	if (isNestedForLoop == false) { 
		if (stringInput.contains("plusplus")) 
			stringInput = stringInput.replace("incrementor plusplus", "; i++");
		if (stringInput.contains("minusminus")) 
			stringInput = stringInput.replace("incrementor minusminus", "; i--");
	}
	if (isNestedForLoop == true) {
		if (stringInput.contains("plusplus"))
			stringInput = stringInput.replace("incrementor plusplus", "; k++");
		if (stringInput.contains("minusminus"))
			stringInput = stringInput.replace("incrementor minusminus", "; k--");
	}
	stringInput = stringInput + "" + ") {";
			//Example output: for ( int i = 0; i >= 10; i++ ) {
	 */
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}
private String declaringIntWithArithmetic (String stringInput) throws Exception { //works
	//Example input: declare variable integer beta equal to 16 plus 14 minus 2 modulus 6
	String intName, intValue;
	boolean isDeclared = true;
	boolean preExistingInt = false;
	boolean preExisitingVariable = false;
	stringInput = stringInput.replace("declare variable integer", "int");
	stringInput = stringInput.replace(EQUALTO, "= (int)");//Everything from here is not working
	if (stringInput.contains(ADDITION))
		stringInput = stringInput.replaceAll(ADDITION, "+");
	if (stringInput.contains(SUBTRACTION))
		stringInput = stringInput.replaceAll(SUBTRACTION, "-");
	if (stringInput.contains(MULTIPLICATION))
		stringInput = stringInput.replaceAll(MULTIPLICATION, "*");
	if (stringInput.contains(DIVISION))
		stringInput = stringInput.replaceAll(DIVISION, "/");
	if (stringInput.contains(MODULUS))
		stringInput = stringInput.replaceAll(MODULUS, "%"); 
	String[] parts = stringInput.split(" = "); //int beta = (int) 16 + 14 - 2 % 6
	intName = parts[0];
	intName = intName.replace("int ","");
	intValue = parts[1];
	if (intValue.matches(".*\\d.*") == false)
		throw new Exception ("An Integer variable must be declared with a number");
	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < charArrayList.size(); i++) {
		if (charArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < booleanArrayList.size(); i++) {
		if (booleanArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	for (int i = 0; i < stringArrayList.size(); i++) {
		if (stringArrayList.get(i).returnName().equals(intName)) 
			preExisitingVariable = true;
		
	}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	
	
	for (int i = 0; i < intArrayList.size(); i++) {
		if (intArrayList.get(i).returnName().equals(intName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + intName + " is " + intArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				intArrayList.get(i).changeVal(intValue);
			i = intArrayList.size();
			preExistingInt = true;
		}
	}
	if (preExistingInt == false)
	intArrayList.add(new Integers(intName,intValue,isDeclared));
	intName = intName.replaceAll("int ",""); 
	stringInput = stringInput + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}
private String declaringDecimalWithArithmetic (String stringInput) throws Exception { //works
	String doubleName, doubleValue;
	boolean isDeclared = true;
	boolean preExistingDouble = false;
	boolean preExisitingVariable = false;
	stringInput = stringInput.replace("declare variable decimal", "double");
	stringInput = stringInput.replace(EQUALTO, "=");
	if (stringInput.contains(ADDITION))
		stringInput = stringInput.replaceAll(ADDITION, "+");
	if (stringInput.contains(SUBTRACTION))
		stringInput = stringInput.replaceAll(SUBTRACTION, "-");
	if (stringInput.contains(MULTIPLICATION))
		stringInput = stringInput.replaceAll(MULTIPLICATION, "*");
	if (stringInput.contains(DIVISION))
		stringInput = stringInput.replaceAll(DIVISION, "/");
	if (stringInput.contains(MODULUS))
		stringInput = stringInput.replaceAll(MODULUS, "%");
	String[] parts = stringInput.split(" = "); //int beta = (int) 16 + 14 - 2 % 6
	doubleName = parts[0];
	doubleName = doubleName.replace("double ","");
	doubleValue = parts[1];
		for (int i = 0; i < intArrayList.size(); i++) {
			if (intArrayList.get(i).returnName().equals(doubleName)) 
				preExisitingVariable = true;
			
		}
		for (int i = 0; i < charArrayList.size(); i++) {
			if (charArrayList.get(i).returnName().equals(doubleName)) 
				preExisitingVariable = true;
			
		}
		for (int i = 0; i < booleanArrayList.size(); i++) {
			if (booleanArrayList.get(i).returnName().equals(doubleName)) 
				preExisitingVariable = true;
			
		}
		for (int i = 0; i < stringArrayList.size(); i++) {
			if (stringArrayList.get(i).returnName().equals(doubleName)) 
				preExisitingVariable = true;
			
		}
	if (preExisitingVariable) 
		throw new Exception("This variable name already exists");
	

	for (int i = 0; i < doubleArrayList.size(); i++) {
		if (doubleArrayList.get(i).returnName().equals(doubleName)) {
			Scanner s = new Scanner(System.in);
			System.out.println("The current value of " + doubleName + " is " + doubleArrayList.get(i).returnValue() + ". Are you sure you want to change it?");
			boolean confirm = s.nextBoolean();
			if (confirm)
				doubleArrayList.get(i).changeVal(doubleValue);
			i = doubleArrayList.size();
			preExistingDouble = true;
		}
	}
	if (preExistingDouble == false)
		doubleArrayList.add(new Decimals(doubleName,doubleValue,isDeclared));
	doubleName = doubleName.replaceAll("int ",""); 
	stringInput = stringInput + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}

}
/*
 * © Verbal Coding 2019
 */
