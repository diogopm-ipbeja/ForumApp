package pt.ipbeja.forumapp.ui.viewpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import pt.ipbeja.forumapp.R
import pt.ipbeja.forumapp.databinding.AddCommentFragmentBinding

// TODO Display the post and a text input
class AddCommentFragment : Fragment() {

    private lateinit var binding: AddCommentFragmentBinding

    private val viewModel: ViewPostViewModel by navGraphViewModels(R.id.postNavigation)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = AddCommentFragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    fun addComment() {

    }


}