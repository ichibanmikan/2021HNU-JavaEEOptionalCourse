package dao;

import JavaBean.*;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class userDao {
    public void addUser(user u, DButil dbu){
        String sql = "insert into user(username, password) values(?, ?)";
        Object[] obj = {u.getUserName(),u.getPassword()};
        int res=dbu.executeUpdate(sql,obj);
    }

    public int delUserOnUsername(String username,DButil dbu) throws Exception {
        String sql = "delete from user where username like ?";
        return dbu.executeUpdate(sql,username);
    }

    public void dropTable(DButil dbutil) throws Exception{
        String sql = "drop table user";
        dbutil.executeUpdate(sql);
    }

    public Boolean isHaveUser(Connection con, user oldUser)throws Exception{
        String sql="select * from user where username=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, oldUser.getUserName());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            if(rs.getString("userName")!=null){
                return true;
            }
        }
        return false;
    }


    public user loginUser(Connection con, user anUser)throws Exception{
        user resultAnUser=null;
        String sql="select * from user where username=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, anUser.getUserName());
        pstmt.setString(2, anUser.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            resultAnUser=new user();
            resultAnUser.setUserName(rs.getString("userName"));
            resultAnUser.setPassword(rs.getString("password"));
        }
        return resultAnUser;
    }

//    public List<user> queAll(DButil dbutil) throws Exception {
//        String sql = "select * from user";
//        List<Map<String,Object>> list = dbutil.query(sql);
//        List<user> userList = new ArrayList<>();
//        user anUser = null;
//        for(Map<String,Object> map:list){
//            anUser = new user((String)map.get("username"),(String)map.get("password"));
//            //System.out.println(map.get("username")+" "+map.get("pass"));
//            userList.add(anUser);
//        }
//        return userList;
//    }
}