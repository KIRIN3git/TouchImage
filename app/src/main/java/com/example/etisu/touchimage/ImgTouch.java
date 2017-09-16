package com.example.etisu.touchimage;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View.OnTouchListener;

/**
 * Created by etisu on 2017/09/16.
 */

public class ImgTouch implements OnTouchListener {

    public ImgTouch(Context context, LinearLayout layout){

        // ImageViewオブジェクトの作成
        ImageView imageView = new ImageView(context);

        // タッチリスナーの設定
        imageView.setOnTouchListener(this);

        // 画像の設定
        imageView.setImageResource(R.drawable.ichien);

        // 画像のサイズの設定
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150,150);

        // 表示座標の設定
        lp.leftMargin = 100;
        lp.topMargin = 50;

        // 画像の追加
        layout.addView(imageView,lp);

    }

    public boolean onTouch(View v, MotionEvent event) {
        Log.w( "DEBUG_DATA", "Touch");
        return true;
    }
}
