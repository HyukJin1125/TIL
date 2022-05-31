package submit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class submit02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileOut = "/home/pc23/test/test.txt";
		
		File test = new File(fileOut);
		try(FileOutputStream fos = new FileOutputStream(test, true);) {
		
			System.out.println("저장하실 문자열을 입력해주세요.");
			System.out.print(">>>");
			String text = sc.nextLine();
			
			fos.write(text.getBytes());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
