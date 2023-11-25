package symmetrical.cosmic.wormholes.messaging.login


import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class ReadyMSG (
    private val fermion: ILuminescent = Luminescent(ReadyMSG::class),
) : Message(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(ReadyMSG::class),
    )
    object Static {
        const val LAST      : Int = Message.Static.LAST
    }

    override fun i() : ReadyMSG {
        super.i()
        return this
    }


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
}