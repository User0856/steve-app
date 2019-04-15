package com.java.steve.profile;

import com.java.steve.common.BaseView;
import com.java.steve.common.Canvas;

public class ProfileView extends BaseView {


    public void draw (Canvas canvas){

        canvas.drawSquare(10);
        System.out.println("Criminal profile view");
        System.out.println("ID: " + ((ProfileModel)model).getId());
        System.out.println("Name: " + ((ProfileModel)model).getName());
        System.out.println("Active: " + ((ProfileModel)model).isActive());
    }


}
