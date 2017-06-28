
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

public class Set_alram{
	public String time = "드닫", go_alram,URL;
	public void right_now_time() {

		while (true) {
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String Refresh_Date = sdf.format(dt);
			if (Refresh_Date.equals(this.go_alram)) {
				run_time();
				break;
			}
			try {//1초 기다렸다가 다시 시간 갱신
				Thread.sleep(1000 * 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Refresh_Date);
			System.out.println(this.go_alram);
		}
	}

	public String want_time = "";

	public void set_date() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String Refresh_Date = sdf.format(dt);
	}

	public void Set_alram() {

		Scanner sc = new Scanner(System.in);
		System.out.println("연도 설정");
		String want_year = sc.next();
		System.out.println("달 설정");
		String want_month = sc.next();
		System.out.println("일 설정");
		String want_date = sc.next();
		System.out.println("시 설정");
		String want_hour = sc.next();
		System.out.println("분 설정");
		String want_minute = sc.next();
		want_time = want_year + "-" + want_month + "-" + want_date + " " + want_hour + ":" + want_minute;
	}

	public void run_time() {
		Sound alal = new Sound("C:\\박수소리.wav", false);
		System.out.println("알람이 울립니다~");
		
		  
		


	}

	public void openBrower(String url) {
		String addr = "http://www.naver.com";
		Process process = null;
		String[] cmd = new String[] { "rundll32", "url.dll", "FileProtocolHandler", url };
		String str = null;

		try {

			// 프로세스 빌더를 통하여 외부 프로그램 실행
			process = new ProcessBuilder(cmd).start();

			// 외부 프로그램의 표준출력 상태 버퍼에 저장
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// 표준출력 상태를 출력
			while ((str = stdOut.readLine()) != null) {
				System.out.println(str);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
