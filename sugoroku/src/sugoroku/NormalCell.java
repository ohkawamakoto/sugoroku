package sugoroku;
/**
 * 普通のマスの実装クラス
 * @author ohkaw
 *
 */
public class NormalCell extends Cell {
	/**
	 * コンストラクタ
	 */
	public NormalCell() {
	}

	@Override
	public boolean doEvent( Coma coma ) {
		return true;
	}

	@Override
	public String getCaption(Coma coma) {
		return "風が吹いている＿";
	}

}
