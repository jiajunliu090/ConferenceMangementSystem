package model;

import java.awt.image.BufferedImage;

public class Captcha {
    private String code;
    private BufferedImage image;

    public Captcha(String code, BufferedImage image) {
        this.code = code;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public BufferedImage getImage() {
        return image;
    }
    @Override
    public String toString() {
        return this.code;
    }
}
