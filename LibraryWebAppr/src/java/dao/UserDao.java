package dao;

import beans.UserBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

        // Сохранение данных пользователя в БД
	public static int save(UserBean bean){
		int status=0;
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_user(id,name,email,password,mobile) values(?,?,?,?,?)");
	ps.setString(1,"1");
                        ps.setString(2,bean.getName());
			ps.setString(3,bean.getEmail());
			ps.setString(4,bean.getPassword());
			ps.setLong(5,bean.getMobile());
			status=ps.executeUpdate();
			con.close();		
		} catch(Exception e){System.out.println(e);}
		return status;
	}
        
        // Изменение данных пользователя в БД
	public static int update(UserBean bean){
		int status=0;
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update e_user set name=?,email=?,password=?,mobile=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4,bean.getMobile());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();
			con.close();			
		} catch(Exception e){System.out.println(e);}		
		return status;
	}
        
        // Просмотр данных пользователя из БД
	public static List<UserBean> view(){
		List<UserBean> list=new ArrayList<UserBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_user");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserBean bean=new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				list.add(bean);
			}
			con.close();			
		} catch(Exception e){System.out.println(e);}		
		return list;
	}
        
        // Просмотр данных пользователя из БД по Id
	public static UserBean viewById(int id){
		UserBean bean=new UserBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_user where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
			con.close();			
		} catch(Exception e){System.out.println(e);}		
		return bean;
	}
        
        // Удаление данных пользователя из БД
	public static int delete(int id){
		int status=0;
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from e_user where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();			
		} catch(Exception e){System.out.println(e);}		
		return status;
	}

        // Авторизация пользователя
	public static boolean authenticate(String email, String password){
		boolean status=false;
		try {
                    Connection con=DB.getCon();
                    PreparedStatement ps=con.prepareStatement("select * from e_user where email=? and password=?");
                    ps.setString(1,email);
                    ps.setString(2,password);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next()){
                        status=true;
                    }
                    con.close();	
		} catch(Exception e){System.out.println(e);}
		return status;
	}
}