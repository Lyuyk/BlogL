package BlogL.Database;

import BlogL.Model.userBean;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class registerCheck {

    public static boolean check(userBean userBeanData) throws Exception
    {
        return !userBeanData.getUserName().isEmpty() && !userBeanData.getUserPassword().isEmpty();
    }

    public static void register(userBean userBeanData) throws Exception
    {
        String sql="INSERT INTO user (user_name, user_password) values(?,?)";
        try(Connection conn=druidTool.connection(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            //ps.setString(1,userBeanData.getUserID());
            ps.setString(1,userBeanData.getUserName());
            ps.setString(2,userBeanData.getUserPassword());
            //ps.setString(4,userBeanData.getUserProfileImgUrl());
            int result=ps.executeUpdate();
            if(result<1)
            {
                throw new RuntimeException("添加账户信息失败(RC_register)");
            }
        }
    }
}
