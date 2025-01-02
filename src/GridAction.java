import ecs100.UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GridAction {

    private int width = 1600;
    private int height = 800;
    private Grid myGrid;

    Counter counter = new Counter();

    public GridAction(Grid grid){
        this.myGrid = grid;
    }

    ArrayList<String> makeBasicLi(String[] arr){
        //def return to this
        return new ArrayList<>(Arrays.asList(arr));
    }

    boolean isRunning = false;
    String buttonLabel = "start";

    public Map<Integer,int[]> myMap(){
        Map<Integer,int[]> myLocs = myGrid.getBlockLocs();
        return myLocs;
    }

    void setupGUI(){
        UI.setWindowSize(width, height);
        UI.addButton(buttonLabel, this::startOrStop);
        //this worked ok using multiple listeners
        UI.setMouseListener(this::doMouse);
        UI.setMouseMotionListener(this::doMouse);
        UI.setDivider(0.1);
    }
    void startOrStop(){
    }

    void doMouse(String action,double x, double y){
//        System.out.println("mouse: " + x + ", " + y);
        //def need to make this attach to the grid value later
        int size = 100;
        if(action.equals("pressed")){
            assert true;
//            myGrid.printGrid();
//            counter.incrI();
        }
        if(action.equals("released")){
            Map<Integer,int[]> currMap = myMap();
            for (Map.Entry<Integer,int[]> entry : currMap.entrySet()){
                int key = entry.getKey();
                int[] value = entry.getValue();
                int topX = value[0]*size;
                int topY = value[1]*size;
                int bottomX = topX+size;
                int bottomY = topY+size;
                if((x > topX && x <= bottomX) && (y > topY && y <= bottomY)){
                    if(myGrid.getMouseBlock() != null){
                        myGrid.addBlock(myGrid.getBlock(key),key);
//                        myGrid.addBlock(myGrid.,key);
                        myGrid.setMouseBlock(null);
                    }else{
                        myGrid.pickBlock(key);
                    }
                }
            }

            myGrid.redraw(x,y);
        }
        if(action.equals("moved")){
//            myGrid.printGrid();
            myGrid.redraw(x,y);
        }

    }
    void doMouseMoved(String action,double x, double y){
        if(action.equals("moved")){
            assert true;
//            myGrid.redraw(x,y);
        }
    }
}
