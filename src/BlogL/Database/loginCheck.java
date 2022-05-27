package BlogL.Database;

import BlogL.Model.userBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class loginCheck {
    private static loginCheck BLOG_SQL_CHECK;
    public static synchronized loginCheck instance()
    {
        if(BLOG_SQL_CHECK==null)
            BLOG_SQL_CHECK=new loginCheck();
        return BLOG_SQL_CHECK;
    }
    /*
    注册账号
    查找用户名是否存在
     */
    public boolean isUserName(String userName)throws Exception
    {
        String sql="SELECT * FROM user WHERE user_name=?";
        try(Connection conn=druidTool.connection(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1,userName);//其为sql中第1个属性
            ResultSet res=ps.executeQuery();//执行sql
            if(res.next())
            {
                return true;
            }
        }
        return false;
    }

    /*
    查找账号id是否存在
     */
    public boolean isUserId(String userId) throws Exception
    {
        String sql="SELECT * FROM user WHERE user_id=?";

        try(Connection conn=druidTool.connection(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1,userId);//其为sql中第1个属性
            ResultSet res=ps.executeQuery();//执行sql
            if(res.next())
            {
                return true;
            }
        }
        return false;
    }

    public void register(userBean userBeanData) throws Exception
    {
        String sql="INSERT INTO user values(?,?,?,?)";
        try(Connection conn=druidTool.connection();PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1,userBeanData.getUserID());
            ps.setString(2,userBeanData.getUserName());
            ps.setString(3,userBeanData.getUserPassword());
            ps.setString(4,userBeanData.getUserProfileImgUrl());
            int result=ps.executeUpdate();
            if(result<1)
            {
              throw new RuntimeException("添加账户信息失败(LC_register)");
            }
        }
    }

    /*
    查找所有的账号匹配的账号密码（登陆确认）
     */
    public static userBean loginMatch(String userId, String password) throws Exception
    {
        String sql="SELECT * FORM user";
        userBean userBeanData=null;
        try(Connection conn=druidTool.connection();PreparedStatement ps=conn.prepareStatement(sql);ResultSet res=ps.executeQuery();)
        {
            while (res.next())
            {
                if(res.getString("user_id").equals(userId)&&res.getString("user_password").equals(password))
                {
                    userBeanData=new userBean(res.getString("user_id"),res.getString("user_name"),res.getString("user_password"),res.getString("user_profile_img"));
                    break;
                }
            }
        }
        return userBeanData;
    }

    public void updateProfile(String userId,String newFileName) throws Exception
    {
        String sql="UPDATE user SET 'user_profile_img'=? WHERE user_name=?";
        try (Connection conn=druidTool.connection();PreparedStatement ps= conn.prepareStatement(sql))
        {
            ps.setString(1,newFileName);
            ps.setString(2,userId);
            int result=ps.executeUpdate();
            if(result<1)
            {
                throw new RuntimeException("更新头像失败(LC_updateProfile)");
            }
        }
    }

    public boolean updatePersonalData(userBean userBeanData,String userName,String profileImgUrl) throws Exception
    {
        if(!isUserNameExist(userBeanData.getUserID(),userName))
        {
            return false;
        }
        String sql="UPDATE user SET 'user_name'=?, 'user_profile_img'=? WHERE 'user_name'=?";
        try(Connection conn=druidTool.connection();PreparedStatement ps= conn.prepareStatement(sql))
        {
            ps.setString(1,userName);
            ps.setString(2,profileImgUrl);
            ps.setString(3,userBeanData.getUserID());
            int result=ps.executeUpdate();
            if(result<1)
            {
                throw new RuntimeException("个人资料更新失败(LC_updatePersonData)");
            }
        }
        return true;
    }

    public boolean isUserNameExist(String userId,String userName) throws Exception
    {
        String sql="SELECT * FROM user WHERE user_name=?";
        try(Connection conn=druidTool.connection();PreparedStatement ps= conn.prepareStatement(sql))
        {
            ps.setString(1,userName);
            ResultSet res= ps.executeQuery();
            if(res.next())
            {
                return res.getString("user_id").equals(userId);
            }
        }
        return true;
    }

    public userBean findUserByUserId(String userId) throws Exception
    {
        String sql="SELECT * FROM user WHERE user_id=?";
        userBean userBeanData=null;
        try(Connection conn=druidTool.connection();PreparedStatement ps= conn.prepareStatement(sql))
        {
            ps.setString(1,userId);
            ResultSet res=ps.executeQuery();
            while (res.next())
            {
                userBeanData=new userBean(res.getString("user_id"),res.getString("user_name"),res.getString("user_password"),res.getString("user_profile_img"));
            }
        }
        return userBeanData;
    }

    public userBean findUserByUserName(String userName) throws Exception
    {
        String sql="SELECT * FROM user WHERE user_name=?";
        userBean userBeanData=null;
        try(Connection conn=druidTool.connection();PreparedStatement ps= conn.prepareStatement(sql))
        {
            ps.setString(1,userName);
            ResultSet res=ps.executeQuery();
            while (res.next())
            {
                userBeanData=new userBean(res.getString("user_id"),res.getString("user_name"),res.getString("user_password"),res.getString("user_profile_img"));
            }
        }
        return userBeanData;
    }

    public List<userBean> findAllUser() throws Exception
    {
        String sql="SELECT * FROM user";
        List<userBean> userBeansData=null;
        try(Connection conn=druidTool.connection();PreparedStatement ps= conn.prepareStatement(sql))
        {
            ResultSet res=ps.executeQuery();
            userBeansData=new ArrayList<>();
            while (res.next())
            {
                userBeansData.add(new userBean(res.getString("user_id"),res.getString("user_name"),res.getString("user_password"),res.getString("user_profile_img")));
            }
        }
        return userBeansData;
    }
}
