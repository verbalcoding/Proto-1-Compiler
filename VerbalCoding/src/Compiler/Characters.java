package Compiler;

public class Characters {
	private String characterName, characterVal;
	private boolean valDeclared;
	public Characters (String name,String value,boolean declared) {
		characterName = name;
		characterVal = value;
		valDeclared = declared;
	}
	public void changeVal (String newVal) {
		characterVal = newVal;
		if (characterVal != null) {
			valDeclared = true;
		}
	}
	public void addVal (String newVal) {
		characterVal = newVal;
		if (characterVal != null)
			valDeclared = true;
		}
	public String returnName () {
		return characterName;
	}
	public String returnValue () {
		return characterVal;
	}
	public boolean returnIfDeclared () {
		return valDeclared;
	}
	public String toString(){
		return "" + characterName + " $$ "+ characterVal + " $$ " + valDeclared;
	}
}
