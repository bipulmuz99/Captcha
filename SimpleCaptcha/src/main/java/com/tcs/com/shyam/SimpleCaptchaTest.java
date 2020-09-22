package com.tcs.com.shyam;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;

public class SimpleCaptchaTest {
	
public static Captcha createCapcha(Integer width ,Integer height ){
		
		Captcha captcha=new Captcha.Builder(width, height).
				addBackground()
				.addText()
				.addNoise().build();
	
		return captcha;
	}
	
	public static void createImage(Captcha captcha) {
		try {
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), "png" , os);
			FileOutputStream fs=new FileOutputStream("E:/gitForSTS/captcha/mycp.png");
			fs.write(os.toByteArray());
			fs.flush();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String arg[]) {
		
		Captcha cap=createCapcha(200, 80);
		createImage(cap);
		System.out.println("captcha created !!!");
	
	}


}
