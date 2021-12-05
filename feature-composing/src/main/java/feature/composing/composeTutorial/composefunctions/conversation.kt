package feature.composing.composeTutorial.composefunctions

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import feature.composing.composeTutorial.model.Message

@Composable
fun Conversation(message: List<Message>) {
    LazyColumn {
        items(message) { message ->
            CardItemInformation(msg = message)
        }
    }
}