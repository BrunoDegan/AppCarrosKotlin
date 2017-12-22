package com.ankotest.kotlin.brunodegan.carroskotlinapp.domain

import android.os.Parcel
import android.os.Parcelable

class Motor(
		val modelo: String,
		val marca: String,
        val cilindros: Int
) : Parcelable{
	
	companion object {
		@JvmField val CREATOR: Parcelable.Creator<Motor> = object : Parcelable.Creator<Motor> {
			override fun createFromParcel(source: Parcel): Motor = Motor(source)
			override fun newArray(size: Int): Array<Motor?> = arrayOfNulls(size)
		}
	}
	
	constructor(source: Parcel) : this(
	source.readString(),
	source.readString(),
	source.readInt()
	)
	
	override fun describeContents() = 0
	
	override fun writeToParcel(dest: Parcel, flags: Int) {
		dest.writeString(modelo)
		dest.writeString(marca)
		dest.writeInt(cilindros)
	}
}