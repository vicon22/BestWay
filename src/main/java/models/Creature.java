package models;

public abstract class Creature {

    protected int s;
    protected int w;
    protected int t;
    protected int p;

    public int getStepCost(char area){
        return switch (area) {
            case('S') -> s;
            case('W') -> w;
            case('T') -> t;
            case('P') -> p;
            default -> throw new IllegalStateException("Unexpected value: " + area);
        };
    }


    @Override
    public String toString() {
        return "Creature{" +
                "class=" + this.getClass().getSimpleName() +
                ", s=" + s +
                ", w=" + w +
                ", t=" + t +
                ", p=" + p +
                '}';
    }
}

