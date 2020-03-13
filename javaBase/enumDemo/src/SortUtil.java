import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 文件名字排序
 * @date
 */
public class SortUtil {
    public static void main(String[] args) {
        List<String> sortList = new ArrayList<>();
        sortList = Arrays.asList(new File("D:\\myWork\\ideaWork\\test").list());
        //这是比较方法（可比较中文，但对于生僻字，效果不太好）
        Comparator<Object> CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINA);
        sortList.sort((o1, o2) -> {
            //比较的基本原则，拿最小长度的字符串进行比较，若全部相等，则长字符串往后排
            int len1 = o1.length();
            int len2 = o2.length();
            int len = (len1 - len2) <= 0 ? len1 : len2;
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < len; i++) {
                String s1 = o1.substring(i, i + 1);
                String s2 = o2.substring(i, i + 1);
                if (isNumeric(s1) && isNumeric(s2)){
                    //取出所有的数字
                    sb1.append(s1);
                    sb2.append(s2);
                    //取数字时，不比较
                    continue;
                }
                if (sb1.length() != 0 && sb2.length() != 0){
                    if (!isNumeric(s1) && !isNumeric(s2)){
                        int value1 = Integer.valueOf(sb1.toString());
                        int value2 = Integer.valueOf(sb2.toString());
                        return value1 - value2;
                    } else if (isNumeric(s1)) {
                        return 1;
                    } else if (isNumeric(s2)) {
                        return -1;
                    }
                }
                int result = CHINA_COMPARE.compare(s1, s2);
                if (result != 0) {
                    return result;
                }
            }
            //这一步：是为了防止以下情况：第10  第20，正好以数字结尾，且字符串长度相等
            if (len1 == len2 && sb1.length() != 0 && sb2.length() != 0) {
                int value1 = Integer.valueOf(sb1.toString());
                int value2 = Integer.valueOf(sb2.toString());
                return value1 - value2;
            }
            //若前面都相等，则直接比较字符串的长度，长的排后面，短的排前面
            return Integer.compare(len1, len2);
        });
        System.out.println(sortList);
    }
    //判断是否是数字
    private static boolean isNumeric(String s){
        return Character.isDigit(s.charAt(0));
    }
}