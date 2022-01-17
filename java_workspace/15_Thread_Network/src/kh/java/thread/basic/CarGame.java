package kh.java.thread.basic;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame{
	private JLabel car1;
	private JLabel car2;
	private JLabel car3;
	private int rank=1;
	
	public CarGame(){
		setSize(601,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		car1 = new JLabel(new ImageIcon("images/car1.gif"));
		car2 = new JLabel(new ImageIcon("images/car2.gif"));
		car3 = new JLabel(new ImageIcon("images/car3.gif"));
		
		//출발신호를 알릴 깃발아이콘
		//리사이즈해서 추가해본다.
		//Image java.awt.Image.getScaledInstance(int width, int height, int hints)
		ImageIcon flag = new ImageIcon("images/racingFlag.png");
		ImageIcon resizedFlag = new ImageIcon(flag.getImage().getScaledInstance(51, 50, Image.SCALE_DEFAULT));
		JLabel race = new JLabel(resizedFlag);

		car1.setSize(100,100);
		car2.setSize(100,100);
		car3.setSize(100,100);
		race.setSize(100,100);
		
		car1.setLocation(10, 10);
		car2.setLocation(10, 60);
		car3.setLocation(10, 110);
		race.setLocation(110, -30);
		
		car1.setVisible(false);
		car2.setVisible(false);
		car3.setVisible(false);
		race.setVisible(false);
		
		add(car1);
		add(car2);
		add(car3);
		add(race);
		
		setVisible(true);

		delay(1000);
		car1.setVisible(true);
		delay(1000);
		car2.setVisible(true);
		delay(1000);
		car3.setVisible(true);
		delay(1000);
		getContentPane().setBackground(Color.GREEN);
		
		
		Thread th1 = new MyThread(car1);
		Thread th2 = new MyThread(car2);
		Thread th3 = new MyThread(car3);
		
		race.setVisible(true);
		th1.start();
		th2.start();
		th3.start();
	}
	
	private void delay(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CarGame();
	}
	
	private class MyThread extends Thread {
		private JLabel car;
		//생성자 접근제한자가 private이지만, 외부클래스에서 접근가능.
		private MyThread(JLabel car){
			this.car = car;
		}
		
		@Override
		public void run(){
			while(true){
				delay(100);
				if(car.getX() > 450) {
//					car.setText(String.valueOf(rank++));//같은 등수가 나올수 있음.
					car.setText(getRank());
					System.out.println(car.getIcon());
					break;
				}
				car.setLocation(car.getX()+(int)(Math.random()*10+1), car.getY());
			}
		}
	}

	private synchronized String getRank() {
		return String.valueOf(rank++);
	}

}