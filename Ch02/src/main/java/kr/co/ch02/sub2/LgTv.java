package kr.co.ch02.sub2;

public class LgTv implements Tv {

	private Speaker speaker;
	
	public LgTv(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
	@Override
	public void power() {
		System.out.println("LgTv power...");
	}

	@Override
	public void chUp() {
		System.out.println("LgTv chUp...");
	}

	@Override
	public void chDown() {
		System.out.println("LgTv chDown...");
	}

	@Override
	public void soundUp() {
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
		speaker.soundDown();
	}

}
