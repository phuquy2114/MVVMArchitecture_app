package com.uits.mvvmarchitecture.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.uits.baseproject.service.ApiClients
import com.uits.mvvmarchitecture.R
import com.uits.mvvmarchitecture.base.Status
import com.uits.mvvmarchitecture.service.RetrofitService

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)

        mainViewModel.getNewsList().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { users ->

                    }
                    // dismiss progress
                }
                Status.LOADING -> {
                    // show progress bar
                }
                Status.ERROR -> {
                    //Handle Error
                    // dismiss progress
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}