package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SetImage {

    private String code = "";
    private Image image;
    private ImageView imageView;

    public SetImage() {
    }

    public SetImage(String code, Image image, ImageView imageView) {
        this.code = code;
        this.image = image;
        this.imageView = imageView;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    //第一次显示走势图
    public void showImageView() {
        image = new Image(code);
        imageView = new ImageView(image);
        imageView.setFitWidth(580);
        imageView.setFitHeight(250);
    }

    //新建Image，第n次显示走势图
    public void changeImageView() {
        imageView.setImage(new Image(code));
    }
}
