package com.github.omidheshmatinia.expressioncalculator.activity.main;

class Model implements Contract.Model {
    private boolean isVisible = false;
    @Override
    public boolean isResultVisible() {
        return isVisible;
    }

    @Override
    public void reverseResultViewVisibility() {
        isVisible = !isVisible;
    }
}
