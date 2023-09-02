package comc.proj.dao;

import comc.proj.entity.Users;
import comc.proj.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private JdbcUtil util=new JdbcUtil();
    //Creating a new account
    public int add(Users user){
        int result=0;
        String sql="insert into information (companyName,businessSector,numberOfEmployees,companyLocation,contactName,contactJobTitle,"+
                "contactEmail,contactTelephone,userName,password) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=util.createStatement(sql);
        try {
            ps.setString(1,user.getCompanyName());
            ps.setString(2,user.getBusinessSector());
            ps.setString(3,user.getNumberOfEmployees());
            ps.setString(4,user.getCompanyLocation());
            ps.setString(5,user.getContactName());
            ps.setString(6,user.getContactJobTitle());
            ps.setString(7,user.getContactEmail());
            ps.setString(8, user.getContactTelephone());
            ps.setString(9,user.getUserName());
            ps.setString(10,user.getPassword());
            result=ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            util.close();
        }
return result;
    }
    //the function of login
    public int logIn(String userName, String password){
        String sql="select count(*) from information where userName=? and password=?";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet rs=null;
        int result=0;
        try{
            ps.setString(1,userName);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while(rs.next()){
                result=rs.getInt("count(*)");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            util.close(rs);
        }
        return result;
    }



}
