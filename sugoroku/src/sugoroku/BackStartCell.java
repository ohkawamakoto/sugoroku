package sugoroku;
/**
 * 鳥に襲われるマス
 * @author ohkawa
 *
 */
public class BackStartCell extends Cell {
	private int amount;
	public BackStartCell(int amount) {
		this.amount = amount;
	}

	@Override
	public boolean doEvent(Coma coma) {
		if(coma.takeBougan(0) == 1) {
			System.out.println("しかしボウガンでやっつけた");
			return true;
		}else {
			System.out.println("つかまれてスタートに戻されてしまった．．．");
			coma.proceed(-amount);
			return true;
		}		
	}

	@Override
	public String getCaption(Coma coma) {
		return "大きな鳥が襲ってきた．．．";
	}

}
