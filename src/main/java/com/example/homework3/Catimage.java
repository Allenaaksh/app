package com.example.homework3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Catimage {

    @PrimaryKey
    private String id;

    private  String url;
    //private String id1


    public List<Breeds> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breeds> breeds) {
        this.breeds = breeds;
    }

    private List<Breeds> breeds;


    public String getId() {
        return id;
    }

    public  String getUrl() {
        return url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    }



