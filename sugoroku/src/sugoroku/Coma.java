/**
 * 
 */
package sugoroku;

/**
 * すごろくのプレイヤー位置を表す コマクラス
 * @author ohkawa
 *
 */
public class Coma {
	
	/**
	 * プレイヤーname
	 */
	private String name;
	/**
	 * 現在位置
	 */
	private int position;
	/**
	 * 優先順位
	 */
	private int priority;
	/**
	 * 川にはまった経験
	 */
	private int river;
	/**
	 * 船の有無
	 */
	private int ship;
	/**
	 * ボウガンの有無
	 */
	private int bougan;
	
	
	/**
	 * コンストラクタ
	 * @param name プレイヤー名
	 */
	public Coma( String name ) {
		this.name = name;
		this.position = 0;
		this.priority = 0;
		this.ship = 0;
		this.bougan = 0;
	}
	/**
	 * このコマの現在位置を返します
	 * @return 位置を表す数値
	 */
	public int getPosition() {
		return this.position;
	}
	/**
	 * このコマが 指定された分量 進む
	 * @param amount 進む量
	 */
	public void proceed(int amount) {
		 this.position += amount;
		 if(this.position == 20) {
			 this.position = 18;
		 }else if(this.position == 21) {
			 this.position = 17;
		 }
	}
	/**
	 * 優先順位の有無
	 * @param a
	 * @return
	 */
	public int getPriority(int a) {
		return this.priority += a;
	}
	public String getName() {
		return this.name;
	}
	public int riverStart(int b) {
		return this.river += b;
	}
	public int takeShip(int c) {
		return this.ship += c;
	}
	public int takeBougan(int d) {
		return this.bougan += d;
	}
	
}
