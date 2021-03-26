package com.example.demo.domain.pizzadomain;


import javax.persistence.Embeddable;


@Embeddable
public class Image {

    public String asset_id;
    
    public String public_id;
    
    public String url;
}
