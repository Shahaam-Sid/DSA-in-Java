// this file is here to aid TreeC class, this is not primarily a part of this
public abstract class AbstractTreeC<E> implements TreeC<E>{
    @Override
    public boolean isInternal(Position<E> p) {return numChildren(p) > 0;}
    @Override
    public boolean isExternal(Position<E> p) {return numChildren(p) == 0;}
    public boolean isRoot(Position<E> p) {return p == root();}
    @Override
    public boolean isEmpty() {return size() == 0;}
    public int depth(Position<E> p) {
        if (isRoot(p)) return 0;
        else return 1 + depth(parent(p));
    }

    private int hieghtBad() {
        int h = 0;
        for (Position<E> p : positions()) h = Math.max(h, depth(p));
        return h;
    }

    public int hieght(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) h = Math.max(h, 1 + hieght(c));
        return h; 
    }
}