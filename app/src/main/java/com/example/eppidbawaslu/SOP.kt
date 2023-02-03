package com.example.eppidbawaslu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SOP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sop)

        val SOP_Konsekuensi: Button = findViewById(R.id.SOP_Konsekuensi)
        SOP_Konsekuensi.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            //openurl ke web
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/1ZqAhCm_8_VyhN6e1Ffyov5XPvv-c9hsT/view")
            startActivity(openURL)
        }

        val SOP_Pengumpulan: Button = findViewById(R.id.SOP_Pengumpulan)
        SOP_Pengumpulan.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/1tQlYBPX3QNU3gEBP9J8HrZ65z86rT8bF/view")
            startActivity(openURL)
        }

        val SOP_Penetapan: Button = findViewById(R.id.SOP_Penetapan)
        SOP_Penetapan.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/1dbE8UINxneDSa86CoE1tzmYR4j_RxfAu/view")
            startActivity(openURL)
        }

        val SOP_Pendokumentasian: Button = findViewById(R.id.SOP_Pendokumentasian)
        SOP_Pendokumentasian.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/1X5HRTQdwlO5MrcRkvIg-uIEL2JJKQZQW/view")
            startActivity(openURL)
        }

        val SOP_DokumentasiInfo: Button = findViewById(R.id.SOP_DokumentasiInfo)
        SOP_DokumentasiInfo.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/1687bTNT9j2GMwR92jbvFjSssX7AwQPr8/view")
            startActivity(openURL)
        }

        val SOP_Penanganan: Button = findViewById(R.id.SOP_Penanganan)
        SOP_Penanganan.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/1bC1VygR0CYnvGQYxgSf3nl_Fgf3qZqJN/view")
            startActivity(openURL)
        }

        val SOP_Pelayanan: Button = findViewById(R.id.SOP_Pelayanan)
        SOP_Pelayanan.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/1q23pDSNjAtZufPZDYu0RwijqJ9oC34dp/view")
            startActivity(openURL)
        }
        val SOP_InformasiDikecualikan: Button = findViewById(R.id.SOP_InformasiDikecualikan)
        SOP_InformasiDikecualikan.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://drive.google.com/file/d/18rG9OROgRBbboPeyud5G31UFSdLyYqSB/view")
            startActivity(openURL)
        }

        val SOP_Sengketa: Button = findViewById(R.id.SOP_Sengketa)
        SOP_Sengketa.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("http://ppid.sleman.bawaslu.go.id/content/449/SOP-Penanganan-Sengketa-Informasi-Non-Litigasi/")
            startActivity(openURL)
        }

        val SOP_Kepemiluan: Button = findViewById(R.id.SOP_Kepemiluan)
        SOP_Kepemiluan.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("http://ppid.sleman.bawaslu.go.id/content/448/SOP-Pelayanan-Informasi-Kepemiluan/")
            startActivity(openURL)
        }
    }
}