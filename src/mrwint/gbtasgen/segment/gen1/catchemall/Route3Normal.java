package mrwint.gbtasgen.segment.gen1.catchemall;

import mrwint.gbtasgen.metric.CheckEncounterMetric;
import mrwint.gbtasgen.metric.gen1.CheckLowerStatEffectMisses;
import mrwint.gbtasgen.move.Move;
import mrwint.gbtasgen.move.gen1.OverworldInteract;
import mrwint.gbtasgen.segment.CatchMonSegment;
import mrwint.gbtasgen.segment.WalkToSegment;
import mrwint.gbtasgen.segment.fight.EndFightSegment;
import mrwint.gbtasgen.segment.fight.InitFightSegment;
import mrwint.gbtasgen.segment.fight.KillEnemyMonSegment;
import mrwint.gbtasgen.segment.fight.KillEnemyMonSegment.EnemyMoveDesc;
import mrwint.gbtasgen.segment.fight.NewEnemyMonSegment;
import mrwint.gbtasgen.segment.util.MoveSegment;
import mrwint.gbtasgen.segment.util.SeqSegment;

public class Route3Normal extends SeqSegment {

	@Override
	public void execute() {
		
//		seq(new WriteMemory(0xd186, 0xff)); // buff dvs
//		seq(new WriteMemory(0xd187, 0xff));
//		seq(new WriteMemory(0xd190, 14)); // buff stats
//		seq(new WriteMemory(0xd192, 13));
//		seq(new WriteMemory(0xd194, 16));
//		seq(new WriteMemory(0xd196, 14));
//		
		seq(new WalkToSegment(11, 6)); // walk up to trainer

		seq(new InitFightSegment(1)); // start fight
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.enemyMoveDesc = new EnemyMoveDesc[]{EnemyMoveDesc.missWith(new CheckLowerStatEffectMisses(), 81)}; // string shot
			kems.attackCount[0][1] = 4; // 4x scratch crit
			kems.numExpGainers = 2; // level up to 8
			kems.onlyPrintInfo = false;
			seq(kems); // Caterpie
		}
		seq(NewEnemyMonSegment.any()); // next mon
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.enemyMoveDesc = new EnemyMoveDesc[]{EnemyMoveDesc.missWith(new CheckLowerStatEffectMisses(), 81)}; // string shot
			kems.attackCount[0][1] = 3; // 3x scratch crit
			kems.numExpGainers = 3; // level up to 9, learns ember
			kems.onlyPrintInfo = false;
			seq(kems); // Weedle
		}
		seq(NewEnemyMonSegment.any()); // next mon

		
		seq(Move.A); // fight
		seq(Move.SELECT); // SCRATCH
		seq(Move.UP);
		seq(Move.SELECT); // EMBER

		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.skipFirstMainBattleMenu = true;
			kems.attackCount[0][1] = 1; // 1x ember crit
			kems.numExpGainers = 2; // level up to 10
			kems.onlyPrintInfo = false;
			seq(kems); // Caterpie
		}
		seq(new EndFightSegment(1)); // player defeated enemy
		
		seq(new WalkToSegment(12, 4)); // walk up to shorts guy
		seq(new WalkToSegment(13, 4)); // walk up to shorts guy
		seq(new MoveSegment(new OverworldInteract(3))); // talk to shorts guy
		
		save("r31");
		load("r31");

		seq(new InitFightSegment(2)); // start fight
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.enemyMoveDesc = new EnemyMoveDesc[]{EnemyMoveDesc.missWith(new CheckLowerStatEffectMisses(), 39)}; // tail whip
			kems.attackCount[0][0] = 1; // 1x ember
			kems.attackCount[0][1] = 1; // 1x ember crit
			kems.numExpGainers = 2; // level up to 11
			kems.onlyPrintInfo = false;
			seq(kems); // Rattata
		}
		seq(NewEnemyMonSegment.any()); // next mon
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.enemyMoveDesc = new EnemyMoveDesc[]{EnemyMoveDesc.missWith(new CheckLowerStatEffectMisses(), 43)}; // leer
			kems.attackCount[0][0] = 1; // 1x ember
			kems.attackCount[0][1] = 1; // 1x ember crit
			kems.numExpGainers = 1; // no level up
			kems.onlyPrintInfo = false;
			seq(kems); // Ekans
		}
		seq(new EndFightSegment(1)); // player defeated enemy
		
		seq(new WalkToSegment(18, 5)); // walk up to trainer
		seq(new MoveSegment(new OverworldInteract(5))); // talk to trainer

		save("r32");
		load("r32");

		seq(new InitFightSegment(1)); // start fight
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.attackCount[0][0] = 1; // ember
			kems.numExpGainers = 2; // level up to 12
			kems.onlyPrintInfo = false;
			seq(kems); // Weedle
		}
		seq(NewEnemyMonSegment.any()); // next mon
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.attackCount[0][0] = 1; // ember
			kems.numExpGainers = 1; // no level up
			kems.onlyPrintInfo = false;
			seq(kems); // Kakuna
		}
		seq(NewEnemyMonSegment.any()); // next mon
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.attackCount[0][0] = 1; // ember
			kems.numExpGainers = 1; // no level up
			kems.onlyPrintInfo = false;
			seq(kems); // Caterpie
		}
		seq(NewEnemyMonSegment.any()); // next mon
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.attackCount[0][0] = 1; // ember
			kems.numExpGainers = 2; // level up to 13
			kems.onlyPrintInfo = false;
			seq(kems); // Metapod
		}
		seq(new EndFightSegment(2)); // player defeated enemy
		
		seq(new WalkToSegment(24, 6, false)); // walk up to trainer
		seq(new MoveSegment(new OverworldInteract(8))); // talk to trainer

		save("r33");
		load("r33");

		seq(new InitFightSegment(1)); // start fight
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.attackCount[0][0] = 1; // ember
			kems.numExpGainers = 1; // no level up
			kems.onlyPrintInfo = false;
			seq(kems); // Caterpie
		}
		seq(NewEnemyMonSegment.any()); // next mon
		{
			KillEnemyMonSegment kems = new KillEnemyMonSegment();
			kems.attackCount[0][0] = 1; // ember
			kems.numExpGainers = 2; // level up to 14
			kems.onlyPrintInfo = false;
			seq(kems); // Metapod
		}
		seq(new EndFightSegment(1)); // player defeated enemy

		seq(new WalkToSegment(33, 11)); // go in grass
		delay(new SeqSegment() {
			@Override
			protected void execute() {
				seq(Move.RIGHT);
				seq(new CheckEncounterMetric(100, 0)); // Jigglypuff
			}
		});
		seq(new CatchMonSegment(0));

		seq(new WalkToSegment(36, 11)); // go in grass
		delay(new SeqSegment() {
			@Override
			protected void execute() {
				seq(Move.RIGHT);
				seq(new CheckEncounterMetric(5, 0)); // Spearow
			}
		});
		seq(new CatchMonSegment(0));

		seq(new WalkToSegment(59, -1, false)); // leave route 3
	}
}
