
import com.mysql.jdbc.Statement;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


//编写一个测试类测试上述代码是否成功
public class TestPropertisread {
    @Test
    public void test() throws SQLException {
        Connection conn = MysqlOperation.getConnection();
        Statement stat = null;
        stat = (Statement) conn.createStatement();
        String sql = "select update_time,create_time from analysis_view limit 10";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            Long update_time = rs.getLong("update_time");
            Long create_time = rs.getLong("create_time");
            String s = Shijiancha.getDistanceTime(update_time, create_time);
            System.out.println(s);

        }
        MysqlOperation.close(conn);
    }
}


