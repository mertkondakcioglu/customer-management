package com.mertosi.customermanagement.model;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;
import org.jeasy.random.randomizers.text.StringRandomizer;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;


public abstract class TestDataBuilder<T> {

    private static final PositiveIntegerRandomizer positiveIntegerRandomizer = new PositiveIntegerRandomizer();

    private static final CharacterRandomizer characterRandomizer = new CharacterRandomizer();

    protected final EasyRandom generator;
    protected T data;
    Class<T> clazz;

    public TestDataBuilder(Class<T> clazz) {
        generator = new EasyRandom(getExclusionParameters());

        this.clazz = clazz;
        data = generator.nextObject(clazz);
    }

    private EasyRandomParameters getExclusionParameters() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.randomize(Integer.class, positiveIntegerRandomizer);
        parameters.randomize(String.class, characterRandomizer);

        return parameters;
    }

    public T build() {
        return data;
    }
}

class PositiveIntegerRandomizer extends IntegerRangeRandomizer {
    public PositiveIntegerRandomizer() {
        super(0, 100);
    }

    @Override
    protected Integer getDefaultMinValue() {
        return 0;
    }
}

class CharacterRandomizer extends StringRandomizer {

    @Override
    public String getRandomValue() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}

