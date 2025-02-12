package com.example.lista.controllador

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lista.R

class DetailActivity : AppCompatActivity() {
    //private lateinit var detailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Recibir el dato pasado
        val itemDetail = intent.getStringExtra("ITEM_DETAIL")
        val itemName = intent.getStringExtra("ITEM_NAME")// "ITEM_DETAIL" es la clave usada para almacenar el dato
        val itemEmail = intent.getStringExtra("ITEM_EMAIL")
        val itemPhone = intent.getStringExtra("ITEM_PHONE")
        //val itemAddress = intent.getStringExtra("ITEM_ADDRESS")
        //val itemCompany = intent.getStringExtra("ITEM_COMPANY")
        val itemWebsite = intent.getStringExtra("ITEM_WEBSITE")

        // Mostrar el dato recibido (por ejemplo, en un TextView)
        val textViewDetails: TextView = findViewById(R.id.item_detail_usrname) // Reemplaza con el ID de tu TextView
        textViewDetails.text = itemDetail // Muestra el detalle en el TextView

        val textViewName: TextView = findViewById(R.id.item_detail_name) // Reemplaza con el ID de tu TextView
        textViewName.text = itemName // Muestra el detalle en el TextView

        val textViewEmail: TextView = findViewById(R.id.item_detail_email) // Reemplaza con el ID de tu TextView
        textViewEmail.text = itemEmail // Muestra el detalle en el TextView

        val textViewPhone: TextView = findViewById(R.id.item_detail_tel) // Reemplaza con el ID de tu TextView
        textViewPhone.text = itemPhone // Muestra el detalle en el TextView

        //val textViewAddress: TextView = findViewById(R.id.item_detail_dir) // Reemplaza con el ID de tu TextView
        //textViewAddress.text = itemAddress // Muestra el detalle en el TextView

        //val textViewCompany: TextView = findViewById(R.id.item_detail_company) // Reemplaza con el ID de tu TextView
        // textViewCompany.text = itemCompany // Muestra el detalle en el TextView

        val textViewWebsite: TextView = findViewById(R.id.item_detail_website) // Reemplaza con el ID de tu TextView
        textViewWebsite.text = itemWebsite // Muestra el detalle en el TextView
    }
}