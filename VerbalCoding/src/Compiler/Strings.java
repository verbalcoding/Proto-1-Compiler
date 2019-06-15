package Compiler;

public class Strings {
	private String stringName, stringVal;
	private boolean valDeclared;
	public Strings (String name,String value,boolean declared) {
		stringName = name;
		stringVal = value;
		valDeclared = declared;
	}
	public void changeVal (String newVal) {
		stringVal = newVal;
		if (stringVal != null) {
			valDeclared = true;
		}
	}
	public void addVal (String newVal) {
		stringVal = newVal;
		if (stringVal != null)
			valDeclared = true;
		}
	public String returnName () {
		return stringName;
	}
	public String returnValue () {
		return stringVal;
	}
	public boolean returnIfDeclared () {
		return valDeclared;
	}
	public String toString(){
		return "" + stringName + " $$ "+ stringVal + " $$ " + valDeclared;
	}
}
