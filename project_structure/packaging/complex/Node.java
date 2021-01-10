package packaging.complex;

import java.util.ArrayList;
import packaging.complex.*;

public class Node implements Relatable, Clearable, Cloneable, Comparable<Node> {

    private Node parent;
    private ArrayList<Node> children;
    private String name;

    public Node () {
        parent = null;
        children = new ArrayList<Node>();
        name = "";
    }

    public Node (String name) {
        parent = null;
        children = new ArrayList<Node>();
        this.name = name;
    }

    public Node (Node parent, String name) {
        this.setParent(parent);
        children = new ArrayList<Node>();
        this.name = name;
    }

    public Node getParent () {
        return parent;
    }

    public ArrayList<Node> getChildren () {
        return children;
    }

    public String getName () {
        return name;
    }

    public void setName (String n) {
        this.name = n;
    }

    @Override
    public void setParent (Relatable a) {
        removeParent();
        this.parent =(Node) a;
        parent.addChild(this);
    }

    @Override
    public void removeParent () {
        if (this.parent != null) {
            parent.removeChild(this);
        }
        this.parent = null;
    }

    @Override
    public void addChild (Relatable a) {
        if (a instanceof Node) {
            children.add((Node) a);
            a.setParent(this);
        }
    }

    @Override
    public void removeChild (Relatable a) {
        if (a instanceof Node) {
            a.removeParent();
            children.remove(a);
        }
    }

    @Override
    public void clear () {
        removeParent();
        children.clear();
    }

    @Override
    public String toString() {
        String rv = getClass().getName() + "[name=" + name + ", parent=";

        if (parent != null) {
            rv += parent.getName();
        } else {
            rv += "null";
        }

        rv += ", children=" + children.toString() + "]";

        return rv;
    }

    @Override
    public boolean equals (Object otherObject) {
        if (otherObject == null) {
            return false;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        Node other = (Node) otherObject;

        return name.equals(other.getName()) && parent.equals(other.getParent()) && children.equals(other.getChildren());
    }

    @Override
    public Object clone() {
        try {
            Node cloned = (Node) super.clone();
            if (parent != null) {
                cloned.parent = (Node) parent.clone();
            } else {
                cloned.parent = null;
            }
            cloned.children = (ArrayList<Node>) children.clone();

            return cloned;
        } catch (CloneNotSupportedException e) {
            // have to do this even though extending cloneable
            return null;
        }
    }

    @Override
    public int compareTo (Node o) {
        //implemented this just to test it
        //based on number of children + parent

        int mine = children.size();
        if (parent != null) {
            mine++;
        }

        int yours = o.getChildren().size();
        if (o.getParent() != null) {
            yours++;
        }

        if (mine > yours) {
            return 1;
        } else if (mine < yours) {
            return -1;
        } else {
            return 0;
        }
    }
}