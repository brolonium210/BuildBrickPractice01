import ecs100.UI;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Grid {
    private Map<Integer,int[]> BlockLocs = new HashMap<>();
    private LinkedList<Block>blockList;
    private Block mouseBlock;
    private int mouseBlockINDEX;
    private int blockGap = 5;

    public Grid(LinkedList<Block>blockList,int ChalSize){
        this.BlockLocs = makeBlockLocs(ChalSize);
//        BlockLocs.put(0, new int[]{0,0});
//        BlockLocs.put(1, new int[]{1,0});
//        BlockLocs.put(2, new int[]{2,0});
//        BlockLocs.put(3, new int[]{3,0});
//        BlockLocs.put(4, new int[]{4,0});
//        BlockLocs.put(5, new int[]{5,0});
//        //-----------------------------
//        BlockLocs.put(6, new int[]{5,1});
//        BlockLocs.put(7, new int[]{4,1});
//        BlockLocs.put(8, new int[]{3,1});
//        BlockLocs.put(9, new int[]{2,1});
//        BlockLocs.put(10, new int[]{1,1});
//        BlockLocs.put(11, new int[]{0,1});
//        //-----------------------------
//        BlockLocs.put(12, new int[]{0,2});
//        BlockLocs.put(13, new int[]{1,2});
//        BlockLocs.put(14, new int[]{2,2});
//        BlockLocs.put(15, new int[]{3,2});
//        BlockLocs.put(16, new int[]{4,2});
//        BlockLocs.put(17, new int[]{5,2});
        //-----------------------------
        this.blockList = blockList;
    }

    Map<Integer,int[]>makeBlockLocs(int ChalSize){
        Map<Integer,int[]>TempLocs = new HashMap<>();
        int nRows = ChalSize/6;
        int count = 0;
        while(count < ChalSize){
            for(int i=0;i<nRows;i++){
                TempLocs.put(count,new int[]{0,i});
                TempLocs.put(count+1,new int[]{1,i});
                TempLocs.put(count+2,new int[]{2,i});
                TempLocs.put(count+3,new int[]{3,i});
                TempLocs.put(count+4,new int[]{4,i});
                TempLocs.put(count+5,new int[]{5,i});
                count = count+6;
            }
        }
        return TempLocs;
    }

    public void printGrid(){
        Color curColor = Color.BLACK;
        int size = 100;
        for(Map.Entry<Integer,int[]> entry : BlockLocs.entrySet()){
            int key = entry.getKey();
            int[] value = entry.getValue();
            UI.setColor(blockList.get(key).getColor());
            UI.fillRect((value[0]*size)+blockGap,(value[1]*size)+blockGap,size,size);
            if (blockList.get(key).isClicked()){
                UI.setColor(Color.BLACK);
                UI.drawRect((value[0]*size)-1,(value[1]*size-1),size+1,size+1);
            }
        }
    }

    void pickBlock(int index){
        Block emptyBlock = new Block(0,0,0,Color.GRAY);
        Block tempBlock = blockList.get(index);
        setMouseBlocLoc(index);
//        blockList.remove(tempBlock);
//        blockList.addLast(emptyBlock);
        emptyBlock.setClicked();
        setMouseBlock(tempBlock);
    }

    void setMouseBlocLoc(int index){
        this.mouseBlockINDEX = index;
    }

    public Block getBlock(int index){
        return blockList.get(index);
    }

    public void addBlock(Block block,int index){
//        blockList.removeLast();
//        blockList.add(index,block);
        blockList.remove(mouseBlockINDEX);
        blockList.add(mouseBlockINDEX, block);
        blockList.remove(index);
        blockList.add(index, mouseBlock);

    }

    public Map<Integer,int[]> getBlockLocs(){
        return BlockLocs;
    }

    public void setMouseBlock(Block mouseBlock) {
        this.mouseBlock = mouseBlock;
    }
    public Block getMouseBlock(){
        return mouseBlock;
    }

    public void redraw(double x,double y){
        UI.clearGraphics();
        printGrid();
        if(getMouseBlock() != null){
            UI.setColor(getMouseBlock().getColor());
            UI.fillRect(x,y,100,100);
        }
    }

}
