package com.github.omidheshmatinia.expressioncalculator.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.omidheshmatinia.expressioncalculator.R;
import com.github.omidheshmatinia.expressioncalculator.custom.RippleView;
import com.jakewharton.rxbinding2.view.RxView;
import com.nineoldandroids.animation.Animator;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity implements Contract.View {

    @BindView(R.id.rippleView_main)
    RippleView rippleView;
    @BindView(R.id.button_main_calc)
    AppCompatButton buttonCalculate;
    @BindView(R.id.textView_main_result)
    AppCompatTextView textViewResult;
    @BindView(R.id.editText_main_query)
    MaterialEditText editTextExpression;
    @BindView(R.id.cardView_main_fields)
    CardView cardViewFields;

    Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        // prevent our lovely users from clicking button too fast
        RxView.clicks(buttonCalculate)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> {
                    presenter.buttonCalcClicked();
                });
    }

    @Override
    public void setResult(String txt) {
        textViewResult.setText(txt);
    }

    @Override
    public void animateRippleView(Boolean show) {
        if(show)
            rippleView.beginRipple();
        else
            rippleView.reverseRipple();
    }

    @Override
    public void changeTextViewVisibility(int visibility) {
        textViewResult.setVisibility(visibility);
    }

    @Override
    public String getExpression() {
        return editTextExpression.getText().toString();
    }

    @Override
    public void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void animateResultTextView(boolean show) {
        if(show)
            YoYo.with(Techniques.FadeInDown).duration(700).playOn(textViewResult);
        else {
            YoYo.with(Techniques.FadeOutUp).duration(300).withListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    textViewResult.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    textViewResult.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            }).playOn(textViewResult);
        }
    }

    @Override
    public void changeButtonText(String txt) {
        buttonCalculate.setText(txt);
    }

    @Override
    public void animateCardView(Boolean show) {
        if(show) {
            cardViewFields.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.ZoomIn).duration(400).withListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    cardViewFields.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    cardViewFields.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            }).playOn(cardViewFields);
        } else {
            YoYo.with(Techniques.ZoomOut).duration(400).withListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    cardViewFields.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    cardViewFields.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            }).playOn(cardViewFields);
        }
    }
}
