package Compiler;

public class Integers {
	private String intName, intVal;
	private boolean valDeclared;
	public Integers (String name,String value,boolean declared) {
		intName = name;
		intVal = value;
		valDeclared = declared;
	}
	public void changeVal (String newVal) {
		intVal = newVal;
		if (intVal != null) {
			valDeclared = true;
		}
	}
	public void addVal (String newVal) {
		intVal = newVal;
		if (intVal != null)
			valDeclared = true;
		}
	public String returnName () {
		return intName;
	}
	public String returnValue () {
		return intVal;
	}
	public boolean returnIfDeclared () {
		return valDeclared;
	}
	public String toString(){
		return "" + intName + " $$ "+ intVal + " $$ " + valDeclared;
	}
}
