package utilities;

import model.Captcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class CaptchaGenerator {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 40;
    private static final int FONT_SIZE = 24;
    private static final int CODE_LENGTH = 4;
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final int LINE_NUM = 4;
    private static final int DOT_NUM = 80;

    private static Random random = new Random();
    private CaptchaGenerator(){}

    public static Captcha generateCaptcha() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // 设置背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 设置字体
        Font font = new Font("Fixedsys", Font.PLAIN, FONT_SIZE);
        g.setFont(font);

        // 生成随机验证码
        String code = generateRandomString(CODE_LENGTH);

        // 绘制验证码
        g.setColor(Color.BLACK);
        g.drawString(code, 15, 25);

        // 绘制干扰线
        g.setColor(Color.GRAY);
        for (int i = 0; i < LINE_NUM; i++) {
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }

        // 绘制干扰点
        g.setColor(Color.BLACK);
        for (int i = 0; i < DOT_NUM; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            g.drawOval(x, y, 1, 1);
        }
        StringBuffer sb = new StringBuffer();
        LocalDateTime localDateTime = LocalDateTime.now();

        sb.append(localDateTime).append(".png");
        System.out.println(sb);
        saveImageToFile(image, sb.toString());
        return new Captcha(code, image);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int type = random.nextInt(3);
            switch (type) {
                case 0:
                    sb.append(CHAR_LOWER.charAt(random.nextInt(CHAR_LOWER.length())));
                    break;
                case 1:
                    sb.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));
                    break;
                case 2:
                    sb.append(NUMBER.charAt(random.nextInt(NUMBER.length())));
                    break;
            }
        }
        return sb.toString();
    }
    private static void saveImageToFile(BufferedImage image, String filename) {
        try {
            String filePath = new StringBuffer().append("src/resources/captchaImage").append(File.separator).append(filename).toString();
            File output = new File(filePath);
            ImageIO.write(image, "png", output);
            System.out.println("验证码图片已保存到：" + output.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }
}

