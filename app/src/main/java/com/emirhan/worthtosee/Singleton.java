package com.emirhan.worthtosee;

import android.graphics.Bitmap;
//Singleton ile sadece 1 object olusturursun. Bu sayede bu objeyi farkli yerlerde kullanabilirsin
//Bunun olayi Singleton ve constructor u private olarak olusturmak
// getInstance ve Singleton variable i static yapilir
//Singleton class icinde private static Singleton objesi tanimlamak gerekiyor
public class Singleton {
    private Bitmap chosenImage;
    private static Singleton singleton;

    private Singleton() {

    }

    public Bitmap getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();

        }
        return singleton;

    }
}
