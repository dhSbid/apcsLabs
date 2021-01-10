package packaging.simple;

import packaging.simple.Simplicity;

public interface Simplifiable {
    
    void simplify ();
    
    Simplicity howSimple ();

    static boolean isSimplest (Simplicity s) {
        return (s == Simplicity.NO_BRAIN_CELLS_REQUIRED);
    }
}