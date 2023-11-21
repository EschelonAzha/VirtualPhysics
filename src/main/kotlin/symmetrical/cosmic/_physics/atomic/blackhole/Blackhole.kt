package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Blackhole(
    private val fermion: IFermion = Fermion(Blackhole::class),
) :
    IFermion by fermion
{

    constructor() : this(
        Fermion(Blackhole::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // black holes encompass all external libraries and frameworks
}