package com.nju.service.Impl;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by lxw on 2020/4/5.
 * 插入数据到数据库
 */
@Service
public class InsertDBServiceImpl {
    static class Province{
        String provName;
        int confirmedCount;
        int suspectedCount;
        int curedCount;
        int deadCount;
        String date;

        public Province(String provName, int confirmedCount, int suspectedCount, int curedCount, int deadCount, String date) {
            this.provName = provName;
            this.confirmedCount = confirmedCount;
            this.suspectedCount = suspectedCount;
            this.curedCount = curedCount;
            this.deadCount = deadCount;
            this.date = date;
        }
    }

    static class City{
        String cityName;
        String provName;
        int confirmedCount;
        int suspectedCount;
        int curedCount;
        int deadCount;
        String date;

        public City(String cityName, String provName, int confirmedCount, int suspectedCount, int curedCount, int deadCount, String date) {
            this.cityName = cityName;
            this.provName = provName;
            this.confirmedCount = confirmedCount;
            this.suspectedCount = suspectedCount;
            this.curedCount = curedCount;
            this.deadCount = deadCount;
            this.date = date;
        }
    }

    private static final String user = "root";
    private static final String pwd = "root";
    private static final String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

    private static final String driver = "com.mysql.jdbc.Driver";

    private static ArrayList<Province> provinces = new ArrayList<>();
    private static ArrayList<City> cities = new ArrayList<>();

