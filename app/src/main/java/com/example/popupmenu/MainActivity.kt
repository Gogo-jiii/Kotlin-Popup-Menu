package com.example.popupmenu

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPopupMenu.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val popupMenu = v?.let { PopupMenu(this@MainActivity, it) }

                popupMenu?.menuInflater?.inflate(R.menu.popup_menu, popupMenu.menu)

                popupMenu?.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener,
                    PopupMenu.OnMenuItemClickListener {
                    override fun onMenuItemClick(item: MenuItem): Boolean {
                        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT)
                            .show()
                        return true
                    }
                })
                popupMenu?.show()
            }
        })
    }
}