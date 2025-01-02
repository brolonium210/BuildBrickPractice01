import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Challenges {
    private int num;

    Challenges(int num){
        this.num = num;
    }

    LinkedList<Block> makeBlocks(){
        LinkedList<Block> blocks = new LinkedList<>();
        ArrayList<Color> colours = new ArrayList<>();
        colours.add(Color.BLUE);
        colours.add(Color.YELLOW);
        colours.add(Color.ORANGE);
        colours.add(Color.RED);
        colours.add(Color.GREEN);


        for(int i = 0; i < num; i++){
            Collections.shuffle(colours);
            blocks.addLast(new Block(i,0,0, colours.getFirst()));
        }
        return blocks;
    }


}