    public static Connection getCon() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
            if (con != null) {
                System.out.println("你已连接到数据库：" + con.getCatalog());
            }
        } catch (Exception e) {
            System.out.println("连接数据库失败！");
            e.printStackTrace();
        }

        return con;
    }

    public static boolean insertDB() {

        Connection con = null;
        Statement stm = null;
        boolean flag = false;

        try {
            con = getCon();
            stm = con.createStatement();
            for(Province p :provinces){
                String sql = "insert into province_data values('" + p.provName + "','"
                        + p.confirmedCount + "','" + p.suspectedCount + "','" + p.curedCount + "','" + p.deadCount
                        + "','" + p.date.split(" ")[0] + "')";
                int i = stm.executeUpdate(sql);
                if (i > 0) {
                    flag = true;
                    System.out.println(flag + "插入数据成功！");
                }
            }
            for(City c :cities){
                String sql = "insert into city_data values('" + c.cityName + "','"
                        + c.provName + "','" + c.confirmedCount + "','" + c.suspectedCount + "','" + c.curedCount + "','" + c.deadCount
                        + "','" + c.date.split(" ")[0] + "')";
                int i = stm.executeUpdate(sql);
                if (i > 0) {
                    flag = true;
                    System.out.println(flag + "插入数据成功！");
                }
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            close(null, stm, con);
        }

        return flag;
    }

    public static void readFromCSV(String fileName){
        try {
//            DataInputStream in = new DataInputStream(new FileInputStream(new File("d:\\*.csv")));
//            BufferedReader br= new BufferedReader(new InputStreamReader(in,"GBK"));
//            csv文件默认编码为ANSI，会出现乱码

            BufferedReader reader = new BufferedReader(new FileReader(fileName));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while((line=reader.readLine())!=null){

                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
//                if(item[4].equals("新疆维吾尔自治区")){
//                    System.out.println(line);
//                }
//                String last = item[item.length-1];//这就是你要的数据了
                String country = item[2];
//                if(item[4].equals("重庆市")){
//                    System.out.println(item[18]);
//                }
                if(country.equals("中国")){
                    if(!item[4].equals("中国")) {
                        System.out.println(line);
                        String provName = item[4];
                        int confirmedCount1;
                        if(item[7].equals("")){
                            confirmedCount1 = 0;
                        }else {
                            confirmedCount1 = Integer.valueOf(item[7]);
                        }
                        int suspectedCount1;
                        if(item[8].equals("")){
                            suspectedCount1 = 0;
                        }else {
                            suspectedCount1 = Integer.valueOf(item[8]);
                        }
                        int curedCount1;
                        if(item[9].equals("")){
                            curedCount1 = 0;
                        }else {
                            curedCount1 = Integer.valueOf(item[9]);
                        }
                        int deadCount1;
                        if(item[10].equals("")){
                            deadCount1 = 0;
                        }else {
                            deadCount1 = Integer.valueOf(item[10]);
                        }

                        String cityName = item[11];

                        int confirmedCount2;
                        if(item[item.length-5].equals("")){
                            confirmedCount2 = 0;
                        }else {
                            confirmedCount2 = Integer.valueOf(item[item.length - 5]);
                        }
                        int suspectedCount2;
                        if(item[item.length-4].equals("")){
                            suspectedCount2 = 0;
                        }else {
                            suspectedCount2 = Integer.valueOf(item[item.length - 4]);
                        }
                        int curedCount2;
                        if(item[item.length-3].equals("")){
                            curedCount2 = 0;
                        }else {
                            curedCount2 = Integer.valueOf(item[item.length - 3]);
                        }
                        int deadCount2;
                        if(item[item.length-2].equals("")){
                            deadCount2 = 0;
                        }else {
                            deadCount2 = Integer.valueOf(item[item.length - 2]);
                        }

                        String date = item[item.length-1];
                        ifExistProv(provName, confirmedCount1, suspectedCount1, curedCount1, deadCount1, date);
                        ifExistCity(cityName, provName, confirmedCount2, suspectedCount2, curedCount2, deadCount2, date);
//                        if(item[4].equals("新疆维吾尔自治区")){
//                            System.out.println(item[17]+" "+item[18]);
//                            System.out.println(line);
//                        }

                    }
                }
//                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
            }

            System.out.println(provinces.size()+" "+cities.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭相关连接

    public static void close(ResultSet rs, Statement stm, Connection con) {

        if (rs != null)
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        if (stm != null)
            try {
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        if (con != null)
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void ifExistProv(String provName, int confirmedCount, int suspectedCount, int curedCount, int deadCount, String date){
        ArrayList<String> dates = new ArrayList<>();
        for(Province p : provinces){
            if(p.provName.equals(provName)){
                dates.add(p.date);
            }
        }
        if(dates.size()==0){
            provinces.add(new Province(provName,confirmedCount, suspectedCount, curedCount, deadCount, date));
        }else{
            if(!dates.get(dates.size()-1).equals(date)){
                if(!dates.get(dates.size()-1).split(" ")[0].equals(date.split(" ")[0])){
                    provinces.add(new Province(provName,confirmedCount, suspectedCount, curedCount, deadCount, date));
                }
            }
        }
    }

    public static void ifExistCity(String cityName,String provName, int confirmedCount, int suspectedCount, int curedCount, int deadCount, String date){
        ArrayList<String> dates = new ArrayList<>();
        for(City c : cities){
            if(c.cityName.equals(cityName)){
                dates.add(c.date);
            }
        }
        if(dates.size()==0){
            cities.add(new City(cityName,provName,confirmedCount, suspectedCount, curedCount, deadCount, date));
        }else{
            if(!dates.get(dates.size()-1).equals(date)){
                if(!dates.get(dates.size()-1).split(" ")[0].equals(date.split(" ")[0])){
                    cities.add(new City(cityName,provName,confirmedCount, suspectedCount, curedCount, deadCount, date));
                }
            }
        }
    }

    public static void main(String[] args) {
        readFromCSV("C:\\Users\\Lence\\Desktop\\postgraduate\\敏捷软件开发\\第二次迭代\\DXYArea1.csv");
//        for(Province p : provinces){
//            if(p.provName.equals("新疆维吾尔自治区")){
//                System.out.println(p.date);
//            }
//        }
        insertDB();
    }
}
