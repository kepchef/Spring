package kr.co.ch03.sub1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTv implements Tv{
	
	@Autowired
	private Speaker speaker;
	
	private Internet internet;
	
	@Override
	public void power() {
		System.out.println("SamsungTv power...");
		internet.access();
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
