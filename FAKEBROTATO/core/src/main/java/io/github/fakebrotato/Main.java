package io.github.fakebrotato;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Player player;
    Level level;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Player(100, 100); // Khởi tạo nhân vật tại vị trí (100, 100)
        level = new Level();           // Khởi tạo level (bao gồm nền)
    }

    @Override
    public void render() {
        // Xóa màn hình
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Cập nhật nhân vật
        player.update(Gdx.graphics.getDeltaTime());

        // Vẽ
        batch.begin();
        level.draw(batch);  // Vẽ nền
        player.draw(batch); // Vẽ nhân vật
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        level.dispose();
    }
}
