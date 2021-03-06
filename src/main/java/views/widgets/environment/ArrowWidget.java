package views.widgets.environment;

import models.Direction;
import models.Position;
import views.AssetSettings;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import views.widgets.Drawable;
import views.widgets.HasRenderableAsset;

import static views.AssetSettings.SPRITE_RESOLUTION;

/**
 * Rendered when user controls ball
 */
public class ArrowWidget implements Drawable, HasRenderableAsset {
    private Position position; // position of ball and arrow
    // direction where the arrow points
    private Direction.DirectionConstant direction = Direction.DirectionConstant.NORTH;

    public ArrowWidget(Position position) {
        this.position = position;
    }

    public void setDirection(Direction.DirectionConstant direction) {
        this.direction = direction;
    }

    /**
     * Draw arrow
     * @throws SlickException if could not render widget
     */
    public void draw() throws SlickException {
        int x = position.getX() * SPRITE_RESOLUTION;
        int y = position.getY() * SPRITE_RESOLUTION;

        var asset = (Image) getAsset();

        switch (direction) {
            case SOUTH:
                asset.rotate(180);
                break;
            case WEST:
                asset.rotate(-90);
                break;
            case EAST:
                asset.rotate(90);
        }

        asset.draw(x, y);
    }

    @Override
    public Renderable getAsset() throws SlickException {
        return new Image(AssetSettings.ARROW);
    }

    public void destroy() {
        position = null;
    }
}
