package com.jle.monkeyfilmapp.home.ui.composables

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jle.monkeyfilmapp.R
import com.jle.monkeyfilmapp.home.data.MediaModel
import kotlinx.coroutines.launch

@Composable
fun MediaGridView() {
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(getListOfMedia()) { mediaModel ->
                MediaItem(mediaModel = mediaModel) {
                    Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                }
            }
        }
    )
}

@Composable
fun MediaListView() {
    val context = LocalContext.current

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 1.dp)
    ) {
        items(getListOfMedia()) { mediaModel ->
            MediaItem(mediaModel = mediaModel) {
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MediaListViewWithStickyHeader() {
    val context = LocalContext.current
    val mediaList: Map<String, List<MediaModel>> = getListOfMedia().groupBy { it.category }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 1.dp)
    ) {
        mediaList.forEach { (category, medias) ->
            stickyHeader {
                Text(
                    text = category, modifier = Modifier
                        .width(100.dp)
                        .background(Color.Transparent), fontSize = 20.sp, color = Color.Black
                )
            }

            items(medias) { mediaModel ->
                MediaItem(mediaModel = mediaModel) {
                    Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun MediaListViewWithCustomControl() {
    val context = LocalContext.current
    val listState = rememberLazyListState()
    val showBackButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
    val showForwardButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex < listState.layoutInfo.totalItemsCount - 1 }
    }
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyRow(
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 1.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getListOfMedia()) { mediaModel ->
                MediaItem(mediaModel = mediaModel) {
                    Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                }
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            if (showBackButton)
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(listState.firstVisibleItemIndex - 1)
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "<-")
                }
            if (showForwardButton)
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(listState.firstVisibleItemIndex + 1)
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "->")
                }
        }
    }
}

@Composable
fun MediaItem(mediaModel: MediaModel, onItemSelected: (MediaModel) -> Unit) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Card(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .width(screenWidth)
            .clickable { onItemSelected(mediaModel) }) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(id = getCatel(mediaModel.catel)),
                contentDescription = mediaModel.title,
                modifier = Modifier
                    .fillMaxWidth()
                    //.height(300.dp)
                    .fillMaxHeight(0.7F),
                contentScale = ContentScale.Crop
            )
            Text(
                text = mediaModel.title,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 4.dp)
            )
            Text(
                text = mediaModel.description,
                modifier = Modifier
                    //.requiredHeight(80.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 8.dp, bottom = 4.dp, end = 8.dp)
                    .verticalScroll(rememberScrollState()),
                fontSize = 10.sp
            )
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                mediaModel.genre.forEach {
                    Text(text = it)
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}

fun getCatel(id: Int): Int {
    return when (id) {
        1 -> R.drawable.c1
        2 -> R.drawable.c2
        3 -> R.drawable.c3
        4 -> R.drawable.c4
        5 -> R.drawable.c5
        6 -> R.drawable.c6
        7 -> R.drawable.c7
        8 -> R.drawable.c8
        9 -> R.drawable.c9
        10 -> R.drawable.c10
        else -> androidx.core.R.drawable.notification_bg_normal
    }
}

