/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

/**
 *
 * @author parrot
 */
public class car {

    public int id;
    public String ten;
    public int namsanxuat;
    public double giaban;
    public String image;
    public String kieudang;
    public String hopso;
    public String nhienlieu;
    public int id_loaixe;
    public String mota;
    public String power;
    public String acceleration;
    public String topspeed;
    public String engine;
    public String DungTich;
    public String TruyenDong;
    public String CongNghe;
    public String TrongLuong;

    public car(int id, String ten, int namsanxuat, double giaban, String image, String kieudang, String hopso, String nhienlieu, int id_loaixe, String mota, String power, String acceleration, String topspeed, String engine, String DungTich, String TruyenDong, String CongNghe, String TrongLuong) {
        this.id = id;
        this.ten = ten;
        this.namsanxuat = namsanxuat;
        this.giaban = giaban;
        this.image = image;
        this.kieudang = kieudang;
        this.hopso = hopso;
        this.nhienlieu = nhienlieu;
        this.id_loaixe = id_loaixe;
        this.mota = mota;
        this.power = power;
        this.acceleration = acceleration;
        this.topspeed = topspeed;
        this.engine = engine;
        this.DungTich = DungTich;
        this.TruyenDong = TruyenDong;
        this.CongNghe = CongNghe;
        this.TrongLuong = TrongLuong;
    }

    public String getDungTich() {
        return DungTich;
    }

    public String getTruyenDong() {
        return TruyenDong;
    }

    public String getCongNghe() {
        return CongNghe;
    }

    public String getTrongLuong() {
        return TrongLuong;
    }

   
    

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getPower() {
        return power;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public String getTopspeed() {
        return topspeed;
    }

    public String getEngine() {
        return engine;
    }

        public int getNamsanxuat() {
        return namsanxuat;
    }

    public double getGiaban() {
        return giaban;
    }

    public String getImage() {
        return image;
    }

    public String getKieudang() {
        return kieudang;
    }

    public String getHopso() {
        return hopso;
    }

    public String getNhienlieu() {
        return nhienlieu;
    }

    public int getId_loaixe() {
        return id_loaixe;
    }

    public String getMota() {
        return mota;
    }

}
