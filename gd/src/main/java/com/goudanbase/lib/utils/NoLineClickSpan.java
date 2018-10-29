package com.goudanbase.lib.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Auther:goudan
 * Date: 2016/1/26
 * Effect:
 */
public class NoLineClickSpan extends ClickableSpan {
    public NoLineClickSpan() {
        super();
    }

    @Override
    public void onClick(View widget) {

    }

    @Override
    public void updateDrawState(TextPaint ds) {
        /**set textColor**/
        ds.setColor(ds.linkColor);
        /**Remove the underline**/
        ds.setUnderlineText(false);
    }
}
