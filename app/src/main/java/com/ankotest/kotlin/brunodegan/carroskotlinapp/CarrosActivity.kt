package com.ankotest.kotlin.brunodegan.carroskotlinapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.ankotest.kotlin.brunodegan.carroskotlinapp.adapter.CarrosAdapter
import com.ankotest.kotlin.brunodegan.carroskotlinapp.data.CarrosMock
import com.ankotest.kotlin.brunodegan.carroskotlinapp.domain.Carro
import kotlinx.android.synthetic.main.activity_carros.*

/**
 * Created by brunodegan on 6/26/17.
 */
class CarrosActivity : AppCompatActivity() {
	
	val carList = ArrayList<Carro>()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_carros)
		
		/*carList.addAll(
				savedInstanceState?.getParcelableArrayList( Carro.Companion.CARROS_STRING )
				?: CarrosMock().gerarCarros(resources)
		)*/

		if (savedInstanceState?.getParcelableArrayList<Carro>(Carro.Companion.CARROS_STRING) != null) {
			carList.addAll(savedInstanceState.getParcelableArrayList(Carro.Companion.CARROS_STRING))
		} else  {
			carList.addAll(CarrosMock().gerarCarros(resources))
		}

		
		initRecycler()
	}
	
	private fun initRecycler() {
		rv_carros.setHasFixedSize(true)
		
		val mLayoutManager = LinearLayoutManager(this)
		rv_carros.layoutManager = mLayoutManager
		
		val divider = DividerItemDecoration(this,mLayoutManager.orientation)
		rv_carros.addItemDecoration(divider)
		
		val carrosAdapter = CarrosAdapter(this,carList)
		rv_carros.adapter = carrosAdapter
	}
	
	override fun onSaveInstanceState(outState: Bundle?) {
		outState?.putParcelableArrayList(Carro.Companion.CARROS_STRING, carList)
		super.onSaveInstanceState(outState)
	}
}