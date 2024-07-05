package unsa.danp.danp_lab07.painting.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import unsa.danp.danp_lab07.R
import unsa.danp.danp_lab07.painting.model.Painting

class PaintingViewModel : ViewModel() {
    var painting = mutableStateOf(
        Painting(
            "La noche estrellada",
            "Vincent van Gogh",
            "Una obra maestra de Van Gogh que muestra el cielo nocturno estrellado.",
            R.drawable.van_gogh_starry_night
        )
    )

    fun onButtonClicked(changed: Boolean) {
        // conexion a bd y se cambia en este caso cambiamos el objeto
        if (changed){
            painting.value = painting.value.copy(
                description = "¡Esta pintura es increíble!"
            )
        } else {
            painting.value = painting.value.copy(
                description = "Una obra maestra de Van Gogh que muestra el cielo nocturno estrellado."
            )
        }
    }
}
