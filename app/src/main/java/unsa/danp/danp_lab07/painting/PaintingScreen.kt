package unsa.danp.danp_lab07.painting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import unsa.danp.danp_lab07.painting.viewmodel.PaintingViewModel

@Composable
fun PaintingScreen(modifier: Modifier) {
    val viewModel: PaintingViewModel = viewModel()
    val painting = viewModel.painting.value
    var changed by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = painting.imageResId),
            contentDescription = painting.title,
            modifier = modifier.size(200.dp)
        )

        Text(
            text = painting.title,
            fontSize = 24.sp
        )

        Text(
            text = "by ${painting.author}",
            fontSize = 18.sp
        )

        Text(
            text = painting.description,
            fontSize = 16.sp
        )

        Button(
            onClick = {
                viewModel.onButtonClicked(changed)
                changed = !changed
            }
        ) {
            Text("Cambiar descripción")
        }
    }
}
