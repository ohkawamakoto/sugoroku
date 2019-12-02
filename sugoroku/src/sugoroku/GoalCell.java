package sugoroku;
/**
 * ゴールしたマス
 * @author ohkawa
 *
 */
public class GoalCell extends Cell {

	public GoalCell() {
	}

	@Override
	public boolean doEvent(Coma coma) {
		return false;
	}

	@Override
	public String getCaption(Coma coma) {
		return "やった～先に城に着いた～";
	}

}
