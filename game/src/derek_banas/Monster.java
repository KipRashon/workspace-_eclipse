package derek_banas;

import java.util.Arrays;


public class Monster {
	
	//create the variables
	public final String tombstone="Here lies the dead monster";
	private char gameboard[][]=new char[10][10];
	private char nameChar='R';
	private int attack=20;
	private int health=500;
	private int movement=2;
	
	public int xposition=0;
	public int yposition=0;
	private boolean alive=true;
	public static int numberofmonsters=0;
	
	public String name="Rashon";
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int decrease) {
		health=health-decrease;
		if(health<0) {
			alive=false;
		}
	}
	public void setHealth(double decrease) {
		health=(int) (health-decrease);
		if(health<0) {
			alive=false;
		}
	}
	public int getMovement() {
		return movement;
	}
	public void setMovement(int movement) {
		this.movement = movement;
	}
	public int getAttack() {
		return attack;
	}
	
	//creating the game board
		public void createGameBoard() {
			//here use an enhanced for loop
			for(char[]row:gameboard) {
				Arrays.fill(row, '*');
			}
		}

		//redrawing the board
		public void redrawBoard() {
			//drawing the dashes
			int k=1;
			while(k<=30) {
				System.out.print("-");
				k++;
			}
			System.out.println();
			
			//drawing the real board
			
			
			for(int i=0;i<gameboard.length;i++) {
				
				for(int j=0;j<gameboard[i].length;j++) {
					System.out.print("|"+gameboard[i][j]+"|");
				}
				System.out.println();
			}

			k=1;
			while(k<=30) {
				System.out.print("-");
				k++;
			}
			System.out.println();
			
			
		}
	
	//creating the constructor
	public Monster(int newHealth,int newAttack,int newMovement,String name) {
		this.attack=newAttack;
		this.health=newHealth;
		this.movement=newMovement;
		this.name=name;
		
		//getting the maxwidthspace and heightspace
		int maxboardspaceX=gameboard.length-1;
		int maxboardspaceY=gameboard[0].length-1;
		int randomy;
		int randomx;
		//using the do loop
		do {
			randomx=(int) Math.random()*maxboardspaceX;
			randomy=(int) Math.random()*maxboardspaceY;
			
		}while(gameboard[randomx][randomy]!='*');
		
		//assign the positions
		this.xposition=randomx;
		this.yposition=randomy;
		this.nameChar=this.name.charAt(0);
		
		gameboard[this.yposition][this.xposition]=this.nameChar;
		System.out.println(randomx);
		numberofmonsters++;
	}
	
	//creating a no arg constructor
	public Monster() {
		
	}
	
	public static void main(String args[]) {
		Monster m= new Monster(1000,20,1,"Rashon");
		m.createGameBoard();
		m.redrawBoard();
	/*	char[][]temp=new char[10][10];
  		
 	Monster[] monsters= new Monster[4];
 		monsters[0]= new Monster(1000,20,1,"Kiptoo");
 		monsters[1]= new Monster(700,30,2,"Rashon");
 	monsters[2]= new Monster(500,16,1,"Weswes");
 		monsters[3]= new Monster(400,15,2,"Collins");
		m.redrawBoard();*/
	}
}










