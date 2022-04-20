package com.yujeong.bigbig.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yujeong.bigbig.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    val binding get() = _binding?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        initView()

        return binding.root
    }

    private fun initView(){
        val date = Date(System.currentTimeMillis())
        val formatter = SimpleDateFormat("MM월 dd일 E요일", Locale("ko", "KR"))
        binding.tvHomeDate.text = formatter.format(date)

    }
}