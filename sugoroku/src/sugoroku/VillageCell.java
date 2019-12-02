/**
 * 
 */
package sugoroku;

/**
 * 村のマス
 * @author ohkawa
 *
 */
public class VillageCell extends Cell {

	/**
	 * 
	 */
	public VillageCell() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	@Override
	public boolean doEvent(Coma coma) {
		if(coma.takeBougan(0) == 1) {
			System.out.println("ここにはもう用はない。先に進もう");
		}else if(coma.takeShip(0) == 1) {
			System.out.println("村人にボウガンをもらった");
			coma.takeBougan(1);
		}else if(coma.riverStart(0) == 1) {
			coma.takeShip(1);
			System.out.println("村人から船を借りた。これで川に流されないぞ");
		}
		return true;
	}


	@Override
	public String getCaption(Coma coma) {
		return "村に着いた";
	}

}
