package com.pgs.workshop.testutils;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class MyCustomIdMatcher extends TypeSafeMatcher<Long> {

    private Long expectedId;
    
    private MyCustomIdMatcher(Long expectedId) {
        this.expectedId = expectedId;
    }
    
    @Override
    public void describeTo(Description description) {
        description.appendValue(expectedId);
    }

    @Override
    protected boolean matchesSafely(Long actualId) {
        return expectedId.equals(actualId);
    }
    
    public static MyCustomIdMatcher myIdEqualsTo(Long expectedId) {
        return new MyCustomIdMatcher(expectedId);
    }
    
}
