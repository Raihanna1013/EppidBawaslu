package com.example.eppidbawaslu

import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.transition.Slide
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
class Home : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        val imageSlider2 = findViewById<ImageSlider>(R.id.imageSlider2)
        val imageList = ArrayList<SlideModel>()
        val imagelist2 = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.regulasi))
        imageList.add(SlideModel(R.drawable.profibawaslu))
        imageSlider.setImageList(imageList, ScaleTypes.FIT)



        imagelist2.add(SlideModel(R.drawable.standarlayanan))
        imagelist2.add(SlideModel(R.drawable.informasilayanan))
        imagelist2.add(SlideModel(R.drawable.informasipublik))
        imageSlider2.setImageList(imagelist2, ScaleTypes.FIT)


        val StandarSOP : ImageButton =findViewById(R.id.SOP)
        StandarSOP.setOnClickListener{
            val intent = Intent(this@Home, SOP::class.java)
            startActivity(intent)
        }
        val Form : ImageButton = findViewById(R.id.formpermohonan)
        Form.setOnClickListener{
            val intent = Intent(this@Home, Form_Permohonan_Informasi::class.java)
            startActivity(intent)
        }

        val Cekstatus : ImageButton = findViewById(R.id.cekStatus)
        Cekstatus.setOnClickListener{
            val openURL= Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://ppid.sleman.bawaslu.go.id/list/1/cek-status-permohonan-informasi/")
            startActivity(openURL)

        }

        val CS : ImageButton = findViewById(R.id.CS)
        CS.setOnClickListener{
            val openURL= Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://wa.me/+628112632284")
            startActivity(openURL)
        }

    }

}