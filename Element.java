public abstract class Element {
    protected Type type;

    public Element(Type type){
        this.type = type;
    }

    public abstract boolean bougerVers(Direction direction);

    public Type getType(){
        return type;}
}
