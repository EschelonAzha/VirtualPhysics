package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics.atomic.bonds.ionic.Ionic
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Compound(
    private val luminescent: ILuminescent = Luminescent(Compound::class),
) : Molecular(),
    ILuminescent by luminescent,
    Ionic
{
    constructor() : this(
        Luminescent(Compound::class),
    )
    object Static {
        const val LAST      : Int = -1
    }



    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (molecularId, remainder) = Strings.remainder(2, super.emit().radiate())
        return luminescent.getClassId()+remainder
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }

    override fun i() : Compound {
        super.i();
        return this
    }
}