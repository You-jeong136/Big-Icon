package com.yujeong.bigbig.presentation.main

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yujeong.bigbig.data.BigBigSharedPreference
import com.yujeong.bigbig.databinding.ActivityMainBinding
import com.yujeong.bigbig.presentation.contact.ContactActivity

class MainActivity : AppCompatActivity() {

    val CONTACT_PERMISSION_REQUEST_CODE = 100

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

    override fun onRequestPermissionsResult( requestCode: Int, permissions: Array<out String>, grantResults: IntArray ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            CONTACT_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    startActivity(Intent(this, ContactActivity::class.java))
                } else if(grantResults.isNotEmpty()) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                        Toast.makeText(this, "연락처 권한이 없어 연락처 기능을 사용할 수 없습니다._1", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(this, "연락처 권한이 없어 연락처 기능을 사용할 수 없습니다._2", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

    }
}