package symmetrical.cosmic._physics._subatomic.fermion

import symmetrical.cosmic.__recycle.Absorber
import kotlin.reflect.KClass

class Fermion : IFermion {

    override fun getAbsorberId() : String {
        return Absorber.getClassId(getKClass())
    }

    override  fun getKClass() : KClass<*> {
        return this::class
    }
}