import javax.swing.*;

import org.omg.Messaging.SyncScopeHelper;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URISyntaxException;

class Text_Handler extends Frame implements ActionListener {
	JTextField hour, minute, second;
	public int HOUR, MINUTE, SECOND, SUM;
	public String YEAR,MONTH,DATE,SIGAN,BOON;
	JTextField hour_text;
	JTextField minute_text;
	JTextField second_text;
	JTextField year_text,month_text,date_text,sigan_text,boon_text,open_web;
	public String alram,U_R_L;
	public void get_text(JTextField hour, JTextField minute, JTextField second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		return;
	}
	public void get_text(JTextField year_text,JTextField month_text,JTextField date_text,JTextField sigan_text,JTextField boon_text)
	{
		this.year_text=year_text;
		this.month_text=month_text;
		this.date_text=date_text;
		this.sigan_text=sigan_text;
		this.boon_text=boon_text;
		this.open_web=open_web;
		return;
	}
	
	public Text_Handler() {

		JFrame frm = new JFrame("Bonik's program");
		frm.setBounds(120, 100, 120, 80);
		frm.setSize(600, 220);// 초기 프레임 설정
		frm.setLayout(new GridLayout(5,8));
		
		
		/* 첫번째 상단 패널 구성요소들 */
		
		JLabel hour_label = new JLabel("시간 ", SwingConstants.LEFT);
		hour_text = new JTextField(5);
		JLabel minute_label = new JLabel("분 ", SwingConstants.LEFT);
		minute_text = new JTextField(5);
		JLabel second_label = new JLabel("초 ", SwingConstants.LEFT);
		second_text = new JTextField(5);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(one_button);
		//JLabel out_put_time= new JLabel("a++",SwingConstants.RIGHT);
		//panel1.add(out_put_time);

		/* 두번째 패널 구성요소들 */
		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(hour_text);//텍스트 박스
		panel2.add(hour_label);//GUI에서 Syso 같은 존재
		panel2.add(minute_text);
		panel2.add(minute_label);
		panel2.add(second_text);
		panel2.add(second_label);
		panel2.add(set_button);
		panel2.add(un_set_button);
		
		
		/* 세번째 패널 구성요소들 */
		JPanel panel3=new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(two_button);
		
		
		/* 네번째 패널 구성요소들 */
		JPanel panel4=new JPanel();
		panel4.setLayout(new FlowLayout());
		
		year_text=new JTextField(5);
		month_text=new JTextField(5);
		date_text=new JTextField(5);
		sigan_text=new JTextField(5);
		boon_text=new JTextField(5);
		
		panel4.add(year_text);
		JLabel year_label=new JLabel("년 ",SwingConstants.LEFT);
		panel4.add(year_label);
		
		panel4.add(month_text);
		JLabel month_label=new JLabel("월 ",SwingConstants.LEFT);
		panel4.add(month_label);
		
		panel4.add(date_text);
		JLabel date_label=new JLabel("일",SwingConstants.LEFT);
		panel4.add(date_label);
		
		panel4.add(sigan_text);
		JLabel sigan_label=new JLabel("시간 ",SwingConstants.LEFT);
		panel4.add(sigan_label);
		panel4.add(boon_text);
		JLabel boon_label=new JLabel("분 ",SwingConstants.LEFT);
		panel4.add(boon_label);
		panel4.add(set_button2);
		//5번째 패널
		JPanel panel5=new JPanel();
		panel5.setLayout(new FlowLayout());
		panel5.add(sp_button1);
		panel5.add(sp_button2);
		panel5.add(sp_button3);
		/* 패널에 추가되는 패널들 */
		frm.add(panel1, BorderLayout.NORTH);
		frm.add(panel2, FlowLayout());
		frm.add(panel3, FlowLayout());
		frm.add(panel4, BorderLayout.CENTER);
		frm.add(panel5, BorderLayout.SOUTH);
		set_button.addActionListener(this);
		un_set_button.addActionListener(this);
		set_button2.addActionListener(this);
		sp_button1.addActionListener(this);
		sp_button2.addActionListener(this);
		sp_button3.addActionListener(this);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	private Object FlowLayout() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		if (jb == set_button) {// 버튼이 눌릴경우 메소드
			get_text(hour_text, minute_text, second_text);

			System.out.print(hour.getText() + "시간 ");
			System.out.print(minute.getText() + "분 ");
			System.out.println(second.getText() + "초 ");
			if ((minute_text.getText().equals("") && second_text.getText().equals("")))// 시간 값만 들어올 경우
			{
				this.HOUR = Integer.parseInt(hour.getText());
				this.MINUTE = 0;
				this.SECOND = 0;
			}
			else if ((hour_text.getText().equals("") && second_text.getText().equals("")))//분 값만 들어올 경우
			{
				this.HOUR = 0;// String 형을 int 형으로 변환
				this.MINUTE = Integer.parseInt(minute.getText());
				this.SECOND = 0;
			}
			else if (hour_text.getText().equals("") && minute_text.getText().equals(""))// 초 값만 들어올 경우
			{
				this.HOUR = 0;
				this.MINUTE = 0;
				this.SECOND = Integer.parseInt(second.getText());
			}
			
			else if (hour_text.getText().equals(""))// 시간이 빈값일경우
			{
				this.HOUR = 0;
				this.MINUTE = Integer.parseInt(minute.getText());
				this.SECOND = Integer.parseInt(second.getText());
			}
			
			else if (minute_text.getText().equals(""))// 분이 빈값일경우
			{
				this.HOUR = Integer.parseInt(hour.getText());// String 형을 int 형으로 변환
				this.MINUTE = 0;
				this.SECOND = Integer.parseInt(second.getText());
			}
			else if (second_text.getText().equals(""))// 초가 빈값일 경우
			{
				this.HOUR = Integer.parseInt(hour.getText());// String 형을 int//형으로 변환
				this.MINUTE = Integer.parseInt(minute.getText());
				this.SECOND = 0;
			}
			
			else// 3개 다 입력됐을 경우
			{
				this.HOUR = Integer.parseInt(hour.getText());// String 형을 int형으로 변환
				this.MINUTE = Integer.parseInt(minute.getText());
				this.SECOND = Integer.parseInt(second.getText());
			}
			this.HOUR *= 3600;
			this.MINUTE *= 60;
			this.SECOND *= 1;
			this.SUM = this.HOUR + this.MINUTE + this.SECOND;
			TimeSet hello = new TimeSet();
			hello.time += this.SUM;
			
			try {
				hello.Time_Set();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*
			hour.setText("");
			minute.setText("");
			second.setText("");
			*/
		}//설정 버튼이 눌렸을때
		else if (jb == un_set_button) {//해제 버튼이 눌렸을때
			TimeSet ya = new TimeSet();
			ya.Un_time_set();
		}
		else if(jb==set_button2)
		{
			get_text(year_text, month_text, date_text, sigan_text, boon_text);
			Set_alram ha=new Set_alram();
			ha.go_alram=year_text.getText()+"-"+month_text.getText()+"-"+date_text.getText()+" "+sigan_text.getText()+":"+boon_text.getText();
			ha.right_now_time();
			
			
		}
		else if(jb==sp_button1)
		{
			
			try {
			       Desktop.getDesktop().browse(new java.net.URI("http://www.coolenjoy.net/bbs/cboard.php?id=29"));
			 } catch (IOException e1) {
			        e1.printStackTrace();
			    } catch (URISyntaxException e1) {
			        e1.printStackTrace();
			     }
		}
		else if(jb==sp_button2)
		{
			try {
			       Desktop.getDesktop().browse(new java.net.URI("http://www.11st.co.kr"));
			 } catch (IOException e1) {
			        e1.printStackTrace();
			    } catch (URISyntaxException e1) {
			        e1.printStackTrace();
			     }
		}
		else if(jb==sp_button3)
		{
			try {
			       Desktop.getDesktop().browse(new java.net.URI("http://www.gmarket.co.kr/"));
			 } catch (IOException e1) {
			        e1.printStackTrace();
			    } catch (URISyntaxException e1) {
			        e1.printStackTrace();
			     }
		}

		
	}

}
