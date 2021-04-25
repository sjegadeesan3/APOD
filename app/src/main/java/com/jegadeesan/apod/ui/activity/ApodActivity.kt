package com.jegadeesan.apod.ui.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.jegadeesan.apod.R
import com.jegadeesan.apod.databinding.ActivityMainBinding
import android.content.DialogInterface
import android.app.AlertDialog
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.jegadeesan.apod.ui.viewmodel.ApodViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class ApodActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val apodViewModel: ApodViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.fab.setOnClickListener { view ->
            showDateDialog(view)
        }
    }

    private fun showDateDialog(view: View) {
        val mLayoutInflater = layoutInflater
        val mCustomDatePicker = mLayoutInflater.inflate(R.layout.custom_date_picker, null)
        val mDatePicker = mCustomDatePicker.findViewById(R.id.datePicker) as DatePicker
        mDatePicker.maxDate = Calendar.getInstance().time.time
        val mCalendar = Calendar.getInstance()
        val mDialog = AlertDialog.Builder(this)
        mDialog.setView(mCustomDatePicker)
        mDialog.setPositiveButton(R.string.button_ok
        ) { _, _ ->
            mCalendar.set(
                mDatePicker.year,
                mDatePicker.month,
                mDatePicker.dayOfMonth
            )
            val date = apodViewModel.getFormattedDate(mCalendar.time)
            Snackbar.make(view, date, Snackbar.LENGTH_LONG).show()
            apodViewModel.getApod(mCalendar.time)
        }.setNegativeButton(R.string.button_cancel
        ) { dialog, _ -> dialog.dismiss() }
        mDialog.create()
        mDialog.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}