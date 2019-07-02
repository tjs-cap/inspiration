package com.bjss.inspiration.random;

import com.bjss.inspiration.domain.RandomSource;

import java.util.Random;
import org.springframework.stereotype.Component;


@Component
public class RandomSourceBasicPrng implements RandomSource {
    private final Random basicPrng = new Random();

    @Override
    public int next(int upperLimit) {
        int nextValue = basicPrng.nextInt(upperLimit);
        return nextValue;
    }
}
