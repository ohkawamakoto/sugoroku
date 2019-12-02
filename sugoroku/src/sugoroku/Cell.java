/**
 * 
 */
package sugoroku;

/**
 * すごろくに使用されるマス目を表現する基底クラス
 * @author ohkawa
 *
 */
public abstract class Cell {

	/**
	 * コンストラクタ
	 */
	protected Cell() {
		
	}
	/**
	 * なにかしらのイベント発生
	 */
	public abstract boolean doEvent(Coma coma);
	/**
	 * マス目の表示
	 * @return 表示文字列
	 */
	public abstract String getCaption(Coma coma);
	
}
