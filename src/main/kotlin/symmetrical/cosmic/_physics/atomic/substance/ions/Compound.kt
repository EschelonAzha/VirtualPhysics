package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics.atomic.bonds.ionic.Ionic
/*
https://en.wikipedia.org/wiki/Chemical_compound
 */
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

    override fun i() : Compound {
        super.i();
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}