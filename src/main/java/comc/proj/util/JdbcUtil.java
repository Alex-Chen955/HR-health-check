package comc.proj.util;
/**
 * 封装JDBC工具类
 * 简化JDBC编程
 */

import java.sql.*;


public class JdbcUtil {
    Connection con=null;
    PreparedStatement ps=null;
    final String URL="jdbc:mysql://localhost:3306/healthcheck";
    final String USERNAME="root";
    final String PASSWORD="123456";
    /*
    工具类的工作方法都是私有的
        工具类中的构造方法都是私有的
        因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用
     */
    public JdbcUtil(){

    }
    //静态代码块在类加载时执行，并且只执行一次
    static {
        try{
                Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
    获取数据库连接对象
   返回连接对象
     */
    public  Connection getCon() {
        try{
            con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return con;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return con;

    }
    public PreparedStatement createStatement(String sql){
        try{
            ps=getCon().prepareStatement(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ps;
    }

    public  void close(){
		/*
		关闭资源
		 */
        if(con!=null){
            try{
                con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try{
                ps.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    public  void close(ResultSet rs){
		/*
		关闭资源
		 */
        if(con!=null){
            try{
                con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try{
                ps.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try{
                rs.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

//	public static void main(String[] args) {
//		Connection conn=null;
//		Statement stmt=null;
//		ResultSet rs=null;
//		final String URL="jdbc:mysql://localhost:3306/ExamSystem";
//		final String USERNAME="root";
//		final String PASSWORD="123456";
//		//将jar包中
//
//		try {
//			//1.register the driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			//2.get connection
//			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
//			//3. get database operating object
//			stmt=conn.createStatement();
//			//4.execute sql
//			String sql="select * from view_130";
//			rs = stmt.executeQuery(sql);
//			//5. process the resultset
//			while(rs.next()) {
//				String moduleid=rs.getString(1);
//				String studentid=rs.getString(2);
//				String studentgender=rs.getString(3);
//				System.out.println(moduleid+", "+studentid+", "+studentgender);
//			}
//
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			//6. release the resources
//			if(rs!=null) {
//				try {
//					rs.close();
//				}
//				catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//			if(stmt!=null) {
//				try {
//					stmt.close();
//				}
//				catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//			if(conn!=null) {
//				try {
//					conn.close();
//				}
//				catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}
//
//
//
//
//
//
//	}

}
