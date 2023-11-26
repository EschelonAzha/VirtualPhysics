package symmetrical.cosmic.wormholes.messaging

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Message(
    private val luminescent: ILuminescent = Luminescent(Message::class),
) : ParticleBeam(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Message::class),
    )

    object Static {
        const val LAST      : Int = ParticleBeam.Static.LAST
    }



    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Message {
        super.i()
        return this
    }
}