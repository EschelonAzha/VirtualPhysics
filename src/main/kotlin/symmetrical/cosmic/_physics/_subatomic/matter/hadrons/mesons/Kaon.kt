package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_mesons.AntiKaon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class Kaon(
    private val antiMatter: IAntiMatter = AntiMatter(Kaon::class, AntiKaon::class),
) : Hadron(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Kaon::class, AntiKaon::class),
    )

    lateinit var quark      : Strange
    lateinit var antiQuark  : AntiUp

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}