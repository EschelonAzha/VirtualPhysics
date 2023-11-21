package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class ChargedWeak(
    private val fermion: IFermion = Fermion(ChargedWeak::class),
) : Particle(),
    IFermion by fermion
{
    // can emit a charged W Boson that can alter the charge of a Proton by
    // altering the structure of its quarks
    constructor() : this(
        Fermion(ChargedWeak::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : ChargedWeak {
        return this
    }
}