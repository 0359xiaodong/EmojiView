package com.zhaohg.emojiview;

import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.ImageView;

public class EmojiIcon extends ImageView {
	
	protected EditText edit;
	
	public EmojiIcon(Context context) {
		super(context);
		this.initView();
	}
	
	private void initView() {
		this.setScaleType(ScaleType.FIT_CENTER);
	}
	
	public EditText getEditText() {
		return this.edit;
	}
	
	public void setEditText(EditText edit) {
		this.edit = edit;
	}
	
	protected void activate() {
		this.setBackgroundColor(Color.BLUE);
	}
	
	protected void inactivate() {
		this.setBackgroundColor(Color.TRANSPARENT);
	}
}
