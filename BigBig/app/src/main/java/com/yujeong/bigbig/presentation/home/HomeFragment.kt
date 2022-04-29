package com.yujeong.bigbig.presentation.home

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yujeong.bigbig.databinding.FragmentHomeBinding
import com.yujeong.bigbig.presentation.contact.ContactActivity
import com.yujeong.bigbig.presentation.main.MainActivity
import com.yujeong.bigbig.util.launchingOtherApp
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {
    val CONTACT_PERMISSION_REQUEST_CODE = 100
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
               checkPermissionGranted()
            }

        }
    }

    private fun checkPermissionGranted(){

        if(ContextCompat.checkSelfPermission(mainActivity, "android.permission.READ_CONTACTS") != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(mainActivity, arrayOf(android.Manifest.permission.READ_CONTACTS), CONTACT_PERMISSION_REQUEST_CODE)
        }
        if(ContextCompat.checkSelfPermission(mainActivity, "android.permission.WRITE_CONTACTS") != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(mainActivity, arrayOf(android.Manifest.permission.WRITE_CONTACTS), CONTACT_PERMISSION_REQUEST_CODE)


            //TODO : 연락처 권한 받아오기.
            // viewModel 만들어서 viewmodel에서 local(room)에 데이터 받아오는거 하나 만들어보기.
            // 연락처 연동하기.
        }
    }

}