package com.one;

//完成迷你版本的学生管理系统
//查询任务

import javax.swing.*;
import javax.swing.table.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


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
 StuManage stumanage=new StuManage();
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
		
		//把各个控件加入到jp2
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		
		//中间
		//创建StuModel实例对象
		sm=new StuModel();
	   //初始化JTable
	 	jt=new JTable(sm);
	 	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	 	tcr.setHorizontalAlignment(SwingConstants.CENTER);//设置表格里的内容居中
	 	jt.setDefaultRenderer(Object.class, tcr);
	 	//初始化jsp JScrollPane
	 	jsp=new JScrollPane(jt);
	 	
	 	//把jsp放入到JFrame
	 	
	 	this.add(jp1,"North");
	 	this.add(jsp);
	 	this.add(jp2,"South");
	 	this.setSize(800,400);
	 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断哪个按钮被点击
		if(e.getSource()==jb1) {
			System.out.println("用户想要查询");
			if(this.jtf.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "不能为空");
				return ;
			}
			String name=this.jtf.getText().trim();//trim有过滤作用
			//写一个sql语句
			//因为把对表的数据封装到StuModel
			String sql = "select * from stu where name='"+name+"'";
			sm=new StuModel(sql);
			//更新JTable
			jt.setModel(sm);
			
		}
		//当用户点击添加
		else if(e.getSource()==jb2) {
			StuAddDialog sa=new StuAddDialog(this,"添加",true);//this是父窗口
			 sm=new StuModel();
			//更新JTable
			jt.setModel(sm);
					
		}else if(e.getSource()==jb3) {
			int rowNum=this.jt.getSelectedRow();
			
			if(rowNum==-1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			System.out.println("===="+rowNum);
			new StuUpdDialog(this,"修改学生",true,sm,rowNum);
			//构建新的数据模型类，并更新
			sm=new StuModel();
			//更新JTable
			jt.setModel(sm);
		}
		else if(e.getSource()==jb4) {
		//说明用户希望删除记录
			//得到该学生的id
			//getSelectedRow会返回用户点中的行
			//如果该用户一行都没有选择，就返回-1
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1) {
				//提示框
				JOptionPane.showMessageDialog(this, "请重新选择一行");
				return ;//到主函数去
			}
			//得到学生编号
			String stuId=(String)sm.getValueAt(rowNum,0);
			
			String sql="delete from stu where id=?";
			String[] paras= {stuId};
			StuModel temp=new StuModel();
			temp.updStu(sql, paras);
			
		
			//更新数据
			 sm=new StuModel();
				//更新JTable
				jt.setModel(sm);
		}
		
	}

}

