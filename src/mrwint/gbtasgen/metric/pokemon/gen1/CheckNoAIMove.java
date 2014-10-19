package mrwint.gbtasgen.metric.pokemon.gen1;

import mrwint.gbtasgen.metric.StateResettingMetric;
import mrwint.gbtasgen.rom.RomInfo;
import mrwint.gbtasgen.util.Util;

public class CheckNoAIMove implements StateResettingMetric {

	int initialMove;

	public CheckNoAIMove(int initialMove) {
		this.initialMove = initialMove;
	}

	@Override
	public int getMetricInternal() {
		int add = Util.runToAddressNoLimit(0,initialMove,RomInfo.pokemon.fightAIMoveCheck); // Check for AI moves (item uses etc.)
//		return (add == RomInfo.rom.fightAIExecuteMove) ? 1 : 0;
		return (add == RomInfo.pokemon.printLetterDelayJoypadAddress) ? 1 : 0;
//		if (add == RomInfo.rom.printLetterDelayJoypadAddress)
//			return 0;
//		int f = State.getRegister(Register.AF) & 0x10;
//		System.out.println(f);
//		return (f == 0) ? 1 : 0;
	}
}