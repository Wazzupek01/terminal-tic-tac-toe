import java.util.ArrayList;

public class Board {
    private final ArrayList<Field> fields = new ArrayList<>();
    public Board(){
        for(int i = 0; i < 9; i++) fields.add(new Field());
    }

    public void drawBoard(){
        int i = 1;
        for(Field f: fields){
            if(i%3 == 0){
                System.out.println(f.getValue());
                System.out.println("---------");
            }
            else System.out.print(f.getValue() + " | ");
            i++;
        }
    }

    public boolean isEmpty(int fieldId){
        return fields.get(fieldId).getValue() == ' ';
    }

    public boolean setField(int fieldId, Player activePlayer){
        if(isEmpty(fieldId)){
            fields.get(fieldId).setValue(activePlayer.getSign());
            return true;
        }
        return false;
    }

    public Field getField(int fieldId) {
        return fields.get(fieldId);
    }
}
