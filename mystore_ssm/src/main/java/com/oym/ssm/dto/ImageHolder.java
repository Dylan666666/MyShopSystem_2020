package com.oym.ssm.dto;

import java.io.InputStream;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/6 16:30
 */
public class ImageHolder {
    private String imageName;
    private InputStream image;

    public ImageHolder(String imageName, InputStream image) {   
        this.imageName = imageName;
        this.image = image;
    }

    public ImageHolder(InputStream image,String imageName) {
        this.imageName = imageName;
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
