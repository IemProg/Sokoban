public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x; this.y = y;
    }

    @Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

	public Position(Position pos){
        this(pos.x, pos.y);
    }

    /*qui permet d’obtenir la position dans le sens de la Direction
    //passée en paramètre en additionnant la direction à la position courante (respectivement dans le sens
    //inverse en soustrayant la direction).
    */

    // ------   les objets Position doivent être immutables ------
    //les opérations sur les positions renverront toujours une nouvelle instance Position
    public Position add(Direction direction){
        return new Position(this.x + direction.getDx(), this.y + direction.getDy());
    }
    public Position sub(Direction direction){
        return new Position(this.x - direction.getDx(), this.y - direction.getDy());
    }


    //Il sera également nécessaire de tester l’égalité entre deux instances de Position
    public boolean equals(Object obj){
        if (this == obj){return true;}
        if (obj == null){return false;}
        if (getClass() != obj.getClass()){return false;}
        Position autre = (Position) obj;
        return x == autre.x && y == autre.y;
    }
    
    

    public int getX() { return x; }

    public int getY() { return y; }
}
