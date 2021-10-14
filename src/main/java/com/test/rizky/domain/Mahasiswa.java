package com.test.rizky.domain;

import com.google.gson.Gson;
import com.test.rizky.shared.LongIdentityEntityBase;

import javax.persistence.*;

@Entity
@Table(name="mahasiswa")
public class Mahasiswa extends LongIdentityEntityBase {
    private static final long serialVersionUID = -9012155658302171102L;
    private String name;

    private String nim;
    private String major;

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="nim", unique = true)
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Column(name="major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
