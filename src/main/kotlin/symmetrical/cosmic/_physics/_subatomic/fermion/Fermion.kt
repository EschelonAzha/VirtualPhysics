package symmetrical.cosmic._physics._subatomic.fermion

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaMinus
import kotlin.reflect.KClass

class Fermion {
    val kClass: KClass<*>
    constructor(kClass: KClass<*>) {
        this.kClass = kClass
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(BetaMinus::class)
    }
    fun getClassId() : String {
        return getLocalClassId()
    }
}