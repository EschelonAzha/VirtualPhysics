package symmetrical.cosmic._physics._subatomic.fermion

import kotlin.reflect.KClass

interface IFermion {
    fun getAbsorberId() : String
    fun getKClass() : KClass<*>


}