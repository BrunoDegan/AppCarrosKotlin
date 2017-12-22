package com.ankotest.kotlin.brunodegan.carroskotlinapp.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.ankotest.kotlin.brunodegan.carroskotlinapp.R
import com.ankotest.kotlin.brunodegan.carroskotlinapp.domain.Acessorio
import com.ankotest.kotlin.brunodegan.carroskotlinapp.domain.Carro
import com.ankotest.kotlin.brunodegan.carroskotlinapp.domain.Marca
import com.ankotest.kotlin.brunodegan.carroskotlinapp.domain.Motor
import java.util.*

/**
 * Created by brunodegan on 6/22/17.
 */

class CarrosMock {
	
	private fun gerarMotor(): Motor {
		
		val modelo = arrayOf("V-Tec", "Rocan", "TSI")
	    val marca = arrayOf("Volkswagen", "Ford", "GM")
		val cilindros = arrayListOf(4,4,8)
		val randIndex = Random().nextInt(3)
		
		return Motor(modelo[randIndex], marca[randIndex], cilindros[randIndex])
	}
	
	private fun gerarAcessorios(): Acessorio {
		val nomes = arrayOf("Teto solar", "Multimídia", "Aro 21 (Sport)", "Bancos de couro")
		val precos = arrayOf(2500f, 5600f, 8000f, 980f)
		val randIndex = Random().nextInt(4)
		
		return Acessorio(nomes[randIndex], precos[randIndex])
	}
	
	private fun temAcessorios(acessorio: Acessorio,
	                          listaDeAcessorios: LinkedList<Acessorio>): Boolean {
		for(aux in listaDeAcessorios) {
			if(aux.nome == acessorio.nome)
				return true
		}
		return false
	}
	
	private fun gerarListaAcessorios(): List<Acessorio> {
		val acessoriosList = LinkedList<Acessorio>()
		val randIndex = Random().nextInt(3) + 1
		
		while(acessoriosList.size < randIndex) {
			
			val aux = gerarAcessorios()
			
			if(aux !in acessoriosList) {
				acessoriosList.add(aux)
			}
		}
		
		return acessoriosList
	}
	
	private fun criarBitmap(resources: Resources, imagemId: Int): Bitmap {
		return BitmapFactory.decodeResource(resources,imagemId)
	}
	
	fun gerarCarros( resources: Resources ) : List<Carro> {
		
		val carros = listOf(
				Carro(
						"Impala",
						2014,
						Marca("Chevrolet", R.drawable.chevrolet_logo),
						gerarMotor(),
						89_997f,
						gerarListaAcessorios(),
						criarBitmap(resources, R.drawable.chevrolet_impala) ),
				Carro(
						"Evoque",
						2017,
						Marca("Land Rover", R.drawable.land_rover_logo),
						gerarMotor(),
						228_500f,
						gerarListaAcessorios(),
						criarBitmap(resources, R.drawable.land_rover_evoque) ),
				Carro(
						"Toureg",
						2017,
						Marca("Volkswagen", R.drawable.volkswagen_logo),
						gerarMotor(),
						327_793f,
						gerarListaAcessorios(),
						criarBitmap(resources, R.drawable.volkswagen_toureg) ),
				Carro(
						"Fusion",
						2017,
						Marca("Ford", R.drawable.ford_logo),
						gerarMotor(),
						98_650f,
						gerarListaAcessorios(),
						criarBitmap(resources, R.drawable.ford_fusion) ),
				Carro(
						"Taurus",
						2015,
						Marca("Ford", R.drawable.ford_logo),
						gerarMotor(),
						113_985f,
						gerarListaAcessorios(),
						criarBitmap(resources, R.drawable.ford_taurus) )
		)
		
		return carros
	}

}