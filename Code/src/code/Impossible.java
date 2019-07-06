package code;

public class Impossible {

	
	static String smallLetters="abcdefghijklmnopqrstuvwxyz";
	static String capitalLetters=smallLetters.toUpperCase();
	
	static char []smallChar=smallLetters.toCharArray();
	static char[]capitalChar=capitalLetters.toCharArray();
	
	public static char[][] createLayers(String name) {
		int numberOfLayers=name.length();
		char arrayOfArrays[][]=new char[26][numberOfLayers];
		for(int i=0;i<5;i++) {
			arrayOfArrays[i]=capitalChar;
			
		}
		return arrayOfArrays;
	}
	public static void generateChar(char a[]) {
		
	}
	
	public static void searchName(String name) {
		char arrays[]=new char[name.length()];
		String generatedname;
		//create the search layers
		char layers[][]=createLayers(name);
		for(int i=0;i<name.length();i++) {
			for(int j=0;j<layers[i].length;j++) {
				arrays[i]=layers[i][j];
			}
			generatedname=String.valueOf(arrays);
			System.out.println(generatedname);
		}
	}
	public static void main(String[] args) {
		searchName("Kiptoo");
	}

}
