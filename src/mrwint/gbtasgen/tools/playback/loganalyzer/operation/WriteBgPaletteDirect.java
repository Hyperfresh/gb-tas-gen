package mrwint.gbtasgen.tools.playback.loganalyzer.operation;

import java.util.TreeMap;

import mrwint.gbtasgen.tools.playback.loganalyzer.Palette;
import mrwint.gbtasgen.tools.playback.loganalyzer.accessibility.Accessibility;
import mrwint.gbtasgen.tools.playback.loganalyzer.accessibility.PaletteAccessibility;

public class WriteBgPaletteDirect implements PlaybackOperation {
  private final TreeMap<Integer, Integer> inputMap = new TreeMap<>();
  public WriteBgPaletteDirect(int index, Palette value) {
    inputMap.put(20, index ^ 0xf);
    for (int i = 0; i < 8; i++) {
      inputMap.put(32*i + 60, toJoypadInput1(value.get(i)));
      inputMap.put(32*i + 60 + 16, toJoypadInput2(value.get(i)));
    }
  }
  @Override
  public TreeMap<Integer, Integer> getInputMap() {
    return inputMap;
  }
  @Override
  public int getCycleCount() {
    return 332;
  }
  @Override
  public int getJumpAddress() {
    return PlaybackAddresses.WRITE_BG_PALETTE_DIRECT;
  }
  @Override
  public int getStartOutputCycle() {
    return 84;
  }
  @Override
  public int getEndOutputCycle() {
    return 308;
  }
  @Override
  public Accessibility getAccessibility() {
    return new PaletteAccessibility();
  }
}