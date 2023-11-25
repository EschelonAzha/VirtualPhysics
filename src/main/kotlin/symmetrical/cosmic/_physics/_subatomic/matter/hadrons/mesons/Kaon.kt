package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class Kaon(
    private val fermion: ILuminescent = Luminescent(Kaon::class),
) : Hadron(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Kaon::class),
    )

    lateinit var quark      : Strange
    lateinit var antiQuark  : AntiUp

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}