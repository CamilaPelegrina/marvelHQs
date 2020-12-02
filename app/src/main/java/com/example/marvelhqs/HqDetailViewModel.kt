package com.example.marvelhqs

import androidx.lifecycle.ViewModel
import com.example.marvelhqs.ui.HQ

class HqDetailViewModel : ViewModel() {
    private val listaHQs = arrayListOf<HQ>(
            HQ(
                    R.drawable.splash_image,
                    "001",
                    "Sinopse do HQ",
                    "Título do HQ",
                    10.50,
                    "10/11/2000",
                    250

            ),
            HQ(
                    R.drawable.splash_image,
                    "002",
                    "Sinopse do HQ",
                    "Título do HQ",
                    10.50,
                    "10/11/2000",
                    250

            ),
            HQ(
                    R.drawable.splash_image,
                    "003",
                    "Sinopse do HQ",
                    "Título do HQ",
                    10.50,
                    "10/11/2000",
                    250

            ),
            HQ(
                    R.drawable.splash_image,
                    "004",
                    "Sinopse do HQ",
                    "Título do HQ",
                    10.50,
                    "10/11/2000",
                    250

            ),
    )

    fun getHQs(): ArrayList<HQ> {
        return listaHQs
    }
}