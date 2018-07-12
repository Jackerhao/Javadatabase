package com.one;
//完成迷你版本的学生管理系统
//查询任务
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class StuManage extends JFrame implements ActionListener{

	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	StuModel sm;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public StuManage() {
		jp1=new JPanel();
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		
		jb1.addActionListener(this);
		jl1=new JLabel("请输入名字");
		
		//把各个空间加入到jp1
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		
		//把各个控件加入到jp2中
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		
		//中间
		//创建StuModel实例对象
		sm=new StuModel();
		//初始化JTable
		jt=new JTable(sm);
		
		//设置表格里的内容居中
		DefaultTableCellRenderer tcr=new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		jt.setDefaultRenderer(Object.class,tcr);
		
		
		jsp=new JScrollPane(jt);
		
		//把jsp放入到JFrame
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
