package kr.co.ch02.sub2;

public class SamsungTv implements Tv{
	
	private Speaker speaker;
	
	public SamsungTv(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void power() {
		System.out.println("SamsungTv power...");
	}

	@Override
	public void chUp() {
		System.out.println("SamsungTv chUp...");
	}

	@Override
	public void chDown() {
		System.out.println("SamsungTv chDown...");
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
