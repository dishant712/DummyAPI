package com.example.apicart;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements  Parcelable, Serializable {

    int id,total,distotal,userid,totalpro,totalquan;
    ArrayList product;

    public Product(int id, int total, int distotal, int userid, int totalpro, int totalquan, ArrayList product) {
        this.id = id;
        this.total = total;
        this.distotal = distotal;
        this.userid = userid;
        this.totalpro = totalpro;
        this.totalquan = totalquan;
        this.product = product;
    }


    protected Product(Parcel in) {
        id = in.readInt();
        total = in.readInt();
        distotal = in.readInt();
        userid = in.readInt();
        totalpro = in.readInt();
        totalquan = in.readInt();
        product=in.readArrayList(ClassLoader.getSystemClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(total);
        dest.writeInt(distotal);
        dest.writeInt(userid);
        dest.writeInt(totalpro);
        dest.writeInt(totalquan);
        dest.writeList(product);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", total=" + total +
                ", distotal=" + distotal +
                ", userid=" + userid +
                ", totalpro=" + totalpro +
                ", totalquan=" + totalquan +
                ", product=" + product +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDistotal() {
        return distotal;
    }

    public void setDistotal(int distotal) {
        this.distotal = distotal;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTotalpro() {
        return totalpro;
    }

    public void setTotalpro(int totalpro) {
        this.totalpro = totalpro;
    }

    public int getTotalquan() {
        return totalquan;
    }

    public void setTotalquan(int totalquan) {
        this.totalquan = totalquan;
    }

    public ArrayList getProduct() {
        return product;
    }

    public void setProduct(ArrayList product) {
        this.product = product;
    }


}