package com.one;

import java.sql.*;
import java.util.*;

import javax.swing.table.AbstractTableModel;

public class StuModel extends AbstractTableModel{

	Vector rowData;//一行的数据
	Vector columnNames;//存放列名
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection ct=null;
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/student?useSSL=FALSE&serverTimezone=UTC";
	private static String user="root";
	private static String password="switch";
	
	public StuModel() {
		this.init("");
	}
	public StuModel(String sql) {
		this.init(sql);
	}
	//做一个用于初始化我们的数据模型
	public void init(String sql) {
		if(sql.equals("")) {
			sql="select * from stu";
		}
		columnNames=new Vector();
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("系别");
		columnNames.add("班级");
		columnNames.add("c语言成绩");
		columnNames.add("java语言成绩");
		columnNames.add("数据库成绩");
		columnNames.add("jsp成绩");
		rowData=new Vector();
		try {
			ct=DriverManager.getConnection(url,user,password);
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getDouble(7));
				hang.add(rs.getDouble(8));
				hang.add(rs.getDouble(9));
				hang.add(rs.getDouble(10));
				
				rowData.add(hang);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(ct!=null) {
					ct.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	//得到共有多少列
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	//得到共有多少行
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	//得到某行某列的数据
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}
	public String getColumName(int column) {
		return (String)this.columnNames.get(column);
	}

}