fun getListOfMedia(): List<MediaModel> {
    return listOf(
        MediaModel(
            id = 1,
            title = "Peaky Blinders",
            description = "Una familia de pandilleros asentada en " +
                    "Birmingham, Reino Unido, tras la Primera Guerra Mundial (1914-1918), dirige un " +
                    "local de apuestas hípicas. Las actividades del ambicioso jefe de la banda " +
                    "llaman la atención del Inspector jefe Chester Campbell, un detective de la Real " +
                    "Policía Irlandesa que es enviado desde Belfast para limpiar la ciudad y acabar " +
                    "con la banda.",
            catel = 1,
            score = 86,
            genre = listOf("Drama", "Crimen"),
            category = "Serie"
        ),
        MediaModel(
            id = 2,
            title = "Pinocho",
            description = "Versión en acción real del aclamado cuento sobre una marioneta que se " +
                    "embarca en una trepidante aventura para convertirse en un niño de verdad. " +
                    "La historia también presenta a otros personajes, como Gepetto, el carpintero " +
                    "que fabrica a Pinocho y lo trata como a su propio hijo; Pepito Grillo, que " +
                    "hace las veces de guía y “conciencia” de Pinocho; el Hada Azul; el Honrado " +
                    "Juan; la gaviota Sofía, y el cochero.",
            catel = 2,
            score = 67,
            genre = listOf("Fantasía", "Aventura", "Familia"),
            category = "Pelicula"
        ),
        MediaModel(
            id = 3,
            title = "The Walking Dead",
            description = "\"The Walking Dead\" está ambientada en un futuro apocalíptico con " +
                    "la Tierra devastada por el efecto de un cataclismo, que ha provocado la " +
                    "mutación en zombies de la mayor parte de los habitantes del planeta. La " +
                    "serie, explora las dificultades de los protagonistas para sobrevivir en un " +
                    "mundo poblado por el horror, así como las relaciones personales que se " +
                    "establecen entre ellos, en ocasiones también una amenaza para su " +
                    "supervivencia.",
            catel = 3,
            score = 81,
            genre = listOf("Acción", "Drama", "Ciencia ficción", "Fantasía", "Aventura"),
            category = "Serie"
        ),
        MediaModel(
            id = 4,
            title = "Star Wars: Andor",
            description = "Las aventuras del espía rebelde Cassian Andor durante los años de " +
                    "formación de la Rebelión antes de los eventos de Rogue One: A Star Wars " +
                    "Story. La serie explora historias llenas de espionaje y atrevidas misiones " +
                    "para devolver la esperanza a una galaxia dominada por un imperio despiadado.",
            catel = 4,
            score = 81,
            genre = listOf(
                "Acción",
                "Guerra",
                "Politica",
                "Ciencia ficción",
                "Fantasía",
                "Aventura"
            ),
            category = "Serie"
        ),
        MediaModel(
            id = 5,
            title = "Los Simpson",
            description = "Comedia americana de animación creada por Matt Groening para la " +
                    "compañía Fox. La serie es una parodia satírica del estilo de la clase media " +
                    "americana encarnada por una familia con ese mismo nombre, compuesta por " +
                    "Homer, Marge, Bart, Lisa, y Maggie Simpson. La trama se desarrolla en la " +
                    "ciudad ficticia de Springfield y parodia la cultura, la sociedad, la " +
                    "televisión estadounidense y muchos otros aspectos de la condición humana.",
            catel = 5,
            score = 81,
            genre = listOf("Familia", "Animación", "Comedia"),
            category = "Serie"
        ),
        MediaModel(
            id = 6,
            title = "Doctor Who: el día del Doctor",
            description = "Episodio especial de \"Doctor Who\" realizado con motivo de la " +
                    "celebración del 50º aniversario de la serie. En la Tierra, el Undécimo Doctor " +
                    "y Clara descubren una peligrosa conspiración en una galería de arte. En 1562, " +
                    "el Décimo Doctor caza Zygons con la ayuda de la Reina Isabel. El último día " +
                    "de la Guerra del Tiempo, un hombre que ya no quiere llamarse \"El Doctor\" " +
                    "toma una terrible decisión: debe cometer un genocidio contra su propia raza " +
                    "para impedir la destrucción del Universo. Todos estos sucesos resultan estar " +
                    "conectados cuando tres encarnaciones del mismo Doctor deben enfrentarse al " +
                    "momento más terrible de sus vidas.",
            catel = 6,
            score = 82,
            genre = listOf("Ciencia ficción", "Aventura"),
            category = "Pelicula"
        ),
        MediaModel(
            id = 7,
            title = "SPY×FAMILY",
            description = "Todo el mundo tiene una parte de sí mismos que no puede mostrar a los " +
                    "demás. En una era en la que las naciones de todo el mundo se encuentran " +
                    "involucradas en una feroz guerra de información a puerta cerrada, Ostania " +
                    "y Westalis llevan décadas en guerra fría. La División de Inteligencia de " +
                    "Westalis (WISE) envía a su mejor espía, \"Twilight\", en una misión " +
                    "ultrasecreta para vigilar los movimientos de Donovan Desmond, quien dirige " +
                    "el Partido Nacional por la Unidad de Ostania, responsable de bombardear los " +
                    "esfuerzos de paz entre ambos países.",
            catel = 7,
            score = 87,
            genre = listOf("Animación", "Aventura", "Acción", "Comedia"),
            category = "Anime"
        ),
        MediaModel(
            id = 8,
            title = "Jurassic World: Dominion",
            description = "Cuatro años después de la destrucción de Isla Nublar, los dinosaurios " +
                    "conviven – y cazan – con los seres humanos en todo el mundo. Este frágil " +
                    "equilibrio cambiará el futuro y decidirá, de una vez por todas, si los seres " +
                    "humanos seguirán en la cúspide de los depredadores en un planeta que comparten " +
                    "con los animales más temibles de la creación.",
            catel = 8,
            score = 70,
            genre = listOf("Ciencia ficción", "Aventura", "Acción"),
            category = "Pelicula"
        ),
        MediaModel(
            id = 9,
            title = "Fullmetal Alchemist: La alquimia final",
            description = "El largo y tortuoso viaje de los hermanos Elric llega a su épico " +
                    "final, en el que deben enfrentar una amenaza de otro mundo que afecta a " +
                    "todo el país.",
            catel = 9,
            score = 63,
            genre = listOf("Fantasía", "Aventura", "Acción"),
            category = "Pelicula"
        ),
        MediaModel(
            id = 10,
            title = "Top Gun: Maverick",
            description = "Después de más de 30 años de servicio como uno de los mejores " +
                    "aviadores de la Armada, Pete \"Maverick\" Mitchell se encuentra dónde siempre " +
                    "quiso estar, empujando los límites como un valiente piloto de prueba y " +
                    "esquivando el alcance en su rango, que no le dejaría volar emplazándolo en " +
                    "tierra. Cuando se encuentra entrenando a un destacamento de graduados de Top " +
                    "Gun para una misión especializada, Maverick se encuentra allí con el teniente " +
                    "Bradley Bradshaw, el hijo de su difunto amigo \"Goose\".",
            catel = 10,
            score = 83,
            genre = listOf("Drama", "Acción"),
            category = "Pelicula"
        ),
    )
}