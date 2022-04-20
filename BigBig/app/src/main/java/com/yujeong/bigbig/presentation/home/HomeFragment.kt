package com.yujeong.bigbig.presentation.home

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Telephony
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yujeong.bigbig.databinding.FragmentHomeBinding
import com.yujeong.bigbig.presentation.contract.ContractActivity
import com.yujeong.bigbig.presentation.main.MainActivity
import com.yujeong.bigbig.util.launchingOtherApp
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    val binding get() = _binding?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        initView()
        initClickListener()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    private fun initView(){
        val date = Date(System.currentTimeMillis())
        val formatter = SimpleDateFormat("MM월 dd일 E요일", Locale("ko", "KR"))
        binding.tvHomeDate.text = formatter.format(date)

    }

    private fun initClickListener(){
        var intent : Intent
        binding.apply {
            clHomeCall.setOnClickListener {
                startActivity(Intent(Intent.ACTION_DIAL))
            }
            clHomeGallery.setOnClickListener {
                intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"
                try {
                    startActivity(launchingOtherApp(mainActivity, intent))
                } catch (e : android.content.ActivityNotFoundException){
                    Toast.makeText(mainActivity, "해당하는 앱을 찾을 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            clHomeCamera.setOnClickListener {
                intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivity(launchingOtherApp(mainActivity, intent))
                } catch (e : android.content.ActivityNotFoundException){
                    Toast.makeText(mainActivity, "해당하는 앱을 찾을 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            clHomeContact.setOnClickListener {
                intent = Intent(mainActivity, ContractActivity::class.java)
                startActivity(intent)
            }

        }

    }
}