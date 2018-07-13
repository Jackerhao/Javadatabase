package com.one;


import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.JDialog;

public class StuUpdDialog extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10;
	JPanel jp1,jp2,jp3;
	
	//owner 父窗口
	//title 窗口名
	//modal 指定是模式窗口，还是非模式的窗口
	public StuUpdDialog(Frame owner,String title,boolean modal,StuModel sm,int rowNums) {
		
		super(owner,title,modal);//调用父类构造方法，达到模式对话框效果
		jl1=new JLabel("学号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("性别");
		jl4=new JLabel("年龄");
		jl5=new JLabel("系别");
		jl6=new JLabel("班级");
		jl7=new JLabel("c语言成绩");
		jl8=new JLabel("java语言成绩");
		jl9=new JLabel("数据库成绩");
		jl10=new JLabel("jsp成绩");
		//
		jtf1=new JTextField();
		//初始化数据
		jtf1.setText((String)sm.getValueAt(rowNums,0));
		//让jtf1不能修改
		jtf1.setEditable(false);
		jtf2=new JTextField();
		jtf2.setText((String)sm.getValueAt(rowNums,1));
		jtf3=new JTextField();
		jtf3.setText((String)sm.getValueAt(rowNums,2));
		jtf4=new JTextField();
		jtf4.setText(sm.getValueAt(rowNums,3).toString());
		jtf5=new JTextField();
		jtf5.setText((String)sm.getValueAt(rowNums,4));
		jtf6=new JTextField();
		jtf6.setText((String)sm.getValueAt(rowNums,5));
		jtf7=new JTextField();
		jtf7.setText(sm.getValueAt(rowNums,6).toString());
		jtf8=new JTextField();
		jtf8.setText(sm.getValueAt(rowNums,7).toString());
		jtf9=new JTextField();
		jtf9.setText(sm.getValueAt(rowNums,8).toString());
		jtf10=new JTextField();
		jtf10.setText(sm.getValueAt(rowNums,9).toString());
		
		jb1=new JButton("修改");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(10,1));
		jp2.setLayout(new GridLayout(10,1));
		
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		jp1.add(jl9);
		jp1.add(jl10);
	
		
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		jp2.add(jtf9);
		jp2.add(jtf10);
		
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		
		
		this.setSize(600,400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
		
			String sql="update stu set name=?,sex=?,age=?,profession=?,classis=?,cscore=?,javascore=?,dbscore=?,jspscore=? "
	    			+ "where id=?";
			String []paras= {jtf2.getText(),
					jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf8.getText()
					,jtf9.getText(),jtf10.getText(),jtf1.getText()};
			StuModel temp=new StuModel();
			temp.updStu(sql, paras);
			this.dispose();
		}
	}
}

