package com.github.omidheshmatinia.expressioncalculator.activity.main;


import android.view.View;
import com.github.omidheshmatinia.expressioncalculator.utils.Calculator;

class Presenter implements Contract.Presenter {

    private final Contract.View view;
    private final Contract.Model model;

    Presenter(Contract.View view) {
        this.view = view;
        this.model = new Model();
    }

    @Override
    public void buttonCalcClicked() {
        if(!model.isResultVisible()){
            String text = view.getExpression();
            Calculator calc= new Calculator();
            try {
                double result = calc.calculateExpression(text);
                view.setResult("Result is "+"\n"+result);
                view.changeTextViewVisibility(View.VISIBLE);
                view.animateCardView(false);
                view.animateRippleView(true);
                view.animateResultTextView(true);
                view.changeButtonText("Hide Result");
                model.reverseResultViewVisibility();
            } catch (Exception e){
                view.toast(e.getMessage());
            }
        } else {
            view.animateCardView(true);
            view.animateRippleView(false);
            view.animateResultTextView(false);
            model.reverseResultViewVisibility();
            view.changeButtonText("Calculate");
        }
    }
}
