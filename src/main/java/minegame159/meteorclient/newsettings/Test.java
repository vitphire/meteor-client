package minegame159.meteorclient.newsettings;

import minegame159.meteorclient.newsettings.annotations.Range;
import minegame159.meteorclient.newsettings.annotations.Setting;

public class Test {
    @Setting(group = "general", name = "range", description = "Range.", onChanged = "onRangeChanged") // onChanged is optional
    @Range(min = 0, max = 10) // sliderMin = 0, sliderMax = 10 (defaults)
    private int range = 5;

    private void onRangeChanged() {
        // Do something
    }
}
