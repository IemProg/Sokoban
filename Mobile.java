public abstract class Mobile extends Element{
    protected Configuration config;
    private Position pos;

    public Mobile(Type type, Configuration config, Position pos){
        super(type);
        this.config= config; this.pos = pos;
    }

    //qui tente de faire bouger l’élément dans la direction souhaitée (renvoie true en cas de succès, false en cas d’échec)
    /*
    1 - un Mur n’est jamais déplaçable ;
    2 - une Case qui ne contient pas d’autres éléments est toujours déplaçable (elle est vide - cela n’a
        pas d’intérêt de la déplacer et il ne se passe rien quand elle est déplacée, la méthode renvoie juste
        true, mais cela facilitera le codage) ;
    3 - une Caisse ne peut être déplacée que si la case de destination est vide ;
    4 - un Joueur ne peut bouger que si la case de destination est vide, ou contient une caisse qui
        peut être poussée dans la direction souhaitée (dans ce cas, la Caisse est poussée puis le Joueur déplacé).
     */

    //Afin de pouvoir fixer ses coordonnées lors de l’initialisation ou d’un déplacement
    //et qui renvoie true si le placement est possible et false sinon.

    public boolean setPosition(Position position){
        if (config.estVide(position)) {
            this.pos = new Position(position);
            return true;
        }else{return false;}
    }

    public Position getPosition(){
        return pos;
    };
}
