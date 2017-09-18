package com.example.etisu.touchimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  implements View.OnTouchListener {

    static int ichienImageId = R.drawable.ichien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 表示したいレイアウト
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout2);

        // ImageViewオブジェクトの作成
        ImageView imageView = new ImageView(this);

        // 画像の設定
        imageView.setImageResource(ichienImageId);

        // タッチリスナーの設定
        imageView.setOnTouchListener(this);

        // 画像のサイズの設定
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150,150);

        // 動的に被らないIDを割り振り（API V17から）
        imageView.setId(View.generateViewId());

        // 表示座標の設定
        lp.leftMargin = 100;
        lp.topMargin = 200;

        // 画像の追加
        layout.addView(imageView,lp);

        //別クラスでタッチ処理
        ImgTouch coinMng = new ImgTouch(this,layout);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        String currAction = "";
        Log.w( "DEBUG_DATA", "v.toString() " + v.toString());
        Log.w( "DEBUG_DATA", "v.getId() " + v.getId());
        Log.w( "DEBUG_DATA", "v.getResources() " + v.getResources());

        // 画像のタッチ位置を取得
        //X軸の取得
        float pointX = event.getX();
        //Y軸の取得
        float pointY = event.getY();

        // イベントの状態を調べる
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                Log.w( "DEBUG_DATA", "DOWN");
                currAction = "DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                Log.w( "DEBUG_DATA", "MOVE");
                currAction = "MOVE";
                break;
            case MotionEvent.ACTION_UP:
                Log.w( "DEBUG_DATA", "UP");
                currAction = "UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.w( "DEBUG_DATA", "CANCEL");
                currAction = "CANCEL";
                break;
        }

        return true;

    }

}
