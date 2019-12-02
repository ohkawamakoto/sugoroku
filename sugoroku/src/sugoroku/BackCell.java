package sugoroku;
/**
 * 戻されるマス
 * @author ohakwa
 *
 */
public class BackCell extends Cell {
	private int amount;
	public BackCell(int amount) {
		this.amount = amount;
	}

	@Override
	public boolean doEvent(Coma coma) {
		System.out.println(amount + "戻る");
		coma.proceed(-amount);
		return true;
	}

	@Override
	public String getCaption(Coma coma) {
		return "残念、戻される．．．";
	}

}
