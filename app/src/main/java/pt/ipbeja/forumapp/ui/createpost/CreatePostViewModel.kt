package pt.ipbeja.forumapp.ui.createpost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ipbeja.forumapp.remote.Api
import pt.ipbeja.forumapp.remote.Post

class CreatePostViewModel : ViewModel() {

    fun createPost(text: String) {

        viewModelScope.launch(Dispatchers.IO) {
            Api.addPost(Post(text))
        }

    }

}