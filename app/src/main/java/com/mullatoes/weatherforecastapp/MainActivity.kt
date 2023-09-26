package com.mullatoes.weatherforecastapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mullatoes.weatherforecastapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val currentWeatherFragment = CurrentWeatherFragment()
        val hourlyForecastFragment = HourlyForecastFragment()
        val sevenDayForecastFragment = SevenDayForecastFragment()
        val settingsFragment = SettingsFragment()

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.current_weather -> {
                    switchScreens(currentWeatherFragment)
                }

                R.id.hourly_weather -> {
                    switchScreens(hourlyForecastFragment)
                }

                R.id.seven_day_weather -> {
                    switchScreens(sevenDayForecastFragment)
                }

                R.id.settings_menu -> {
                    switchScreens(settingsFragment)
                }
            }
            true
        }

    }

    private fun switchScreens(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}