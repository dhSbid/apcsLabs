package packaging.complex;

/**
* Creates a hierarchy, in which any object can have one parent but multiple children
*/


public interface Relatable {

    public void setParent (Relatable a);

    public void removeParent ();

    public void addChild (Relatable a);

    public void removeChild (Relatable a);

}