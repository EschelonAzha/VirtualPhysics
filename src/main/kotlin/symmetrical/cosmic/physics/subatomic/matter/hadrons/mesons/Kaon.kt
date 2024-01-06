package symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic.physics.subatomic.matter.hadrons.Hadron
import symmetrical.cosmic.physics.subatomic.matter.quarks.Strange
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.anti_mesons.AntiKaon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Kaon
 */
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