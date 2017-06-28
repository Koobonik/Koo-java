

import java.io.*;
import java.util.Scanner;

public class TimeSet extends Exception {
	Scanner sc = new Scanner(System.in);

	public String time = "shutdown -s -t ";
	public String cancel = "shutdown -a";

	public void Time_Set() throws IOException {
		System.out.println("예약 종료 타이머를 설정해주세요:");
		try {
			//String set_time = sc.nextLine();
			//this.time += set_time;
			Runtime rt = Runtime.getRuntime();

			rt.exec(new String[] { "cmd.exe", "/c", this.time });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Un_time_set() {
		System.out.println("예약종료를 취소합니다.");
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec(new String[] { "cmd.exe", "/c", cancel });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
