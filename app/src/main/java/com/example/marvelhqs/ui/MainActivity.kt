package com.example.marvelhqs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.marvelhqs.R


class MainActivity : AppCompatActivity() {
    //private val viewModel: HqDetailViewModel by viewModels()
//    lateinit var HqAdapter: HqAdapter
//    lateinit var GridLayoutManager: GridLayoutManager

    companion object{
        lateinit var fm : FragmentManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fm = supportFragmentManager
        fm.beginTransaction().add(R.id.fragmentContainer, FragmentHome(), null).commit()

    }

//    val viewModel by viewModels<HqDetailViewModel>{
//        object : ViewModelProvider.Factory{
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                return HqDetailViewModel(repository) as T
//            }
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        supportActionBar?.setIcon(R.drawable.ic_marvel_logo_icon)
//        supportActionBar?.setTitle("")
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        fm = supportFragmentManager
//        fm.beginTransaction().add(R.id.fragmentContainer, FragmentHome(), null).commit()
//
//        HqAdapter = HqAdapter()
//        rv_recyclerHome.adapter = HqAdapter
//        rv_recyclerHome.apply {
//            layoutManager = GridLayoutManager(context, 3)
//        }
//        rv_recyclerHome.setHasFixedSize(true)
//
//        viewModel.listaHQs.observe(this) {
//            HqAdapter.addList(it)
//        }
//
//        viewModel.getHQs()
//
//        setScroller()
//
//    }
//
//    fun setScroller(){
//        rv_recyclerHome.addOnScrollListener(object : RecyclerView.OnScrollListener(){
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                if(dy > 0){
//                    val litem = GridLayoutManager.itemCount
//                    val vItem  = GridLayoutManager.findFirstCompletelyVisibleItemPosition()
//                    val itens = HqAdapter.itemCount
//                    if(litem + vItem >= itens){
//                        Log.i("TAG", "Chamou")
//                    }
//                }
//            }
//        })
//    }
}