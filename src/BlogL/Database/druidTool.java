package BlogL.Database;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druidTool {

    private static DataSource DATA_SOURCE = null;

    private static synchronized DataSource dataSource() throws Exception
    {
        if(DATA_SOURCE==null)
        {
            Properties properties=new Properties();
            InputStream druidInputStream = druidTool.class.getClassLoader().getResourceAsStream("druid.properties");
            //System.out.println(druidInputStream.toString());
            //System.out.println("dT");
            properties.load(druidInputStream);
            DATA_SOURCE = DruidDataSourceFactory.createDataSource(properties);
        }
        return DATA_SOURCE;
    }

    public static Connection connection()
    {
        try {
            return dataSource().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
