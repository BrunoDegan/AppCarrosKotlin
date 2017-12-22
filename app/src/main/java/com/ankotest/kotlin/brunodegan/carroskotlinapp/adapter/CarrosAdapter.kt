package com.ankotest.kotlin.brunodegan.carroskotlinapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ankotest.kotlin.brunodegan.carroskotlinapp.bold
import com.ankotest.kotlin.brunodegan.carroskotlinapp.R
import com.ankotest.kotlin.brunodegan.carroskotlinapp.domain.Carro
import com.ankotest.kotlin.brunodegan.carroskotlinapp.getPrecoHuman

/**
 * Created by brunodegan on 6/26/17.
 */

class CarrosAdapter(private val context : Context,
                    private val carrosList: List<Carro>) :
		RecyclerView.Adapter<CarrosAdapter.ViewHolder>() {
	
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.setData(carrosList[position])
	}
	
	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
		val layout = LayoutInflater.from(context).inflate(R.layout.item_carro,parent,false)
		return ViewHolder(layout)
	}
	
	override fun getItemCount(): Int {
		return carrosList.size
	}
	
	inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
		var ivImagem: ImageView
		var ivLogo: ImageView
		var tvModelo: TextView
		var tvMarca: TextView
		var tvMotor: TextView
		var tvAcessorios: TextView
		var tvPreco: TextView
		
		init {
			ivImagem = itemView.findViewById(R.id.iv_imagem) as ImageView
			ivLogo = itemView.findViewById(R.id.iv_logo) as ImageView
			tvModelo = itemView.findViewById(R.id.tv_modelo) as TextView
			tvMarca = itemView.findViewById(R.id.tv_marca) as TextView
			tvMotor = itemView.findViewById(R.id.tv_motor) as TextView
			tvAcessorios = itemView.findViewById(R.id.tv_acessorios) as TextView
			tvPreco = itemView.findViewById(R.id.tv_preco) as TextView
		}
		
		fun setData(carro : Carro) {
			ivImagem.setImageBitmap(carro.imagem)
			
			tvModelo.text = carro.modelo
			
			ivLogo.setImageResource(carro.marca.logo)
			
			tvMarca.text = "${carro.marca.nome} - ${carro.ano}"
			
			tvMotor.text = "Motor: ".bold().
					append( "${carro.motor.modelo} " +
					"${carro.motor.cilindros} - " + "${carro.motor.marca}")
					
			tvAcessorios.text = "Acessórios: ".bold().append( carro.getAcessorios())
			
			tvPreco.text = carro.preco.getPrecoHuman()
		}
	}
}