package symmetrical.cosmic.wormholes.messaging

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class Message(
    private val matter: IMatter = Matter(Message::class, Message::class, true),
) : ParticleBeam(),
    IMatter by matter
{
    constructor() : this(
        Matter(Message::class, Message::class, true),
    )

    object Static {
        const val LAST      : Int = ParticleBeam.Static.LAST
    }



    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun i() : Message {
        super.i()
        return this
    }
}