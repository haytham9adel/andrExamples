package com.example.andr.andr_example.libs;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.andr.andr_example.R;

/**
 * Created by dev-haytham on 9/6/2017.
 */

public class GlideExample {

    public static void loadUrlOnImgView(Activity ctx , String url , ImageView v ) {
             Glide
                .with(ctx)
                .load(url)
                .placeholder(R.drawable.ic_action_name)
                .into(v);
    }



}
