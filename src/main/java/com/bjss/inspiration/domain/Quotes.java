package com.bjss.inspiration.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Quotes {

    private final RandomSource randomSource;

    private static final String[] QUOTES = {
            "Life usually gets better than this. Except when it gets worse",
            "Maybe you'll be a pirate instead of a DevOps engineer",
            "My lottery ticket didn't come up this week - so you have more chance!",
            "Good news! These are the easiest deployments you will ever do",
            "There are old DevOps engineers and there are bold DevOps engineers. But there are no old, bold DevOps engineers",
            "Could be worse - you could be on-call at 2 AM!",
            "You never know when understanding multi-step Jenkins pipelines might save your life",
            "The darkest moment is before the dawn. Unless the Sun has imploded",
            "Aim for the stars and be mocked for only reaching the moon",
            "It's funny how the jobs you want as a kid are obsolete by the time you grow up",
            "Adulthood: When it's hard to tell your dreams and nightmares apart",
            "My dream job got turned into a £1.99 phone app",
            "A career in software piracy sounded so promising in the advert",
            "Even famous rock stars have to fix broken tests. Oh, hang on ...",
            "The DevOps blues is only 11 bars long. The last one failed to roll out",
            "There is a reason canaries never apply for a deployment job",
            "One day, AI will be smart enough to delete the database just to annoy you"
    };

    @Autowired
    public Quotes(final RandomSource randomSource) {
        this.randomSource = randomSource;
    }


    public Quote selectAtRandom() {
        String randomQuote = QUOTES[randomSource.next(QUOTES.length)];
        return new Quote(randomQuote);
    }
}
