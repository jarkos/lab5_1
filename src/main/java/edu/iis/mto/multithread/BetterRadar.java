package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;

public class BetterRadar 
{
	
	private PatriotBattery battery;
	private Executor launcher;

	public BetterRadar(PatriotBattery missle) {
		this.battery = missle;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	private void launchPatriot() {
		Runnable launchPatriotTask = new Runnable() {
			public void run() {
			for (int i = 0; i < 10; i++) 
				battery.launchPatriot();
				
			}
		};
		
		launcher.execute(launchPatriotTask);
	}

	public void setLauncher(Executor Executor) {
		this.launcher = Executor;
	}
	
}