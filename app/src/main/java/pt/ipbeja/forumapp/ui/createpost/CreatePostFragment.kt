package pt.ipbeja.forumapp.ui.createpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import pt.ipbeja.forumapp.R
import pt.ipbeja.forumapp.databinding.CreatePostFragmentBinding

class CreatePostFragment : Fragment() {


    private lateinit var binding: CreatePostFragmentBinding
    private val viewModel: CreatePostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = CreatePostFragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.submit.setOnClickListener {
            // get text from input
            // create post
            // call viewModel.addPost(post)
            // pop backstack
        }
    }

}