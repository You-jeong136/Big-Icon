package com.yujeong.bigbig.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.yujeong.bigbig.R
import com.yujeong.bigbig.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMainViewPagerFragmentAdapter()
    }

    private fun setMainViewPagerFragmentAdapter(){
        binding.vpMain.adapter = MainViewPagerFragmentAdapter(this@MainActivity)
    }

}