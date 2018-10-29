package com.goudanbase.lib.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auther:goudan
 * Date: 2016/1/26
 * Effect: 字符串工具
 */
public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        }

        return false;
    }

    /**
     * 检验手机号码是否合法
     *
     * @param phoneNum 手机号码
     * @return
     */
    public static boolean checkPhoneNum(String phoneNum) {
        return phoneNum
                .matches("^1(3|4|8|7|5|6)\\d{9}$");
    }

    /**
     * 使用正则表达式检查邮箱地址格式
     *
     * @param email
     * @return
     */
    public static boolean checkEmailAddress(String email) {
        return email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
    }

    /**
     * 检查是否输入了特殊字符
     *
     * @param s 输入字符
     * @return true 有特殊字符 false 没有
     */
    public static boolean checkStringSpecial(String s) {
        String regEx = "[`~!@#$%^&*()+-=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 正则表达式验证密码(字母+数字6-16位)
     *
     * @param password 密码
     * @return
     */
    public static boolean checkPassword(String password) {

        return password.matches("^(?!\\D+$)(?![^a-zA-Z]+$)[a-zA-Z0-9]{6,16}$");
    }

    /**
     * 通过多个以某个String间隔的多个String组成的String解析出String的list
     *
     * @param str         原始String
     * @param strInterval 间隔的字符串
     * @return
     */
    public static ArrayList<String> getStringListByString(String str, String strInterval) {
        List<String> listUrls = new ArrayList<String>();

        if (isNullOrEmpty(str))
            return (ArrayList<String>) listUrls;

        try {

            while (str.indexOf(strInterval) != -1) {
                listUrls.add(str.substring(0, str.indexOf(strInterval)));
                str = str.substring(
                        str.indexOf(strInterval) + strInterval.length(),
                        str.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<String>();
        }

        listUrls.add(str);// 加入最末尾的一个url

        return (ArrayList<String>) listUrls;
    }

    /**
     * 组装出以某个字符串间隔的字符串
     *
     * @param list
     * @param strInterval 间隔字符串
     * @return
     */
    public static String getStringByStringList(List<String> list, String strInterval) {
        String str = "";

        if (list == null)
            return str;

        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i) + strInterval;
        }

        if (str.lastIndexOf(strInterval) != -1)
            str = str.substring(0, str.lastIndexOf(strInterval));

        return str;
    }

    public static String formatJsonStr(String jsonStr) {
        String formatJsonStr = jsonStr.replace("\\", "");
        return formatJsonStr;
    }

    /**
     * 过滤字符串中的html代码
     *
     * @param inputString
     * @return
     */
    public static String filtHtml(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        Matcher m_script;
        Pattern p_style;
        Matcher m_style;
        Pattern p_html;
        Matcher m_html;

        Pattern p_html1;
        Matcher m_html1;

        try {
            String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[//s//S]*?<///script>
            // }
            String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[//s//S]*?<///style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String regEx_html1 = "<[^>]+";
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
            m_html1 = p_html1.matcher(htmlStr);
            htmlStr = m_html1.replaceAll(""); // 过滤html标签

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;// 返回文本字符串
    }

    /**
     * 截取字符串中的数字
     *
     * @param content
     * @return
     */
    public static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }


    /**
     * 将手机号码的中间4位替换为****
     */

    public static String repalcePhoneNumber(String s) {
        String ss = s.substring(0, s.length() - (s.substring(3)).length()) + "****" + s.substring(7);
        return ss;
    }

    /**
     * tv自动换行文字排字参差不齐的原因及处理
     *
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 格式化价格，强制保留2位小数
     *
     * @param price
     * @return
     */
    public static String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String format = "￥" + df.format(price);
        return format;
    }

    public static String formatPrice1(double price) {
        DecimalFormat df = new DecimalFormat("0.0");
        String format = df.format(price);
        return format;
    }

    /**
     * 获取随机字符串
     *
     * @param length 表示生成字符串的长度
     * @return
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    /**
     * 验证身份证格式
     *
     * @param idNum
     * @return
     */

    public static boolean isIDCardNum(String idNum) {
        String regx = "[0-9]{17}[x|X]";
        String reg1 = "[0-9]{15}";
        String regex = "[0-9]{18}";
        if (TextUtils.isEmpty(idNum)) {
            return false;
        } else {
            return idNum.matches(regx) || idNum.matches(reg1) || idNum.matches(regex);
        }
    }

    /**
     * 移除字符串中的某些字符串
     *
     * @param str
     * @param s
     * @return
     */
    public static String cleanStrForStr(String str, String s) {
        if (str.indexOf(s) != -1) {
            str = str.replace(s, "");
            return str;
        } else {
            return null;
        }
    }

    /**
     * 读取 用户协议 raw
     *
     * @return
     */
    public static String readRawTxt(Context context, int resId) {
        InputStream inputStream = context.getResources().openRawResource(resId);
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString().trim();
    }

    /**
     * 更改字符串中的颜色
     *
     * @param str  需要显示的字符串
     * @param str1 需要更改颜色的字符串
     * @return
     */
    public static SpannableStringBuilder style(String str, String str1, int color) {
        int start = str.indexOf(str1);
        int end = start + str1.length();
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }


    // 将字母转换成数字_1
    public static int letterToDigit(String input) {
        String reg = "[a-zA-Z]";
        StringBuffer strBuf = new StringBuffer();
        input = input.toLowerCase();
        if (null != input && !"".equals(input)) {
            for (char c : input.toCharArray()) {
                if (String.valueOf(c).matches(reg)) {
                    strBuf.append(c - 96);
                } else {
                    strBuf.append(c);
                }
            }
            return Integer.valueOf(strBuf.toString());
        } else {
            return Integer.valueOf(input);
        }
    }

    /**
     * 处理手机号码格式
     */
    public static String getPhoneNum(String mobile) {
        String str = "";
        for (int i = 0; i < mobile.length(); i++) {
            if (i == mobile.length() - 11) {
                str += mobile.charAt(i);
            } else if (i == mobile.length() - 10) {
                str += mobile.charAt(i);
            } else if (i == mobile.length() - 9) {
                str += mobile.charAt(i);
            } else if (i == mobile.length() - 3) {
                str += mobile.charAt(i);
            } else if (i == mobile.length() - 2) {
                str += mobile.charAt(i);
            } else if (i == mobile.length() - 1) {
                str += mobile.charAt(i);
            } else {
                str += "*";
            }
        }
        return str;
    }


    public static Drawable getDrawable(Context c, int resId) {
        Drawable mDrawable = c.getResources().getDrawable(resId);
        mDrawable.setBounds(0, 0, mDrawable.getMinimumWidth(), mDrawable.getMinimumHeight());
        return mDrawable;
    }


    public static String isNullToZero(String str) {
        if (str.equals("null")) {
            return "0";
        } else {
            return str;
        }
    }


}
