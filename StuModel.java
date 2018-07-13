package com.one;


//mode1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.table.AbstractTableModel;

//这是我的一个stu表的模型
public class StuModel extends AbstractTableModel{

	
	Vector rowData;
	//columnName存放列名
	Vector columnNames;
	
	
PreparedStatement ps=null;
ResultSet rs=null;
Connection ct=null;
private static String driver ="com.mysql.cj.jdbc.Driver";
private static String url = "jdbc:mysql://localhost/student?useSSL=FALSE&serverTimezone=UTC";
private static String user = "root";
private static String password = "switch";
//添加学生
public boolean updStu(String sql,String []paras) {
	   boolean b=true;
	
		
		   try {
			   Class.forName(driver);
		    	ct= DriverManager.getConnection(url,user,password);
		    	
				ps=ct.prepareStatement(sql);
				//rs=ps.executeQuery();
				
			//给参数赋值	
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1,paras[i]);
			}
			//4.执行操作
			if(ps.executeUpdate()!=1) {
				b=false;
			}
			
			
			} catch(Exception ex) {
				b=false;
				ex.printStackTrace();
			}
		   finally {
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
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
	   return b;
}
	
public StuModel() {
	   this.init("");
}

public StuModel(String sql) {
	   this.init(sql);
}



//做一个构造函数，用于初始化我们的数据模型
public void init(String sql) {
	
	   if(sql.equals("")){
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
	    	Class.forName(driver);
	    	ct= DriverManager.getConnection(url,user,password);
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
		    	
		    	
		    	//加入到rowData
		    	rowData.add(hang);	 
			}
		} catch (Exception e) {
			// TODO: handle exception
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
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
}

	//得到共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	//得到共有多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	//得到某行某列的数据
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

}
