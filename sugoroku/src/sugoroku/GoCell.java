/**
 * 
 */
package sugoroku;

/**
 * 進むマス
 * @author ohkawa
 *
 */
public class GoCell extends Cell {

	private int amount;


	/**
	 * 
	 */
	public GoCell(int amount) {
		this.amount = amount;
	}


	@Override
	public boolean doEvent(Coma coma) {
		System.out.println(amount + "進む");
		coma.proceed(amount);
		//event(coma);
		return true;
	}

	
	@Override
	public String getCaption(Coma coma) {
		return "ラッキー さらに進めるよ";
	}

}
