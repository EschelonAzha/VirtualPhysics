package symmetrical.cosmic._physics._dimensions.temperature

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Temperature (
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Temperature::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Temperature {
        return this
    }
}