package thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NumFile {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Num> al = new ArrayList<>();
		
		System.out.println(LocalDateTime.now());
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Aiden\\Documents\\Test\\Test\\src\\struct\\List_Sample.txt"));
        String str;

        while ((str = in.readLine()) != null) {
            String words[] = str.split("\t");
            Num g = new Num(Integer.parseInt(words[0]),Integer.parseInt(words[1]));
            al.add(g);
        }
        in.close();
		
		System.out.println(LocalDateTime.now());
	}


}

class Num {
	int numA;
	int numB;
	public Num(int parseInt, int parseInt2) {
		// TODO Auto-generated constructor stub
	}
	
	public int getNumA() {
		return numA;
	}
	public void setNumA(int numA) {
		this.numA = numA;
	}
	public int getNumB() {
		return numB;
	}
	public void setNumB(int numB) {
		this.numB = numB;
	}
	
}
