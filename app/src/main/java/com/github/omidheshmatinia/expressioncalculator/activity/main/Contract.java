package com.github.omidheshmatinia.expressioncalculator.activity.main;

class Contract {

    interface View {
        void setResult(String txt);
        void animateRippleView(Boolean show);
        void changeTextViewVisibility(int visibility);
        String getExpression();
        void toast(String message);
        void animateResultTextView(boolean show);
        void changeButtonText(String txt);
        void animateCardView(Boolean show);
    }

    interface Presenter {
        void buttonCalcClicked();
    }

    interface Model{
        boolean isResultVisible();
        void reverseResultViewVisibility();
    }

}
