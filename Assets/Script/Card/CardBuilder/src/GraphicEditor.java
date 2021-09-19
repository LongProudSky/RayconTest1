import java.awt.Graphics2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.awt.*;

import javax.imageio.ImageIO;
// "C:\\Users\\Ray\\Pictures\\Saved Pictures\\Advanced\\backimg"
public class GraphicEditor {
    public BufferedImage Load(String path){
        File file = new File(path);
        try {
            BufferedImage image = ImageIO.read(file);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String AddString(Card card,String targetPath,BufferedImage image){
        //int Width = image.getWidth();
        //int Height = image.getHeight();
        HashMap<String,Dimension> map = CreateAddString(card);
        Graphics2D graphic = image.createGraphics();
        Font fTxtBottom = new Font("微软雅黑", Font.PLAIN, 30);
        Color myColorTxtBottom = Color.BLACK;
        graphic.setColor(myColorTxtBottom);
        graphic.setFont(fTxtBottom);
        //graphic.drawString("生成器文字测试", 0, Height/2);
        graphic.drawString(card.CardTitle, map.get(card.CardTitle).width,  map.get(card.CardTitle).height);
        graphic.drawString(card.type, map.get(card.type).width,  map.get(card.type).height);
        graphic.drawString(card.Damage+"", map.get(card.Damage+"").width,  map.get(card.Damage+"").height);
        graphic.drawString(card.Health+"", map.get(card.Health+"").width,  map.get(card.Health+"").height);

        BufferedImage surfaceImage = Load(card.CardPic);
        graphic.drawImage(surfaceImage,9,42,null);


        graphic.dispose();
        String imageName = new Date().getTime() + ".png";
        File newFile = new File(targetPath,imageName);
        try {
            ImageIO.write(image, "png", newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.getAbsolutePath();
    }

    private HashMap<String,Dimension> CreateAddString(Card card){
        HashMap<String,Dimension> map = new HashMap<>();
        map.put(card.CardTitle, new Dimension(103,35));
        map.put(card.type, new Dimension(10,300));
        map.put(card.Damage+"", new Dimension(127,265));
        map.put(card.Health+"", new Dimension(127,330));
        return map;
    }



    public String  CreateBackImage(Card card,String path,String targetPath){
        CreateAddString(card);
        BufferedImage bufferImage = Load(path);
        return AddString(card,targetPath, bufferImage);
    }



}
