package game;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import blocks.Block;

public class GameBoardTest {
    GameBoard gameBoard = new GameBoard();
    public GameBoardTest() throws IOException {}

    @Test
    public void moveRight(){
    	int X = gameBoard.x;
    	int Y = gameBoard.y;
    	gameBoard.moveRight();
    	
    	Assert.assertEquals(gameBoard.x, X+1);
    	Assert.assertEquals(gameBoard.y, Y);
    }
    
    @Test
    public void moveLeft(){
    	int X = gameBoard.x;
    	int Y = gameBoard.y;
    	gameBoard.moveLeft();
    	
    	Assert.assertEquals(gameBoard.x, X-1);
    	Assert.assertEquals(gameBoard.y, Y);
    	
    }
    
    @Test
    public void moveDown(){
    	int X = gameBoard.x;
    	int Y = gameBoard.y;
    	gameBoard.moveDown();
    	
    	Assert.assertEquals(gameBoard.x, X);
    	Assert.assertEquals(gameBoard.y, Y+1);
    }
    
    @Test
    public void rotateBlock(){
    	Block block = gameBoard.curr;
    	
    	gameBoard.rotateBlock();
    	//Assert.assertNotSame(block.getShape(), gameBoard.curr.getShape());
    	gameBoard.rotateBlock();
    	//Assert.assertNotSame(block.getShape(), gameBoard.curr.getShape());
    	gameBoard.rotateBlock();
    	//Assert.assertNotSame(block.getShape(), gameBoard.curr.getShape());
    	gameBoard.rotateBlock();
    	Assert.assertArrayEquals(block.getShape(), gameBoard.curr.getShape());
    }
    
    @Test
    public void newBlock() {
    	Block block = gameBoard.curr;
    	Assert.assertNotSame(block, gameBoard.curr);
    	
    }


}
