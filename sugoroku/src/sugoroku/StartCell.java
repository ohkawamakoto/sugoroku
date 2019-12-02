package sugoroku;

public class StartCell extends Cell {
/**
 * スタートマス
 * @author ohkawa
 */
	public StartCell() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean doEvent(Coma coma) {
		
		return true;
	}

	@Override
	public String getCaption(Coma coma) {
		return "スタートの街だ。城に向かって出発だ～";
	}

}
