package com.zhaohg.emojiview;

import android.content.Context;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;

public class EmojiIconAdd extends EmojiIcon {
	
	private String emojiText = ""; 
	
	public EmojiIconAdd(Context context) {
		super(context);
		this.initListener();
	}
	
	private String convertCodeToString(int code) {
		return new String(Character.toChars(code));
	}
	
	public void setEmojiCode(int code) {
		this.setEmojiText(convertCodeToString(code));
	}
	
	public void setEmojiCode(int code1, int code2) {
		this.setEmojiText(convertCodeToString(code1) + convertCodeToString(code2));
	}
	
	public void setEmojiText(String text) {
		this.emojiText = text;
	}
	
	public void addEmojiText() {
		if (this.edit != null) {
			int index = this.edit.getSelectionStart();
			if (index >= 0) {
				Editable editable = this.edit.getEditableText();
				editable.insert(index, this.emojiText);
			}
		}
	}
	
	public void initListener() {
		this.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				EmojiIconAdd self = (EmojiIconAdd) view;
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_HOVER_ENTER:
					self.activate();
					break;
				case MotionEvent.ACTION_HOVER_EXIT:
					self.inactivate();
					break;
				case MotionEvent.ACTION_UP:
					self.inactivate();
					self.addEmojiText();
					break;
				}
				return false;
			}
		});
	}
}