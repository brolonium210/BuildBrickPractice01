import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

        int i = 0;
        while(i<num){
            Collections.shuffle(colours);
            blocks.addLast(new Block(i,0,0, colours.getFirst()));
            i++;
            blocks.addLast(new Block(i,0,0, colours.getFirst()));
            i++;
            blocks.addLast(new Block(i,0,0, colours.getFirst()));
            i++;
            blocks.addLast(new Block(i,0,0, colours.getFirst()));
            i++;
            blocks.addLast(new Block(i,0,0, colours.getFirst()));
            i++;
            blocks.addLast(new Block(i,0,0, colours.getFirst()));
            i++;
        }
//
//        for(int i = 0; i < num; i++){
//            Collections.shuffle(colours);
//            blocks.addLast(new Block(i,0,0, colours.getFirst()));
//        }
        Collections.shuffle(blocks);
        return blocks;
    }

    Boolean[] testScore(LinkedList<Block> blocks){
        int cols = blocks.size()/6;
        Boolean point3;
        Boolean[] finalPoints = new Boolean[cols];


        for(int i = 0; i < cols; i++){
            int curCol = i*6;
            HashSet<Color> myHash = new HashSet<>();
            for(int j = 0; j < cols; j++){
                Color temp = blocks.get(curCol+j).getColor();
                myHash.add(temp);
            }
            boolean allSame = (myHash.size() == 1);
            finalPoints[i] = allSame;
        }
        return finalPoints;
    }

}
