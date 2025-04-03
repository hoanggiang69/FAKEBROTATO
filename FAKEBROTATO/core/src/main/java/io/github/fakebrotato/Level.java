package io.github.fakebrotato;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
    private Texture backgroundTexture; // Hình nền

    public Level() {
        backgroundTexture = new Texture("background.png"); // Đảm bảo file background.png có trong thư mục assets
    }

    public void draw(SpriteBatch batch) {
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Vẽ nền, kéo giãn để vừa màn hình
    }

    public void dispose() {
        backgroundTexture.dispose(); // Giải phóng tài nguyên
    }
}
