package com.litziy.kawalcovid.ui.hospital;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalData implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("photo_path")
    @Expose
    private String photoPath;
    @SerializedName("operasional")
    @Expose
    private String operasional;
    @SerializedName("kontak_rs")
    @Expose
    private String kontakRs;
    @SerializedName("fasilitas")
    @Expose
    private String fasilitas;
    @SerializedName("kontak_ambulance")
    @Expose
    private String kontakAmbulance;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("real_photo_path")
    @Expose
    private String realPhotoPath;

    protected HospitalData(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        alamat = in.readString();
        deskripsi = in.readString();
        photoPath = in.readString();
        operasional = in.readString();
        kontakRs = in.readString();
        fasilitas = in.readString();
        kontakAmbulance = in.readString();
        lat = in.readString();
        _long = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        realPhotoPath = in.readString();
    }

    public static final Creator<HospitalData> CREATOR = new Creator<HospitalData>() {
        @Override
        public HospitalData createFromParcel(Parcel in) {
            return new HospitalData(in);
        }

        @Override
        public HospitalData[] newArray(int size) {
            return new HospitalData[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getOperasional() {
        return operasional;
    }

    public void setOperasional(String operasional) {
        this.operasional = operasional;
    }

    public String getKontakRs() {
        return kontakRs;
    }

    public void setKontakRs(String kontakRs) {
        this.kontakRs = kontakRs;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getKontakAmbulance() {
        return kontakAmbulance;
    }

    public void setKontakAmbulance(String kontakAmbulance) {
        this.kontakAmbulance = kontakAmbulance;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRealPhotoPath() {
        return realPhotoPath;
    }

    public void setRealPhotoPath(String realPhotoPath) {
        this.realPhotoPath = realPhotoPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeString(alamat);
        dest.writeString(deskripsi);
        dest.writeString(photoPath);
        dest.writeString(operasional);
        dest.writeString(kontakRs);
        dest.writeString(fasilitas);
        dest.writeString(kontakAmbulance);
        dest.writeString(lat);
        dest.writeString(_long);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(realPhotoPath);
    }
}