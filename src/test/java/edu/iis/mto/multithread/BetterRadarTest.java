package edu.iis.mto.multithread;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;



import java.util.concurrent.Executor;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {

	@Rule
	public RepeatRule repeatRule = new RepeatRule();
	
	@Test
	@Repeat( times = 10)
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		Executor executor = new Launcher();
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		BetterRadar betterRadar = new BetterRadar(batteryMock);
		betterRadar.setLauncher(executor);
		betterRadar.notice(new Scud());
		verify(batteryMock, Mockito.times(10)).launchPatriot();
	}

}
