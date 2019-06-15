package Compiler;

public class Decimals {
	private String decimalName, decimalVal;
	private boolean valDeclared;
	public Decimals (String name,String value,boolean declared) {
		decimalName = name;
		decimalVal = value;
		valDeclared = declared;
	}
	public void changeVal (String newVal) {
		decimalVal = newVal;
		if (decimalVal != null) {
			valDeclared = true;
		}
	}
	public void addVal (String newVal) {
		decimalVal = newVal;
		if (decimalVal != null)
			valDeclared = true;
		}
	public String returnName () {
		return decimalName;
	}
	public String returnValue () {
		return decimalVal;
	}
	public boolean returnIfDeclared () {
		return valDeclared;
	}
	public String toString(){
		return "" + decimalName + " $$ "+ decimalVal + " $$ " + valDeclared;
	}
}
