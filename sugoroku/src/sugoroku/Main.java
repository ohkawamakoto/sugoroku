package sugoroku;

import java.util.Random;
import java.util.Scanner;

/**
 * すごろくチャレンジ
 * @author ohkawa
 *
 */
public class Main {
	/**
	 * すごろくインスタンスで使用する乱数発生装置
	 */
	private Random rand = new Random();
	/**
	 * すごろくインスタンスで使用する入力装置
	 */
	private Scanner input = new Scanner(System.in);
	private Cell[] path;
	private Coma player;
	private Coma com;
	/**
	 * すごろくのメインプログラム
	 * @param args 起動時引数
	 */
	public static void main(String[] args) {
		// ダイスがあるはず
		// マス目があるはず
		// ふりだし、あがり、その他のいろいろなマスがあるはず
		// プレイヤーが存在するはず
		// どの位置にいるかを記憶しておく必要があるはず
		// お金の概念はどうしよう
		
//		Main m = new Main();
//		m.run();
		new Main().run();  // 上と同じ
	}

	private void run() {
		//ゲーム準備
		initGame();
		//順番決める
		turnPriority();
		// ターンを繰り返し
		do {
			//順番判定してからダイスを振る
			if( player.getPriority(0) > com.getPriority(0) ) {
				// もしゴールだったらゲーム終了
				if(judgGoal(player)) {
					break;
				}else if(judgGoal(com)) {
					break;
				};
			}else {
				if(judgGoal(com)) {
					break;
				}else if(judgGoal(player)) {
					break;
				}
			}
		}while(true);
		exitGame();
	}
	/**
	 * ゴールだったら勝利宣言	
	 * @param coma
	 * @return
	 */
	private boolean judgGoal(Coma coma) {
		Dice(coma);
		boolean comaGoal = path.length - 1 == coma.getPosition();
		if(comaGoal) {
			showPath();
			System.out.println(coma.getName() + "の勝ちです～");
		}
		return comaGoal;
	}
	/**
	 * ダイスを振って進んだ先でイベント発生
	 * @param coma
	 */
	private void Dice(Coma coma) {
		showPath();
		System.out.println(coma.getName() + "の番です。ダイス振ってね(エンター)");
		input.nextLine();
		int proceedComa = rand.nextInt(3) + 1; // 1~3のどれか
		System.out.println( proceedComa + "が出たよ" );
		// コマを出目分進める
		coma.proceed( proceedComa );
		// comaイベント
		event(coma);
	}
	/**
	 * イベント実行
	 * @param coma
	 */
	private void event(Coma coma) {
		int comaPos = coma.getPosition();
		if( comaPos < path.length ) {
			Cell now = path[comaPos];
			System.out.println( now.getCaption(coma) );
			now.doEvent(coma);
		}
	}

	/**
	 * 現状のすごろく状態を表示
	 */
	private void showPath() {
		// マス目番号を表示
		System.out.println("---------------------------------------------------------------");
		for (int i = 0; i < path.length; i++) {
			if( i == 0 ) {
				System.out.print(" 街  ");
			}else if(i == 1 | i == 2 | i == 3 | i == 4 | i == 5) {
				System.out.print(" 草  ");
			}else if(i == 5 | i == 6 | i == 7 | i == 8 | i == 9) {
				System.out.print(" 森  ");
			}else if( i == 10 | i == 11 | i == 12){
				System.out.print(" 村  ");
			}else if( i == 13 | i == 14) {
				System.out.print(" 川  ");	
			}else if( i == 15 | i == 16 | i == 17 | i == 18) {
				System.out.print(" 山  ");
			}else if(i == 19) {
				System.out.print(" 城  ");
			}
		}
		System.out.println(); // 改行
		showPosi(player, "○");
		showPosi(com, "●");
		System.out.println("---------------------------------------------------------------");
				
	}
	/**
	 * コマの位置表示
	 * @param coma
	 * @param a
	 */
	private void showPosi(Coma coma,String a) {
		for (int i = 0; i < path.length; i++) {
			// プレイヤーのいる場所を表示
			if( i != coma.getPosition() ) {
				System.out.print("   ");
			}else {
				System.out.print(" " + a + " ");
			}
		}
		System.out.println();// 改行
	}
	
	
	/**
	 * ゲーム終了
	 */
	private void exitGame() {
		System.out.println("ゲーム終了です。また遊んでください～");
	}
	/**
	 * ゲーム開始準備セルの配置
	 */
	private void initGame() {
		
		path = new Cell[20];
		for (int i = 0; i < path.length; i++) {
			path[i] = new NormalCell();
		}
		path[0] = new StartCell();
		
		path[2] = new GoCell(3);
		path[4] = new BackCell(2);
		path[5] = new BackStartCell(5);
		
		path[8] = new GoCell(1);
		path[9] = new BackCell(2);
		
		path[10] = new VillageCell();
		path[11] = new VillageCell();
		path[12] = new VillageCell();
		
		path[13] = new RiverStartCell(13);
		path[14] = new RiverStartCell(14);
		
		path[15] = new BackStartCell(15);
		path[16] = new BackCell(3);
		path[17] = new BackStartCell(17);
		
		path[19] = new GoalCell();
		
		player = new Coma("あなた");
		com = new Coma("ライバル");
		System.out.println( "○ = (´▽｀) あなたです");
		System.out.println( "● = ('ω') ライバルです");
		System.out.println("お城まで競争だ～ただしぴったり止まってね");
	}
	/**
	 * ダイスを振って先攻後攻を決める
	 */
	private void turnPriority() {
		System.out.println("順番決めます。ダイス振ってね(エンター)");
		input.nextLine();
		int priorityPlayer = rand.nextInt(6) + 1; // 1~6のどれか
		System.out.println(priorityPlayer + "が出たよ" );
		System.out.println("ライバルの番です(エンター)");
		input.nextLine();
		int priorityCom = rand.nextInt(6) + 1; // 1~6のどれか
		System.out.println(priorityCom + "が出たよ" );
		if( priorityPlayer > priorityCom ) {
			player.getPriority(1);
			System.out.println("あなたからです");
			//System.out.println(player.getPriority(1));
		}else if( priorityPlayer < priorityCom ){
			System.out.println("ライバルからです");
			com.getPriority(1);
			//System.out.println(com.getPriority(1));
		}else {
			System.out.println("もう一回やり直し");
			turnPriority();
		}
	}
	
}
