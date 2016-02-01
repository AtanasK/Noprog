package mk.atanask.noprog.gameStates;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mk.atanask.noprog.NoProgGame;

/**
 * Created by AtanasK on 11-Jan-16.
 */
public class EndGameState extends State {
    private Texture background;

    public EndGameState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, NoProgGame.WIDTH / 2, NoProgGame.HEIGHT / 2);
        background = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        sb.draw(background, 0, 0);



        sb.end();
    }

    @Override
    public void dispose() {

    }
}
