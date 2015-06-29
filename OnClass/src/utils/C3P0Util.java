package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {

	private static DataSource ds =new ComboPooledDataSource();
	
	/**
	 * ���ڴӳ��л�ȡ����
	 * @return
	 */
	public static synchronized Connection getConneciton(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ���ڻ�ȡһ�����Դ
	 * @return
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	//�ر���Դ
	public static void release(ResultSet rs,Statement st,Connection con ){
		try {
			if(rs!=null){
			    rs.close();
			    rs=null;//Ŀ�����û��������������������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(st!=null){
				st.close();
				st=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
