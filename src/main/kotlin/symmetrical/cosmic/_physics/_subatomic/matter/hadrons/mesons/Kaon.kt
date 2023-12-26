package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_mesons.AntiKaon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


open class Kaon(
    private val matter: IMatter = Matter(Kaon::class, AntiKaon::class),
) : Hadron(),
    IMatter by matter
{
    constructor() : this(
        Matter(Kaon::class, AntiKaon::class),
    )

    lateinit var antiQuark  : AntiUp
    lateinit var quark      : Strange


    override fun getClassId() : String {
        return matter.getClassId()
    }
}