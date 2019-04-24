package com.java.steve.profile;

import com.java.steve.common.BaseView;
import com.java.steve.common.Canvas;
import com.java.steve.common.CompositeView;

public class ProfileView extends CompositeView {


    public void draw (Canvas canvas){
        for(BaseView view: children){
            view.draw(canvas);
        }

        canvas.drawSquare(10);
        System.out.println("Criminal profile view");
        System.out.println("ID: " + ((ProfileModel)model).getId());
        System.out.println("Name: " + ((ProfileModel)model).getName());
        System.out.println("Active: " + ((ProfileModel)model).isActive());
    }


    public void init(){
        ProfilePhotoView photoView = new ProfilePhotoView(5, 5, 5);
        children.add(photoView);

    }



}
