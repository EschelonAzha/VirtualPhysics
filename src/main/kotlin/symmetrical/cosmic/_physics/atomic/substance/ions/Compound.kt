package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics.atomic.bonds.ionic.Ionic

open class Compound(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Compound::class, Compound::class),
) : Molecular(),
    IMatterAntiMatter by matterAntiMatter,
    Ionic
{
    constructor() : this(
        MatterAntiMatter(Compound::class, Compound::class),
    )
    object Static {
        const val LAST      : Int = -1
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (molecularId, remainder) = Strings.remainder(2, super.emit().radiate())
        return matterAntiMatter.getClassId()+remainder
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    override fun i() : Compound {
        super.i();
        return this
    }
}