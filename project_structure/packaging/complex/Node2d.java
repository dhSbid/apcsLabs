package packaging.complex;

public class Node2d extends Node implements Displayable {

    private float x;
    private float y;
    private float rotation;
    private boolean isVisible;

    public Node2d () {
        super();
        x = 0f;
        y = 0f;
        rotation = 0f;
        isVisible = true;
    }

    public Node2d (String name, float x, float y, float rotation) {
        super(name);
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        isVisible = true;
    }

    public Node2d (Node parent, String name, float x, float y, float rotation) {
        super(parent, name);
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        isVisible = true;
    }

    public float getX () {
        return x;
    }

    public float getY () {
        return y;
    }

    public float getRotation () {
        return rotation;
    }

    public boolean isVisible () {
        return isVisible;
    }

    public void setX (float x) {
        this.x = x;
    }

    public void setY (float y) {
        this.y = y;
    }

    public void setRotation (float rotation) {
        this.rotation = rotation;
    }

    @Override
    public void clear () {
        super.clear();
        x = 0f;
        y = 0f;
        rotation = 0f;
    }

    @Override
    public String toString () {
        String rv = super.toString();

        rv += "[x=" + x + ", y=" + y + ", rotation=" + rotation + "]";

        return rv;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }
        Node2d other = (Node2d) otherObject;
        return x == other.getX() && y == other.getY() && rotation == other.getRotation();
    }

    @Override
    public void display () {
        if (isVisible) {
            System.out.println("" + x + ", " + y + ", " + rotation + ".");
        }
    }

    @Override
    public void setVisible (boolean a) {
        isVisible = a;
    }
}