package dao;

import JavaBean.*;
import util.DButil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class managerDao {
    public void addMgnr(manager mngr, DButil dbu){
        String sql = "insert into mgnr(mngrname,password) values(?, ?)";
        Object[] obj = {mngr.getMngrName(),mngr.getPassword()};
        int res=dbu.executeUpdate(sql,obj);
    }

    public int delMngrOnMngrname(String mngrname,DButil dbu) throws Exception {
        String sql = "delete from mngr where mngrname like ?";
        return dbu.executeUpdate(sql,mngrname);
    }

    public void dropTable(DButil dbutil) throws Exception{
        String sql = "drop table mngr";
        dbutil.executeUpdate(sql);
    }

    public manager loginMngr(Connection con,manager mngr)throws Exception{
        manager resultMngr=null;
        String sql="select * from mngr where mngrname=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, mngr.getMngrName());
        pstmt.setString(2, mngr.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            resultMngr=new manager();
            resultMngr.setMngrName(rs.getString("mngrname"));
            resultMngr.setPassword(rs.getString("password"));
        }
        return resultMngr;
    }

//    public List<manager> queAll(DButil dbutil) throws Exception {
//        String sql = "select * from mngr";
//        List<Map<String,Object>> list = dbutil.query(sql);
//        List<manager> mngrList = new ArrayList<>();
//        manager anMngr = null;
//        for(Map<String,Object> map:list){
//            anMngr = new manager((String)map.get("mngrname"),(String)map.get("password"));
//            //System.out.println(map.get("username")+" "+map.get("pass"));
//            mngrList.add(anMngr);
//        }
//        return mngrList;
//    }
}