/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.driver;

import java.sql.*;

/**
 *
 * @author parrot
 */
public class driver {

    public Connection ketnoi;
    public PreparedStatement sttm;
    public ResultSet rs;
    public String execute;
    public String tenbang;

    public Connection getKetnoi() {
        return ketnoi;
    }

    public driver(String tenbangs) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

//            String url = "jdbc:mysql://mysql:3306/Web_Cart"
//                    + "?useSSL=false"
//                    + "&allowPublicKeyRetrieval=true"
//                    + "&serverTimezone=Asia/Ho_Chi_Minh";
            String url = "jdbc:mysql://2hJSigBDqRmGQGa.root:OGre5d1aofbruVxO@gateway01.ap-southeast-1.prod.aws.tidbcloud.com:4000/Web_Cart?sslMode=VERIFY_IDENTITY";
            this.ketnoi = DriverManager.getConnection(url, "admin", "123");
            System.out.println("Kết nối thành công: " + (this.ketnoi != null));
            this.tenbang = tenbangs;
        } catch (ClassNotFoundException ex) {
            System.getLogger(driver.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(driver.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet laybang(String tb) {
        execute = "select * from " + tenbang + " " + tb;
        try {
            sttm = ketnoi.prepareStatement(execute);
            return rs = sttm.executeQuery();
        } catch (SQLException ex) {
            System.getLogger(driver.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
}
