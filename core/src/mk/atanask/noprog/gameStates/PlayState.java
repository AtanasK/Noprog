package mk.atanask.noprog.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mk.atanask.noprog.NoProgGame;
import mk.atanask.noprog.sprites.Bird;

/**
 * Created by AtanasK on 09-Jan-16.
 */
public class PlayState extends State {
    protected Bird bird;
    private Texture bg;

    public PlayState(mk.atanask.noprog.gameStates.GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 100);
        cam.setToOrtho(false, NoProgGame.WIDTH / 2, NoProgGame.HEIGHT / 2);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        bird.dispose();
    }
}
