package kuzim.iphone_keypad

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection

public class KeyInputMethodService: InputMethodService() {
    override fun onCreateInputView(): View {
        // res/layout/custom_keypad.xml 레이아웃을 불러옵니다.
        return layoutInflater.inflate(R.layout.custom_keypad, null)
    }

    override fun onStartInput(attribute: EditorInfo, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
    }

    override fun onStartInputView(attribute: EditorInfo, restarting: Boolean) {
        super.onStartInputView(attribute, restarting)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DEL -> {
                val ic: InputConnection? = currentInputConnection
                ic?.deleteSurroundingText(1, 0)
                return true
            }
            else -> return super.onKeyDown(keyCode, event)
        }
    }
}