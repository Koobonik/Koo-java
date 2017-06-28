
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame {
	JFrame frame = new JFrame("Bonik's Program");
	static JButton set_button = new JButton("설정");
	static JButton un_set_button = new JButton("해제");
	static JButton one_button = new JButton("예약 종료 프로그램");
	static JButton two_button=new JButton("알림 프로그램");
	static JButton set_button2=new JButton("알림 등록");
	static JButton sp_button1=new JButton("쿨엔조이");
	static JButton sp_button2=new JButton("11 번가");
	static JButton sp_button3=new JButton("G 마켓");
	public void createFrame() {
		frame.setBounds(120, 120, 400, 200);
		frame.setLayout(new FlowLayout());

		frame.add(set_button);
		frame.add(un_set_button);
		frame.add(one_button);

		frame.setSize(400, 400);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
