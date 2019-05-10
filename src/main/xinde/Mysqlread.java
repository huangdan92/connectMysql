import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;


//编写mysql.properties读取属性类Mysqlread.java，负责读取mysql.properties中的属性名称
public class Mysqlread {

    public static final String[] message = readurl();


    private static String[] readurl() {
        Properties prop = new Properties();
        String[] message = new String[4];
        int i = 0;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/db.properties"));
            prop.load(in);
            message[0] = prop.getProperty("jdbc.driver");
            message[1] = prop.getProperty("jdbc.url");
            message[2] = prop.getProperty("jdbc.username");
            message[3] = prop.getProperty("jdbc.password");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return message;
    }
}