package com.example.magiccolor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;

public class MagicText2 extends android.support.v7.widget.AppCompatTextView {

    SpannableString spannableString;
    int pixel;

    public String mText;
    public int mColor;
    public int mSize;
    public String mStyle;
    public String mSubString;

    public MagicText2(Context context) {
        super(context);
    }

    public MagicText2(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MagicText );
        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.MagicText_magic_text:
                    mText = a.getString(attr);
                    break;
                case R.styleable.MagicText_magic_color:
                    mColor = a.getColor(attr,0);
                    break;
                case R.styleable.MagicText_magic_size:
                    mSize = a.getInt(attr,0);
                    break;
                case R.styleable.MagicText_magic_style:
                    mStyle = a.getString(attr);
                    break;
                case R.styleable.MagicText_magic_substring:
                    mSubString = a.getString(attr);
                    break;
            }
        }
        change(mText,mColor,mSize,mStyle,mSubString);
        a.recycle();
    }

    public MagicText2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void change(String string, int[] color, int[] size, String[] bold_or_italic, String[] sub_string) {
        try {
            spannableString = new SpannableString(string);
            int first, last;
            for (int i = 0; i < sub_string.length; i++) {
                first = string.toLowerCase().indexOf(sub_string[i].toLowerCase());
                last = first + sub_string[i].length();

              try {
                  if (color[i] != 0) {
                      spannableString.setSpan(new ForegroundColorSpan(
                                      ContextCompat.getColor(getContext(), color[i])),
                              first, last, 0);
                  }

                  if (size[i] != 0) {
                      pixel = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size[i], getContext().getResources().getDisplayMetrics());
                      spannableString.setSpan(new AbsoluteSizeSpan(pixel), first, last, 0);
                  }
              }catch (ArrayIndexOutOfBoundsException e){

              }
                if (bold_or_italic[i].equals("Bold")) {
                    spannableString.setSpan(new StyleSpan(Typeface.BOLD), first, last, 0);
                } else if (bold_or_italic[i].equals("Italic")) {
                    spannableString.setSpan(new StyleSpan(Typeface.ITALIC), first, last, 0);
                }
            }
            super.setText(spannableString, BufferType.SPANNABLE);
        } catch (Exception e) {
        }
    }

    public void change(String string, int color, int size, String bold_or_italic,String substring) {

        spannableString = new SpannableString(string);
        int first, last;
            first = string.toLowerCase().indexOf(substring.toLowerCase());
            last = first + substring.length();

        if (color != 0) {
            spannableString.setSpan(new ForegroundColorSpan(color), first, last, 0);
        }

        if (size != 0) {
//            pixel = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, getContext().getResources().getDisplayMetrics());
            spannableString.setSpan(new AbsoluteSizeSpan(size), first, last, 0);
        }
        if (!bold_or_italic.equals("null")) {
            if (bold_or_italic.equals("Bold")) {
                spannableString.setSpan(new StyleSpan(Typeface.BOLD), first, last, 0);
            } else if (bold_or_italic.equals("Italic")) {
                spannableString.setSpan(new StyleSpan(Typeface.ITALIC), first, last, 0);
            }
        }
        super.setText(spannableString, BufferType.SPANNABLE);
    }

    public void change(String string, int color, int size, String bold_or_italic) {

        spannableString = new SpannableString(string);

        if (color != 0) {
            spannableString.setSpan(new ForegroundColorSpan(
                            ContextCompat.getColor(getContext(), color)),
                    0, string.length(), 0);
        }
        if (size != 0) {
            pixel = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, getContext().getResources().getDisplayMetrics());
            spannableString.setSpan(new AbsoluteSizeSpan(pixel), 0, string.length(), 0);
        }
        if (!bold_or_italic.equals("null")) {
            if (bold_or_italic.equals("Bold")) {
                spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, string.length(), 0);
            } else if (bold_or_italic.equals("Italic")) {
                spannableString.setSpan(new StyleSpan(Typeface.ITALIC), 0, string.length(), 0);
            }
        }
        super.setText(spannableString, BufferType.SPANNABLE);
    }

    public void change(String string, int color, int size) {
        change(string, color, size, "null");
    }
    public void change(String string, int color) {
        change(string, color,0, "null");
    }
    public void change(String string) {
        change(string, 0,0, "null");
    }
}
