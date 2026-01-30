package org.vitya0717.pannoniaCore.lootTable.functions.count;

import org.vitya0717.pannoniaCore.lootTable.models.ItemFunction;

import java.util.Random;

public class SetUniformCountFunction extends ItemFunction {
    private final int min;
    private final int max;

    public SetUniformCountFunction(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getRandomCount(Random random) {
        return min + random.nextInt(max - min + 1);
    }

}