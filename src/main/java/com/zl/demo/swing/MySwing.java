package com.zl.demo.swing;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MySwing {

	public static void main(String[] args) {
		
		JComponent p3 = jFrameDemo().getLayeredPane();
		System.out.println(p3.getComponents().length);
		//showConfirmDialog(jFrameDemo(), "您确定吗?");
	}
	
	private static JFrame  jFrameDemo() {
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(100, 100, 400, 200);
		frame.setTitle("JFrame");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}
	
	private static void showMessageDialog(Component parent, String messsgage) {
		JOptionPane.showMessageDialog(parent, "信息",messsgage, JOptionPane.WARNING_MESSAGE);
	}
	
	private static void showConfirmDialog(Component parent,String message) {
		JOptionPane.showConfirmDialog(parent, message, "确认框", JOptionPane.OK_CANCEL_OPTION);
	}
}
