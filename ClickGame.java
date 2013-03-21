import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickGame extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;

	private static int M = 20;

	private static int N = 20;

	private JFrame mainFrame;

	private JPanel panel;

	private static JButton clickButton;

	private static int init;

	private ArrayList<JButton> disButton = new ArrayList<JButton>();

	private void init() {
		mainFrame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new GridLayout(M, N));
		clickButton = new JButton("hehe！");
		clickButton.addMouseListener(this);
		panel.add(clickButton);
		disButton.add(clickButton);
		init = 0;
		JButton temp = null;
		for (int i = 1; i < M * N; i++) {
			temp = new JButton();
			disButton.add(temp);
			temp.setVisible(false);
			panel.add(temp);
			temp = null;
		}
		mainFrame.add(panel);
		mainFrame.setSize(500, 500);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ClickGame().init();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		Random random = new Random();
		int nextRandom;
		boolean flag = true;
		while (flag) {
			nextRandom = random.nextInt(100);
			if (nextRandom != init) {
				init = nextRandom;
				flag = false;
			}
		}
		clickButton.setLocation(disButton.get(init).getLocation().x, disButton
				.get(init).getLocation().y);
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
