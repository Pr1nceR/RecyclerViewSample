package com.example.recyclerviewpractice;

public class ZodiacSignModel {
    String zodiacSignName;
    String zodiacSignDesc;
    int image;

    public ZodiacSignModel(String zodiacSignName,String zodiacSignDesc, int image) {
        this.zodiacSignName = zodiacSignName;
        this.image = image;
        this.zodiacSignDesc = zodiacSignDesc;

    }
    public String getZodiacSignDesc() {
        return zodiacSignDesc;
    }
    public String getZodiacSignName() {
        return zodiacSignName;
    }

    public int getImage() {
        return image;
    }


}
