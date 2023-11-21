package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Kaon(
    private val fermion: IFermion = Fermion(Kaon::class),
) : Hadron(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Kaon::class),
    )

    lateinit var quark      : Strange
    lateinit var antiQuark  : AntiUp

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}