package BlogL.Utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class stringUtils {

    public static boolean isEmpty(String str)
    {
        if (str==null||str.trim().equals(""))
            return true;
        return false;
    }

    public static String cutingString(String str,int begin,int end)
    {
        if (str.length()<end||str.length()<begin)
            return str;
        return str.substring(begin,end);
    }

    //解码 解决在url传中文值出现乱码的问题
    public static String pareCode(String str) throws UnsupportedEncodingException
    {
        return new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
