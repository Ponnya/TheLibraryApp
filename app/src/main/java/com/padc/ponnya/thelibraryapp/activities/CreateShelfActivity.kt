package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.databinding.ActivityCreateShelfBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.CreateShelfPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.CreateShelfPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.CreateShelfView

class CreateShelfActivity : BaseActivity(), CreateShelfView {
    private lateinit var binding: ActivityCreateShelfBinding
    private lateinit var mPresenter: CreateShelfPresenter

    companion object {
        fun newIntent(context: Context) = Intent(context, CreateShelfActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateShelfBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpPresenter()

        showKeyboardAndCursorOnEdt()
        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateShelfPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun showKeyboardAndCursorOnEdt() {
        binding.edtCreateShelf.requestFocus()
        val inputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.edtCreateShelf, InputMethodManager.SHOW_IMPLICIT)

    }

    private fun setUpListener() {
        binding.edtCreateShelf.setOnEditorActionListener { textView, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                mPresenter.onTapDoneButton(
                    ShelfVO(
                        shelfName = textView.text.toString(),
                        shelfCover = null
                    )
                )
            }
            false
        }
        binding.btnBack.setOnClickListener {
            mPresenter.onTapBackButton()
        }
    }

    override fun endActivity() {
        finish()
    }
}