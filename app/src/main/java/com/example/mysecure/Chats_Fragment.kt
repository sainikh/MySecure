package com.example.mysecure

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.mysecure.databinding.FragmentChatsBinding


class Chats_Fragment : Fragment(),MenuProvider {

    private var _binding : FragmentChatsBinding? = null
    private val binding : FragmentChatsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentChatsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.addMenuProvider(this,viewLifecycleOwner,Lifecycle.State.RESUMED)
    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.mainmenu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.item1)
        {
            Toast.makeText(requireContext(),"Clicked Serch Option in Menu",Toast.LENGTH_SHORT).show()
            return true
        }
        if(menuItem.itemId == R.id.item2)
        {
            Toast.makeText(requireContext(),"Create Group Clicked",Toast.LENGTH_SHORT).show()
            return true
        }
        if(menuItem.itemId == R.id.item3)
        {
            Toast.makeText(requireContext(),"Create BroadCast Clicked",Toast.LENGTH_SHORT).show()
            return true
        }

        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}