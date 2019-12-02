package sugoroku;
/**
 * 川に流されるマス
 * @author ohakwa
 *
 */
public class RiverStartCell extends Cell {
	private int amount;
	public RiverStartCell(int amount) {
		this.amount = amount;
	}

	@Override
	public boolean doEvent(Coma coma) {
		if(coma.takeShip(0) == 0) {
			System.out.println("しまった、スタートまで流されてしまった．．．");
			coma.proceed(-amount);
			coma.riverStart(1);
			return true;
		}else {
			System.out.println("しかし船のおかげで流されずに済んだ");
			return false;
		}
		
	}

	@Override
	public String getCaption(Coma coma) {
		return "大きな川がある．．．";
	}

}
