package BlogL.Tool;

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
            properties.load(druidInputStream);
            DATA_SOURCE = DruidDataSourceFactory.createDataSource(properties);
        }
        return DATA_SOURCE;
    }

    public static Connection connection() throws Exception
    {
        return dataSource().getConnection();
    }
}
