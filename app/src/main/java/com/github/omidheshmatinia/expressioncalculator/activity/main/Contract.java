package com.github.omidheshmatinia.expressioncalculator.activity.main;

class Contract {

    interface View {
        /**
         * show result in {@link MainActivity#textViewResult}
         * @param txt
         */
        void setResult(String txt);

        /**
         * animate or reverse the {@link MainActivity#rippleView} animation
         * @param show
         */
        void animateRippleView(Boolean show);

        /**
         * change visibility of {@link MainActivity#textViewResult}
         * @param visibility
         */
        void changeTextViewVisibility(int visibility);

        /**
         * get expression entered in {@link MainActivity#editTextExpression}
         */
        String getExpression();

        /**
         * toast a message
         * @param message
         */
        void toast(String message);

        /**
         * animate {@link MainActivity#textViewResult}
         * @param show show FadeIn animation if true, otherwise show Fade out animation
         */
        void animateResultTextView(boolean show);

        /**
         * change title of button {@link MainActivity#buttonCalculate}
         * @param txt title of button
         */
        void changeButtonText(String txt);

        /**
         * animate {@link MainActivity#cardViewFields}
         * @param show show ZoomIn animation if true, otherwise show ZoomOut animation
         */
        void animateCardView(Boolean show);
    }

    interface Presenter {
        /**
         * called whenever user click on calculate button ({@link MainActivity#buttonCalculate})
         */
        void buttonCalcClicked();
    }

    interface Model{
        boolean isResultVisible();
        void reverseResultViewVisibility();
    }

}
