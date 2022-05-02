package blocks;

import java.util.Random;

public class GetRandomBlock {
	
	public Block getRandomBlockMode(String modeName) {
		switch (modeName) {
		case "EASY":
			return getRandomBlockEasyMode();
		case "NORMAL":
			return getRandomBlockNormalMode();
		case "HARD":
			return getRandomBlockHardMode();
		}
		return getRandomBlockNormalMode();
	}

	// easy mode
	public Block getRandomBlockEasyMode() {
		int random = (int) (Math.random() * 72);
		if (random < 10) {
			return new JBlock();
		} else if (random < 20) {
			return new LBlock();
		} else if (random < 30) {
			return new ZBlock();
		} else if (random < 40) {
			return new SBlock();
		} else if (random < 50) {
			return new TBlock();
		} else if (random < 60) {
			return new OBlock();
		} else {
			return new IBlock(); // 가중치 12
		}
	}

	// normal mode
	public Block getRandomBlockNormalMode() {
		Random rnd = new Random(System.currentTimeMillis());
		int block = rnd.nextInt(1000) % 7;
		switch (block) {
		case 0:
			return new IBlock();
		case 1:
			return new JBlock();
		case 2:
			return new LBlock();
		case 3:
			return new ZBlock();
		case 4:
			return new SBlock();
		case 5:
			return new TBlock();
		}
		return new OBlock();
	}

	// hard mode
	public Block getRandomBlockHardMode() {
		int random = (int) (Math.random() * 68);
		if (random < 10) {
			return new JBlock();
		} else if (random < 20) {
			return new LBlock();
		} else if (random < 30) {
			return new ZBlock();
		} else if (random < 40) {
			return new SBlock();
		} else if (random < 50) {
			return new TBlock();
		} else if (random < 60) {
			return new OBlock();
		} else {
			return new IBlock(); // 가중치 8
		}
	}

	public Block getItemBlock(String modeName) {
		Random rnd = new Random(System.currentTimeMillis());
		int block = rnd.nextInt(1000) % 5;
		switch (block) {
			case 0:
				return new WBlock();
			case 1:
				Block temp = getRandomBlockMode(modeName);
				rnd = new Random(System.currentTimeMillis());
				block = rnd.nextInt(1000) % 4;
				int count = 0;
				for(int i=0;i<temp.width();i++)
					for(int j=0;j<temp.height();j++)
						if(temp.getShape(i, j)==1) {
							if(count==block) {
								temp.setShape(i, j, 2);
								temp.setItem("L");
								return temp;
							}
							count++;
						}
				temp.setItem("L");
				return temp;
			case 2:
				return new CBlock();
			case 3:
				return new EBlock();
		}
		return new BBlock();
	}
}