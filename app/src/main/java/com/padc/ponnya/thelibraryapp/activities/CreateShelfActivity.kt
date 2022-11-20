package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.padc.ponnya.thelibraryapp.databinding.ActivityCreateShelfBinding

class CreateShelfActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateShelfBinding

    companion object {
        fun newIntent(context: Context) = Intent(context, CreateShelfActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateShelfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showKeyboardAndCursorOnEdt()
        setUpListener()
    }

    private fun showKeyboardAndCursorOnEdt() {
        binding.edtCreateShelf.requestFocus()
        val inputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.edtCreateShelf, InputMethodManager.SHOW_IMPLICIT)

    }

    private fun setUpListener() {
        binding.edtCreateShelf.setOnEditorActionListener { _, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                Log.i("Check Done", "Enter pressed")
            }
            false
        }
    }
}