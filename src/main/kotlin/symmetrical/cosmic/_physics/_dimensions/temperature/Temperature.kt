package symmetrical.cosmic._physics._dimensions.temperature

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Temperature (
    private val fermion: IFermion = Fermion(Temperature::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(Temperature::class),
    ) {
        fermion.setKClass(Temperature::class)
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : Temperature {
        return this
    }
}