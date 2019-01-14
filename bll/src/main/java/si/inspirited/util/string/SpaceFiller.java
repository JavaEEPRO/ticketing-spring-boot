package si.inspirited.util.string;

public class SpaceFiller {

    private int BOX_LENGTH;

    public SpaceFiller() {
        this.BOX_LENGTH = 1;
    }

    public SpaceFiller(int boxLength) {
        this.BOX_LENGTH = boxLength;
    }

    public String generate(int usedCounted, String usedUncountable) {
        return generate(BOX_LENGTH, usedCounted, usedUncountable);
    }

    public String generate(int total, int usedCounted, String usedUncountable) {
        int usedLength = usedCounted + usedUncountable.length();
        int capacity = total-usedLength;
        if(capacity <= 0) {capacity = 0;}

        StringBuilder stringBuilder = new StringBuilder(capacity);

        for(int i = 1; i < stringBuilder.capacity()+1; i++){
            char current = i%2>0? ' ' : '.';
            stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }


}
