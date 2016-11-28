package com.haier.camer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.edmodo.cropper.CropImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_sure;
    private ImageView croppedImageView;
    private CropImageView cropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        cropImageView.setAspectRatio(8, 10);
        cropImageView.setFixedAspectRatio(true);
        cropImageView.setGuidelines(2);
        cropImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.imge2));
        //   cropImageView.rotateImage(90);
    }

    private void initView() {
        btn_sure = (Button) findViewById(R.id.btn_sure);
        cropImageView = (CropImageView) findViewById(R.id.CropImageView);
        croppedImageView = (ImageView) findViewById(R.id.croppedImageView);
        btn_sure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sure:
                Bitmap croppedImage = cropImageView.getCroppedImage();
                croppedImageView.setImageBitmap(croppedImage);
                break;
        }
    }
}
