package io.github.fakebrotato;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    private Texture texture;  // Hình ảnh của nhân vật
    private float x, y;       // Tọa độ của nhân vật
    private float speed;      // Tốc độ di chuyển

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 200; // Tốc độ di chuyển
        this.texture = new Texture("player.png"); // Đảm bảo file player.png có trong thư mục assets
    }

    public void update(float delta) {
        // Xử lý di chuyển
        if (Gdx.input.isKeyPressed(Keys.A)) x -= speed * delta;
        if (Gdx.input.isKeyPressed(Keys.D)) x += speed * delta;
        if (Gdx.input.isKeyPressed(Keys.W)) y += speed * delta;
        if (Gdx.input.isKeyPressed(Keys.S)) y -= speed * delta;

        // Giới hạn nhân vật trong màn hình
        if (x < 0) x = 0;
        if (x > Gdx.graphics.getWidth() - texture.getWidth())
            x = Gdx.graphics.getWidth() - texture.getWidth();
        if (y < 0) y = 0;
        if (y > Gdx.graphics.getHeight() - texture.getHeight())
            y = Gdx.graphics.getHeight() - texture.getHeight();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y); // Vẽ nhân vật
    }

    public void dispose() {
        texture.dispose(); // Giải phóng tài nguyên
    }
}
