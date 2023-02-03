package com.example.eppidbawaslu

class NoteModel (
    val permohonan: List<Data>
){
    data class Data (
        val nama: String?,
        val nohp: Int?,
        val noktp: Int?,
        val alamat: String?,
        val pekerjaan: String?,
        val rincian: String?,
        val tujuan: String?,
        val cmi: String?,
        val cmi2: String?,
        val cmsi: String?)
}


