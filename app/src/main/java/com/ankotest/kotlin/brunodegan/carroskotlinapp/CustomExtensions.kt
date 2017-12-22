package com.ankotest.kotlin.brunodegan.carroskotlinapp

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import java.util.*

//OU PODEMOS UTILIZÁ-LO DA SEGUINTE MANEIRA INLINE EXTENDIDA

/**
 * Created by brunodegan on 6/26/17.
 */

/*fun Float.com.ankotest.kotlin.brunodegan.carroskotlinapp.getPrecoHuman() : String  {
	
	return String.format(Locale.GERMAN, "R$ %,.2f", this)
	
}*/


fun Float.getPrecoHuman() : String {
	return String.format( Locale.GERMAN, "R$ %,.2f", this )
}

fun String.bold() : SpannableStringBuilder {
	val aux = SpannableStringBuilder(this)
	
	aux.setSpan(
			StyleSpan(Typeface.BOLD),
			0,
			this.length,
			Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
	return aux
}
