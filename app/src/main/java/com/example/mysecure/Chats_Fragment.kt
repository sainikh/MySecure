package com.example.mysecure

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysecure.databinding.FragmentChatsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


lateinit var adapter: ChatsAdapter
lateinit var Chats_List : ArrayList<ChatData>
lateinit var chatGroup: Array<String>
lateinit var chatData : Array<String>
class Chats_Fragment : Fragment(),MenuProvider,ChatInterface {

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
        InitializeData()
        val layoutManager = LinearLayoutManager(context)
        val BottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        binding.recyclerView.layoutManager = layoutManager
        adapter = ChatsAdapter(Chats_List,this)
        binding.recyclerView.adapter = adapter
        BottomNavigationView.visibility = View.VISIBLE

    }

    private fun InitializeData() {
        Chats_List = ArrayList<ChatData>()
        chatGroup = arrayOf("Sai","Adhitya","Neha","Salman")
        chatData = arrayOf("he's Good BOY","Il go through it sir","I can do it by today","OK first Clear the bugs")

        for(i in chatGroup.indices)
        {
            val FinalList = ChatData(chatGroup[i], chatData[i])
            Chats_List.add(FinalList)
        }
    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.chatsactionbar,menu)
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

    override fun getPos(position: Int) {
    var action = Chats_FragmentDirections.actionChatsFragmentToViewDetailsFragment(Chats_List[position].ChatGroup)
        binding.root.findNavController().navigate(action)
    }

}