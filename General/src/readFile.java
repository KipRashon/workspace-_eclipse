import java.io.*;


public class readFile{
	public static void main(String args[]) throws Exception {
		File f= new File("C:\\Users\\Rashon\\Documents\\study\\material_science.txt");
		//File f= new File("F:\\Kapkenda.docx");
		FileReader st= new FileReader(f);
		BufferedReader br=new BufferedReader(st);
		String line;
		while((line=br.readLine())!=null) {
			animate(line);
			System.out.println();
			Thread.sleep(1000);
		}
		
		
	}
	public static void animate(String line) {
		String splitted[]=line.split(" ");
		for(int i=0;i<splitted.length;i++) {
			System.out.print(splitted[i]+" ");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}