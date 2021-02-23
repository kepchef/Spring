package kr.co.ch03.sub1;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class LgTv implements Tv {

	@Inject
	private Speaker speaker;
	
	private Internet internet;
	
	@Override
	public void power() {
		System.out.println("LgTv power...");
		internet.access();
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
