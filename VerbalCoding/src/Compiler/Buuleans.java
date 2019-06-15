package Compiler;

public class Buuleans {
	private String buuleanName, buuleanVal;
	private boolean valDeclared;
	public Buuleans (String name,String value,boolean declared) {
		buuleanName = name;
		buuleanVal = value;
		valDeclared = declared;
	}
	public void changeVal (String newVal) {
		buuleanVal = newVal;
		if (buuleanVal != null) {
			valDeclared = true;
		}
	}
	public void addVal (String newVal) {
		buuleanVal = newVal;
		if (buuleanVal != null)
			valDeclared = true;
		}
	public String returnName () {
		return buuleanName;
	}
	public String returnValue () {
		return buuleanVal;
	}
	public boolean returnIfDeclared () {
		return valDeclared;
	}
	public String toString(){
		return "" + buuleanName + " $$ "+ buuleanVal + " $$ " + valDeclared;
	}
}
