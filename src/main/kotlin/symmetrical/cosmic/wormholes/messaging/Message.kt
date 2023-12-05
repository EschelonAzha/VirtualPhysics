package symmetrical.cosmic.wormholes.messaging

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Message(
    private val antiMatter: IAntiMatter = AntiMatter(Message::class, Message::class),
) : ParticleBeam(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Message::class, Message::class),
    )

    object Static {
        const val LAST      : Int = ParticleBeam.Static.LAST
    }



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Message {
        super.i()
        return this
    }
}