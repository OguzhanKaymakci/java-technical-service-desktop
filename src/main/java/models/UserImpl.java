package models;

import Utils.DB;


import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserImpl implements IUser{

    public static String name = "";
    public static int uid = 0;
    DB db= new DB();

    @Override
    public boolean userLogin(String email, String password) {
        boolean status= false;
        try {
            String sql="select * from user where email=? and password=?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1,email);
            pre.setString(2,password);
            ResultSet rs= pre.executeQuery();
            status= rs.next();
            if(status){
                name = rs.getString("name")+" "+rs.getString("surname");
                uid =rs.getInt("uid");
            }
        }catch (Exception ex){
            System.out.println("login error"+ex);

        }finally {
            db.close();

        }return status;
    }
}
