package com.one;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;




public class StuAddDialog extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10;
	JPanel jp1,jp2,jp3;
	
	public StuAddDialog(Frame owner,String title,boolean modal) {
     super(owner,title,modal);
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
     
     jtf1=new JTextField();
     jtf2=new JTextField();
     jtf3=new JTextField();
     jtf4=new JTextField();
     jtf5=new JTextField();
     jtf6=new JTextField();
     jtf7=new JTextField();
     jtf8=new JTextField();
     jtf9=new JTextField();
     jtf10=new JTextField();
     
     jb1=new JButton("添加");
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
     
     jb1.addActionListener(this);
     this.setSize(600,400);
     this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
			StuModel temp=new StuModel();
			String sql="insert into stu values(?,?,?,?,?,?,?,?,?,?)";
			String[] paras= {jtf1.getText(),jtf2.getText(),jtf3.getText()
					,jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText()
					,jtf8.getText(),jtf9.getText(),jtf10.getText()};
			if(!temp.updStu(sql, paras)) {
				//提示信息
				JOptionPane.showMessageDialog(this,"添加失败");
			}
			//关闭对话框
			this.dispose();
			
		}
	}

}
