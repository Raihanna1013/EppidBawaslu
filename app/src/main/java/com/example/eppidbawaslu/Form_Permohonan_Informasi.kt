package com.example.eppidbawaslu

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.github.dhaval2404.imagepicker.ImagePicker
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class Form_Permohonan_Informasi : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etNohp: EditText
    private lateinit var etNoktp: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etPekerjaan: EditText
    private lateinit var etRincian: EditText
    private lateinit var etTujuan: EditText
    private lateinit var etCMI: EditText
    private lateinit var etCMI2: EditText
    private lateinit var etCMSI: EditText
    private lateinit var btnSaveData: Button

    private lateinit var btnPickImage: Button

    private lateinit var imgImage: ImageView
    private var file: File? = null

    private val api by lazy { ApiRetrofit().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_permohonan_informasi)

        etName = findViewById(R.id.etName)
        etNohp = findViewById(R.id.etNohp)
        etNoktp = findViewById(R.id.etNoktp)
        etAlamat = findViewById(R.id.etAlamat)
        etPekerjaan = findViewById(R.id.etPekerjaan)
        etRincian = findViewById(R.id.etRincian)
        etTujuan = findViewById(R.id.etTujuan)
        etCMI = findViewById(R.id.etCMI)
        etCMI2 = findViewById(R.id.etCMI2)
        etCMSI = findViewById(R.id.etCMSI)
        btnSaveData = findViewById(R.id.btnSave)

        btnPickImage = findViewById(R.id.btnPickImage)
        imgImage = findViewById(R.id.imgImage)


        btnSaveData.setOnClickListener {
            savepermohonanData()
        }

        btnPickImage.setOnClickListener {
            ImagePicker.with(this)
                .maxResultSize(640, 640)
                .compress(200) // maks size 250kb
//                .start()
                .start { resultCode, data ->
                    when (resultCode) {
                        Activity.RESULT_OK -> {
                            file = ImagePicker.getFile(data)!!
                            imgImage.setImageURI(data?.data)

                            Log.d("file", file.toString())
                        }
                        ImagePicker.RESULT_ERROR -> {
                            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT)
                                .show()
                        }
                        else -> {
                            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

        }
    }

    private fun savepermohonanData() {

        //getting values
        val nama = etName.text.toString()
        val nohp = etNohp.text.toString()
        val noktp = etNoktp.text.toString()
        val alamat = etAlamat.text.toString()
        val pekerjaan = etPekerjaan.text.toString()
        val rincian = etRincian.text.toString()
        val tujuan = etTujuan.text.toString()
        val cmi = etCMI.text.toString()
        val cmi2 = etCMI2.text.toString()
        val cmsi = etCMSI.text.toString()

        if (file == null) {
            Toast.makeText(this, "Silahkan pilih gambar", Toast.LENGTH_SHORT).show()
            return
        }

        val builder = MultipartBody.Builder()
        builder.setType(MultipartBody.FORM)

        builder.addFormDataPart("nama", nama)
        builder.addFormDataPart("nohp", nohp)
        builder.addFormDataPart("noktp", noktp)

        builder.addFormDataPart("alamat", alamat)
        builder.addFormDataPart("pekerjaan", pekerjaan)

        builder.addFormDataPart(
            "foto", file!!.name, file!!
                .asRequestBody("multipart/form-data".toMediaTypeOrNull())
        )

        builder.addFormDataPart("rincian", rincian)
        builder.addFormDataPart("tujuan", tujuan)
        builder.addFormDataPart("cmi", cmi)
        builder.addFormDataPart("cmi2", cmi2)
        builder.addFormDataPart("cmsi", cmsi)

        val body = builder.build()

        api.createData(body)
            .enqueue(object : Callback<SubmitModel> {
                override fun onResponse(call: Call<SubmitModel>, response: Response<SubmitModel>) {
                    if (response.isSuccessful) {
                        val submit = response.body()
                        Toast.makeText(
                            applicationContext, submit!!.messaage, Toast.LENGTH_SHORT
                        ).show()
                        etName.text.clear()
                        etNohp.text.clear()
                        etNoktp.text.clear()
                        etAlamat.text.clear()
                        etPekerjaan.text.clear()
                        etRincian.text.clear()
                        etTujuan.text.clear()
                        etCMI.text.clear()
                        etCMI2.text.clear()
                        etCMSI.text.clear()
                        imgImage.setImageBitmap(null)
                    }
                }

                override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                }

            })

    }
}
